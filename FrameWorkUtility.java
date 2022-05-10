package com.QA.TestApp.Utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripperByArea;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import com.relevantcodes.extentreports.LogStatus;

//import RequestSubmissionPage;

public class FrameWorkUtility extends  BaseScript {
	
	//FileUtils fb=new FileUtils();
	public  WebDriver driver=null;
	//ThreadLocal<WebDriver> webDriverLocal = new ThreadLocal<>();
	
	ThreadLocal<File> scrFile = new ThreadLocal<>();
	ThreadLocal<File> descFile = new ThreadLocal<>();
	static ThreadLocal<String> screenhotNameLocal = new ThreadLocal<>();
	File sourceFile;
	File DestinationFile;
	int counterScreenshot=0;
	
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: finitiateDrivers
	 *Description:Initiate Driver Object 
	 *Author 	 :Tcs
	--------------------------------------------------------------------------------------------------------------------------------------
	public void finitiateDriver(int BrowserType, String URL)
	  {
		  switch (BrowserType)
		  {
			  case "IE":
				  System.setProperty("webdriver.ie.driver", .strCurrentDirectory+"//jars//IEDriverServer.exe");	
				  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				  capabilities.setCapability("requireWindowFocus", true);
				  Driver = new InternetExplorerDriver();
				  Driver.get(URL);
			   break;
			  case "FireFox":
				  Driver = new FirefoxDriver();
				  Driver.get(URL);
			   break;
			  case "Chrome":
				  System.setProperty("webdriver.chrome.driver", .strCurrentDirectory+"//jars//chromedriver.exe");
				  ChromeOptions options = new ChromeOptions();
			      options.addArguments("--test-type");
			      options.addArguments("chrome.switches","--disable-extensions");
				  Driver = new ChromeDriver(options);
				  Driver.manage().window().maximize();
				  Driver.get(URL);
			   break;
			   
			  case 1:
				  System.setProperty("webdriver.chrome.driver", "D:\\Pupun\\Study\\Drivers\\chromedriver.exe");
				 // String downloadFilepath=FrameWorkUtility.fgetData("Path1");
				  String downloadFilepath = "C:/Download_File";
				  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				  chromePrefs.put("profile.default_content_settings.popups", 0);
				  chromePrefs.put("download.prompt_for_download", "false");
				  chromePrefs.put("download.default_directory", downloadFilepath);
				  chromePrefs.put("plugins.plugins_disabled", new String[]{"Adobe Flash Player", "Chrome PDF Viewer"});
				  
				  ChromeOptions options = new ChromeOptions();
				  options.setExperimentalOption("prefs", chromePrefs);
				 
				  DesiredCapabilities cap = DesiredCapabilities.chrome();
				  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				  cap.setCapability(ChromeOptions.CAPABILITY, cap);
				  BrowserFactory.getInstance() = new ChromeDriver(options);
				  BrowserFactory.getInstance().manage().window().maximize();
				  BrowserFactory.getInstance().get(URL);
				  
				   System.setProperty("webdriver.chrome.driver", .strCurrentDirectory+"//jars//chromedriver.exe");
				  ChromeOptions options = new ChromeOptions();
			      options.addArguments("--test-type");
			      options.addArguments("chrome.switches","--disable-extensions");
			      options.CAPABILITY=
				  Driver = new ChromeDriver(options);
				  Driver.manage().window().maximize();
				  Driver.get(URL);
				  
				  //TCS
				  String downloadFilepath = "D:\\Download";
				  Map<String, Object> preferences = new Hashtable<String, Object>();
				  preferences.put("profile.default_content_settings.popups", 0);
				  preferences.put("download.prompt_for_download", "false");
				  preferences.put("download.default_directory", downloadFilepath);

				  // disable flash and the PDF viewer
				  preferences.put("plugins.plugins_disabled", new String[]{
				      "Adobe Flash Player", "Chrome PDF Viewer"});

				  //ChromeOptions options = new ChromeOptions();
				  options.setExperimentalOption("prefs", preferences);

				  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				  capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				  Driver = new ChromeDriver(capabilities);
			   break;
		  }
	  }*/
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fGetDataFromExlSheetRowWise
	 *Description: To fetch data from a excel file
	 *Author 	 : Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	public String fGetDataFromExlSheetRowWise(String filePath,String SheetName,int ColNum,String data,int SearchColumn)
	  {
		  String ValueToLookup="";
		  try
		  {
		  FileInputStream file = new FileInputStream(new File(filePath));
		  HSSFWorkbook workbook = new HSSFWorkbook(file);
		  HSSFSheet worksheet = workbook.getSheet(SheetName);
		  int intAppEnvRowNum = worksheet.getPhysicalNumberOfRows();	
		  for(int i = 1 ;i<intAppEnvRowNum;i++)
		  {
			  HSSFRow ExlRow = worksheet.getRow(i);
			  String DataToLookup = ExlRow.getCell(ColNum).getStringCellValue();
			  if(DataToLookup.equals(data))
			  {
				  ValueToLookup = ExlRow.getCell(SearchColumn).getStringCellValue(); 
				 break;
			  }
		  }
		file.close();
		  }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
		  return ValueToLookup;
		  
	  }
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fCreateFolder
	 *Description: To Create a folder in specified path
	 *Author 	 : Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	public void fCreateFolder(String strPath)
	  {
		  File dir = new File(strPath);
		  dir.mkdirs();
	  }
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fGetRandomNumUsingTime
	 *Description: To Create a random number using current system time(MMDDYYHHMMSS Format)
	 *Author 	 : Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	public String fGetRandomNumUsingTime()
	  {
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(calendar.getTime());
		  int month = Calendar.MONTH;
		  int day = Calendar.DAY_OF_MONTH;	  
		  int hours = calendar.get(Calendar.HOUR_OF_DAY);
		  int minutes = calendar.get(Calendar.MINUTE);
		  int seconds = calendar.get(Calendar.SECOND);
		  counterScreenshot=counterScreenshot+1;
		  String Rand = counterScreenshot+Integer.toString(month)+Integer.toString(day)+Integer.toString(hours)+Integer.toString(minutes)+Integer.toString(seconds);
		  return Rand;		  
	  }
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fGetKeywords
	 *Description: To add all the keywords to ArrayList for Sceanrio
	 *Author 	 : Tcs
	--------------------------------------------------------------------------------------------------------------------------------------*/
	public ArrayList<String> fGetKeywords(String path,String SheetName,String header)
	  {
		  ArrayList<String> Keywordwords = new ArrayList<String>();
		  try
		  {
		  FileInputStream file = new FileInputStream(new File(path));
		  HSSFWorkbook workbook = new HSSFWorkbook(file);
		  HSSFSheet worksheet = workbook.getSheet(SheetName);
		  HSSFRow firstRow = worksheet.getRow(0);
		  int intColumnNum = firstRow.getLastCellNum();
		  int intRowNum = worksheet.getPhysicalNumberOfRows();
		  int ScenarioColNum=0;	 
		  int i,j;
		  
		  System.out.println(intRowNum);
		  
		  for(j=0;j<=intColumnNum;j++)
		  {
			  System.out.println(j);
			  String HeaderValue = firstRow.getCell(j).getStringCellValue();
			  System.out.println(HeaderValue);
			  if(HeaderValue.equals(header))
			  {
				  ScenarioColNum = j;
				  break;
			  }
		  }
		  
		  for(i=1;i<intRowNum;i++)
		  {
			  
			  if((worksheet).getRow(i).getCell(ScenarioColNum)==null)
			  {
				  break;			  
			  }
			  else if((worksheet).getRow(i).getCell(ScenarioColNum).toString().equals("")||(worksheet).getRow(i).getCell(ScenarioColNum).toString().equals(" "))
			  {
				  break;
			  }
			  else
			  {
				  Keywordwords.add((worksheet).getRow(i).getCell(ScenarioColNum).getStringCellValue());
			  }
		  }
		   
		file.close();
		  }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Keywordwords; 	  
			  
	  }
	
	/*--------------------------------------------------------------------------------------------------------------------------------------
	 * Method Name: fExecuteKeywords
	 *Description: To Execute keywords in a ArrayList
	 *Author 	 : Tcs
	--------------------------------------------------------------------------------------------------------------------------------------
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public void fExecuteKeywords(ArrayList<String> List,String myClass) throws ClassNotFoundException, Exception
	   {
	 	Class noparams[] = {};
	 	Class[] paramString = new Class[1];	
	 	paramString[0] = String.class;
	 	Class[] paramInt = new Class[1];	
	 	paramInt[0] = Integer.TYPE;
	 	try{
	     
	 	Class cls = Class.forName(.strPackage+"."+myClass);
	 	Object obj = cls.newInstance();		
	 	//call the printIt method
	 	for(int i=0;i<List.size();i++)
	 	{
	 	Method method = cls.getDeclaredMethod(List.get(i),noparams);
	 	@SuppressWarnings("unused")
	 	Object invoke = method.invoke(obj);
	 	}
	 			
	 }catch(Exception ex){
		 ex.printStackTrace();
		 {
				String TestScenario=sheet.getRow(i).getCell(1).getStringCellValue();
				if(TestScenario.equalsIgnoreCase(strScenarioName))
				{  HSSFRow Exlrow = sheet.getRow(0);
					int ColumnCount=Exlrow.getPhysicalNumberOfCells();
					for(int j=0;j<ColumnCount;j++)
				 		{
					 		String ResultStatus=sheet.getRow(0).getCell(j).getStringCellValue();

					 		if(ResultStatus.equalsIgnoreCase("Status"))
					 				{
					 					sheet.getRow(i).createCell(j).setCellValue("Fail");
					 					HSSFCellStyle cell= workbook.createCellStyle();
					 					cell.setFillForegroundColor(IndexedColors.RED.getIndex());
					 					cell.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					 					sheet.getRow(i).getCell(j).setCellStyle(cell);

					 					FileOutputStream fout=new FileOutputStream(strCurrentDirectory+"\\TestPlan.xls");
					 					//Datasheet.write(fout);
					 					workbook.write(fout);
					 					STATUS = "Fail";

					 					break;

					 				}
				 		}
				}
		 }
	 }
				
	 
	 	 
	   }*/
	 
	/* --------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: fgetData
		 *Description: To get test data
		 *Author 	 : Tcs
		--------------------------------------------------------------------------------------------------------------------------------------
	 public String fgetData(String attribute)
	 {
		 FileInputStream TestDataFile ;
		 String Data = null;
		 String scenarioNameValidate=null;
		 String iterationNumberValidate=null;
		 try
		  {	 
		  TestDataFile = new FileInputStream(new File("D:\\Pupun\\Study\\Workspace\\MyFramework\\src\\main\\resources\\Inputs\\DataSheet.xls"));
		  HSSFWorkbook workbook = new HSSFWorkbook(TestDataFile);
		  HSSFSheet worksheet = workbook.getSheet(.strGadgetName);
		  HSSFRow firstRow = worksheet.getRow(0);
		  int intColumnNum = firstRow.getLastCellNum();
		  int intRowNum = worksheet.getPhysicalNumberOfRows();
		  int RowNumberOperating=0;
		  int ScenarioColNum=0;	 
		  int i,j;
		  for(j=1;j<intRowNum;j++)
		  {	
			  Cell cell1 = (worksheet).getRow(j).getCell(1);
			  switch (cell1.getCellType()) 
			  	{
	              case Cell.CELL_TYPE_STRING:
	            	  scenarioNameValidate = (worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getStringCellValue();
	                  break;
	              case Cell.CELL_TYPE_BOOLEAN:
	            	  scenarioNameValidate = Boolean.toString((worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getBooleanCellValue());
	                  break;
	              case Cell.CELL_TYPE_NUMERIC:		            	 
	            	  cell1.setCellType(Cell.CELL_TYPE_STRING);
	            	  scenarioNameValidate = (worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getStringCellValue();
	            	  //Data = Double.toString((worksheet).getRow(i).getCell(ScenarioColNum+.intIterationNum).getNumericCellValue());
	                  break;  
	              case Cell.CELL_TYPE_FORMULA:
	            	  
	            	  
	            	  if (HSSFDateUtil.isCellDateFormatted((worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum))) {
	            	        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            	        scenarioNameValidate = df.format((worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getDateCellValue());
	            	    }
	            	  else
	            	  {
	            		cell1.setCellType(Cell.CELL_TYPE_STRING); 
	            		scenarioNameValidate = (worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getStringCellValue();
	            	  }
	            	 
			  	}
			  Cell cell2 = (worksheet).getRow(j).getCell(0);
			  switch (cell2.getCellType()) 
			  	{
	              case Cell.CELL_TYPE_STRING:
	            	  iterationNumberValidate = (worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getStringCellValue();
	                  break;
	              case Cell.CELL_TYPE_BOOLEAN:
	            	  iterationNumberValidate = Boolean.toString((worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getBooleanCellValue());
	                  break;
	              case Cell.CELL_TYPE_NUMERIC:		            	 
	            	  cell2.setCellType(Cell.CELL_TYPE_STRING);
	            	  iterationNumberValidate = (worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getStringCellValue();
	            	  //Data = Double.toString((worksheet).getRow(i).getCell(ScenarioColNum+.intIterationNum).getNumericCellValue());
	                  break;  
	              case Cell.CELL_TYPE_FORMULA:
	            	  
	            	  
	            	  if (HSSFDateUtil.isCellDateFormatted((worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum))) {
	            	        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            	        iterationNumberValidate = df.format((worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getDateCellValue());
	            	    }
	            	  else
	            	  {
	            		cell2.setCellType(Cell.CELL_TYPE_STRING); 
	            		iterationNumberValidate = (worksheet).getRow(j).getCell(ScenarioColNum+.intIterationNum).getStringCellValue();
	            	  }
	            	 
			  	}
			  scenarioNameValidate=((worksheet).getRow(j).getCell(1).getStringCellValue());
			  iterationNumberValidate=((worksheet).getRow(j).getCell(0).getStringCellValue());
			  int internationNum=Integer.parseInt(iterationNumberValidate);
			  if(scenarioNameValidate.equals(.strScenarioName) && internationNum==.intIterationNum)
			  {
				  RowNumberOperating=j;
				  break;
			  }
			  String HeaderValue = firstRow.getCell(j).getStringCellValue();
			  if(HeaderValue.equals(.strScenarioName))
			  {
				  ScenarioColNum = j;
				  break;
			  }
		  }
		  
		  for(i=2;i<intColumnNum;i++)
		  {
			  String HeaderValue = firstRow.getCell(i).getStringCellValue();
			  if(HeaderValue.equals(attribute))
			  {
				  Cell cell = (worksheet).getRow(RowNumberOperating).getCell(i);
				  switch (cell.getCellType()) 
				  	{
		              case Cell.CELL_TYPE_STRING:
		            	  Data = (worksheet).getRow(RowNumberOperating).getCell(i).getStringCellValue();
		                  break;
		              case Cell.CELL_TYPE_BOOLEAN:
		            	  Data = Boolean.toString((worksheet).getRow(RowNumberOperating).getCell(i).getBooleanCellValue());
		                  break;
		              case Cell.CELL_TYPE_NUMERIC:		            	 
		            	  cell.setCellType(Cell.CELL_TYPE_STRING);
						  Data = (worksheet).getRow(RowNumberOperating).getCell(i).getStringCellValue();
		            	  //Data = Double.toString((worksheet).getRow(i).getCell(ScenarioColNum+.intIterationNum).getNumericCellValue());
		                  break;  
		              case Cell.CELL_TYPE_FORMULA:
		            	  
		            	  
		            	  if (HSSFDateUtil.isCellDateFormatted((worksheet).getRow(RowNumberOperating).getCell(i))) {
		            	        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		            	        Data = df.format((worksheet).getRow(RowNumberOperating).getCell(i).getDateCellValue());
		            	    }
		            	  else
		            	  {
		            		cell.setCellType(Cell.CELL_TYPE_STRING); 
		            		Data = (worksheet).getRow(RowNumberOperating).getCell(i).getStringCellValue();
		            	  }
		            	 
				  	}	
				 // Data = (worksheet).getRow(RowNumberOperating).getCell(i).getStringCellValue();
				  break;
			  }
			  
			  		  
		  }	  
		 
		  TestDataFile.close();   
		
	  }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 catch (Exception ex) {
				ex.printStackTrace();
			}
		return Data;		
		
	 }*/
	 
	 
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: fgetData_MasterSheet_GO
		 *Description: To get test data from MaterSheet for Geo Owner Login
		 *Author 	 : Tcs
		--------------------------------------------------------------------------------------------------------------------------------------	 
	 public String[] fgetData_MasterSheet_GO()
	 {
		 FileInputStream TestDataFile ;
		 String locationValidate=null;
		 String iterationNumberValidate=null;
		 String[] ar = new String[2];
		 String UserName=null, Password=null;
	

		 try
		  {	 
		  TestDataFile = new FileInputStream(new File(.strCurrentDirectory+"\\MasterDataSheet.xls"));
		  HSSFWorkbook workbook = new HSSFWorkbook(TestDataFile);
		  HSSFSheet worksheet = workbook.getSheet("Go_Login");
		  HSSFRow firstRow = worksheet.getRow(0);
		  int intColumnNum = firstRow.getLastCellNum();
		  int intRowNum = worksheet.getPhysicalNumberOfRows();
		  int RowNumberOperating=0;
		  int ScenarioColNum=0;	 
		  String preferredLocation= FrameWorkUtility.fgetData("PreferredLocation");
		  
		  int i,j;
		  for(j=1;j<intRowNum;j++)
		  {	
			  Cell cell1 = (worksheet).getRow(j).getCell(0);
			  switch (cell1.getCellType()) 
			  	{
	              case Cell.CELL_TYPE_STRING:
	            	  locationValidate = cell1.getStringCellValue();
	            	  RowNumberOperating=j;
	            	  if (locationValidate.equals(preferredLocation)) {
	              		Cell uid=(worksheet).getRow(RowNumberOperating).getCell(1);
	              		Cell pwd=(worksheet).getRow(RowNumberOperating).getCell(2);
	          	        
	              		UserName= uid.getStringCellValue();
	              		Password= pwd.getStringCellValue();
	              		ar[0]= UserName;
	          	        ar[1]=Password;

	              	  }
	              	  else
	              	  {
	              		
	              	  }
	                  break;

			  	}
			 
		  }
		  

		  TestDataFile.close();  
	 
		  }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 catch (Exception ex) {
				ex.printStackTrace();
			}
		return ar;
		
		  }*/

		 
	
	 
	 
	/* --------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: fgetData_MasterSheet_GO
		 *Description: To get test data from MaterSheet for Geo Owner Login
		 *Author 	 : Tcs
		--------------------------------------------------------------------------------------------------------------------------------------	 
	 public String fgetData_Output()

	 {
		 FileInputStream TestDataFile ;
		 String data = null;
		 try
		  {	 
		  TestDataFile = new FileInputStream(new File(.strCurrentDirectory+"\\DataSheet.xls"));
		  HSSFWorkbook workbook = new HSSFWorkbook(TestDataFile);
		  HSSFSheet worksheet = workbook.getSheet("Output");
		  HSSFRow firstRow = worksheet.getRow(0);
		  int intColumnNum = firstRow.getLastCellNum();
		  int intRowNum = worksheet.getPhysicalNumberOfRows();
		  int ScenarioColNum=0;	 
		  int i,j;

		  
		 
			  data=((worksheet).getRow(1).getCell(2).getStringCellValue());
		
			  
		  
		 
		
		  TestDataFile.close();   
		
	  }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;		
		
	 }
	 */
		 
	/*
	 --------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: fgetData_MasterSheet_SM
		 *Description: To get test data from MaterSheet for Service Manager Login
		 *Author 	 : Tcs
		--------------------------------------------------------------------------------------------------------------------------------------	 
	 public String[] fgetData_MasterSheet_SM()
	 {
		 FileInputStream TestDataFile ;
		 String focusAreaValidate=null;
		 String iterationNumberValidate=null;
		 String[] ar = new String[2];
		 String UserName=null, Password=null;
	

		 try
		  {	 
		  TestDataFile = new FileInputStream(new File(.strCurrentDirectory+"\\MasterDataSheet.xls"));
		  HSSFWorkbook workbook = new HSSFWorkbook(TestDataFile);
		  HSSFSheet worksheet = workbook.getSheet("SM_Login");
		  HSSFRow firstRow = worksheet.getRow(0);
		  int intColumnNum = firstRow.getLastCellNum();
		  int intRowNum = worksheet.getPhysicalNumberOfRows();
		  int RowNumberOperating=0;
		  int ScenarioColNum=0;	 
		  String focusArea= FrameWorkUtility.fgetData("FocusArea");
		  
		  int i,j;
		  for(j=1;j<intRowNum;j++)
		  {	
			  Cell cell1 = (worksheet).getRow(j).getCell(0);
			  switch (cell1.getCellType()) 
			  	{
	              case Cell.CELL_TYPE_STRING:
	            	  focusAreaValidate = cell1.getStringCellValue();
	            	  RowNumberOperating=j;
	            	  if (focusAreaValidate.equals(focusArea)) {
	              		Cell uid=(worksheet).getRow(RowNumberOperating).getCell(1);
	              		Cell pwd=(worksheet).getRow(RowNumberOperating).getCell(2);
	          	        
	              		UserName= uid.getStringCellValue();
	              		Password= pwd.getStringCellValue();
	              		ar[0]= UserName;
	          	        ar[1]=Password;

	              	  }
	              	  else
	              	  {
	              		
	              	  }
	                  break;

			  	}
			  break;
		  }
		  

		  TestDataFile.close();  
	 
		  }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 catch (Exception ex) {
				ex.printStackTrace();
			}
		return ar;
		
		  }*/

		 
	/* --------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: fgetData
		 *Description: To get test data
		 *Author 	 : Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/
	 public String fgetDataNew(String attribute) throws Exception{
		 FileInputStream TestDataFile ;
		 String Data = null;
		 try{	 
			 	  TestDataFile = new FileInputStream(new File(fUtil.readInput("Data")));
			 	  HSSFWorkbook workbook = new HSSFWorkbook(TestDataFile);
				  HSSFSheet worksheet = workbook.getSheet(gadGetName);
				  HSSFRow firstRow = worksheet.getRow(0);
				  int intColumnNum = firstRow.getLastCellNum();
				  int intRowNum = worksheet.getPhysicalNumberOfRows();
				  int ScenarioColNum=0;
				  int internationNum=0;	 
				  int i,j;
				  for(j=1;j<intRowNum;j++){
					  String HeaderTSValue= (worksheet).getRow(j).getCell(0).getStringCellValue();
					  System.out.println("set="+HeaderTSValue);
					  String HeaderValue= (worksheet).getRow(j).getCell(1).getStringCellValue();
					  System.out.println("case="+HeaderValue);
					  Double HeaderIterationValue= (worksheet).getRow(j).getCell(2).getNumericCellValue();
					  int IterationVal=(int) Math.round(HeaderIterationValue);
			//  String HeaderValue = firstRow.getCell(j).getStringCellValue();
					  if(HeaderValue.equals(scenarioName) && HeaderTSValue.equals(testSetName)){
						  if(IterationVal==iterationValue){
							  	ScenarioColNum = j;
							  	break;
						  }
					  }
				  }
				  for(i=2;i<intColumnNum;i++){
				  
					  if(firstRow.getCell(i).getStringCellValue().equals(attribute)){
		            	  String DataFound = (worksheet).getRow(ScenarioColNum).getCell(i).getStringCellValue();
		            	  if(DataFound.equals("NA")) {
		            		  HSSFSheet worksheetID = workbook.getSheet("IntermediateData");
		            		  HSSFRow firstRowID = worksheetID.getRow(0);
		            		  int intColumnNumID = firstRowID.getLastCellNum();
		            		  int intRowNumID = worksheetID.getPhysicalNumberOfRows();
		            		  int ScenarioColNumID=0;
		            		  int internationNumID=0;	 
		            		  int it,c;
		            		  int numberOfIteration=0;
		            		  boolean found=false;
		            		  //Map<String, Integer> setIterationMap=new HashMap<String, Integer>();
		            		  List<Double> arrRowIterationNum= new ArrayList<Double>(); 
		            		  //double arrRowIterationNum[]=new double[(int) iterationTotalCount]; 
		            		  for(c=1;c<intRowNumID;c++){
		            			  Cell cellStestSet=worksheetID.getRow(c).getCell(0);
		            			  if(cellStestSet != null) {
		            				String testSetNameValue= cellStestSet.getStringCellValue();
		            				double iterationValueHeader= worksheetID.getRow(c).getCell(2).getNumericCellValue();
		            			  
		            				  if(testSetNameValue.equals(testSetName) && iterationValueHeader==iterationValue){
		            				
		            					  ScenarioColNumID = c;
		            					  found=true;
		            				  }
		            			 }
		            		  }
		            		  if(found==true){
		            			  
			            		  for(it=3;it<intColumnNumID;it++){
			            				  
			            			  if(firstRowID.getCell(it).getStringCellValue().equals(attribute)){
			            				  Data = (worksheetID).getRow(ScenarioColNumID).getCell(it).getStringCellValue();
			            		         
			            			  }		  		  
			            		  }	  

		            		  }
		            		  else{
		            			  fUtil.flogResult("Failed", "Read Data from Datasheet", "Column Header is not found", 0);
		            		  }
		            		  
		            	  }	
		            	  else {
		            		  Data=DataFound;
		            	  }
					  }
				  }
		  TestDataFile.close();   
		  }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Data;		
		
	 }
	 
	 public void setLocalDriver(WebDriver d)
	 {
		 driver=d;
		 //driver=webDriverLocal.get();
		 System.out.println("LocalDriver"+driver);
	 }
	 public WebDriver getLocalDriver(WebDriver dv)
	 {
		 return dv;
	 }
	// fUtil.flogResult("Passed",step,btnName,ScreenShot);
	/* --------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: flogResult
		 *Description: To flog result
		 *Author 	 : Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/
	 public void flogResult(String Status,String Step,String Decripion,int ScreenShot) throws Exception{
		 
		 switch (ScreenShot)
		 {
		 case 1:
			// String screenshotName=screenhotNameLocal.get();
			 String screenshotName= "img"+fGetRandomNumUsingTime()+".jpg";
			try {
				
				 //File scrFile = ((TakesScreenshot) browserFactory.getDriver()).getScreenshotAs(OutputType.FILE);
				 //File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				 //File descFile= new File(ResultLocation+"\\Images1\\"+screenshotName);
				// sourceFile= scrFile.get();
				// DestinationFile=descFile.get();
				// sourceFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// DestinationFile= new File(ResultLocation+"\\Images1\\"+screenshotName);
				 System.out.println(screenshotName);
				 //FileUtils.copyFile(sourceFile, DestinationFile);
				 //FileUtils.copyFile(takeScreenshot(), new File(ResultLocation+"\\Images1\\"+screenshotName));
				 FileUtils.copyFile(((TakesScreenshot) BrowserFactory.webDriver.get()).getScreenshotAs(OutputType.FILE), new File(ResultLocation+"\\Images1\\"+screenshotName));
				 System.out.println("My Local Driver:"+BrowserFactory.webDriver.get());
				//FileUtils.copyFile(scrFile, new File(.strCurrentDirectory+"\\screenshot\\img"+fGetRandomNumUsingTime()+".jpg"));
				//FileUtils ft= new FileUtils();
				 
				// copyFile(scrFile, descFile);
				//fb.copyFile(scrFile, new File("C:\\Result"));
			} catch (Exception e) {			
				e.printStackTrace();
			}
			String screenShotPath= ResultLocation+"\\Images1\\"+screenshotName;
			//String image= test.addScreenCapture(screenShotPath);
			String image= ExtentTestManager.getTest().addScreenCapture(screenShotPath);
			
				if(Status.equals("Passed"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, Step+" -- The Actual Is : "+'\n'+Decripion,image);
					//test.log(LogStatus.PASS, Step+" -- The Actual Is : "+'\n'+Decripion,image);
					
					
				}else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, Step +"-- The Actual Is : "+'\n'+Decripion,image);
					
				
				}
				break;
		      case 0: 
			 if(Status.equals("Passed"))
				{
				 ExtentTestManager.getTest().log(LogStatus.PASS,Step,Decripion);
			
				 
				}else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL,Step,Decripion);
				
					
				}
			 	
			 break;
		 }
		 
		 //report.flush();
		 ExtentManager.getInstance().flush();
	 }
	 
	/* --------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: finitiateDrivers
		 *Description:Initiate Driver Object 
		 *Author 	 :Tcs
		--------------------------------------------------------------------------------------------------------------------------------------
		public void finitiateDriverTest(String BrowserType, String URL)
		  {
			  switch (BrowserType)
			  {
				  case "IE":
					  System.setProperty("webdriver.ie.driver", .strCurrentDirectory+"//jars//IEDriverServer.exe");	
					  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					  capabilities.setCapability("requireWindowFocus", true);
					  Driver = new InternetExplorerDriver();
					  Driver.get(URL);
				   break;
				  case "FireFox":
					  Driver = new FirefoxDriver();
					  Driver.get(URL);
				   break;
				  case "Chrome":
					  System.setProperty("webdriver.chrome.driver", .strCurrentDirectory+"//jars//chromedriver.exe");
					  ChromeOptions options = new ChromeOptions();
				      options.addArguments("--test-type");
				      options.addArguments("chrome.switches","--disable-extensions");
					  Driver = new ChromeDriver(options);
					  Driver.manage().window().maximize();
					  Driver.get(URL);
				   break;
				   
				  case "Chrome":
					  System.setProperty("webdriver.chrome.driver", .strCurrentDirectory+"//jars//chromedriver.exe");
					 // String downloadFilepath=FrameWorkUtility.fgetData("Path1");
					  String downloadFilepath = "C:/Download_File";
					  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					  chromePrefs.put("profile.default_content_settings.popups", 0);
					  chromePrefs.put("download.prompt_for_download", "false");
					  chromePrefs.put("download.default_directory", downloadFilepath);
					  chromePrefs.put("plugins.plugins_disabled", new String[]{"Adobe Flash Player", "Chrome PDF Viewer"});
					  
					  ChromeOptions options = new ChromeOptions();
					  options.setExperimentalOption("prefs", chromePrefs);
					 
					  DesiredCapabilities cap = DesiredCapabilities.chrome();
					  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					  cap.setCapability(ChromeOptions.CAPABILITY, cap);
					  
					  Driver = new ChromeDriver(options);
					  Driver.manage().window().maximize();
					  Driver.get(URL);
					  
					   System.setProperty("webdriver.chrome.driver", .strCurrentDirectory+"//jars//chromedriver.exe");
					  ChromeOptions options = new ChromeOptions();
				      options.addArguments("--test-type");
				      options.addArguments("chrome.switches","--disable-extensions");
				      options.CAPABILITY=
					  Driver = new ChromeDriver(options);
					  Driver.manage().window().maximize();
					  Driver.get(URL);
					  
					  //TCS
					  String downloadFilepath = "D:\\Download";
					  Map<String, Object> preferences = new Hashtable<String, Object>();
					  preferences.put("profile.default_content_settings.popups", 0);
					  preferences.put("download.prompt_for_download", "false");
					  preferences.put("download.default_directory", downloadFilepath);

					  // disable flash and the PDF viewer
					  preferences.put("plugins.plugins_disabled", new String[]{
					      "Adobe Flash Player", "Chrome PDF Viewer"});

					  //ChromeOptions options = new ChromeOptions();
					  options.setExperimentalOption("prefs", preferences);

					  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					  capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					  Driver = new ChromeDriver(capabilities);
				   break;
			  }
		  }
*/
	 public boolean verifyPDFContent(String strURL, String reqTextInPDF, int startPage) {
			
			boolean flag = false;
			
			PDFTextStripperByArea pdfStripper = null;
			PDDocument pdDoc = null;
			COSDocument cosDoc = null;
			String parsedText = null;

			try {
				URL url = new URL(strURL);
				BufferedInputStream file = new BufferedInputStream(url.openStream());
				PDFParser parser = new PDFParser( file);
				
				parser.parse();
				cosDoc = parser.getDocument();
				pdfStripper = new PDFTextStripperByArea();
				pdfStripper.setStartPage(startPage);
				pdfStripper.setEndPage(1);
				
				pdDoc = new PDDocument(cosDoc);
				parsedText = pdfStripper.getText(pdDoc);
				System.out.println(parsedText);
			} catch (MalformedURLException e2) {
				System.err.println("URL string could not be parsed "+e2.getMessage());
			} catch (IOException e) {
				System.err.println("Unable to open PDF Parser. " + e.getMessage());
				try {
					if (cosDoc != null)
						cosDoc.close();
					if (pdDoc != null)
						pdDoc.close();
				} catch (Exception e1) {
					e.printStackTrace();
				}
			}
			
			System.out.println("+++++++++++++++++");
			System.out.println(parsedText);
			System.out.println("+++++++++++++++++");

			if(parsedText.contains(reqTextInPDF)) {
				flag=true;
			}
			
			return flag;
		}
	 /*--------------------------------------------------------------------------------------------------------------------------------------
		 * Method Name: fgetData_MasterSheet_GO
		 *Description: To get test data from MaterSheet for Geo Owner Login
		 *Author 	 : Tcs
		--------------------------------------------------------------------------------------------------------------------------------------*/
public String readInput(String parameter) throws IOException{
	File file = new File("D:\\Oshina_eclipse_ws\\OIC_RTA\\Config.properties");
	FileInputStream properties = new FileInputStream(file);
	Properties prop = new Properties();
	prop.load(properties);
	prop.getProperty(parameter);
	return prop.getProperty(parameter);
	
}

/* --------------------------------------------------------------------------------------------------------------------------------------
 * Method Name: fgetData
 *Description: To get test data
 *Author 	 : Tcs
--------------------------------------------------------------------------------------------------------------------------------------*/
public void fWriteData(String attribute, String data)
{
 FileInputStream TestDataFile ;
 FileOutputStream TestDataFileWrite ;
 String Data = null;
 try
  {	 
  TestDataFile = new FileInputStream(new File(fUtil.readInput("Data")));
  HSSFWorkbook workbook = new HSSFWorkbook(TestDataFile);
  HSSFSheet worksheet = workbook.getSheet("IntermediateData");
  HSSFRow firstRow = worksheet.getRow(0);
  int intColumnNum = firstRow.getLastCellNum();
  int intRowNum = worksheet.getPhysicalNumberOfRows();
  int ScenarioColNum=0;
  int internationNum=0;	 
  int i,j;
  int numberOfIteration=0;
  boolean found=false;
  //Map<String, Integer> setIterationMap=new HashMap<String, Integer>();
  List<Double> arrRowIterationNum= new ArrayList<Double>(); 
  //double arrRowIterationNum[]=new double[(int) iterationTotalCount]; 
  for(j=1;j<intRowNum;j++)
  {
	  Cell cellStestSet=worksheet.getRow(j).getCell(0);
	  if(cellStestSet != null) {
	  String testSetNameValue= cellStestSet.getStringCellValue();
	  //String HeaderValue= (worksheet).getRow(j).getCell(1).getStringCellValue();
	  //Double HeaderIterationValue= (worksheet).getRow(j).getCell(2).getNumericCellValue();
	  //int IterationVal=(int) Math.round(HeaderIterationValue);
	//  String HeaderValue = firstRow.getCell(j).getStringCellValue();
	  if(testSetNameValue.equals(testSetName))
	  {
		  numberOfIteration++;
		  //setIterationMap.put(testSetName, j);	
		  arrRowIterationNum.add((double) j);
		 // ScenarioColNum = j;
			  found=true;
	}
	  }
}
  if(found==true)
  {
	  
	  
	  if(iterationValue==arrRowIterationNum.size() || iterationValue<arrRowIterationNum.size())
	  {
		  for(int k=0;k<arrRowIterationNum.size();k++) 
		  {
			 // HSSFRow rowWrite = worksheet.getRow((int) arrRowIterationNum[k]);
			  //int intColumnNum = firstRow.getLastCellNum();
			  Double iterationCheck =worksheet.getRow((int) Math.round(arrRowIterationNum.get(k))).getCell(2).getNumericCellValue();
			  
			  if(iterationCheck==iterationValue)
			  {
				  ScenarioColNum=(int) Math.round(arrRowIterationNum.get(k));
			  }
		  }
	  }
	  else
	  {
		 // if(iterationValue>arrRowIterationNum.length) {
			//  for(int l=0;l<iterationTotalCount;l++)
			//  {
		  int rowCount1=0;	  
		  rowCount1=worksheet.getPhysicalNumberOfRows();
		  		  HSSFRow newRow= worksheet.createRow(rowCount1);
				  Cell cell1 = newRow.createCell(0);
				  Cell cell2 = newRow.createCell(1);
				  Cell cell3 = newRow.createCell(2);
				  cell1.setCellValue(testSetName);
				  cell2.setCellValue(scenarioName);
				  cell3.setCellValue(iterationValue);
				  ScenarioColNum = rowCount1;
			//  }
		//  }
	  }
	  
  }
  
  else{
	  int rowCount2=0;
	  rowCount2=worksheet.getPhysicalNumberOfRows();
	  HSSFRow newRow1= worksheet.createRow(rowCount2);
	  Cell cell11 = newRow1.createCell(0);
	  Cell cell22 = newRow1.createCell(1);
	  Cell cell33 = newRow1.createCell(2);
	  cell11.setCellValue(testSetName);
	  cell22.setCellValue(scenarioName);
	  cell33.setCellValue(iterationValue);
	  ScenarioColNum = rowCount2;
  }
  
  for(i=3;i<intColumnNum;i++)
  {
	 // if(((worksheet).getRow(i).getCell(ScenarioColNum).getStringCellValue()).equals(attribute))
		  
	if(firstRow.getCell(i).getStringCellValue().equals(attribute))
	  {
		Cell cell4 = (worksheet).getRow(ScenarioColNum).createCell(i);	  
		(worksheet).getRow(ScenarioColNum).getCell(i).setCellValue(data);
            	  
         
	  }		  		  
  }	  
  TestDataFileWrite = new FileOutputStream(new File(fUtil.readInput("Data")));
  workbook.write(TestDataFileWrite);
  TestDataFileWrite.close();   

}
catch(FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}		

}

/* --------------------------------------------------------------------------------------------------------------------------------------
 * Method Name: fgetData
 *Description: To get test data
 *Author 	 : Tcs
--------------------------------------------------------------------------------------------------------------------------------------*/
public void fCopyReportFile(String filePath1, String filePath2) throws IOException
{
	  File originalWb = new File(filePath1);
	  File clonedWb = new File(filePath2);
	  FileUtils.copyFile(originalWb, clonedWb);
}
/* --------------------------------------------------------------------------------------------------------------------------------------
 * Method Name: fgetData
 *Description: To get test data
 *Author 	 : Tcs
--------------------------------------------------------------------------------------------------------------------------------------*/
public void fWriteBusinessData(String LOB, String Application, String Module, String TestSet, String TestCase, String Status, String filePath2)
{
 FileInputStream ReportFile ;
 FileOutputStream TestDataFileWrite ;
 String Data = null;
 try
  {	
	 

  //Files.copy(originalWb.toPath(), clonedWb.toPath());	 
	
  ReportFile = new FileInputStream(new File(filePath2));
  HSSFWorkbook workbook = new HSSFWorkbook(ReportFile);
  HSSFSheet worksheet = workbook.getSheet("Detail Status");
  HSSFRow firstRow = worksheet.getRow(0);
  
  int intColumnNum = firstRow.getLastCellNum();
  int intRowNum = worksheet.getPhysicalNumberOfRows();

 // for(int j=1;j<=intRowNum;j++)
  //{
	//  if(intRowNum==1){
		  HSSFRow newRow= worksheet.createRow(intRowNum);
		  Cell cell1 = newRow.createCell(0);
		  Cell cell2 = newRow.createCell(1);
		  Cell cell3 = newRow.createCell(2);
		  Cell cell4 = newRow.createCell(3);
		  Cell cell5 = newRow.createCell(4);
		  Cell cell6 = newRow.createCell(5);
		  
		  cell1.setCellValue(LOB);
		  cell2.setCellValue(Application);
		  cell3.setCellValue(Module);
		  cell4.setCellValue(TestSet);
		  cell5.setCellValue(TestCase);
		  cell6.setCellValue(Status);
		  TestDataFileWrite = new FileOutputStream(new File(filePath2));
		  workbook.write(TestDataFileWrite);
		  workbook.close();
		  TestDataFileWrite.close(); 
	//	  break;
	 // }else{
	  
	//  Cell cellStestSet=worksheet.getRow(j).getCell(0);
	//  if(cellStestSet != null) {
		//  int rowCount1=0;	  
		//  rowCount1=worksheet.getPhysicalNumberOfRows();
		  	/*	  HSSFRow newRow= worksheet.createRow(j);
				  Cell cell1 = newRow.createCell(0);
				  Cell cell2 = newRow.createCell(1);
				  Cell cell3 = newRow.createCell(2);
				  Cell cell4 = newRow.createCell(3);
				  Cell cell5 = newRow.createCell(4);
				  Cell cell6 = newRow.createCell(5);
				  
				  cell1.setCellValue(LOB);
				  cell2.setCellValue(Application);
				  cell3.setCellValue(Module);
				  cell4.setCellValue(TestSet);
				  cell5.setCellValue(TestCase);
				  cell6.setCellValue(Status);
				  TestDataFileWrite = new FileOutputStream(new File(filePath));
				  workbook.write(TestDataFileWrite);
				  workbook.close();
				  TestDataFileWrite.close(); 
				  break;
				  }	   */
//  }
 // }
}
catch(FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}		

}

/* --------------------------------------------------------------------------------------------------------------------------------------
 * Method Name: fgetData
 *Description: To get test data
 *Author 	 : Tcs
--------------------------------------------------------------------------------------------------------------------------------------*/
public String fgetDataNew1(String attribute) throws Exception{
 FileInputStream TestDataFile ;
 String Data = null;
 try{	 
	 	  TestDataFile = new FileInputStream(new File(fUtil.readInput("DataNew")+testSetName+".xls"));
	 	  HSSFWorkbook workbook = new HSSFWorkbook(TestDataFile);
		  HSSFSheet worksheet = workbook.getSheet("Sheet1");
		  HSSFRow firstRow = worksheet.getRow(0);
		  int intColumnNum = firstRow.getLastCellNum();
		  int intRowNum = worksheet.getPhysicalNumberOfRows();
		  int ScenarioColNum=0;
		  int internationNum=0;	 
		  int i,j;
		  for(j=1;j<intRowNum;j++){
			  String HeaderTSValue= (worksheet).getRow(j).getCell(0).getStringCellValue();
			  System.out.println("set="+HeaderTSValue);
			  String HeaderValue= (worksheet).getRow(j).getCell(1).getStringCellValue();
			  System.out.println("case="+HeaderValue);
			  Double HeaderIterationValue= (worksheet).getRow(j).getCell(2).getNumericCellValue();
			  int IterationVal=(int) Math.round(HeaderIterationValue);
	//  String HeaderValue = firstRow.getCell(j).getStringCellValue();
			  if(HeaderValue.equals(scenarioName) && HeaderTSValue.equals(testSetName)){
				  if(IterationVal==iterationValue){
					  	ScenarioColNum = j;
					  	break;
				  }
			  }
		  }
		  for(i=2;i<intColumnNum;i++){
		  
			  if(firstRow.getCell(i).getStringCellValue().equals(attribute)){
            	  String DataFound = (worksheet).getRow(ScenarioColNum).getCell(i).getStringCellValue();
            	  if(DataFound.equals("NA")) {
            		  HSSFSheet worksheetID = workbook.getSheet("IntermediateData");
            		  HSSFRow firstRowID = worksheetID.getRow(0);
            		  int intColumnNumID = firstRowID.getLastCellNum();
            		  int intRowNumID = worksheetID.getPhysicalNumberOfRows();
            		  int ScenarioColNumID=0;
            		  int internationNumID=0;	 
            		  int it,c;
            		  int numberOfIteration=0;
            		  boolean found=false;
            		  //Map<String, Integer> setIterationMap=new HashMap<String, Integer>();
            		  List<Double> arrRowIterationNum= new ArrayList<Double>(); 
            		  //double arrRowIterationNum[]=new double[(int) iterationTotalCount]; 
            		  for(c=1;c<intRowNumID;c++){
            			  Cell cellStestSet=worksheetID.getRow(c).getCell(0);
            			  if(cellStestSet != null) {
            				String testSetNameValue= cellStestSet.getStringCellValue();
            				double iterationValueHeader= worksheetID.getRow(c).getCell(2).getNumericCellValue();
            			  
            				  if(testSetNameValue.equals(testSetName) && iterationValueHeader==iterationValue){
            				
            					  ScenarioColNumID = c;
            					  found=true;
            				  }
            			 }
            		  }
            		  if(found==true){
            			  
	            		  for(it=3;it<intColumnNumID;it++){
	            				  
	            			  if(firstRowID.getCell(it).getStringCellValue().equals(attribute)){
	            				  Data = (worksheetID).getRow(ScenarioColNumID).getCell(it).getStringCellValue();
	            		         
	            			  }		  		  
	            		  }	  

            		  }
            		  else{
            			  fUtil.flogResult("Failed", "Read Data from Datasheet", "Column Header is not found", 0);
            		  }
            		  
            	  }	
            	  else {
            		  Data=DataFound;
            	  }
			  }
		  }
  TestDataFile.close();   
  }
catch(FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
return Data;		

}

}