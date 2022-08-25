package org.example.hw6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RezkaMainMenuBlock extends RezkaBasePage{
    public RezkaMainMenuBlock(WebDriver driver) {
        super(driver);
    }

    private final String profileXpathLocator = "//span[@class='b-tophead-dropdown']";
    @FindBy(xpath = profileXpathLocator)
    private WebElement profile;

    public RezkaMainMenuBlock checkProfile() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profileXpathLocator)));
        Assertions.assertEquals(driver.findElement(By.xpath(profileXpathLocator)).isDisplayed(), true);
        return this;
    }
    private final String findIdLocator = "search-field";
    @FindBy(id = findIdLocator)
    private WebElement find;

    private final String findButtonLocator = "b-search__submit";
    @FindBy(className = findButtonLocator)
    private WebElement findButton;

    public StarWarsPage findMovie(String nameMovie){
        find.click();
        driver.switchTo().activeElement().sendKeys(nameMovie);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(findButtonLocator)));
        findButton.click();
        return new StarWarsPage(driver);
    }
    private final String filmsSuggestLocator = "//li[@class='b-topnav__item i1']//a[@class='b-topnav__item-link']";
    @FindBy(xpath = filmsSuggestLocator)
    private WebElement filmsSuggest;

    private final String filmsFictionLocator = "//a[@href=\"/films/fiction/\"]";
    @FindBy(xpath = filmsFictionLocator)
    private WebElement filmsFiction;

    public RezkaFilmsFictionPage filmsSuggestClick(){
        actions.moveToElement(driver.findElement(By.xpath(filmsSuggestLocator)))
                .build()
                .perform();
        driver.findElement(By.xpath(filmsFictionLocator)).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "http://hdrezkabbdh4d.net/films/fiction/");
        return new RezkaFilmsFictionPage(driver);
    }

}
