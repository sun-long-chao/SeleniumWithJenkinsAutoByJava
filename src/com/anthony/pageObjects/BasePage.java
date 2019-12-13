package com.anthony.pageObjects;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public WebDriver driver;
	
	/**
	 * 定义�?个获取当前页title的字符串，常用来判断打开页面是否正确
	 */
	public String getTitle() {
		
		return driver.getTitle().trim().toString();
		
	}

}
