package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkout;

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement ckeckoutFirstName;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement ckeckoutLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement ckeckoutPostalCode;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishBtn;

    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    public WebElement purchaseConfirm;

    public void checkoutCredentials(String firstName, String lastName, String postalCode) {
        ckeckoutFirstName.sendKeys(firstName);
        ckeckoutLastName.sendKeys(lastName);
        ckeckoutPostalCode.sendKeys(postalCode);
    }

    public String getTotalPrice(String price) {
        return Driver.get().findElement(By.xpath("//div[text()='" + price + "']")).getText();
    }


}


//input[@id='last-name']