package com.hung.app.firsttestapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//import org.openqa.selenium.remote.CapabilityType;


public class Calculator {
    AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
//        capabilities.setCapability("VERSION", "7.1.1");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("deviceName", "192.168.227.101:5555");
        capabilities.setCapability("platformName", "Android");


        capabilities.setCapability("appPackage", "com.android.calculator2");
// This package name of your app (you can get it from apk info app)
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
        //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @Test
    public void testCalAdd() throws Exception {
        //locate the Text on the calculator by using By.name()
        try {
            MobileElement two = driver.findElement(By.id("digit_1"));
            two.click();
            MobileElement plus = driver.findElement(By.id("op_add"));
            plus.click();
            MobileElement four = driver.findElement(By.id("digit_2"));
            four.click();
            MobileElement equalTo = driver.findElement(By.id("eq"));
            equalTo.click();
            //locate the edit box of the calculator by using By.tagName()
            MobileElement results = driver.findElement(By.id("result"));
            //Check the calculated value on the edit box
            assert results.getText().equals("3") : "Actual value is : " + results.getText() + " did not m8atch with expected value: 3";
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testCalMulti() throws Exception {
        //locate the Text on the calculator by using By.name()
        try {
            MobileElement two = driver.findElement(By.id("digit_2"));
            two.click();
            MobileElement plus = driver.findElement(By.id("op_mul"));
            plus.click();
            MobileElement four = driver.findElement(By.id("digit_2"));
            four.click();
            MobileElement equalTo = driver.findElement(By.id("eq"));
            equalTo.click();
            //locate the edit box of the calculator by using By.tagName()
            MobileElement results = driver.findElement(By.id("result"));
            //Check the calculated value on the edit box
            assert results.getText().equals("4") : "Actual value is : " + results.getText() + " did not m8atch with expected value: 4";
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @AfterClass
    public void teardown() {
        //close the app
        driver.quit();
    }
}