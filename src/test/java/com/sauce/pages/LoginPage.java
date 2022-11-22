package com.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class LoginPage extends BasePage{

    @FindBy(id="user-name")
    public WebElement inputUserName;

    @FindBy(id="password")
    public WebElement inputPassword;
    @FindBy(name="login-button")
    public WebElement loginBtn;

    public void login (String username, String password){
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();

    }

}
