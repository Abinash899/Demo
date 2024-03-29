package com.QA.TestApp.Utilities;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    private static ExtentReports extent = ExtentManager.getInstance();

    public static synchronized ExtentTest getTest() {
    	//System.out.println("Extent thread"+extentTestMap.get((int) (long) (Thread.currentThread().getId())));
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
       // extentTestMap.get((int) (long) (Thread.currentThread().getId())).assignCategory(arg0)
    }

    public static synchronized void endTest() {
        extent.endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        
        //Pradeep- 2nd May
        test.assignCategory(BaseScript.gadGetName);
       // test.assignCategory(BaseScript.gadGetName).assignCategory("Test");
        //test.assignCategory(BaseScript.gadGetName)
        //end modification
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

        return test;
    }
}