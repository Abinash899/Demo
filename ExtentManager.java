package com.QA.TestApp.Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports report;
    /*public static FrameWorkUtility fUtil=new FrameWorkUtility();
    public static String xx;
    public static String ResultLocation=BaseScript.ResultLocation;*/
    
    
    public static synchronized ExtentReports getInstance() {
        if (report == null) {
        	/*//ResultLocation = "C:\\Result";
   		 	fUtil.fCreateFolder(ResultLocation);
   		 	fUtil.fCreateFolder (ResultLocation+"\\Images1");
   		 	xx=ResultLocation+"\\ExecutionReport"+fUtil.fGetRandomNumUsingTime()+".html";*/
            report = new ExtentReports(BaseScript.reportName, true);
        }

        return report;
    }
}
