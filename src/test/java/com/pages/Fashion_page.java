
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;

public class Fashion_page extends Library {

    SeleniumResuable se;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;

    public Fashion_page(WebDriver driver) {
        Library.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        se = new SeleniumResuable(driver);
    }

    // ✅ Fashion link
    @FindBy(xpath = "//*[@id='container']/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div/a/div/div/div[2]")
    WebElement Fashionlink;

    // ✅ Kids Section
    @FindBy(xpath = "//*[@id='slot-list-container']/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/div[6]/div/div/div/div/a/div/div[2]")
    WebElement Kidslink;

    // ✅ 4 to 6 Years
    @FindBy(xpath = "//*[@id='slot-list-container']/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/a/div/picture/img")
    WebElement Girlsdresslink;

    // ✅ Price High to Low
    @FindBy(xpath = "//div[text()='Price -- High to Low']")
    WebElement Pricehightolow;

    // ✅ Step 1 — Click Fashion
    public void movefashionlink() {
        try {
            WebElement fashion = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(
                    "//*[@id='container']/div/div[1]/div/div/div/div/div/div" +
                    "/div/div/div/div[1]/div/div/div[3]/div/div/div/div/div" +
                    "/div/div/div[2]/div/div/div/a/div/div/div[2]")));

            js.executeScript("arguments[0].scrollIntoView(true);", fashion);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", fashion);
            Thread.sleep(3000);
            System.out.println("✅ Clicked Fashion");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ✅ Step 2 — Scroll down and Click Kids Section
    public void movekidslink() {
        try {
            js.executeScript("window.scrollBy(0, 500)");
            Thread.sleep(2000);

            WebElement kids = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(
                    "//*[@id='slot-list-container']/div/div[2]/div/div/div/div" +
                    "/div/div/div/div/div/div/div/div/div/div/div/div[1]" +
                    "/div[6]/div/div/div/div/a/div/div[2]")));

            js.executeScript("arguments[0].scrollIntoView(true);", kids);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", kids);
            Thread.sleep(2000);
            System.out.println("✅ Clicked Kids Section");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ✅ Step 3 — Scroll down and Click 4 to 6 Years
    public void clickgirlsdress() {
        try {
            js.executeScript("window.scrollBy(0, 500)");
            Thread.sleep(2000);

            WebElement dress = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(
                    "//*[@id='slot-list-container']/div/div[3]/div/div/div/div" +
                    "/div/div/div/div/div/div[2]/div/div[2]/div/div/div/a/div/picture/img")));

            js.executeScript("arguments[0].scrollIntoView(true);", dress);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", dress);
            Thread.sleep(2000);
            System.out.println("✅ Clicked 4 to 6 Years");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ✅ Step 4 — Click Price High to Low
    public void clickprice() {
        try {
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(2000);

            WebElement price = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(
                    "//div[text()='Price -- High to Low']")));

            js.executeScript("arguments[0].scrollIntoView(true);", price);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", price);
            Thread.sleep(2000);
            System.out.println("✅ Clicked Price High to Low");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ✅ Step 5 — Get Page Title
    public String getpagetitle() {
        String title = driver.getTitle();
        System.out.println("✅ Final Page Title: " + title);
        return title;
    }
}