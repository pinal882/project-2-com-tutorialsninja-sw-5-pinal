package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement qtyField;
    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath ="//a[contains(text(),'shopping cart')]" )
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;

public void enterQuantity(String qty){

    sendTextToElement(qtyField,qty);
}
public void clickOnAddToCartButton(){
    clickOnElement(addToCartButton);
}
public String getProductAddedSuccessMessage(){
    return getTextFromElement(successMessage);
}
public void clickOnShoppingCartLinkIntoMessage(){
    clickOnElement(shoppingCartLink);
}
    public String getProductText() {
        return getTextFromElement(productText);
    }

}
