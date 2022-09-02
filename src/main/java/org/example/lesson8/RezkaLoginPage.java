package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RezkaLoginPage {

    private SelenideElement loginField = $(By.id("login_name"));

    private SelenideElement passwordField = $(By.id("login_password"));

    private SelenideElement rezkaSingInButton = $(By.xpath("//button[@class='login_button btn btn-action']"));


    @Step("Логин")
    public RezkaMainPage login(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        rezkaSingInButton.click();
        return page(RezkaMainPage.class);
    }

}
