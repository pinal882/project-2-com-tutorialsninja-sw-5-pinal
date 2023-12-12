package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlistener.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.ArrayList;
import java.util.Collections;
@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test (groups = {"sanity","smoke","regression"})
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverOnDesktopsLinkAndClick();
        //1.2 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");
        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopPage.getProductsNameList();
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.selectSortByOption("Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        ArrayList<String> afterSortByZToAProductsName = desktopPage.getProductsNameList();
        Assert.assertEquals(afterSortByZToAProductsName,originalProductsName);
    }
    @Test(groups = {"regression"},dataProvider = "Desktops",dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total ){
        //2.1 Mouse hover on Currency Dropdown and click
        // 2.2 Mouse hover on £Pound Sterling and click
        homePage.selectCurrency("£Pound Sterling");
        //2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverOnDesktopsLinkAndClick();
        //2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");
        //2.5 Select Sort By position "Name: A to Z"
        desktopPage.selectSortByOption("Name (A - Z)");
        //2.6 Select product <product>
        desktopPage.selectProductByName("HP LP3065");
        //2.7 Enter Qty <qty> using Select class.
        productPage.enterQuantity("1");
        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();
        //2.9 Verify the Message <successMessage>
Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"), "Product not added to cart");
        //2.10 Click on link “shopping cart” display into success message
productPage.clickOnShoppingCartLinkIntoMessage();
        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");

        //2.12 Verify the Product name <productName>
        Assert.assertEquals(shoppingCartPage.getProductName(), "HP LP3065", "Product Name Doesn't appear");
        //2.13 Verify the Model <model>
        Assert.assertEquals(shoppingCartPage.getModelText(), "Product 21", "Model Name Doesn't appear");
        //2.14 Verify the Total <total>
Assert.assertEquals(shoppingCartPage.getTotalText(),"£74.73", "Total not matched");

    }
}
