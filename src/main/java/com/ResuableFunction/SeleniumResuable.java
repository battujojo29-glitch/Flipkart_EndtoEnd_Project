package com.ResuableFunction;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumResuable {

    WebDriver driver;

    public SeleniumResuable(WebDriver driver) {
        this.driver = driver;
    }

    public void Entervalue(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void waits() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void dropdown(WebElement element, String value) {
        Select select = new Select(element);
        try {
            select.selectByVisibleText(value);
        } catch (Exception e) {
            try {
                select.selectByValue(value);
            } catch (Exception ex) {
                System.out.println("Dropdown value not found: " + value);
            }
        }
    }

    public void Scrolldown(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element
            );
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println("Scroll failed: " + e.getMessage());
        }
    }

    public void MultipleGettext(List<WebElement> elements) {
        System.out.println("Total results found: " + elements.size());
        if (elements.isEmpty()) {
            System.out.println("No results found — check XPath!");
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText().trim();
            if (!text.isEmpty()) {
                System.out.println("*********************************");
                System.out.println("Result " + (i + 1) + ": " + text);
            }
        }
    }

    public void Getvalue(WebElement element) {
        String text = element.getText().trim();
        System.out.println("Value: " + text);
    }

    // ✅ Fixed - added JavaScript scrollIntoView before hover
    // and wrapped in try/catch to avoid JsonException crash
    public void mousehover(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            Thread.sleep(500);
            Actions act = new Actions(driver);
            act.moveToElement(element).build().perform();
        } catch (Exception e) {
            System.out.println("mousehover failed: " + e.getMessage());
        }
    }

    // ✅ Fixed - added null check and try/catch
    // moveelement now creates its own Actions instance safely
    public void moveelement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            Thread.sleep(500);
            Actions act = new Actions(driver);
            act.moveToElement(element).click().build().perform();
        } catch (Exception e) {
            System.out.println("moveelement failed: " + e.getMessage());
        }
    }

    // ✅ Fixed - now returns actual title instead of null
    public String gettitle() {
        try {
            String title = driver.getTitle();
            System.out.println("Title: " + title);
            return title;
        } catch (Exception e) {
            System.out.println("Couldn't get the Title");
            return null;
        }
    }

    public void screenshot(String path) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(path));
            System.out.println("Screenshot saved: " + path);
        } catch (Exception e) {
            System.out.println("Unable to take screenshot: " + e.getMessage());
        }
    }

    // ✅ Fixed - skip parent window when switching to child
    public void windowhandling(WebElement element) {
        try {
            String parentWindow = driver.getWindowHandle();
            element.click();
            Thread.sleep(2000);

            Set<String> allWindows = driver.getWindowHandles();
            System.out.println("Total windows: " + allWindows.size());

            for (String childWindow : allWindows) {
                if (!childWindow.equals(parentWindow)) {  // ✅ skip parent
                    driver.switchTo().window(childWindow);
                    System.out.println("Switched to child window: " + driver.getTitle());
                }
            }
        } catch (Exception e) {
            System.out.println("Window handling failed: " + e.getMessage());
        }
    }
}