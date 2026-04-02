package com.Stepdefinition;

import org.openqa.selenium.By;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;
import com.pages.Filter_page;

import io.cucumber.java.en.Then;

public class Filter_Stepdefinition extends Library {

    Filter_page fp;
    SeleniumResuable se;

    @Then("select Minimum and Maximum Amount")
    public void select_minimum_and_maximum_amount() throws InterruptedException {
        fp = new Filter_page(driver);
        se = new SeleniumResuable(driver);

        String BeforeFilter = driver.findElement(
            By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[4]/div/div/div/a/div[2]/div[1]")
        ).getText();
        System.out.println("BEFORE FILTER: " + BeforeFilter);

        fp.Min();
        se.waits(); // ✅ now exists in SeleniumResuable
        fp.Max();
        se.waits();
    }

    @Then("Select the Brand")
    public void select_the_brand() throws InterruptedException {
        fp.brand();
        se.waits();
    }

    @Then("Select the Ram")
    public void select_the_ram() throws InterruptedException {
        fp.ram();
        se.waits();
    }

    @Then("Select the Battery Capacity")
    public void select_the_battery_capacity() throws InterruptedException {
        fp.Clickbattery();
        se.waits();
    }

    @Then("It should display the Relevant result")
    public void it_should_display_the_relevant_result() {
        System.out.println("****************************");
        String AfterFilter = driver.findElement(
            By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]")
        ).getText();
        System.out.println("AFTER FILTER: " + AfterFilter);
    }
}
