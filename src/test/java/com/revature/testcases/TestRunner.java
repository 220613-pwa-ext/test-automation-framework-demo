package com.revature.testcases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(glue="com.revature.stepdefinitions", features={ "src/test/resources/login.feature" })
public class TestRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeMethod // Before each test case (in the case of Cucumber, before each scenario)
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // headless means that we don't want for the browser to be displayed
        // Especially useful if we are running test cases from a machine that has no display (such as an EC2 instance)

        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
