package com.Stepdefinition;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;
import com.pages.Fashion_page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Fashion_Stepdefinition extends Library {

    Fashion_page fp;
    SeleniumResuable se;

    @Given("User to move the Fashion link")
    public void user_to_move_the_fashion_link() {
        se = new SeleniumResuable(driver);
        fp = new Fashion_page(driver);
        System.out.println("Before clicking Fashion link");
        se.gettitle();
        fp.movefashionlink();       // ✅ Click Fashion
    }

    @When("Cursor to move to the Kids link")
    public void cursor_to_move_to_the_kids_link() {
        fp.movekidslink();          // ✅ Scroll + Click Kids
    }

    @When("Move to girls dress and click")
    public void move_to_girls_dress_and_click() {
        fp.clickgirlsdress();       // ✅ Scroll + Click 4 to 6 Years
    }

    @When("Click the price high to low link")
    public void click_the_price_high_to_low_link() {
        fp.clickprice();            // ✅ Click Price High to Low
    }

    @Then("it should display the relevant details and get the title")
    public void it_should_display_the_relevant_details_and_get_the_title() {
        System.out.println("After clicking Fashion link");
        String title = fp.getpagetitle();
        System.out.println(" Final Page Title: " + title);
        se.gettitle();
    }
}