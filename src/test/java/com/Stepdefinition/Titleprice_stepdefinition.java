package com.Stepdefinition;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;
import com.pages.Titleprice_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Titleprice_stepdefinition extends Library {
    Titleprice_page tp;
    SeleniumResuable re;

    @Given("Enter the search text in the search field")
    public void enter_the_search_text_in_the_search_field() {
        tp = new Titleprice_page(driver);
        tp.entersearch("Shirts");
    }

    @When("click the search icon")
    public void click_the_search_icon() {
        tp.clicksearchicon();
    }

    @Then("it should display the search result and get the title and price")
    public void it_should_display_the_search_result_and_get_the_title_and_price() {
        re = new SeleniumResuable(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Product Brand Names - class FoI1Ob
        List<WebElement> titles =
            driver.findElements(By.xpath("//div[@class='FoI1Ob']//div[contains(@class,'blCLBY')]"));

        if (titles.isEmpty()) {
            titles = driver.findElements(By.xpath("//div[contains(@class,'FoI1Ob')]"));
        }

        System.out.println("Total products found: " + titles.size());
        for (int i = 0; i < titles.size(); i++) {
            String text = titles.get(i).getText().trim();
            if (!text.isEmpty()) {
                System.out.println("*********************************");
                System.out.println("Product " + (i + 1) + ": " + text);
            }
        }

        // Prices - class Nx9bqj
        List<WebElement> prices =
            driver.findElements(By.xpath("//div[contains(@class,'Nx9bqj')]"));

        System.out.println("Total prices found: " + prices.size());
        for (int i = 0; i < prices.size(); i++) {
            String price = prices.get(i).getText().trim();
            if (!price.isEmpty()) {
                System.out.println("*********************************");
                System.out.println("Price " + (i + 1) + ": " + price);
            }
        }
    }
}
	
	

