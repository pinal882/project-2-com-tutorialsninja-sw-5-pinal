package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlistener.CustomListeners;
import com.tutorialsninja.demo.pages.AccountLoginPage;
import com.tutorialsninja.demo.pages.AccountRegisterPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * /1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
 *     //1.2 This method should click on the options whatever name is passed as parameter.
 *     //(Hint: Handle List of Element and Select options)
 */
@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {
    HomePage homePage;
    AccountRegisterPage accountRegisterPage;
    AccountLoginPage accountLoginPage;
    MyAccountPage myAccountPage;
    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();
        accountLoginPage = new AccountLoginPage();
myAccountPage = new MyAccountPage();
    }
    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
       //1.1 Clickr on My Account Link.
        homePage.clickOnMyQAccountTab();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter//“Register”
        homePage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),"Register Account", "Register page not displayed");
    }
    @Test (groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Clickr on My Account Link.
        homePage.clickOnMyQAccountTab();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter//“Login”
        homePage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(accountLoginPage.getReturningCustomerText(),"Returning Customer", "Login page not displayed");

    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Clickr on My Account Link.
        homePage.clickOnMyQAccountTab();
        // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
accountRegisterPage.enterFirstName("abc");
        //3.4 Enter Last Name
accountRegisterPage.enterLastName("ch");
        //3.5 Enter Email
accountRegisterPage.enterEmail("abc@gmail.com");
        //3.6 Enter Telephone
accountRegisterPage.enterTelephone("07654312678");
        //3.7 Enter Password
accountRegisterPage.enterPassword("abc123");
        //3.8 Enter Password Confirm
accountRegisterPage.enterConfirmPassword("abc123");
        //3.9 Select Subscribe Yes radio button
        accountRegisterPage.selectSubscription("yes");
        //3.10 Click on Privacy Policy check box
accountRegisterPage.clickOnPrivacyPolicyCheckBox();
        //3.11 Click on Continue button
       accountRegisterPage.clickOnContinueButton();
        // 3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(myAccountPage.getYourAccountHasBeenCreatedText(),"Your Account Has Been Created!",  "Account not created");
        // 3.13 Click on Continue button
        myAccountPage.clickOnContinueButton();
        // 3.14 Clickr on My Account Link.
        homePage.clickOnMyQAccountTab();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
Assert.assertEquals(myAccountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
        //3.17 Click on Continue button
        myAccountPage.clickOnContinueButton();

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Clickr on My Account Link.
        homePage.clickOnMyQAccountTab();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
accountLoginPage.enterEmailAddress("abc@gmail.com");
        //4.4 Enter Last Name
        //4.5 Enter Password
        accountLoginPage.enterPassword("abc123");
        //4.6 Click on Login button
        accountLoginPage.clickOnLoginButton();
        //4.7 Verify text “My Account”

        //4.8 Clickr on My Account Link.
        homePage.clickOnMyQAccountTab();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        Assert.assertEquals(myAccountPage.getAccountLogoutText(),"Account Logout", "Not logged out");
        //4.11 Click on Continue button
        myAccountPage.clickOnContinueButton();
    }
}
