package org.example.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RezkaMainMenuBlock {

    private SelenideElement profile = $(By.xpath("//span[@class='b-tophead-dropdown']"));

    @Step("Проверка отображения профиля")
    public RezkaMainMenuBlock checkProfile() {
        //profile.shouldHave(Condition.visible);
        $(profile).shouldBe(visible);
        //Assertions.assertEquals(driver.findElement(By.xpath(profileXpathLocator)).isDisplayed(), true);
        return this;
    }

    private SelenideElement find = $(By.id("search-field"));

    private SelenideElement findButton = $(By.className("b-search__submit"));


    @Step("Поиск фильма")
    public StarWarsPage findMovie(String nameMovie){
        find.click();
        WebDriverRunner.getWebDriver().switchTo().activeElement().sendKeys(nameMovie);
        findButton.click();
        return page(StarWarsPage.class);
    }

    private SelenideElement filmsSuggest = $(By.xpath("//li[@class='b-topnav__item i1']//a[@class='b-topnav__item-link']"));

    private SelenideElement filmsFiction = $(By.xpath("//a[@href=\"/films/fiction/\"]"));


    @Step("Навести курсор на всплывающее меню Фильмы и клик по кнопке Фантастика")
    public RezkaFilmsFictionPage filmsSuggestClick(){
        filmsSuggest.hover();
        filmsFiction.click();
        webdriver().shouldHave(url("http://hdrezkabbdh4d.net/films/fiction/"));
        //Assertions.assertEquals(driver.getCurrentUrl(), "http://hdrezkabbdh4d.net/films/fiction/");
        return page(RezkaFilmsFictionPage.class);
    }

}
