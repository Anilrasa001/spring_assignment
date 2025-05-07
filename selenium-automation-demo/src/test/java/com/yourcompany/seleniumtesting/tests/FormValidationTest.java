package com.yourcompany.seleniumtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
 
public class FormValidationTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\Automation Testing\\chromedriver.exe");
        driver = new ChromeDriver();
    }
     
    
    @Test
    public void testRequiredFieldsValidation() {
        driver.get("http://localhost:8080/form");

        driver.findElement(By.id("submitBtn")).click();
        WebElement error = driver.findElement(By.id("requiredFieldError"));
        Assert.assertTrue(error.isDisplayed());
    }

    @Test
    public void testDropdownOptions() {
        driver.get("http://localhost:8080/form");

        Select tenureDropdown = new Select(driver.findElement(By.id("tenure")));
        List<WebElement> options = tenureDropdown.getOptions();
        List<String> expectedOptions = Arrays.asList("1", "3", "6", "12");

        for (String expected : expectedOptions) {
            boolean found = options.stream().anyMatch(opt -> opt.getText().equals(expected));
            Assert.assertTrue(found, "Missing option: " + expected);
        }
    }

    @Test
    public void testSubmitEnabledAfterValidInput() {
        driver.get("http://localhost:8080/form");

        WebElement submitButton = driver.findElement(By.id("submitBtn"));
        Assert.assertFalse(submitButton.isEnabled());

        driver.findElement(By.id("depositAmount")).sendKeys("10000");
        driver.findElement(By.id("tenure")).sendKeys("6");
        driver.findElement(By.id("rate")).sendKeys("7.5");

        // Re-fetch the button after inputs, in case it re-renders
        submitButton = driver.findElement(By.id("submitBtn"));
        Assert.assertTrue(submitButton.isEnabled());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}