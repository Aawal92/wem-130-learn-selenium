package com.parabank.app;


import com.parabank.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

public class Parabank {
    static WebDriver driver;
    static WebDriverWait driverWait;
    static Properties properties;

    //region Hooks
    @BeforeTest
    public void setUp(){
        // Initialize driver object
        driver = new ChromeDriver();

        // Initialize explicit/fluent wait object
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to URL
        properties = getAppConfig();
        String url = properties.getProperty("URL");
        driver.get(url);

        // Delete cookies
        driver.manage().deleteAllCookies();

        //Maximize Window
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
    //endregion

    //region Tests
    @Test
    public void testNavigateToApplication(){
        // 1. Navigate to app url
        // 2. Validate teh login button is displayed

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        boolean isDisplayed = loginButton.isDisplayed();

        Assert.assertTrue(isDisplayed);
    }

    //endregion



    private Properties getAppConfig(){
        return ConfigReader.loadProperties("app_config");
    }

}

