package com.baseclass;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {

    public static WebDriver driver;
    public static Properties prop;

    public void launchapplication() throws Exception {

        FileInputStream fis = new FileInputStream(
            System.getProperty("user.dir") +
            "\\src\\test\\resources\\Properties\\config.properties"
        );

        prop = new Properties();
        prop.load(fis);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
    }
}