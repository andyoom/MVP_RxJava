package com.andy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void classTest(){
        Class<String> strClass=String.class;
        System.out.println(strClass);
        System.out.println(strClass.getAnnotations().length);
        System.out.println(strClass.getCanonicalName());
        System.out.println(strClass.getClasses());
        System.out.println(strClass.getClassLoader());

        System.out.println(strClass.getMethods().length);
        System.out.println(strClass.getFields().length);
        System.out.println(strClass.getName());
        System.out.println(strClass.getPackage());
    }


}