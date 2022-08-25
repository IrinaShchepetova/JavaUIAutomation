package org.example.hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RezkaLoginPage extends RezkaBasePage {
    public RezkaLoginPage(WebDriver driver) {
        super(driver);
    }
    private final String loginIdLocator = "login_name";
    @FindBy(id = "login_name")
    private WebElement loginField;

    @FindBy(id = "login_password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='login_button btn btn-action']")
    private WebElement rezkaSingInButton;

    public RezkaMainPage login(String login, String password){
//        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginIdLocator)));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        rezkaSingInButton.click();
        return new RezkaMainPage(driver);
    }

}
