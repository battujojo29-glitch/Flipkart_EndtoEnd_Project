package com.Stepdefinition;

import org.openqa.selenium.By;

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
	    tp=new Titleprice_page(driver);
	    tp.entersearch("Shirts");
	}

	@When("click the search icon")
	public void click_the_search_icon() {
		tp.clicksearchicon();
	    
	}

	@Then("it should display the search result and get the title and price")
	public void it_should_display_the_search_result_and_get_the_title_and_price() {
		re= new SeleniumResuable(driver);
		re.MultipleGettext(driver.findElements(By.xpath("//a[@class='IRpwTa']/..")));
	    
	}

	
	
}
