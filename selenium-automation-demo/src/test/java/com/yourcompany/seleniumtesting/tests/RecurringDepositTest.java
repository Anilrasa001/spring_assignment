package com.yourcompany.seleniumtesting.tests;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class RecurringDepositTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Make sure to update the path to your actual chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\Automation Testing\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testRecurringDepositSetup() {
        driver.get("http://localhost:8080/recurring-deposit");

        driver.findElement(By.id("monthlyContribution")).sendKeys("2000");
        driver.findElement(By.id("tenure")).sendKeys("12");
        driver.findElement(By.id("submitBtn")).click();

        WebElement totalInvestment = driver.findElement(By.id("totalInvestment"));
        String expected = "24000";
        Assert.assertEquals(totalInvestment.getText(), expected);
    }

    @Test
    public void testRecurringDepositInvalidInput() {
        driver.get("http://localhost:8080/recurring-deposit");

        driver.findElement(By.id("monthlyContribution")).sendKeys("abc");
        driver.findElement(By.id("submitBtn")).click();

        WebElement error = driver.findElement(By.id("inputError"));
        Assert.assertTrue(error.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
