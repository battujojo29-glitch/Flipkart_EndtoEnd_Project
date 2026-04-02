package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;

public class Titleprice_page extends Library{
	SeleniumResuable se;
	
	public Titleprice_page(WebDriver driver)
	{
		Library.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="q")
	WebElement search;
	
	@FindBy(xpath="//button(@type='sumbit')")
	WebElement searchicon;
	
	public void entersearch(String Text)
	{
		se =new SeleniumResuable(driver);
		se.Entervalue(search,Text);
	}
	
	public void clicksearchicon()
	{
		se.clickElement(searchicon);
	}
	
}
