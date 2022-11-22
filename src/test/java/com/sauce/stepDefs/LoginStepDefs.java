package com.sauce.stepDefs;

import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductPage;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.Properties;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("^The user enters username \"(.*)\" and password \"(.*)\"$")
    public void the_user_enters_username_and_password_secret_sauce(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("The user should be able to login and see {string} header")
    public void the_user_should_be_able_to_login_and_see_header(String expectedHeader) {
        Assert.assertEquals("Verify that expected Header is PRODUCTS", expectedHeader, productPage.productHeader.getText());
    }

    @And("The user should be able to sort the products {string}")
    public void theUserShouldBeAbleToSortTheProductsHoghToLow(String sortType) {
        productPage.sortProducts(sortType);
    }


    @Then("The user clicks cheapest as {string} and second {string} cost list product")
    public void theUserClicksCheapestAsAndSecondCostListProduct(String cheapest, String costliest) {
        productPage.addProduct(cheapest);
        productPage.addProduct(costliest);
    }
    @And("The user opens the basket")
    public void theUserOpensTheBasket() {
        productPage.basket.click();

    }
    @Then("The user clicks checkout")
    public void theUserClicksCheckout() {
        checkoutPage.checkout.click();

    }
    @And("The user enters {string} , {string} and {string}")
    public void chekout(String firstName, String lastName,String postalCode){
        checkoutPage.checkoutCredentials(firstName,lastName,postalCode);
}
    @Then("User clicks continue button")
    public void userClicksContinueButton() {
        checkoutPage.continueBtn.click();
    }

    @And("The user verifies that items are{string} and be able to see total is {string}")
    public void theUserVerifiesTahtItemsAreAndBeAbleToSeeTotalIs(String price, String total) {
        System.out.println("checkoutPage.getTotalPrice(price) = " + checkoutPage.getTotalPrice(price));
        Assert.assertEquals(total,checkoutPage.getTotalPrice(price));
    }

    @Then("The user should finalize the purchase")
    public void theUserShouldFinalizeThePurchase() {
        checkoutPage.finishBtn.click();
    }

    @And("Purchase will be confirmed")
    public void purchaseWillBeConfirmed() {
        Assert.assertEquals("THANK YOU FOR YOUR ORDER",checkoutPage.purchaseConfirm.getText());
    }
}
