package com.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.ResuableFunction.SeleniumResuable;
import com.baseclass.Library;

public class Hooks extends Library

{
	SeleniumResuable se;
    public static Scenario scenario;

    @Before
    public void test(Scenario Cucumberscenario) throws Exception
    {
        scenario = Cucumberscenario;
        launchapplication();
    }

     @After
     public void cleanup(Scenario scenario) {
    	se =new SeleniumResuable(driver);
    	se.attachscreenshot(scenario);
    	se.closeapp();
        driver.quit();
    }
}