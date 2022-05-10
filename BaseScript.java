package com.QA.TestApp.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.QA.TestApp.Pages.AdditionalPolicyDetailsPage;
import com.QA.TestApp.Pages.B2BDetailpage;
import com.QA.TestApp.Pages.B2BHomePage;
import com.QA.TestApp.Pages.B2BLogin;
import com.QA.TestApp.Pages.B2BPage2;
import com.QA.TestApp.Pages.B2BPaymentDetails;
import com.QA.TestApp.Pages.B2BPom;
import com.QA.TestApp.Pages.B2BPom_1Page;
import com.QA.TestApp.Pages.B2BTravelInsuranceHome;
import com.QA.TestApp.Pages.B2BpaymentGateway;
import com.QA.TestApp.Pages.BancsDriverDetailsPage;
import com.QA.TestApp.Pages.BancsFollowUpTab;
import com.QA.TestApp.Pages.BancsLandingPage;
import com.QA.TestApp.Pages.BancsPremiumSchedulePage;
import com.QA.TestApp.Pages.BancsSearchTablePage;
import com.QA.TestApp.Pages.BancsTableDataDetails;
import com.QA.TestApp.Pages.Bancsadditionalpolicydeatils;
import com.QA.TestApp.Pages.BancsbasicDetailspage;
import com.QA.TestApp.Pages.BancsbasicpolicyDetailspage;
import com.QA.TestApp.Pages.BansHomepage;
import com.QA.TestApp.Pages.BansLoginPageBancs;
import com.QA.TestApp.Pages.BansPolicySearch;
import com.QA.TestApp.Pages.BansSummaryPage;
import com.QA.TestApp.Pages.Bansdocumentpage;
import com.QA.TestApp.Pages.BansliabilityDetailspage;
import com.QA.TestApp.Pages.BanspartyCodeSearchpage;
import com.QA.TestApp.Pages.BanspartyRoles;
import com.QA.TestApp.Pages.BanspolicyRelationspage;
import com.QA.TestApp.Pages.Bansreinsurance;
import com.QA.TestApp.Pages.BansvehicleDetails;
import com.QA.TestApp.Pages.BasicDetail;
import com.QA.TestApp.Pages.BasicDetailPage;
import com.QA.TestApp.Pages.BasicPolicyDetailsPage;
import com.QA.TestApp.Pages.BillingPage;
import com.QA.TestApp.Pages.Book_a_Travel_PolicyPage;
import com.QA.TestApp.Pages.C360Page;
import com.QA.TestApp.Pages.CONOPSPolicyCreationPage;
import com.QA.TestApp.Pages.Cancellation;
import com.QA.TestApp.Pages.Cancellation5Page;
import com.QA.TestApp.Pages.Cancellation_4Page;
import com.QA.TestApp.Pages.Cancellation_New_PageObj;
import com.QA.TestApp.Pages.CessionofPolicy;
import com.QA.TestApp.Pages.ContactsPage;
import com.QA.TestApp.Pages.DocumentPage;
import com.QA.TestApp.Pages.Endorsement5Page;
import com.QA.TestApp.Pages.Endorsement9Page;
import com.QA.TestApp.Pages.EndorsementPage;
import com.QA.TestApp.Pages.Endorsement_4Page;
import com.QA.TestApp.Pages.Endorsement_New_PageObj;
import com.QA.TestApp.Pages.Fleet_Addition_Of_VehiclePage;
import com.QA.TestApp.Pages.GmailLogin;
import com.QA.TestApp.Pages.Homepage;
import com.QA.TestApp.Pages.InsuredDetailsPage;
import com.QA.TestApp.Pages.Intimate_new_claimPage;
import com.QA.TestApp.Pages.LiabilityDetailsPage;
import com.QA.TestApp.Pages.LocalMailPage;
import com.QA.TestApp.Pages.LoginPage;
import com.QA.TestApp.Pages.LoginPageBancs;
import com.QA.TestApp.Pages.Module_B2BPage;
import com.QA.TestApp.Pages.Motor_TPL_PageObjects;
import com.QA.TestApp.Pages.NewBusiness5page;
import com.QA.TestApp.Pages.NewBusiness9page;
import com.QA.TestApp.Pages.NewBusinessB2BPage;
import com.QA.TestApp.Pages.NewBusinessBPage;
import com.QA.TestApp.Pages.NewBusinessBancsLogin;
import com.QA.TestApp.Pages.NewBusinessPOM;
import com.QA.TestApp.Pages.NewBusinessPage6;
import com.QA.TestApp.Pages.New_Business2Page;
import com.QA.TestApp.Pages.New_BusinessPage;
import com.QA.TestApp.Pages.Of_Receipt_CreationPage;
import com.QA.TestApp.Pages.OracleFinancePage;
import com.QA.TestApp.Pages.PartyAuditTrailPage;
import com.QA.TestApp.Pages.PartyDetailPage;
import com.QA.TestApp.Pages.PartyFunctionPage;
import com.QA.TestApp.Pages.PartyPage;
import com.QA.TestApp.Pages.PartyPropertyDetailsPage;
import com.QA.TestApp.Pages.PartySearch;
import com.QA.TestApp.Pages.PartySummaryPage;
import com.QA.TestApp.Pages.PartyVersionListPage;
import com.QA.TestApp.Pages.PayPlanDetailScreenPage;
import com.QA.TestApp.Pages.PolicyRelation;
import com.QA.TestApp.Pages.PolicyRelationDetail;
import com.QA.TestApp.Pages.PolicyRelationPage;
import com.QA.TestApp.Pages.PolicyRenewalPage;
import com.QA.TestApp.Pages.PolicySearchPage;
import com.QA.TestApp.Pages.RenewalofPolicy;
import com.QA.TestApp.Pages.RiskDetail;
//import com.QA.TestApp.Pages.SearchPollicyNo;
import com.QA.TestApp.Pages.SearchPollicyNoPage;
import com.QA.TestApp.Pages.SearchingPoliciesAndQuotesPage;
import com.QA.TestApp.Pages.SelectClaimEnquiryPage;
import com.QA.TestApp.Pages.SummaryPage;
import com.QA.TestApp.Pages.UnderwritingBatchProcessesPage;
import com.QA.TestApp.Pages.VehicleDetail;
import com.QA.TestApp.Pages.VehicleDetailsPage;
import com.QA.TestApp.Pages.claims;
import com.QA.TestApp.Pages.newBusinessbancs1;

public class BaseScript{
public static HSSFWorkbook workbook;
public static HSSFSheet sheet;
public static FileInputStream file;
public static String strScenarioName ;
public static String strTestSetName;
public static String strTestcaseName;
public static String strGadgetName;
public static String strEnvironment;
public static String strUserID;
public static String strParallelFlag;
public static String strServiceManager;
public static String strPWD;
public static String decryptedPassword;
public static String strTCDesc;
public static String intTCIteration;
public static double intIteration;
public static WebDriver Driver;
public BrowserFactory browserFactory;
public static int intIterationNum;
public static int iterationValue;
public static double iterationTotalCount;
public static String scenarioName;
public static String testSetName;
public static String gadGetName;
public static int testcaseCountPerSet=0;


//public static ExtentReports report;
//public ExtentTest test;
//public static ReportManager lt;
public static String Browser;
public static String URL;	
public static FrameWorkUtility fUtil=new FrameWorkUtility();
public static GeneralFunctions gmethods=new GeneralFunctions();
public static List<String> testCaseNames=new ArrayList<String>();
public static List<String> moduleNames=new ArrayList<String>();
public static List<String> environmentNames=new ArrayList<String>();

//public static CreateTentNGTest dscript;
//public static SignUpPage signUpPage;
public LoginPage signUpPage;
public GmailLogin gmailLogin;
public LoginPageBancs loginPageBancs;
public SelectClaimEnquiryPage selectClaimEnquiryPage;
public LocalMailPage localMailPage;
public BancsLandingPage bancsLandingPage; 
public NewBusinessBancsLogin BancsLogin; 
public BasicDetailPage basicDetailPage;
public PolicyRelationPage policyRelationPage;
public BasicPolicyDetailsPage basicPolicyDetailsPage;
public LiabilityDetailsPage liabilityDetailsPage;
public AdditionalPolicyDetailsPage additionalPolicyDetailsPage;
public SummaryPage summaryPage;
public Of_Receipt_CreationPage of_Receipt_CreationPage;
public CONOPSPolicyCreationPage conopspolicycreationpage;
public PolicyRenewalPage policyrenewalPage;
public  DocumentPage documentpage;
public Fleet_Addition_Of_VehiclePage fleet_Addition_Of_VehiclePage;
public SearchPollicyNoPage searchPollicyNoBancs;
public OracleFinancePage oracleFinancePage;
public Book_a_Travel_PolicyPage book_a_Travel_PolicyPage;
public CessionofPolicy CessionOfAPolicy;
public RenewalofPolicy RenewalOfAPolicy;
public PolicySearchPage policy;
public PartyPage partyPage;
public ContactsPage contactsPage;
public B2BDetailpage B2BDetailpage;
public B2BHomePage B2BHomePage;
public B2BLogin B2BLogin;
public B2BPaymentDetails B2BPaymentDetails;
public B2BTravelInsuranceHome B2BTravelInsuranceHome;
public BasicDetail BasicDetail;
public PartySearch PartySearch;
public PolicyRelation PolicyRelation;
public PolicyRelationDetail PolicyRelationDetail;
public RiskDetail RiskDetail;
public VehicleDetail VehicleDetail;
public Intimate_new_claimPage intimate_new_claimPage;
public Homepage bookanIndividualMotorPolicy;
public B2BPom b2bPOMPage;
public PartyDetailPage partyDetailPage;

public BansLoginPageBancs bancsloginPageBancs;
public BansHomepage bancsHomepg;
public  BansPolicySearch  bancspolicy;
public  BansSummaryPage bancssummaryPage;
public  BancsbasicDetailspage bancsbasicDetails;
public  BansvehicleDetails  bancsvehicledetails;
public  BanspartyCodeSearchpage bancspartycodesearchpage;
public  BanspolicyRelationspage bancspolicyrelationspage;
public BancsbasicpolicyDetailspage bancsbasicpolicydetailspage;
public BansliabilityDetailspage bancsliabilitydetailspage;
public Bancsadditionalpolicydeatils bancsadditionalPolicydeatils;
public Bansreinsurance bancsreinsurancepage;
public  Bansdocumentpage bancsdocumentPage;
public  B2BpaymentGateway b2BpaymentGateway;
public VehicleDetailsPage vehicledetailspage;
public NewBusinessPOM NewBusinesspOM;
public New_BusinessPage  new_BusinessPage;
public NewBusinessB2BPage newBusinessB2BPage;

public BillingPage billingpage;
public EndorsementPage endorsementPage;
public New_Business2Page new_Business2Page;
public C360Page c360Page;


/*Added by Hansika on 24th May 2019*/
public PartyVersionListPage partyVersionListPage;
public PartyAuditTrailPage partyAuditTrailPage;
public PartySummaryPage partySummaryPage;
public PartyFunctionPage partyFunctionPage;
public PartyPropertyDetailsPage partyPropertyDetailsPage;

//Added by Hansika for B2B Renewal on 3rd June 2019
public SearchingPoliciesAndQuotesPage searchingPoliciesAndQuotesPage;
public BanspartyRoles banspartyRoles;
public BancsSearchTablePage bancsSearchTablePage;
public BancsTableDataDetails bancsTableDataDetails;
public PayPlanDetailScreenPage payPlanDetailScreenPage;
public UnderwritingBatchProcessesPage underwritingBatchProcessesPage;
public BancsFollowUpTab bancsFollowUpTab;
//Added by Abinash on 5th July
public Module_B2BPage b2bpage;
 public NewBusiness5page newBusiness5page;
public claims claimsPage;
public Cancellation  cancellation;
public NewBusinessPage6 newBusinessPage;

//Added by Abinash on 5th Aug
public BancsDriverDetailsPage driverdetailsPage;
public Motor_TPL_PageObjects motor_TPL_PageObjects;
public newBusinessbancs1 newBusinessbancs;

//Added by Satish
public BancsDriverDetailsPage bancsDriverdetailsPage;

//Added by Abinash on 5th Aug
public BancsbasicDetailspage driverDetailsPage;

public NewBusiness5page NewBusiness5page;
//Oshina
public Endorsement_New_PageObj endorsement_New_PageObj;
public Cancellation_New_PageObj cancellation_New_PageObj;
//added on 1st oct
public Endorsement9Page endorsement9Page;
public BancsPremiumSchedulePage bancsPremiumSchedulePage; 
public B2BPage2 b2BPage2;
public NewBusinessBPage newBusinessBPage; 
public NewBusiness9page newBusiness9page;
public Cancellation5Page cancellation5Page;
public Endorsement_4Page Endorsement_Page3;
public Cancellation_4Page Cancellation_Page3;
public B2BPom_1Page B2BPom_1page;
public Endorsement5Page endorsement5Page; 
public InsuredDetailsPage insuredDetailsPage;

//public SearchPollicyNo SearchPollicyNoBancs;
//public static String xx;
public static String ResultLocation= "C:\\Phase2 Results\\Reports\\TC_Bancs_Property_End_013"; //"C:\\Users\\1527483\\Defect_Fixed_Result\\TC_B2B_GENERAL_040";
public static Map<String, String> scenarioGadgetMap;
public static Map<String, Integer> scenarioIterationMap;
public static Map<String, String> scenarioBrowserMap;
public static Map<String, String> scenarioURLMap;


public static String reportName;
public int a;
public static String cancellationTestCaseName;
	
	
public static String getReportNameTestNG()
{
	fUtil.fCreateFolder(ResultLocation);
	fUtil.fCreateFolder (ResultLocation+"\\Images1");
	String reportName1=ResultLocation+"\\ExecutionReport"+fUtil.fGetRandomNumUsingTime()+".html";
	return reportName1;
}
	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	//iterationValue=1;
	//fUtil.verifyPDFContent("http://10.40.32.59:9080/IIMS/document/tempDOWNLOAD/0101_MEMO_12727419.pdf", "Arslan", 1);
	
	scenarioGadgetMap = new HashMap<String, String>();
	scenarioIterationMap=new HashMap<String, Integer>();
	scenarioBrowserMap=new HashMap<String, String>();
	scenarioURLMap=new HashMap<String, String>();
	
	ArrayList<String> listeners = new ArrayList<String>();
    listeners.add("com.QA.TestApp.Utilities.PriorityInterceptor");
	//BaseScript bs=new BaseScript();


	XmlSuite xmlSuite=new XmlSuite();
	xmlSuite.setName("Suite1");
	xmlSuite.setListeners(listeners);
	//xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
	//xmlSuite.setThreadCount(4);
	xmlSuite.setVerbose(1);
	
	List<String> TCNames=new ArrayList<String>();
	try
	{
	
		  file= new FileInputStream(new File(fUtil.readInput("TestPlan")));
		  workbook = new HSSFWorkbook(file);		  		  
		  sheet = workbook.getSheet("ExecuteScript");
		  int intRowNum = sheet.getPhysicalNumberOfRows();
		  int executableTCCount=0;
		  for(int i =1;i<intRowNum;i++){
			  HSSFRow Exlrow = sheet.getRow(i);
			  String flag = Exlrow.getCell(6).getStringCellValue();
			  
			  if (Exlrow.getCell(7) != null) {
				  intIteration = Exlrow.getCell(7).getNumericCellValue();
			 
			  }				  
			  if(flag.equals("Y"))
				  {
					  
					  /*String test=sheet.getRow(i+1).getCell(6).getStringCellValue();
					  i++;
					  String test1=sheet.getRow(i+1).getCell(6).getStringCellValue();
					  System.out.println(test1);
					  if(test.equals(""))
					  {
						  System.out.println("aaaa");
					  }*/
				  testCaseNames.clear();
				  moduleNames.clear();
				  environmentNames.clear();
					  for(int iterator=1;iterator<=intIteration;iterator++)
					  {
						  testcaseCountPerSet=0;
						 // strtestSetName = Exlrow.getCell(1).getStringCellValue();
						   String testCaseName=Exlrow.getCell(3).getStringCellValue();
						   
						   cancellationTestCaseName = Exlrow.getCell(3).getStringCellValue();
						   
						   String moduleName = Exlrow.getCell(4).getStringCellValue();
						   String envName = Exlrow.getCell(5).getStringCellValue();
						   testCaseNames.add(testCaseName);
						   moduleNames.add(moduleName);
						   environmentNames.add(envName);
						  // String ss=sheet.getRow(i+1).getCell(6).getStringCellValue();
						  // System.out.println(ss);
						   int y=i;
						   while(y<intRowNum-1 && sheet.getRow(y+1).getCell(6).getStringCellValue().equals("")){
							  	testcaseCountPerSet=testcaseCountPerSet+1;
							  	String testCase=(sheet.getRow(y+1)).getCell(3).getStringCellValue();
							  	String module=(sheet.getRow(y+1)).getCell(4).getStringCellValue();
							  	String env=(sheet.getRow(y+1)).getCell(5).getStringCellValue();
							  	testCaseNames.add(testCase);
							  	moduleNames.add(module);
							  	environmentNames.add(env);
							  	System.out.println(testcaseCountPerSet);
							  	y++;
						  	}
						  /*if(sheet.getRow(i+1).getCell(6).getStringCellValue().equals(""))
						  {
							  
						  }*/
						  for(int iTest=0;iTest<=testcaseCountPerSet;iTest++) {
							  
						  
							  executableTCCount=executableTCCount+1;
							  
							  strScenarioName = testCaseNames.get(iTest);
							  strTestSetName = Exlrow.getCell(1).getStringCellValue();
							  strGadgetName = moduleNames.get(iTest);
							  strEnvironment = environmentNames.get(iTest);
						
							  strTCDesc = Exlrow.getCell(2).getStringCellValue(); 	
							 // if(iterator>1)
							 // {
								  
							  //pradeep
							  	  String strScenarioNameIteration=strTestSetName+"TS"+strScenarioName+"Dataset"+iterator;
							  	//String strScenarioNameIteration=strScenarioName+"Dataset"+iterator;
							  	  //pradeep
								  TCNames.add(strScenarioNameIteration);
								  //String iterationString=Integer.toString(iterator);
								  scenarioIterationMap.put(strScenarioNameIteration, iterator);
								  
							//  }
							 // else
							 // {
							 
								//  TCNames.add(strScenarioName);
								  //String iterationString=Integer.toString(iterator);
								  //scenarioIterationMap.put(strScenarioName, iterator);
								  
							 // }
							
							  scenarioGadgetMap.put(strScenarioName,strGadgetName);
							 // String iterationString=Integer.toString(iterator);
							 // scenarioIterationMap.put(strScenarioName, iterationString);
							  //scenarioGadgetMap.put(strScenarioName,strGadgetName);
							  Browser = fUtil.fGetDataFromExlSheetRowWise(fUtil.readInput("TestPlan"),"AppEnv",1,strEnvironment,3);
							  URL = fUtil.fGetDataFromExlSheetRowWise(fUtil.readInput("TestPlan"),"AppEnv",1,strEnvironment,2);
							  scenarioBrowserMap.put(strScenarioName, Browser);
							  scenarioURLMap.put(strScenarioName, URL);
							 
							  //ResultLocation = fUtil.fGetDataFromExlSheetRowWise("D:\\Pupun\\Study\\Workspace\\test1\\src\\main\\resources\\Inputs\\TestPlan.xls","AppEnv",1,strEnvironment,4);					  
							  //fUtil.fCreateFolder (ResultLocation);
							  //fUtil.fCreateFolder (ResultLocation+"\\Images");
							  // xx=ResultLocation+"\\"+strScenarioName+fUtil.fGetRandomNumUsingTime()+".html";
							  //report = new ExtentReports(xx, true);//,DisplayOrder.NEWEST_FIRST
							  
							  //lt= new ReportManager();
							 // lt.onStart();
							  	//test = report.startTest(strScenarioName,strTCDesc);
								XmlTest xmlTest=new XmlTest(xmlSuite);
								xmlTest.setName(TCNames.get(executableTCCount-1));
								//xmlTest.
								//xmlTest.setThreadCount(0);
								//xmlTest.addParameter("Browser", Browser );
								//xmlTest.setPreserveOrder(true);
								
								
								XmlClass test1Class=new XmlClass(Class.forName("com.QA.TestApp.Testcases."+strGadgetName));
								List<XmlClass> listClass=new ArrayList<XmlClass>();
								listClass.add(test1Class);
								xmlTest.setXmlClasses(listClass);
								
								
								ArrayList<String> Keywords = fUtil.fGetKeywords(fUtil.readInput("ScenarioNew")+strTestSetName+".xls","Sheet1",strScenarioName);
								
								ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();
								for (int KCount = 0; KCount < Keywords.size(); KCount++) { 		       
									methodsToRun.add(new XmlInclude(Keywords.get(KCount)));
								 } 
								 listClass.get(0).setIncludedMethods(methodsToRun);
						  }
					  }
						// report.endTest(test);
						// report.flush();
				  }
		  }
		 
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}	catch(ClassNotFoundException e){
		e.printStackTrace();
		}
	catch(Exception eew)
	{
		eew.printStackTrace();
	}
	
	TestNG testNG=new TestNG();
	
	List<XmlSuite> listSuite=new ArrayList<XmlSuite>();
	listSuite.add(xmlSuite);
	testNG.setXmlSuites(listSuite);
//	testNG.setXmlSuites(xmlSuite);
		System.out.println (listSuite.get(0).toXml());
		testNG.run();
			
}

@BeforeSuite
public void reportingSetup()
{
	//System.out.println("Before Suite");	
//ResultLocation = "C:\\Result";
// fUtil.fCreateFolder(ResultLocation);
 // fUtil.fCreateFolder (ResultLocation+"\\Images");
  // xx=ResultLocation+"\\ExecutionReport"+fUtil.fGetRandomNumUsingTime()+".html";
  //report = new ExtentReports(xx, true); //,DisplayOrder.NEWEST_FIRST
	reportName= getReportNameTestNG();
}


@AfterSuite
public void reportingEnd()
{
	//report.flush();
	//System.out.println("In After Suite");
	ExtentManager.getInstance().flush();
	//Driver.quit();
}

@BeforeTest
public void setup(ITestContext testContext)
{
	try
	{
		String scenarioNameTest=testContext.getName();
		String[] strArray=scenarioNameTest.split("Dataset");
		String[] sceArray=strArray[0].split("TS");
		testSetName=sceArray[0];		
		scenarioName=sceArray[1];
		//pradep
		String brwsr=scenarioBrowserMap.get(scenarioName);
		String url=scenarioURLMap.get(scenarioName);
		//
		
		browserFactory = BrowserFactory.getInstance();
		//System.out.println("BF"+browserFactory);
		//fUtil.finitiateDriver(1, URL);
		browserFactory.setDriver(brwsr);
		initialisePageObjects();
		fUtil.setLocalDriver(browserFactory.getDriver());
		browserFactory.getDriver().get(url);
		//System.out.println("Before Test");
		
		Driver=browserFactory.getDriver();
		//Driver= BrowserFactory.getInstance().getDriver();
		
		//Driver=new Augmenter().augment(browserFactory.getDriver());
		
		System.out.println("Driver"+Driver);
		
		
		iterationTotalCount=intIteration;
		gadGetName=scenarioGadgetMap.get(scenarioName);
		iterationValue=scenarioIterationMap.get(scenarioNameTest);
		if(testSetName.equals(scenarioName)){
			ExtentTestManager.startTest(scenarioName);
		}
		else{
			ExtentTestManager.startTest(testSetName+"-"+scenarioName);
		}
		//System.out.println(scenarioName);
		
		//test = report.startTest(scenarioName);
		
	}
	catch(Exception E)
	{
		E.printStackTrace();
	}
}

@AfterTest
public void endTestReport()
{
	//report.endTest(test);
	//System.out.println("In After Test");
	ExtentTestManager.endTest();
	
   // ExtentManager.getInstance().flush();
}

public File takeScreenshot()
{
	return ((TakesScreenshot) browserFactory.getDriver()).getScreenshotAs(OutputType.FILE);
	 
}

public void initialisePageObjects()
{
 // signUpPage= PageFactory.initElements(browserFactory.getDriver(), LoginPage.class);
  //gmailLogin= PageFactory.initElements(browserFactory.getDriver(), GmailLogin.class);
	loginPageBancs= PageFactory.initElements(browserFactory.getDriver(), LoginPageBancs.class);
	selectClaimEnquiryPage= PageFactory.initElements(browserFactory.getDriver(), SelectClaimEnquiryPage.class);
	//SearchPollicyNoBancs= PageFactory.initElements(browserFactory.getDriver(), SearchPollicyNo.class);
	localMailPage= PageFactory.initElements(browserFactory.getDriver(), LocalMailPage.class);
	bancsLandingPage=PageFactory.initElements(browserFactory.getDriver(), BancsLandingPage.class);
	basicDetailPage=PageFactory.initElements(browserFactory.getDriver(), BasicDetailPage.class);
	policyRelationPage=PageFactory.initElements(browserFactory.getDriver(), PolicyRelationPage.class);
	basicPolicyDetailsPage=PageFactory.initElements(browserFactory.getDriver(), BasicPolicyDetailsPage.class);
	liabilityDetailsPage=PageFactory.initElements(browserFactory.getDriver(), LiabilityDetailsPage.class);
	additionalPolicyDetailsPage=PageFactory.initElements(browserFactory.getDriver(), AdditionalPolicyDetailsPage.class);
	summaryPage=PageFactory.initElements(browserFactory.getDriver(), SummaryPage.class);
	of_Receipt_CreationPage=PageFactory.initElements(browserFactory.getDriver(), Of_Receipt_CreationPage.class);
	conopspolicycreationpage = PageFactory.initElements(browserFactory.getDriver(), CONOPSPolicyCreationPage.class); 
	policyrenewalPage = PageFactory.initElements(browserFactory.getDriver(), PolicyRenewalPage.class);
	documentpage = PageFactory.initElements(browserFactory.getDriver(), DocumentPage.class);
	
	
	
	BancsLogin= PageFactory.initElements(browserFactory.getDriver(), NewBusinessBancsLogin.class);
	fleet_Addition_Of_VehiclePage= PageFactory.initElements(browserFactory.getDriver(), Fleet_Addition_Of_VehiclePage.class);
	searchPollicyNoBancs= PageFactory.initElements(browserFactory.getDriver(), SearchPollicyNoPage.class);
	oracleFinancePage= PageFactory.initElements(browserFactory.getDriver(), OracleFinancePage.class);
	book_a_Travel_PolicyPage=PageFactory.initElements(browserFactory.getDriver(), Book_a_Travel_PolicyPage.class);
	CessionOfAPolicy=PageFactory.initElements(browserFactory.getDriver(), CessionofPolicy.class);
	RenewalOfAPolicy= PageFactory.initElements(browserFactory.getDriver(), RenewalofPolicy.class);
	B2BDetailpage= PageFactory.initElements(browserFactory.getDriver(), B2BDetailpage.class);
	B2BHomePage= PageFactory.initElements(browserFactory.getDriver(), B2BHomePage.class);
	B2BLogin= PageFactory.initElements(browserFactory.getDriver(), B2BLogin.class);
	B2BPaymentDetails= PageFactory.initElements(browserFactory.getDriver(), B2BPaymentDetails.class);
	B2BTravelInsuranceHome= PageFactory.initElements(browserFactory.getDriver(), B2BTravelInsuranceHome.class);
	BasicDetail= PageFactory.initElements(browserFactory.getDriver(), BasicDetail.class);
	PartySearch= PageFactory.initElements(browserFactory.getDriver(), PartySearch.class);
	PolicyRelation= PageFactory.initElements(browserFactory.getDriver(), PolicyRelation.class);
	PolicyRelationDetail= PageFactory.initElements(browserFactory.getDriver(), PolicyRelationDetail.class);
	RiskDetail= PageFactory.initElements(browserFactory.getDriver(), RiskDetail.class);
	VehicleDetail= PageFactory.initElements(browserFactory.getDriver(), VehicleDetail.class);
	intimate_new_claimPage= PageFactory.initElements(browserFactory.getDriver(), Intimate_new_claimPage.class);
	bookanIndividualMotorPolicy= PageFactory.initElements(browserFactory.getDriver(), Homepage.class);
	policy=PageFactory.initElements(browserFactory.getDriver(), PolicySearchPage.class);
	
	bancsloginPageBancs= PageFactory.initElements(browserFactory.getDriver(), BansLoginPageBancs.class);
	  bancsHomepg = PageFactory.initElements(browserFactory.getDriver(), BansHomepage.class);
	  bancspolicy = PageFactory.initElements(browserFactory.getDriver(), BansPolicySearch.class);
	  bancssummaryPage = PageFactory.initElements(browserFactory.getDriver(), BansSummaryPage.class);
	  bancsbasicDetails = PageFactory.initElements(browserFactory.getDriver(), BancsbasicDetailspage.class);
	  bancsvehicledetails = PageFactory.initElements(browserFactory.getDriver(), BansvehicleDetails.class);
	  bancspartycodesearchpage = PageFactory.initElements(browserFactory.getDriver(), BanspartyCodeSearchpage.class);
	  bancspolicyrelationspage = PageFactory.initElements(browserFactory.getDriver(), BanspolicyRelationspage.class);
	  bancsbasicpolicydetailspage = PageFactory.initElements(browserFactory.getDriver(), BancsbasicpolicyDetailspage.class);
	  bancsliabilitydetailspage = PageFactory.initElements(browserFactory.getDriver(), BansliabilityDetailspage.class);
	  bancsadditionalPolicydeatils = PageFactory.initElements(browserFactory.getDriver(), Bancsadditionalpolicydeatils.class);
	  bancsreinsurancepage = PageFactory.initElements(browserFactory.getDriver(), Bansreinsurance.class);
	  bancsdocumentPage = PageFactory.initElements(browserFactory.getDriver(), Bansdocumentpage.class);
	  b2BpaymentGateway = PageFactory.initElements(browserFactory.getDriver(), B2BpaymentGateway.class);
	// signUpPage = new SignUpPage();
	  
	  vehicledetailspage = PageFactory.initElements(browserFactory.getDriver(), VehicleDetailsPage.class);
	  NewBusinesspOM = PageFactory.initElements(browserFactory.getDriver(), NewBusinessPOM.class);
	  b2bPOMPage = PageFactory.initElements(browserFactory.getDriver(), B2BPom.class);
	  new_BusinessPage=PageFactory.initElements(browserFactory.getDriver(), New_BusinessPage.class);
	  partyDetailPage=PageFactory.initElements(browserFactory.getDriver(), PartyDetailPage.class);
	  partyPage=PageFactory.initElements(browserFactory.getDriver(), PartyPage.class);
	  billingpage = PageFactory.initElements(browserFactory.getDriver(), BillingPage.class);
	  endorsementPage = PageFactory.initElements(browserFactory.getDriver(), EndorsementPage.class);
	  contactsPage = PageFactory.initElements(browserFactory.getDriver(), ContactsPage.class);
	  
	  /*Added by Hansika on 24th May 2019*/
	 // partyDetailPage = PageFactory.initElements(browserFactory.getDriver(), PartyDetailPage.class);
	  partyVersionListPage = PageFactory.initElements(browserFactory.getDriver(), PartyVersionListPage.class);
	  partyAuditTrailPage = PageFactory.initElements(browserFactory.getDriver(), PartyAuditTrailPage.class);
	  partySummaryPage = PageFactory.initElements(browserFactory.getDriver(), PartySummaryPage.class);
	  partyFunctionPage =  PageFactory.initElements(browserFactory.getDriver(), PartyFunctionPage.class);
	  partyPropertyDetailsPage = PageFactory.initElements(browserFactory.getDriver(), PartyPropertyDetailsPage.class);
	  banspartyRoles = PageFactory.initElements(browserFactory.getDriver(), BanspartyRoles.class);
	  bancsSearchTablePage = PageFactory.initElements(browserFactory.getDriver(), BancsSearchTablePage.class);
	  bancsTableDataDetails = PageFactory.initElements(browserFactory.getDriver(), BancsTableDataDetails.class);
	  searchingPoliciesAndQuotesPage = PageFactory.initElements(browserFactory.getDriver(), SearchingPoliciesAndQuotesPage.class);
	  payPlanDetailScreenPage = PageFactory.initElements(browserFactory.getDriver(), PayPlanDetailScreenPage.class);
	  underwritingBatchProcessesPage = PageFactory.initElements(browserFactory.getDriver(), UnderwritingBatchProcessesPage.class);
	  newBusinessB2BPage = PageFactory.initElements(browserFactory.getDriver(), NewBusinessB2BPage.class);
	  bancsFollowUpTab= PageFactory.initElements(browserFactory.getDriver(), BancsFollowUpTab.class);
	  b2bpage=PageFactory.initElements(browserFactory.getDriver(), Module_B2BPage.class);
	  claimsPage=PageFactory.initElements(browserFactory.getDriver(), claims.class);
	  cancellation =PageFactory.initElements(browserFactory.getDriver(), Cancellation.class);
	  newBusinessPage=PageFactory.initElements(browserFactory.getDriver(), NewBusinessPage6.class);
	  driverdetailsPage=PageFactory.initElements(browserFactory.getDriver(), BancsDriverDetailsPage.class);
	  motor_TPL_PageObjects=PageFactory.initElements(browserFactory.getDriver(), Motor_TPL_PageObjects.class);
	  newBusinessbancs=PageFactory.initElements(browserFactory.getDriver(), newBusinessbancs1.class);
	  NewBusiness5page = PageFactory.initElements(browserFactory.getDriver(), NewBusiness5page.class);

	  newBusiness5page = PageFactory.initElements(browserFactory.getDriver(), NewBusiness5page.class);
	  //Added by Satish
	  bancsDriverdetailsPage=PageFactory.initElements(browserFactory.getDriver(), BancsDriverDetailsPage.class);
	  
	  endorsement_New_PageObj = PageFactory.initElements(browserFactory.getDriver(), Endorsement_New_PageObj.class);
	  cancellation_New_PageObj=PageFactory.initElements(browserFactory.getDriver(), Cancellation_New_PageObj.class);
	  
	  endorsement9Page=PageFactory.initElements(browserFactory.getDriver(), Endorsement9Page.class);
	  bancsPremiumSchedulePage=PageFactory.initElements(browserFactory.getDriver(), BancsPremiumSchedulePage.class); 
	  b2BPage2=PageFactory.initElements(browserFactory.getDriver(), B2BPage2.class);
	  newBusinessBPage=PageFactory.initElements(browserFactory.getDriver(), NewBusinessBPage.class);
	 // NewBusiness5page = PageFactory.initElements(browserFactory.getDriver(), NewBusiness5page.class); 
	  newBusiness9page = PageFactory.initElements(browserFactory.getDriver(), NewBusiness9page.class);
	cancellation5Page = PageFactory.initElements(browserFactory.getDriver(), Cancellation5Page.class); 
	Endorsement_Page3=PageFactory.initElements(browserFactory.getDriver(), Endorsement_4Page.class);
	Cancellation_Page3 = PageFactory.initElements(browserFactory.getDriver(), Cancellation_4Page.class);
	new_Business2Page = PageFactory.initElements(browserFactory.getDriver(), New_Business2Page.class);
	B2BPom_1page = PageFactory.initElements(browserFactory.getDriver(), B2BPom_1Page.class);
	endorsement5Page= PageFactory.initElements(browserFactory.getDriver(), Endorsement5Page.class);
	insuredDetailsPage =  PageFactory.initElements(browserFactory.getDriver(), InsuredDetailsPage.class);
	c360Page=  PageFactory.initElements(browserFactory.getDriver(), C360Page.class);
	
	
	
}
}