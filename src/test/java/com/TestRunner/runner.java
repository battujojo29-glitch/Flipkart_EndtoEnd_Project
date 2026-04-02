package com.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"com.Stepdefinition","com.Hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    tags = "@tc005",
    monochrome = true
)
public class runner extends AbstractTestNGCucumberTests {
}