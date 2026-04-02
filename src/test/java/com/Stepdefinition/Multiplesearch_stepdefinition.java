package com.Stepdefinition;


import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;
import com.pages.Multiplesearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Multiplesearch_stepdefinition extends Library {

    Multiplesearch ms;
    SeleniumResuable rs;

    @Given("Enter the {string} in the search field")
    public void enter_the_in_the_search_field(String searchText) {
        ms = new Multiplesearch(driver);
        rs = new SeleniumResuable(driver);
        ms.enterSearch(searchText);
    }

    @When("click the search button to search the text")
    public void click_the_search_button_to_search_the_text() {
        if (ms == null) {
            ms = new Multiplesearch(driver);
        }
        ms.clickSearch();
    }

    @Then("it should navigate to the next page and display the corresponding page")
    public void it_should_navigate_to_the_next_page_and_display_the_corresponding_page() {

        rs = new SeleniumResuable(driver);

        // ✅ Wait for page to fully load before taking screenshot
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        System.out.println("***********************");

        // ✅ Use searchText from title first word only — clean unique name
        String fileName = title.split("-")[0].trim()
                              .replaceAll("[^a-zA-Z0-9]", "_");

        System.out.println("Saving screenshot as: " + fileName);

        // ✅ Each search gets its own unique screenshot file
        rs.screenshot("src/test/resources/Screenshot/" + fileName + ".png");
    }
}

