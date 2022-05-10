package com.QA.TestApp.Utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	private static BrowserFactory instance = null;
	public static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<>();
	public FrameWorkUtility FUtil = new FrameWorkUtility();
	//WebDriver driver;
	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	@SuppressWarnings("deprecation")
	public final void setDriver(String browser) throws Exception {

		DesiredCapabilities caps = null;

		switch (browser) {

		case "Chrome":
			caps = DesiredCapabilities.chrome();
			ChromeOptions chOptions = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("credentials_enable_service", false);
			chOptions.setExperimentalOption("prefs", chromePrefs);
			chOptions.addArguments("--disable-plugins", "--disable-extensions",
					"--disable-popup-blocking");
			caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
			caps.setCapability("applicationCacheEnabled", false);
			System.setProperty("webdriver.chrome.driver",
					FUtil.readInput("ChromeDriver"));
			webDriver.set(new ChromeDriver());
			//System.out.println("DD"+webDriver);
			//driver=webDriver.get();
			webDriver.get().manage().window().maximize();
			/*Robot rb=new Robot();
			rb.keyPress(KeyEvent.VK_WINDOWS);
			Thread.sleep(1000);
			rb.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			rb.keyRelease(KeyEvent.VK_WINDOWS);
			Thread.sleep(1000);
			rb.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);*/
			
			//webDriver.get().findElement(By.xpath("//html")).sendKeys(Keys.chord(Keys.ALT, Keys.TAB));
			//((JavascriptExecutor) webDriver.get()).executeScript("window.focus();");
			
			break;
		
		case "IE":
			try {
			caps=DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			//caps.setVersion("11");
			//caps.setCapability(CapabilityType.VERSION, "11");
			System.out.println("Inside IE");
			System.setProperty("webdriver.ie.driver", FUtil.readInput("IEDriver"));
			webDriver.set(new InternetExplorerDriver(caps)); 
			//webDriver.set(new InternetExplorerDriver());
			webDriver.get().manage().window().maximize();
			//webDriver.get().findElement(By.xpath("//html")).sendKeys(Keys.chord(Keys.HOME, Keys.ARROW_DOWN));
			/*Robot rb1=new Robot();
			rb1.keyPress(KeyEvent.VK_WINDOWS);
			Thread.sleep(1000);
			rb1.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			rb1.keyRelease(KeyEvent.VK_WINDOWS);
			Thread.sleep(1000);
			rb1.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);*/
			
			
			//((JavascriptExecutor) webDriver.get()).executeScript("window.focus();");
			//((JavascriptExecutor) webDriver.get()).executeScript("window.focus();");
			}
			catch(SessionNotCreatedException ee) {
				webDriver.get().findElement(By.xpath("//html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				webDriver.get().findElement(By.xpath("//html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				//Robot rt=new Robot();
				//rt.keyPress(keycode);
			}
			
			break;
		}
	}

	public WebDriver getDriver() {
		return webDriver.get();
	}
}
