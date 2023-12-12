package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(id = "input-email" )
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "input-password" )
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;
    public String getReturningCustomerText() {
        return getTextFromElement(returningCustomerText);

    }
    public void enterEmailAddress(String email) {
        sendTextToElement(emailAddressField, email);
    }
    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }
    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
    }
}
