package org.example.hw6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarWars1Page extends RezkaBasePage{
    public StarWars1Page(WebDriver driver) {
        super(driver);
    }
    private final String walkerLocator = "//pjsdiv[@style='position: absolute; top: -11.5px; left: -20px; width: 40px; height: 23px; border-radius: 2.3px; background: rgb(23, 35, 34); opacity: 0.7; transition: opacity 0.1s linear 0s, background 0.1s linear 0s, transform 0.1s linear 0s; cursor: pointer; pointer-events: auto; transform: scale(1.6);']";
    @FindBy(xpath = walkerLocator)
    private WebElement walker;

    private final String movie5Locator = "//a[@href='http://hdrezkabbdh4d.net/films/fiction/1058-zvezdnye-voyny-epizod-5-imperiya-nanosit-otvetnyy-udar-1980.html']";
    @FindBy(xpath = movie5Locator)
    private WebElement movie5;

    public StarWars1Page walkerPlay(){
        walker.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(movie5Locator)));
        Assertions.assertEquals(driver.findElement(By.xpath(movie5Locator)).isDisplayed(), true);
        return this;
    }
}
