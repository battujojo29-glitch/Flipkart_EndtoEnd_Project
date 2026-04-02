package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;

public class Multiplesearch extends Library {

    SeleniumResuable se;

    public Multiplesearch(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
        se = new SeleniumResuable(driver);
    }

    @FindBy(xpath = "//header//form//input")
    WebElement searchField;

    
    public void enterSearch(String searchText) {
        se.Entervalue(searchField, searchText);
    }

    public void clickSearch() {
        searchField.sendKeys(Keys.ENTER);
    }
}