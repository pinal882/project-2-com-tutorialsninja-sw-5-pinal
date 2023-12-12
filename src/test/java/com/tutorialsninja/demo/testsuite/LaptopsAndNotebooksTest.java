package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlistener.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
    }
    @Test (groups = {"sanity","smoke","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
        // Get all the products price and stored into array list
        List<Double> originalProductsPrice = laptopsAndNotebooksPage.getProductsPriceList();
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        //1.3 Select Sort By "Price (High > Low)"
laptopsAndNotebooksPage.selectSortByOption("Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        // After filter Price (High > Low) Get all the products name and stored into array list
        ArrayList<Double> afterSortByPrice = laptopsAndNotebooksPage.getProductsPriceList();
        Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }

    @Test (groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully(){
      //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortByOption("Price (High > Low)");
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectProductByName("MacBook");
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(productPage.getProductText(), "MacBook", "MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        productPage.clickOnAddToCartButton();
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        //2.8 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLinkIntoMessage();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getProductName(), "MacBook", "Product Name Doesn't appear");
        //2.11 Change Quantity "2"
        shoppingCartPage.clearAndAddQuantity("2");
        // 2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdate();
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(shoppingCartPage.isSuccessMessageAppearing("Success: You have modified your shopping cart!"), "Cart not modified");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.getTotalText(), "£737.45", "Total not matched");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckout();
        //2.16 Verify the text “Checkout”
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(checkoutPage.verifyNewCustomerText(),"New Customer");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestCheckOut();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueTab();
        //2.20 Fill the mandatory fields
        checkoutPage.enterFirstName("abc");
        checkoutPage.enterLastName("ch");
        checkoutPage.enterEmailAddress("abc@gmail.com");
        checkoutPage.enterTelephone("07654321809");
        checkoutPage.enterAddress("123,hill view");
        checkoutPage.enterCity("harrow");
        checkoutPage.enterPostcode("ha3 4rh");
        checkoutPage.selectCountryFromDropdown();
        checkoutPage.selectRegion();
        //2.21 Click on “Continue” Button
checkoutPage.clickOnContinueButton();
        //2.22 Add Comments About your order into text area
checkoutPage.enterTextInCommentBox("Deliver to safe place");
        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnCheckbox();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnContinueButton();
        // 2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(checkoutPage.verifyWarningMessage(),"Warning: Payment method required!");
    }
}
