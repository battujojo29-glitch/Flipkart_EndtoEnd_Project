package com.Stepdefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.baseclass.Library;
import com.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchMobile_Testcase extends Library {

    SearchPage searchPage;

    @Given("Launch the Flipkart Application")
    public void launch_the_flipkart_application() throws Exception {
        launchapplication();
        searchPage = new SearchPage(driver);
    }

    @When("close the popup")
    public void close_the_popup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(searchPage.popupCloseButton));
            ((WebElement) searchPage.popupCloseButton).click();
        } catch (Exception e) {
            System.out.println("No popup appeared, continuing...");
        }
    }

    @Then("it should Navigate to the Home page")
    public void it_should_navigate_to_the_home_page() {
        searchPage.homescreen();
    }

    @Given("User enter the text in the search field")
    public void user_enter_the_text_in_the_search_field() {
        searchPage.Search("Mobile");
    }

    @When("click the search button")
    public void click_the_search_button() {
        searchPage.Clicksearch();
    }

    @Then("it should navigate to the search result page and display the relevant details")
    public void it_should_navigate_to_the_search_result_page_and_display_the_relevant_details() {
        searchPage.Result();
    }

    @Then("Extract the Results and print in console")
    public void extract_the_results_and_print_in_console() {
        searchPage.printentireresult();
        System.out.println("**************************");
    }

    @Then("Print the Third result and keep it in the console")
    public void print_the_third_result_and_keep_it_in_the_console() {
        searchPage.Print3rdresult();
    }
}
