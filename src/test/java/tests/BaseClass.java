package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class BaseClass {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setup() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "iPhone 6s");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "13.0");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("app", "/Users/shridharvenkatesh/Library/Developer/Xcode/DerivedData/UIKitCatalog-bpthhnkdgnnsarctpycxyzerqjpc/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
		
		try{
			driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
