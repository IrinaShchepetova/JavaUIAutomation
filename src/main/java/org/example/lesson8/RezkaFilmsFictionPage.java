package org.example.lesson8;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;


public class RezkaFilmsFictionPage {

    private SelenideElement ad = $(By.xpath("//img[@style=\"max-height: 1765px; max-width: 240px; display: block; margin: 0px auto;\"]"));

    @Step("Удалить рекламу")
    public RezkaFilmsFictionPage adBlock(){
        //driver.manage().window().maximize();
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript(String.format("let element = document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n", ad) +
                "element.singleNodeValue.remove()");
        return this;
    }
}
