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

public class StarWarsPage {

    private SelenideElement movie1 = $(By.xpath("//a[@href='http://hdrezkabbdh4d.net/films/fantasy/1054-zvezdnye-voyny-epizod-1-skrytaya-ugroza-1999.html']"));

    @Step("Клик на карточку фильма")
    public StarWars1Page moviesClick(){
        movie1.click();
        return page(StarWars1Page.class);

    }
}
