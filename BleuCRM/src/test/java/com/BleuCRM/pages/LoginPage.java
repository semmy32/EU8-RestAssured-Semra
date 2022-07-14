package com.BleuCRM.pages;

import com.BleuCRM.utilities.BrowserUtils;
import com.BleuCRM.utilities.ConfigurationReader;
import com.BleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement userLoginInput;

    @FindBy(name = "USER_PASSWORD")
    public WebElement userPasswordInput;

    @FindBy(xpath = "//input[@class='login-btn']")
    public WebElement loginBtn;

    public void loginHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        userLoginInput.sendKeys(ConfigurationReader.getProperty("username3"));
        userPasswordInput.sendKeys(ConfigurationReader.getProperty("pw"));
        loginBtn.click();
        BrowserUtils.waitForPageToLoad(5);
    }
}
