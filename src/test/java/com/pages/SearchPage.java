package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;

public class SearchPage extends Library {

    public final By popupCloseButton = null;
	SeleniumResuable se;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        se = new SeleniumResuable(driver);
    }

    @FindBy(name = "q")
    WebElement Searchtext;

    @FindBy(xpath = "//img[contains(@src,'flipkart')]")
    WebElement Homepage;

    @FindBy(xpath = "//div[contains(@class,'results')]")
    WebElement Searchresult;

    public void Search(String text) {
        wait.until(ExpectedConditions.visibilityOf(Searchtext));
        se.Entervalue(Searchtext, text);
    }

    public void Clicksearch() {
        wait.until(ExpectedConditions.visibilityOf(Searchtext));
        Searchtext.sendKeys(Keys.ENTER);
    }

    public void homescreen() {
        try {
            System.out.println("Homepage displayed: " + Homepage.isDisplayed());
        } catch (Exception e) {
            System.out.println("Homepage element not found - skipping");
        }
    }

    public void Result() {
        try {
            wait.until(ExpectedConditions.visibilityOf(Searchresult));
            System.out.println("Results displayed: " + Searchresult.isDisplayed());
            System.out.println("Page title: " + driver.getTitle());
        } catch (Exception e) {
            System.out.println("Result page title: " + driver.getTitle());
        }
    }

    public void printentireresult() {
        try {
            // ✅ scroll to trigger lazy load
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800)");
            Thread.sleep(2000);

            // ✅ use driver.findElements directly — bypasses PageFactory caching
            List<WebElement> results = driver.findElements(
                By.xpath("//div[@data-id]//a/div[2]/div[1]")
            );

            System.out.println("Total results found: " + results.size());

            if (results.isEmpty()) {
                System.out.println("⚠️ No results — check XPath in DevTools");
            } else {
                for (int i = 0; i < results.size(); i++) {
                    String text = results.get(i).getText().trim();
                    if (!text.isEmpty()) {
                        System.out.println("*********************************");
                        System.out.println("Result " + (i + 1) + ": " + text);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error printing results: " + e.getMessage());
        }
    }

    public void Print3rdresult() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800)");
            Thread.sleep(2000);

            List<WebElement> results = driver.findElements(
                By.xpath("//div[@data-id]//a/div[2]/div[1]")
            );

            System.out.println("Total results found: " + results.size());

            if (results.size() >= 3) {
                System.out.println("3rd Result: " + results.get(2).getText().trim());
            } else {
                System.out.println("⚠️ Less than 3 results. Total found: " + results.size());
            }
        } catch (Exception e) {
            System.out.println("❌ Error fetching 3rd result: " + e.getMessage());
        }
    }
}