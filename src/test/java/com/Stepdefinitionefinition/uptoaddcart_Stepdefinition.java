package com.Stepdefinitionefinition;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;
import com.pages.uptoaddcart_page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class uptoaddcart_Stepdefinition extends Library {

    uptoaddcart_page up;
    SeleniumResuable re;

    @Given("User can move to the login link")
    public void user_can_move_to_the_login_link() {
        up = new uptoaddcart_page(driver);
        re = new SeleniumResuable(driver);
        up.moveLoginLink();
        System.out.println("Parent window title: " + driver.getTitle());
    }

    @When("User click the flipkart plus zone")
    public void user_click_the_flipkart_plus_zone() {
        up.moveFlipkartPlus();
    }

    @When("Mouse move to the Home&Furniture link")
    public void mouse_move_to_the_home_furniture_link() {
        up.moveHomeFurniture();
    }

    @When("Going to click the wall lamp")
    public void going_to_click_the_wall_lamp() {
        up.clickWallLamp();
    }

    @When("Scroll down the page and click one particular result")
    public void scroll_down_the_page_and_click_one_particular_result() {
        up.clickOneResult();
    }

    @When("Enter delivery pincode and click the check link")
    public void enter_delivery_pincode_and_click_the_check_link() {
        up.enterPincode();
    }

    @Then("Pincode should be checked and displayed and verify the titles")
    public void pincode_should_be_checked_and_displayed_and_verify_the_titles() {
        up.clickCheckLink();
        System.out.println("Final title: " + driver.getTitle());
        re.screenshot("src/test/resources/Screenshot/uptoaddcart.png");
    }
}