package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StarWars1Page {

    private SelenideElement walker = $(By.xpath("//pjsdiv[@style='position: absolute; top: -11.5px; left: -20px; width: 40px; height: 23px; border-radius: 2.3px; background: rgb(23, 35, 34); opacity: 0.7; transition: opacity 0.1s linear 0s, background 0.1s linear 0s, transform 0.1s linear 0s; cursor: pointer; pointer-events: auto; transform: scale(1.6);']"));

    private SelenideElement movie5 = $(By.xpath("//a[@href='http://hdrezkabbdh4d.net/films/fiction/1058-zvezdnye-voyny-epizod-5-imperiya-nanosit-otvetnyy-udar-1980.html']"));

    @Step("Включить фильм в плеере")
    public StarWars1Page walkerPlay(){
        walker.click();
        $(movie5).shouldBe(visible);
        return this;
    }
}
