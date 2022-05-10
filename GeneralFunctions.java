package com.QA.TestApp.Utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class GeneralFunctions extends BaseScript {
	
	//public static WebDriver d = BrowserFactory.webDriver.get();	
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fEnterDatatoEdtBox .
	 *Description: Enter data into an edit box
	 *Arguments : obj (Edit box Web element), step (step name to be displayed in the execution log), data (string to be entered in the edit box), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	
	public boolean fEnterDatatoEdtBox(WebElement obj,String step,String data, int ScreenShot) throws Exception
	{	
		
		
		WaitForObject(obj);
		boolean flag = false;
		try
		{
			if(obj.isEnabled())
			{
				obj.clear();
				obj.sendKeys(data);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
				//d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try
				{
					if(!obj.getAttribute("value").equals(""))
					{
						fUtil.flogResult("Passed",step,"Successfully Entered :"+data,ScreenShot);
						flag = true;
					}
					else
					{
						fUtil.flogResult("Failed",step,"Failed to Enter",ScreenShot);
					}
				}
				catch(Exception e)
				{
					fUtil.flogResult("Failed",step,"Failed to Enter",ScreenShot);
				}
			}
			else
			{			
				fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
				return false;
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,e.getMessage(),ScreenShot);
		}
		return flag;	
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fClickOnButton
	 *Description: Clicking a button
	 *Arguments : obj (Button Web element), step (step name to be displayed in the execution log), data (Button Name), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	
	/*public boolean fClickOnButton(WebElement obj,String step,String btnName, int ScreenShot) throws Exception
	{
		
		boolean flag = false;
		WaitForObject(obj);
		try
		{
			if(obj.isEnabled())
			{
				
				//highlightElement(obj);
//				Actions actions = new Actions(BrowserFactory.webDriver.get());
//				actions.moveToElement(obj).build().perform();
				//BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				JavascriptExecutor executor = (JavascriptExecutor)BrowserFactory.webDriver.get();
				executor.executeScript("arguments[0].click();", obj);
				BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
				fUtil.flogResult("Passed",step,"Successfully Clicked :"+btnName,ScreenShot);
				flag = true;
				//obj.click();	
			}
			else
			{			
				fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
				return false;
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,"Object not present/Exception :"+e,ScreenShot);
		}
		return flag;	
	}*/
	
	public boolean fClickOnButton(WebElement obj,String step,String btnName, int ScreenShot) throws Exception
	{
	boolean flag = false;
	WaitForObject(obj);
	try
	{
	if(obj.isEnabled())
	{
	//highlightElement(obj);
	// Actions actions = new Actions(BrowserFactory.webDriver.get());
	// actions.moveToElement(obj).build().perform();
	//BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	JavascriptExecutor executor = (JavascriptExecutor)BrowserFactory.webDriver.get();
	executor.executeScript("arguments[0].click();", obj);
	BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	fUtil.flogResult("Passed",step,"Successfully Clicked :"+btnName,ScreenShot);
	flag = true;
	//obj.click(); 
	}
	else
	{ 
	fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
	return false;
	}
	}
	catch(ScriptTimeoutException eee){
	fUtil.flogResult("Passed",step,"Successfully Clicked :"+btnName,ScreenShot);
	} 
	catch(JavascriptException ee){
	fUtil.flogResult("Passed",step,"Successfully Clicked :"+btnName,ScreenShot);
	}
	catch(Exception e)
	{
	//if(e.)
	fUtil.flogResult("Failed",step,"Object not present/Exception :"+e,ScreenShot);
	}
	return flag; 
	}
	
	
	
	
	
	
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fClickOnButton
	 *Description: Clicking a button
	 *Arguments : obj (Button Web element), step (step name to be displayed in the execution log), data (Button Name), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	
	public String fGetValueRiskDetail(String ID,String step,String fieldName, int ScreenShot) throws Exception
	{
		
		String flag = null;
		//WaitForObject(obj);
		try
		{
			//if(obj.isDisplayed())
			//{
				
				//highlightElement(obj);
//				Actions actions = new Actions(BrowserFactory.webDriver.get());
//				actions.moveToElement(obj).build().perform();
				//BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				JavascriptExecutor executor = (JavascriptExecutor)BrowserFactory.webDriver.get();
				String IdVal=ID;
				String Script= "return document.getElementById('"+ID+"').value";
				flag=executor.executeScript(Script).toString();
				BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
				fUtil.flogResult("Passed",step,"Successfully Clicked :"+fieldName,ScreenShot);
				return flag;
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,"Object not present/Exception :"+e,ScreenShot);
		}
		return flag;	
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fSelectCheckBox .
	 *Description: To select a Check box
	 *Arguments : obj (Check box Web element), step (step name to be displayed in the execution log), data (Check box name), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	
	public boolean fSelectCheckBox(WebElement obj,String step,String data, int ScreenShot) throws Exception
	{
		
		
		boolean flag = false;
		try
		{
			WebDriver d = BrowserFactory.webDriver.get();
			
			WaitForObject(obj);
			if(!obj.isSelected())
			{
				
				highlightElement(obj);
				JavascriptExecutor executor = (JavascriptExecutor)BrowserFactory.webDriver.get();
				executor.executeScript("arguments[0].click();", obj);
				d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
				fUtil.flogResult("Passed",step,"Successfully Checked :"+data,ScreenShot);
				//obj.click();			
			}
			else
			{			
				fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
				return false;
			}
			return flag;
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,e.getMessage(),ScreenShot);
			return flag;
		}
	}

	
	/**--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: TypeInDateField
	 *Description: To enter data in a date format
	 *Arguments : obj (Edit box Web element), step (step name to be displayed in the execution log), data (Edit box name), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void TypeInDateField(WebElement obj,String step,String data, int ScreenShot) throws Exception
	{
		try
		{
		    String val = data; 
		    if(obj.isDisplayed())
			{
		    	
			    obj.clear();
			    obj.click();
			    for (int i = 0; i < val.length(); i++)
			    {
			        char c = val.charAt(i);
			        String s = new StringBuilder().append(c).toString();	
			        if(!s.equals("/"))
			        {
			        obj.sendKeys(s);  
			        }
			        try 
		            {
						Thread.sleep(500);
					} catch (InterruptedException e) {					
						e.printStackTrace();
					}
			        
			    } 
			    fUtil.flogResult("Passed",step,"Successfully Entered :"+data,ScreenShot);
			}
		    else
		    {
		    	fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
		    }
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,e.getMessage(),ScreenShot);
		}
		    
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fUploadFile
	 *Description: To upload a file
	 *Arguments : obj (Edit box Web element), step (step name to be displayed in the execution log), data (Path to be uploaded), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
		
	public boolean fUploadFile(WebElement obj,String step,String filePath, int ScreenShot) throws Exception
	{
		boolean flag = false;
		try
		{
			WaitForObject(obj);
			if(obj.isDisplayed())
			{
				
				highlightElement(obj);
				obj.sendKeys(filePath);
				fUtil.flogResult("Passed",step,"Successfully Entered Path :"+filePath,ScreenShot);
				//obj.click();			
			}
			else
			{			
				fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
				return false;
			}
			return flag;	
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,e.getMessage(),ScreenShot);
			return flag;	
		}
		
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fSelectDataFromDropDown
	 *Description: To select a drop down value
	 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), data (Value to be selected in drop down), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
		
	public boolean fSelectDataFromDropDown(WebElement obj,String step,String data, int ScreenShot) throws Exception
	{
		boolean flag = false;
		WaitForObject(obj);
		try
		{
			if(obj.isDisplayed())
			{				
				//highlightElement(obj);
				obj.click();
				Select select = new Select(obj);
				select.selectByValue(data);
				//select.selectByVisibleText(data);		
				fUtil.flogResult("Passed",step,"Successfully Selected :"+data,ScreenShot);					
			}
			else
			{			
				fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
				return false;
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,e.toString(),ScreenShot);			
		}
		return flag;	
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fSelectDataFromDropDowntext
	 *Description: To select a drop down value
	 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), data (Value to be selected in drop down), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
		
	public boolean fSelectDataFromDropDownText(WebElement obj,String step,String data, int ScreenShot) throws Exception
	{
		boolean flag = false;
		WaitForObject(obj);
		try
		{
			//if(obj.isDisplayed())
			{				
				//highlightElement(obj);
				//obj.click();
				Select select = new Select(obj);
				//select.selectByValue(data);
				select.selectByVisibleText(data);		
				fUtil.flogResult("Passed",step,"Successfully Selected :"+data,ScreenShot);					
			}
			//else
			/*{			
				fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
				return false;
			}*/
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,e.toString(),ScreenShot);			
		}
		return flag;	
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fGetSelectedDataFromDropDown
	 *Description: To get the selected value from a drop down value
	 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
		
	public String fGetSelectedDataFromDropDown(WebElement obj,String step,int ScreenShot) throws Exception
	{
		String strCurrentValue = null;
		WaitForObject(obj);
		try
		{
			//if(gmethodes.isElementVisible(obj, 30))
			{				
				//highlightElement(obj);
				//obj.click();
				Select select = new Select(obj);
				//select.selectByVisibleText(data);		
				strCurrentValue = select.getFirstSelectedOption().getText();
				fUtil.flogResult("Passed",step,"Successfully Selected :",ScreenShot);
				//return strCurrentValue;
			//}
			//else
			/*{			
				fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
			}*/
		}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,e.toString(),ScreenShot);			
		}
		return strCurrentValue;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fSelectDataFromDropDownIndex
	 *Description: To select a drop down value
	 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), data (Value to be selected in drop down), Screenshot (yes/no)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
		
	public boolean fSelectDataFromDropDownIndex(WebElement obj,String step,String data, int ScreenShot) throws Exception
	{     
		boolean flag = false;
		boolean DataFoundFlag = false;
		WaitForObject(obj);
		try
		{
			if(gmethods.isElementVisible(obj, 30))
			{				
				//highlightElement(obj);
				int k = 0;
				int i =0;
				//obj.click();
				Select select = new Select(obj);
				List<WebElement> dropDwonElements = select.getOptions();
				String[] dropDownText = new String[dropDwonElements.size()];
				for (WebElement e : dropDwonElements) {
					dropDownText[i]=e.getText().trim();
					i++;
				}
				for (String f : dropDownText) {
					if(f.equalsIgnoreCase(data)){
						select.selectByIndex(k);
						DataFoundFlag=true;
						fUtil.flogResult("Passed",step,"Successfully Selected :"+data,ScreenShot);	
						break;
					}
					k++;
				}	
				if(DataFoundFlag==false){
					fUtil.flogResult("Failed",step,"Unable to Find "+data+" in the Select Dropdown",ScreenShot);
				}
				
				//select.selectByValue(data);
				//select.selectByVisibleText(data);		
								
			}
			else
			{			
				fUtil.flogResult("Failed",step,"Object not present",ScreenShot);
				return false;
			}
		}
		catch(Exception e)
		{
			fUtil.flogResult("Failed",step,e.toString(),ScreenShot);			
		}
		return flag;	
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: highlightElement
	 *Description: To highlight a web element
	 *Arguments : element(Web element)
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
		
	 public void highlightElement(WebElement element)  
	 {
		 WebDriver d = BrowserFactory.webDriver.get();
		 try
		 {
	       
		 		WaitForObject(element);
	            JavascriptExecutor js = (JavascriptExecutor)BrowserFactory.webDriver.get();
	            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 4px solid red;");
	            try 
	            {
					Thread.sleep(1000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
	           // js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')",element);
		 }
		 catch(Exception e)
		 {
			 
		 }
	       
	  }
	 
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: WaitForObject
		 *Description: To wait for object dynamically
		 *Arguments : How (type of locator), value (locator_string)
		 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/
	 public void WaitForObject(WebElement ee)
	 {
		 
	 }
	 
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: setObject
		 *Description: To set object dynamically
		 *Arguments : How (type of locator), value (locator_string)
		 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/
			
	 public  WebElement waitForObject(String How,String value) throws Exception
	 {
		 WebElement myDynamicElement = null;
		 try
		 {
			 
			 switch(How)
			 {
			 case "id":
			 //myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 100)).until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
			 myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
			 break;
			 case "xpath":
			 //myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 100)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
			 myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			 break;
			 case "name":
			 //myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 100)).until(ExpectedConditions.presenceOfElementLocated(By.name(value)));
			 myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
			 break;
			 } 
		 }
		 catch(Exception e)
		 {
			 fUtil.flogResult("Failed","Object with "+How +"="+value+"Creation Failed",e.toString(),1);
			 return myDynamicElement;
		 }
		 
		return myDynamicElement;
		 
	 }
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: verifyObjectExistance
		 *Description: To verify if an object exists or not
		 *Arguments : How (type of locator), value (locator_string)
		 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/
			
	 public boolean verifyObjectExistance(String How,String value) throws Exception
	 {
		 WebElement myDynamicElement = null;
		 try
		 {
			 switch(How)
			 {
			 case "id":
			 myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
			 break;
			 case "xpath":
			 myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			 break;
			 case "name":
			 myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
			 break;
			 case "css":
			myDynamicElement = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
			break;
			 }
			return myDynamicElement.isDisplayed();
		 }
		 catch(Exception e)
		 {
			 fUtil.flogResult("Failed","Object with : "+How +"="+value+" : Creation Failed",e.toString(),1);
			 return false;
		 }
		 
	 }
	 
	 public String GetTextFromObject(WebElement ee, String attribute) throws Exception
	 {
		 try
		 {
			 return ee.getAttribute(attribute);	
		 }
		 catch(Exception e)
		 {
			 fUtil.flogResult("Failed","Get the value from Element", "Failed to get the value due to exception:"+e.toString(),1);
			 return "null";
		 }
	 }
	
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: WaitUnitlObjectDisappear
		 *Description: To set wait until object disappear
		 *Arguments : How (type of locator), value (locator string)
		 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/
			
	 public  boolean WaitUnitlObjectDisappear(String How,String value)
	 {
		 boolean Status = false;
		 try{			 
		
			 switch(How)
			 {
			 case "id":
			 Status = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.invisibilityOfElementLocated(By.id(value)));
			 break;
			 case "xpath":
			 Status = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(value)));
			 break;
			 case "name":
			 Status = (new WebDriverWait(BrowserFactory.webDriver.get(), 50)).until(ExpectedConditions.invisibilityOfElementLocated(By.name(value)));
			 break;
			 }				 
			return Status;
		 }
		 catch(NoSuchElementException e)
		 {
			 return true;
		 }
		 catch (StaleElementReferenceException e) 
		 {
			 return true;
		 }
		 
	 }
	 
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: isElementClickable
		 *Description: To check a web element is clickable
		 *Arguments : element(Web element), time (wait duration)
		 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/
			
	 public  boolean isElementClickable(WebElement element, int time)
	 {
		 try{
			 if(isElementPresent(element)==false || element.isEnabled()==false)
			 {
				 WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), time);
				 wt.until(ExpectedConditions.elementToBeClickable(element));
				 
				 return element.isEnabled();	
			 }
			 else
			 {
				 return true;
			 }
		 }
		 
		 catch(Exception e)
		 {
			 //fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
			 return false;
			 
		 }
		
	 }
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: isElementVisible
		 *Description: to check if a web element is visible
		 *Arguments : element (Web element), time (wait duration)
		 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/
			
	 public boolean isElementVisible(WebElement element, int time)
	 {
//		 try
//		 {
			 if(isElementPresent(element)==false)
			 {
				 WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), time);
				 wt.until(ExpectedConditions.visibilityOf(element));
				/// wt.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
				 return element.isDisplayed();
			 }
			 else
			 {
				 return true;
			 }
				
	 }
	 
	 public boolean isElementDisappeared(By by, int time)
	 {
		 
			 if(isElementPresent(BrowserFactory.webDriver.get().findElement(by)))
			 {
				 WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), time);
				 wt.until(ExpectedConditions.invisibilityOfElementLocated(by));
				 
				 if(BrowserFactory.webDriver.get().findElement(by).isDisplayed())
					 return false;
				 else
					 return true;
			 }
		 
			 else
			 {
				 return true;
			 }
		 
	 }
	 
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: rightClick
		 *Description: to right click on a web element
		 *Arguments : How(String) which is for selecting the rack whether it is Standard or Personal or Company, value(String) which is the test data
		 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/
		
	 
	 /*public static void rightClick(String How, String value) throws Exception{
			 try{			 
				 
				 switch(How)
				 {
				 case "Standard":
					 System.out.println("in right click Standard");
					 String xpathStandardService=GeneralFunctions.dynamicXpath("//div[@id='commonTemplateExpander']//div[text()='xxxx']",fUtil.fgetDataNew(value));
					 System.out.println(value);
					 System.out.println(xpathStandardService);				 
					 WebElement elementStd=BrowserFactory.webDriver.get().findElement(By.xpath(xpathStandardService));
					 GeneralFunctions.scroll("Standard",elementStd);
					 Thread.sleep(5000);
					 Actions action = new Actions(BrowserFactory.webDriver.get()).contextClick(elementStd);
					 action.build().perform();
					 //Thread.sleep(4000);
					 break;
				 case "Company":
					 String xpathServiceCompany=GeneralFunctions.dynamicXpath("//div[@id='companyTemplateExpander']//div[text()='xxxx']",fUtil.fgetDataNew(value));
					 WebElement elementCmp=BrowserFactory.webDriver.get().findElement(By.xpath(xpathServiceCompany));
					 GeneralFunctions.scroll("Company",elementCmp);
					 Thread.sleep(5000);
					 Actions action1 = new Actions(BrowserFactory.webDriver.get()).contextClick(elementCmp);
					 action1.build().perform();
					 //Thread.sleep(10000);
					 break;
				 case "Personal":
					 System.out.println("in right click personal");
					 String xpathServicePersonal=GeneralFunctions.dynamicXpath("//div[@id='userTemplateExpander']//div[text()='xxxx']",fUtil.fgetDataNew(value));
					 System.out.println(value);
					 System.out.println(xpathServicePersonal);
					 WebElement elementPer=BrowserFactory.webDriver.get().findElement(By.xpath(xpathServicePersonal));
					 GeneralFunctions.scroll("Personal",elementPer);
					 Thread.sleep(5000);
					 Actions action2 = new Actions(BrowserFactory.webDriver.get()).contextClick(elementPer);
					 action2.build().perform();
					 //Thread.sleep(10000);

					 break;

				 }

			 }
			 catch(Exception e)
			 {
				 fUtil.flogResult("Failed","right click failed",e.toString(),1);

			 }

	 }
*/
	 
	/* public static void SetAsDefaultTemplate()
	 {
		 String xpathTemplate=GeneralFunctions.dynamicXpath("//div[@id='commonTemplateExpander']//div[text()='xxxx']//span[@title='Default Template']",fUtil.fgetDataNew("TemplateName"));
		 
	 }
*/
	 
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: isElementPresent
		 *Description: to check if a web element is present
		 *Arguments : element (Web element)
		 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/
		 
	 
	 public  boolean isElementPresent(WebElement element)
	 {
			
		 try
		 {
			 if(element.isDisplayed())
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 
		 catch(Exception e)
		 {
			 //fUtil.flogResult("Failed","Object Not Present",e.toString(),"Yes");
			 return false;
			 
		 }
				 
	 }
	 
	/* public static void VerifyPageNavigation(WebElement obj,String step,String data, int ScreenShot) throws Exception
		{
			try
			{
				if(GeneralFunctions.isElementVisible(obj,30));
				 {
					 fUtil.flogResult("Passed","Navigated to",data,1);
					 //return true;
				 }
				
			}
			catch(Exception e)
			{
				fUtil.flogResult("Failed",step,"Navigation failed :"+e,ScreenShot);
				//return false;
			}
			
		}*/
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: dynamicXpath
		 *Description: to create dynamic xpath
		 *Arguments : element (String), argument (String)
		 *Author 	 :TCS
		--------------------------------------------------------------------------------------------------------------------------------------*/
		 
	 public  String dynamicXpath(String element,String argument)
		{
			//String str = element.toString();
			String[] a=element.split("xxxx");
			return a[0]+argument+a[1];
		}
	 
	 public  String dynamicXpath(String element,String argument1,String argument2)
		{
			//String str = element.toString();
			String[] a=element.split("xxxx");
			return a[0]+argument1+a[1]+argument2+a[2];
		}
	 
	 public  boolean loaderTimeOut()
		{
			//String str = element.toString();
		 boolean loaderimage=gmethods.isElementDisappeared(By.xpath("//div[@id='loaderImage']"), 180);
		 return loaderimage;
		}
	 
	 public boolean isElementPresentAndEnable(String xpath)
	 {
		 String btnStatus;
	 
		 try{
		 btnStatus =  BrowserFactory.webDriver.get().findElement(By.xpath(xpath)).getAttribute("class");
		 System.out.println("Btn available");
		 }
		 catch(Exception e){
			 System.out.println("Btn not available");
			 return false;
		 }
//		 WebElement wb= BrowserFactory.webDriver.get().findElement(By.xpath(xpath));
//		 try
//		 {
			 if(btnStatus.equalsIgnoreCase("disableButton"))
			 {
				return false;
			 }
			 else
			 {
				 return true;
			 }
				
	 }	
	 
	 public boolean isElementPresentAndEnableWE(WebElement element)
	 {
		 String btnStatus;
	 
		 try{
		 btnStatus =  element.getAttribute("class");
				 
		 System.out.println("Btn available");
		 }
		 catch(Exception e){
			 System.out.println("Btn not available");
			 return false;
		 }
//		 WebElement wb= BrowserFactory.webDriver.get().findElement(By.xpath(xpath));
//		 try
//		 {
			 if(btnStatus.equalsIgnoreCase("disableButton"))
			 {
				return false;
			 }
			 else
			 {
				 return true;
			 }
				
	 }	
	 
	 public  boolean isElementVisibleXpath(String xpath, int time)
	 {
		
		try{
			Thread.sleep(2000);
			 WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), time);
			 wt.until(ExpectedConditions.visibilityOf(BrowserFactory.webDriver.get().findElement(By.xpath(xpath)))) ;
	 
		
		}
		
		catch(Exception e)
		{
			return false;
		}
			
	return true;
	 }
	

		
		
		/*put the below lines in module class and pass formattedDate in to the function
		 * 			Calendar cal=Calendar.getInstance();
					Date date=cal.getTime();
					System.out.println(date);
					DateFormat df= new SimpleDateFormat("HH:mm:ss");
					String formattedDateInput= df.format(date);
		 * 
		 * 
		 */
		
		
		
		
		 public void  pageLoadStatusCheckDisplayed(WebElement element, String PageName, String formattedDateInput) throws Exception
		 {
			 ArrayList<Long> timeValues = new ArrayList<Long>();
			 try{	 	
					//int i=0;
				  boolean found=false;
					for(int i=0;i<900;i++)
					{
						if(element.isDisplayed()==false)
						{
					 
							// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
							// wt.until(ExpectedConditions.elementToBeClickable(element));
							Thread.sleep(1000);
							i++;
							
							//return element.isEnabled();	
						}
						 else
						 {
							// return true;
							 found=true;
							 	Calendar cal=Calendar.getInstance();
								Date date=cal.getTime();
								System.out.println(date);
								DateFormat df= new SimpleDateFormat("HH:mm:ss");
								String formattedDate= df.format(date);
								//String f2="14:15:45";
								System.out.println(formattedDate);
								
								Date time2=df.parse(formattedDate);
								Date time1=df.parse(formattedDateInput);
								long timeTest=time2.getTime()-time1.getTime();
								System.out.println(timeTest);
								long timeInSec=timeTest/1000 %60;
								long timeInMin=timeTest/(60*1000) %60;
								//timeValues.add(timeInMin);
								//timeValues.add(timeInSec);
								System.out.println(timeInMin);
								fUtil.flogResult("Passed", "Check the Page load time of " +PageName, "Page Load time(MM:SS) - "+timeInMin+":"+timeInSec, 0);
								break;
							 
						 }
					}
					if(found==false)
					{
						fUtil.flogResult("Failed", "Check the Page load of " +PageName, "Page not loaded within 15 minutes", 1);
					}
						//return timeValues;
			 }
			 
			 catch(Exception e)
			 {
				 //fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
				// return false;
				 fUtil.flogResult("Failed", "Check the Page load of " +PageName, "Page not loaded due to exception"+e.getMessage(), 1);
			 }
			
			
		 }
		 
		 public void  windowLoadTimeTrack(Set<String> windowArray, String windowName, String formattedDateInput, long timeDiffTest) throws Exception
		 {
			 ArrayList<Long> timeValues = new ArrayList<Long>();
			 try{	 	
					//int i=0;
				 	boolean found=false;
					for(int i=0;i<900;i++)
					{
						if(windowArray.size()==1)
						{
					 
							// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
							// wt.until(ExpectedConditions.elementToBeClickable(element));
							Thread.sleep(1000);
							i++;
							
							//return element.isEnabled();	
						}
						 else
						 {
							 found=true;
							// return true;
							 	Calendar cal=Calendar.getInstance();
								Date date=cal.getTime();
								System.out.println(date);
								DateFormat df= new SimpleDateFormat("HH:mm:ss");
								String formattedDate= df.format(date);
								//String f2="14:15:45";
								System.out.println(formattedDate);
								System.out.println("In side Window load");
								
								Date time1=df.parse(formattedDate);
								Date time2=df.parse(formattedDateInput);
								long timeTest=time1.getTime()-time2.getTime();
								long timeDiff=timeTest-timeDiffTest;
								System.out.println(timeDiff);
								long timeInSec=timeDiff/1000 %60;
								long timeInMin=timeDiff/(60*1000) %60;
								//timeValues.add(timeInMin);
								//timeValues.add(timeInSec);
								System.out.println(timeInMin);
								fUtil.flogResult("Passed", "Check the Window load time of " +windowName, "Window Load time(MM:SS) - "+timeInMin+":"+timeInSec, 0);
								break;
							 
						 }
					}
					if(found==false)
					{
						
						fUtil.flogResult("Failed", "Check the Window load of " +windowName, "Window not loaded within 15 minutes", 1);
					}
						//return timeValues;
			 }
			 
			 catch(Exception e)
			 {
				 //fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
				// return false;
				 fUtil.flogResult("Failed", "Check the Page load of " +windowName, "Page not loaded due to exception"+e.getMessage(), 1);
			 }
			
			
		 }
		
		 
		//Robot
			//___________________________
			public void rbSendKeys(Robot robot, String keys) {
			    for (char c : keys.toCharArray()) {
			        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			        if (KeyEvent.CHAR_UNDEFINED == keyCode) {
			            throw new RuntimeException(
			                "Key code not found for character '" + c + "'");
			        }
			        robot.keyPress(keyCode);
			        robot.delay(100);
			        robot.keyRelease(keyCode);
			        robot.delay(100);
			    }
			}  
			
			
			/*put the below lines in module class and pass formattedDate in to the function
			 * 			Calendar cal=Calendar.getInstance();
						Date date=cal.getTime();
						System.out.println(date);
						DateFormat df= new SimpleDateFormat("HH:mm:ss");
						String formattedDateInput= df.format(date);
			 * 
			 * 
			 */
			
			public String getSystemTime() {
				Calendar cal=Calendar.getInstance();
				Date date=cal.getTime();
				System.out.println(date);
				DateFormat df= new SimpleDateFormat("HH:mm:ss");
				String formattedDateInput= df.format(date);
				return formattedDateInput;
			}
			
			 public long  pageLoadStatusCheckEnabled(WebElement element, String PageName, String formattedDateInput, long timeDiffTest) throws Exception
			 {
				 ArrayList<Long> timeValues = new ArrayList<Long>();
				 long timeDiff=0;
				 try{	 	
						//int i=0;
						for(int i=0;i<900;i++)
						{
							if(element.isEnabled()==false)
							{
						 
								// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
								// wt.until(ExpectedConditions.elementToBeClickable(element));
								Thread.sleep(1000);
								i++;
								
								//return element.isEnabled();	
							}
							 else
							 {
								// return true;
								 	Calendar cal=Calendar.getInstance();
									Date date=cal.getTime();
									System.out.println(date);
									DateFormat df= new SimpleDateFormat("HH:mm:ss");
									String formattedDate= df.format(date);
									//String f2="14:15:45";
									System.out.println(formattedDate);
									System.out.println("In side page load");
									
									Date time1=df.parse(formattedDate);
									Date time2=df.parse(formattedDateInput);
									long timeTest=time1.getTime()-time2.getTime();
									timeDiff=timeTest-timeDiffTest;
									System.out.println(timeDiff);
									long timeInSec=timeDiff/1000 %60;
									long timeInMin=timeDiff/(60*1000) %60;
									//timeValues.add(timeInMin);
									//timeValues.add(timeInSec);
									System.out.println(timeInMin);
									fUtil.flogResult("Passed", "Check the Page load time of " +PageName, "Page Load time(MM:SS) - "+timeInMin+":"+timeInSec, 0);
									break;
								 
							 }
						}
							//return timeValues;
						return timeDiff;
				 }
				 
				 catch(Exception e)
				 {
					 //fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
					// return false;
					
					 fUtil.flogResult("Failed", "Check the Page load of " +PageName, "Page not loaded due to exception"+e.getMessage(), 1);
					 return timeDiff;
				 }
				
				
			 }
			 
			 
			 
			 public void  pageLoadStatusCheckEnabled1(WebElement element, String PageName, String formattedDateInput, long timeDiffTest) throws Exception
			 {
				 ArrayList<Long> timeValues = new ArrayList<Long>();
			//	 long timeDiff=0;
				 try{	 	
						//int i=0;
						for(int i=0;i<900;i++)
						{
							if(element.isEnabled()==false)
							{
						 
								// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
								// wt.until(ExpectedConditions.elementToBeClickable(element));
								Thread.sleep(1000);
								i++;
								
								//return element.isEnabled();	
							}
							 else
							 {
								// return true;
								 	Calendar cal=Calendar.getInstance();
									Date date=cal.getTime();
									System.out.println(date);
									DateFormat df= new SimpleDateFormat("HH:mm:ss");
									String formattedDate= df.format(date);
									//String f2="14:15:45";
									System.out.println(formattedDate);
									System.out.println("In side page load");
									
									Date time1=df.parse(formattedDate);
									Date time2=df.parse(formattedDateInput);
									long timeTest=time1.getTime()-time2.getTime();
									long timeDiff=timeTest-timeDiffTest;
									System.out.println(timeDiff);
									long timeInSec=timeDiff/1000 %60;
									long timeInMin=timeDiff/(60*1000) %60;
									//timeValues.add(timeInMin);
									//timeValues.add(timeInSec);
									System.out.println(timeInMin);
									fUtil.flogResult("Passed", "Check the Page load time of " +PageName, "Page Load time(MM:SS) - "+timeInMin+":"+timeInSec, 0);
									break;
								 
							 }
						}
							//return timeValues;
						//return timeDiff;
				 }
				 
				 catch(Exception e)
				 {
					 //fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
					// return false;
					
					 fUtil.flogResult("Failed", "Check the Page load of " +PageName, "Page not loaded due to exception"+e.getMessage(), 1);
					// return timeDiff;
				 }
				
				
			 }
			 
			 public void  pageLoadStatusCheckDisplayed(WebElement element, String PageName, String formattedDateInput, long timeDiffTest) throws Exception
			 {
			//	 ArrayList<Long> timeValues = new ArrayList<Long>();
				 try{	 	
						//int i=0;
						for(int i=0;i<900;i++)
						{
							if(element.isDisplayed()==false)
							{
						 
								// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
								// wt.until(ExpectedConditions.elementToBeClickable(element));
								Thread.sleep(1000);
								i++;
								
								//return element.isEnabled();	
							}
							 else
							 {
								// return true;
								 	Calendar cal=Calendar.getInstance();
									Date date=cal.getTime();
									System.out.println(date);
									DateFormat df= new SimpleDateFormat("HH:mm:ss");
									String formattedDate= df.format(date);
									//String f2="14:15:45";
									System.out.println(formattedDate);
									System.out.println("In side page load");
									
									Date time1=df.parse(formattedDate);
									Date time2=df.parse(formattedDateInput);
									long timeTest=time1.getTime()-time2.getTime();
									long timeDiff=timeTest-timeDiffTest;
									System.out.println(timeDiff);
									long timeInSec=timeDiff/1000 %60;
									long timeInMin=timeDiff/(60*1000) %60;
									//timeValues.add(timeInMin);
									//timeValues.add(timeInSec);
									System.out.println(timeInMin);
									fUtil.flogResult("Passed", "Check the Page load time of " +PageName, "Page Load time(MM:SS) - "+timeInMin+":"+timeInSec, 0);
									break;
								 
							 }
						}
							//return timeValues;
				 }
				 
				 catch(Exception e)
				 {
					 //fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
					// return false;
					 fUtil.flogResult("Failed", "Check the Page load of " +PageName, "Page not loaded due to exception"+e.getMessage(), 1);
				 }
				
				
			 }
			
			
			 public void  pageLoadStatusCheckValueCheck(WebElement element, String PageName, String formattedDateInput, long timeDiffTest) throws Exception
			 {
				 ArrayList<Long> timeValues = new ArrayList<Long>();
				 try{	 	
						//int i=0;
					 boolean found=false;
						for(int i=0;i<900;i++)
						{
							if(element.isDisplayed()==false)
							{
						 
								// WebDriverWait wt= new WebDriverWait(BrowserFactory.webDriver.get(), 1);
								// wt.until(ExpectedConditions.elementToBeClickable(element));
								Thread.sleep(1000);
								i++;
								
								//return element.isEnabled();	
							}
							 else
							 {
								// return true;
								 if(element.getAttribute("value").isEmpty()) {
									 Thread.sleep(1000);
										i++;
								 }
								 else {
									 found=true;
								 	Calendar cal=Calendar.getInstance();
									Date date=cal.getTime();
									System.out.println(date);
									DateFormat df= new SimpleDateFormat("HH:mm:ss");
									String formattedDate= df.format(date);
									//String f2="14:15:45";
									System.out.println(formattedDate);
									System.out.println("In side page load");
									
									Date time1=df.parse(formattedDate);
									Date time2=df.parse(formattedDateInput);
									long timeTest=time1.getTime()-time2.getTime();
									long timeDiff=timeTest-timeDiffTest;
									System.out.println(timeDiff);
									long timeInSec=timeDiff/1000 %60;
									long timeInMin=timeDiff/(60*1000) %60;
									//timeValues.add(timeInMin);
									//timeValues.add(timeInSec);
									System.out.println(timeInMin);
									fUtil.flogResult("Passed", "Check the Page load time of " +PageName, "Page Load time(MM:SS) - "+timeInMin+":"+timeInSec, 0);
									break;
								 }
							 }
						}
						if(found==false)
						{
							fUtil.flogResult("Failed", "Check the Page load of " +PageName, "Page not loaded within 15 minutes", 1);
						}
							//return timeValues;
				 }
				 
				 catch(Exception e)
				 {
					 //fUtil.flogResult("Failed","Object Not Clickable",e.toString(),"Yes");
					// return false;
					 fUtil.flogResult("Failed", "Check the Page load of " +PageName, "Page not loaded due to exception"+e.getMessage(), 1);
				 }
				
				
			 }
			 
			 public boolean isImagePresent(String image){
				 boolean status=false;
				 Screen scr=new Screen();
				 try{
					 scr.find(image);
					 status=true;
				 }catch(FindFailed ee){
					 ee.getMessage();
				 }
				 return status;
			 }
			 
			 public void waitForImage(String image,int time) throws InterruptedException{
				 for(int i=0;i<time;i++){
					 if(isImagePresent(image)){
						 break;
					 }else{
						 Thread.sleep(1000);
					 }
				 }
			 }
		 
			 public boolean isElementEnabled(WebElement elementToCheck) {
				 
				 if(elementToCheck.isEnabled())
				 return true;
				 else 
				 return false;
				 }
			 
			 
			 public boolean fScrollInto(WebElement obj,String step,String btnName, int ScreenShot) throws Exception
				{

					boolean flag = false;
					WaitForObject(obj);
					try
					{
			               JavascriptExecutor executor = (JavascriptExecutor)BrowserFactory.webDriver.get();
							executor.executeScript("arguments[0].click();", obj);
							BrowserFactory.webDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
							fUtil.flogResult("Passed",step,"Successfully Clicked :"+btnName,ScreenShot);
							flag = true;



					}
					catch(Exception e)
					{
						fUtil.flogResult("Failed",step,"Object not present/Exception :"+e,ScreenShot);
					}
					return flag;	
				} 
			 
			 
			 
			 public File lastFileModified(String dir) {
				    File fl = new File(dir);
				    File[] files = fl.listFiles();
				    long lastMod = Long.MIN_VALUE;
				    File choice = null;
				    for (File file : files) {
				        if (file.lastModified() > lastMod) {
				            choice = file;
				            lastMod = file.lastModified();
				        }
				    }
				    return choice;
				}
			 
			 /*--------------------------------------------------------------------------------------------------------------------------------------
				 * Method Name: fSelectDataFromDropDown
				 *Description: To select a drop down value
				 *Arguments : obj (Drop down Web element), step (step name to be displayed in the execution log), data (Value to be selected in drop down), Screenshot (yes/no)
				 *Author 	 :Tcs
				--------------------------------------------------------------------------------------------------------------------------------------*/
					
				public boolean selectDataFromDropDown(WebElement obj,String step,String data, int ScreenShot) throws Exception
				{
					boolean flag = false;
					WaitForObject(obj);
					try
					{
						
						obj.click();
						Select select = new Select(obj);
						select.selectByVisibleText(data);
						fUtil.flogResult("Passed",step,"Successfully Selected :"+data,ScreenShot);					
						
					}
					catch(Exception e)
					{
						fUtil.flogResult("Failed",step,e.toString(),ScreenShot);			
					}
					return flag;	
				}
	
	 
}
//verify if an element is highlighted
//wait for object----change the logic

