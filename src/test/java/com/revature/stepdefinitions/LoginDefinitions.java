package com.revature.stepdefinitions;

import com.revature.pages.LoginPage;
import com.revature.testcases.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginDefinitions {

    private LoginPage loginPage;

    @Given("I am at the login page")
    public void i_am_at_the_login_page() {
        TestRunner.driver.get("http://ec2-18-191-141-71.us-east-2.compute.amazonaws.com");
        loginPage = new LoginPage(TestRunner.driver);
    }

    @When("I type in a username of {string}")
    public void iTypeInAUsernameOf(String arg0) {
        loginPage.typeUsername(arg0);
    }

    @And("I type in a password of {string}")
    public void iTypeInAPasswordOf(String arg0) {
        loginPage.typePassword(arg0);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the success page")
    public void iShouldBeRedirectedToTheSuccessPage() {
        WebDriverWait wdw = new WebDriverWait(TestRunner.driver, Duration.ofSeconds(10));
        wdw.until(ExpectedConditions.urlToBe("http://ec2-18-191-141-71.us-east-2.compute.amazonaws.com/success.html"));

        String expectedUrl = "http://ec2-18-191-141-71.us-east-2.compute.amazonaws.com/success.html";
        String actual = TestRunner.driver.getCurrentUrl();

        Assert.assertEquals(actual, expectedUrl);
    }

    @Then("I should receive an error message of {string}")
    public void iShouldReceiveAnErrorMessageOf(String arg0) {
        String actual = loginPage.getErrorMessageParagraphText();
        String expected = arg0;

        Assert.assertEquals(actual, expected);
    }
}
