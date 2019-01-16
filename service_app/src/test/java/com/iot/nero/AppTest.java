package com.iot.nero;

import com.alibaba.dubbo.common.compiler.support.JavassistCompiler;
import com.alibaba.dubbo.common.compiler.support.JdkCompiler;
import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.common.json.ParseException;
import com.sun.tools.javac.main.JavaCompiler;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
         final String SOURCE_CODE = "{\n" +
                 "    \"d\" : {\n" +
                 "        \"LW100\" : [ 0 ],\n" +
                 "        \"value 1\" : [ false ],\n" +
                 "        \"value 2\" : [ 2 ],\n" +
                 "        \"value 3\" : [ \"1234\" ],\n" +
                 "        \"value 4\" : [ 2 ]\n" +
                 "    },\n" +
                 "    \"ts\" : \"2018-03-15T16:46:40.840746\"\n" +
                 "}";

        try {
            Object jsonObject = JSON.parse(SOURCE_CODE);
            JSONObject object = (JSONObject) jsonObject;

            JSONObject jsonObject1  = (JSONObject) object.get("d");
            JSONArray jsonObject2 = (JSONArray) jsonObject1.get("value 4");

            System.out.println(jsonObject2.get(0).toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
