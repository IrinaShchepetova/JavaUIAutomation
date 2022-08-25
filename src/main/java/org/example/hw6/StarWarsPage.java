package org.example.hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarWarsPage extends RezkaBasePage{
    public StarWarsPage(WebDriver driver) {
        super(driver);
    }
    private final String movie1Locator = "//a[@href='http://hdrezkabbdh4d.net/films/fantasy/1054-zvezdnye-voyny-epizod-1-skrytaya-ugroza-1999.html']";
    @FindBy(xpath = movie1Locator)
    private WebElement movie1;

    public StarWars1Page moviesClick(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(movie1Locator)));
        movie1.click();
        return new StarWars1Page(driver);

    }
}
