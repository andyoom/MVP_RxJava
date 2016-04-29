package com.andy.common.net;

import com.socks.library.KLog;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpEngine;
import okio.Buffer;
import okio.BufferedSource;


/**
 * 类描述：
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/26 10:29
 * 修改备注：
 */
public class HttpKLogInterceptor implements Interceptor{

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startNs = System.nanoTime();
        Response response=null;
        try {
            response = chain.proceed(request);
        }catch (Exception e){
            KLog.e(e.getMessage());
        }
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
        printLog(request,response,tookMs);
        return response;
    }

    private synchronized void printLog(Request request,Response response,long time) throws IOException{

        log("=====================================================================");
        Charset charset = UTF8;

        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        String requestStartMessage = "--> " + request.method() + ' ' + request.url();
        if (hasRequestBody) {
            requestStartMessage += " (" + requestBody.contentLength() + "-byte body)";
        }
        log(requestStartMessage);

        if (hasRequestBody) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            log(buffer.readString(charset));
            log("--> END " + request.method() + " (" + requestBody.contentLength() + "-byte body)");
        }

        if(response!=null){
            ResponseBody responseBody = response.body();
            long contentLength = responseBody.contentLength();
            String bodySize = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            log("<-- " + response.code() + ' ' + response.message() + ' '
                    + response.request().url() + " (" + time + "ms" +
                    ", " + bodySize + " body" + ')');
            if (HttpEngine.hasBody(response)) {
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                Buffer buffer = source.buffer();

                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(UTF8);
                    } catch (UnsupportedCharsetException e) {
                    }
                }
                if (contentLength != 0) {
                    KLog.json(buffer.clone().readString(charset));
                }

                log("<-- END HTTP (" + buffer.size() + "-byte body)");
            }
        }
        log("=====================================================================");
    }

    private void log(Object msg){
        KLog.d(msg);
    }
}
