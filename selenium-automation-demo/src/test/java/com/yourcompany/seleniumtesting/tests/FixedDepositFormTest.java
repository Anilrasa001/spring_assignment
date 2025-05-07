package com.yourcompany.seleniumtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FixedDepositFormTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Make sure you have chromedriver in your system PATH or specify its path here
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\Automation Testing\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testFixedDepositFormSubmission() {
        driver.get("http://localhost:8080/fixed-deposit");

        driver.findElement(By.id("depositAmount")).sendKeys("10000");
        driver.findElement(By.id("tenure")).sendKeys("5");
        driver.findElement(By.id("rate")).sendKeys("7.5");

        driver.findElement(By.id("submitBtn")).click();

        WebElement successMessage = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMessage.isDisplayed());

        WebElement maturityAmount = driver.findElement(By.id("maturityAmount"));
        System.out.println("Maturity Amount: " + maturityAmount.getText());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}