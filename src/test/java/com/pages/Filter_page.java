package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;

public class Filter_page extends Library {

    SeleniumResuable se;
    WebDriverWait wait;

    public Filter_page(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
        se = new SeleniumResuable(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

   
    @FindBy(xpath = "//div[contains(@class,'_6c1Nb5')]//input[@type='text'][1]")
    WebElement MinimumAmount;

    @FindBy(xpath = "//div[contains(@class,'_6c1Nb5')]//input[@type='text'][2]")
    WebElement MaximumAmount;

    @FindBy(xpath = "//div[text()='Apple']/preceding-sibling::div")
    WebElement Brand;

    @FindBy(xpath = "//div[text()='1 GB']/preceding-sibling::div")
    WebElement Ram;

    @FindBy(xpath = "//div[text()='Battery Capacity']/..")
    WebElement Batteryarrow;

    @FindBy(xpath = "//div[text()='4000 - 4999 mAh']/preceding-sibling::div")
    WebElement BatteryCapacity;

    public void Min() {
        try {
            wait.until(ExpectedConditions.visibilityOf(MinimumAmount));
            // ✅ Price range is a text input — clear and type
            se.Entervalue(MinimumAmount, "10000");
            MinimumAmount.sendKeys(org.openqa.selenium.Keys.ENTER);
        } catch (Exception e) {
            System.out.println(" Min price filter failed: " + e.getMessage());
        }
    }

    public void Max() {
        try {
            wait.until(ExpectedConditions.visibilityOf(MaximumAmount));
            se.Entervalue(MaximumAmount, "150000");
            MaximumAmount.sendKeys(org.openqa.selenium.Keys.ENTER);
        } catch (Exception e) {
            System.out.println(" Max price filter failed: " + e.getMessage());
        }
    }

    public void brand() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(Brand));
            se.clickElement(Brand);
        } catch (Exception e) {
            System.out.println("Brand filter failed: " + e.getMessage());
        }
    }

    public void ram() {
        try {
            se.Scrolldown(Ram);
            wait.until(ExpectedConditions.elementToBeClickable(Ram));
            se.clickElement(Ram);
        } catch (Exception e) {
            System.out.println(" RAM filter failed: " + e.getMessage());
        }
    }

    public void Clickbattery() {
        try {
            se.Scrolldown(Batteryarrow);
            wait.until(ExpectedConditions.elementToBeClickable(Batteryarrow));
            se.clickElement(Batteryarrow);
            wait.until(ExpectedConditions.elementToBeClickable(BatteryCapacity));
            se.clickElement(BatteryCapacity);
        } catch (Exception e) {
            System.out.println(" Battery filter failed: " + e.getMessage());
        }
    }
}