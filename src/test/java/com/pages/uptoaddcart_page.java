package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;

public class uptoaddcart_page extends Library {

    SeleniumResuable se;
    WebDriverWait wait;

    public uptoaddcart_page(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
        se = new SeleniumResuable(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(linkText = "Login")
    WebElement loginLink;

    // Step 1 — Hover Login
    public void moveLoginLink() {
        try {
            se.mousehover(loginLink);
            Thread.sleep(1500);
            System.out.println("Hovered Login");
        } catch (Exception e) {
            System.out.println("Login hover failed: " + e.getMessage());
        }
    }

    // Step 2 — Navigate to Flipkart Plus directly
    public void moveFlipkartPlus() {
        try {
            Library.driver.get("https://www.flipkart.com/plus");
            Thread.sleep(2000);
            System.out.println("Navigated to Flipkart Plus: " + Library.driver.getTitle());
        } catch (Exception e) {
            System.out.println("Flipkart Plus failed: " + e.getMessage());
        }
    }

    // Step 3 — Navigate directly to Wall Lamp page
    public void moveHomeFurniture() {
        try {
            Library.driver.get("https://www.flipkart.com/home-lighting/decor-lighting-accessories/wall-lamps/pr?sid=jhg,6w8,mbd");
            Thread.sleep(3000);
            System.out.println("Navigated to Wall Lamp page: " + Library.driver.getTitle());
        } catch (Exception e) {
            System.out.println("Wall Lamp navigation failed: " + e.getMessage());
        }
    }

    // Step 4 — Find and scroll to first product
    public void clickWallLamp() {
        try {
            WebElement firstProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("(//div[contains(@class,'slAVV4')]//a |" +
                             "//div[contains(@class,'_2kHMtA')]//a |" +
                             "//div[contains(@class,'CXW8mj')]//a |" +
                             "//a[contains(@href,'wall-lamp')])[1]")
                )
            );
            se.Scrolldown(firstProduct);
            Thread.sleep(500);
            System.out.println("Found product: " + firstProduct.getAttribute("href"));
        } catch (Exception e) {
            System.out.println("First product not found: " + e.getMessage());
        }
    }

    // Step 5 — Click first product using JavaScript
    public void clickOneResult() {
        try {
            WebElement firstProduct = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("(//a[contains(@href,'wall-lamp') and not(contains(@href,'wall-lamps/pr'))])[1]")
                )
            );
            se.Scrolldown(firstProduct);
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) Library.driver;
            js.executeScript("arguments[0].click();", firstProduct);
            System.out.println("Clicked product: " + firstProduct.getAttribute("href"));
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Product click failed: " + e.getMessage());
        }
    }

    // Step 6 — Switch to new tab, scroll and enter pincode
    public void enterPincode() {
        try {
            Thread.sleep(3000);

            // ✅ Switch to new tab
            String parentWindow = Library.driver.getWindowHandle();
            for (String window : Library.driver.getWindowHandles()) {
                if (!window.equals(parentWindow)) {
                    Library.driver.switchTo().window(window);
                    break;
                }
            }
            System.out.println("Switched to: " + Library.driver.getTitle());

            JavascriptExecutor js = (JavascriptExecutor) Library.driver;

            // ✅ Scroll in 3 steps to trigger lazy loading
            js.executeScript("window.scrollBy(0, 400);");
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0, 400);");
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0, 400);");
            Thread.sleep(1500);

            // ✅ Try multiple pincode locators
            WebElement pincodeField = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//input[@id='pincodeInputId'] |" +
                             "//input[contains(@placeholder,'incode')] |" +
                             "//input[contains(@id,'incode')] |" +
                             "//div[contains(text(),'Delivery')]//following::input[1]")
                )
            );

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", pincodeField);
            Thread.sleep(500);
            pincodeField.clear();
            pincodeField.sendKeys("500072");
            System.out.println("Entered pincode: 500072");

        } catch (Exception e) {
            System.out.println("Pincode entry failed: " + e.getMessage());

            // ✅ Debug — print all input fields on page
            System.out.println("Current URL: " + Library.driver.getCurrentUrl());
            System.out.println("Current Title: " + Library.driver.getTitle());
            try {
                List<WebElement> inputs = Library.driver.findElements(By.tagName("input"));
                System.out.println("Total inputs found: " + inputs.size());
                for (WebElement input : inputs) {
                    System.out.println("id: " + input.getAttribute("id") +
                                       " | placeholder: " + input.getAttribute("placeholder") +
                                       " | class: " + input.getAttribute("class"));
                }
            } catch (Exception ex) {
                System.out.println("Debug failed: " + ex.getMessage());
            }
        }
    }

    // Step 7 — Click Check button
    public void clickCheckLink() {
        try {
            WebElement checkBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Check']")
                )
            );
            checkBtn.click();
            Thread.sleep(1000);
            System.out.println("Clicked Check");
        } catch (Exception e) {
            System.out.println("Check click failed: " + e.getMessage());
        }
    }
}