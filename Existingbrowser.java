package com.QA.TestApp.Utilities;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;

public class Existingbrowser {

	public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor){
	    HttpCommandExecutor executor = new HttpCommandExecutor(command_executor) {

	    public Response execute(Command command) throws IOException {
	        Response response = null;
	        if (command.getName() == "newSession") {
	            response = new Response();
	            response.setSessionId(sessionId.toString());
	            response.setStatus(0);
	            response.setValue(Collections.<String, String>emptyMap());
	            try {
	                Field commandCodec = null;
	                commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
	                commandCodec.setAccessible(true);
	                commandCodec.set(this, new W3CHttpCommandCodec());
	                Field responseCodec = null;
	                responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
	                responseCodec.setAccessible(true);
	                responseCodec.set(this, new W3CHttpResponseCodec());
	            } catch (NoSuchFieldException e) {
	                e.printStackTrace();
	            } catch (IllegalAccessException e) {
	                e.printStackTrace();
	            }

	        } else {
	            response = super.execute(command);
	        }
	        return response;
	    }
	    };

	    return new RemoteWebDriver(executor, new DesiredCapabilities());
	}

	public static void main(String [] args) throws MalformedURLException {
		
///////Step 1////////////		
/*      System.setProperty("webdriver.ie.driver", "D:\\\\OIC\\\\Phase1Workspace\\\\src\\\\main\\\\resources\\\\Inputs\\\\IEDriverServer.exe");
	    InternetExplorerDriver driver = new InternetExplorerDriver();
	    HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
	    URL url = executor.getAddressOfRemoteServer();
	    String url1 = url.toString();
	    System.out.println(url1);
	    SessionId session_id = driver.getSessionId();
	    String session_id1= session_id.toString();
	    System.out.println(session_id1);
	    driver.get("http://192.168.196.199:8081/IIMS/");*/
	     
///////Step 2///////////		
	     
		URL url = new URL("http://localhost:32565");
		SessionId session_id = new SessionId("d0f72c26-6f6d-498c-9b32-d84952495f04");
	    RemoteWebDriver driver2 = createDriverFromSession(session_id, url);
	    driver2.get("http://192.168.196.199:8081/IIMS/");
	    driver2.switchTo().parentFrame();
	    driver2.switchTo().frame(driver2.findElement(By.xpath("//frame[@name='display']")));
	    driver2.findElement(By.xpath("//input[@name='pUserName']")).sendKeys("akash");
	    //driver2.findElement(By.xpath("//input[@name='pPassword']")).sendKeys("kolkata@1");
	    //driver2.findElement(By.xpath("//input[@name='pPassword']")).clear();
	    
	    
	}

}
