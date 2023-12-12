package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckout;
    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueTab;
    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstname;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastname;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement addressField;
@CacheLookup
@FindBy(id = "input-payment-city")
WebElement cityField;
@CacheLookup
@FindBy(id = "input-payment-postcode")
WebElement postcodeField;
@CacheLookup
@FindBy(id = "input-payment-country")
WebElement countryDropdown;
@CacheLookup
@FindBy(id = "input-payment-zone")
WebElement regionDropdown;
@CacheLookup
@FindBy(id = "button-guest")
WebElement continueButton;
@CacheLookup
@FindBy(xpath = "//textarea[@name='comment']")
WebElement textField;
@CacheLookup
@FindBy(xpath = "//input[@name='agree']")
WebElement checkbox;
@CacheLookup
@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
WebElement warning;
    public String verifyNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckOut() {
        clickOnElement(guestCheckout);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }

    public void enterFirstName(String name) {
        sendTextToElement(firstname, name);
    }

    public void enterLastName(String name) {
        sendTextToElement(lastname, name);
    }

    public void enterEmailAddress(String mail) {
        sendTextToElement(email, mail);
    }

    public void enterTelephone(String phone) {
        sendTextToElement(telephone, phone);
    }
    public void enterAddress(String address){
        sendTextToElement(addressField,address);
    }
    public void enterCity(String city){
        sendTextToElement(cityField,city);
    }
    public void enterPostcode(String postcode){
        sendTextToElement(postcodeField,postcode);
    }
    public void selectCountryFromDropdown(){
        selectByIndexFromDropDown(countryDropdown,222);
    }
    public void selectRegion(){
        selectByIndexFromDropDown(regionDropdown,3518);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);

    }
    public void enterTextInCommentBox(String text){
        sendTextToElement(textField,text);

    }
    public void clickOnCheckbox(){
        clickOnElement(checkbox);
    }
    public String verifyWarningMessage(){
        return getTextFromElement(warning);
    }
}