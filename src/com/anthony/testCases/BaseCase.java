package com.anthony.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.anthony.utils.ReadConfig;

public class BaseCase {
	
	ReadConfig rc = new ReadConfig();
	public String baseURL= rc.getServerUrl();
	public String userName= rc.getUserName();
    public String password= rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger; // adding logger
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		
		
		if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver = new FirefoxDriver();
		}else if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver();
		}else {
			logger.error("暂时没有考虑其他浏览器，例如safari，你自己添加对应代码�?");
		}
		
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
    
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	/**
	 * 失败截图�?
	 * @param driver
	 * @param tname
	 * @throws IOException
	 */
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshout taken");
	}
}
