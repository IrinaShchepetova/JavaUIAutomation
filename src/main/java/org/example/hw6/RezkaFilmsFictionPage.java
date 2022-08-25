package org.example.hw6;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RezkaFilmsFictionPage extends RezkaBasePage{
    public RezkaFilmsFictionPage(WebDriver driver) {
        super(driver);
    }
    private final String adLocator = "//img[@style=\"max-height: 1765px; max-width: 240px; display: block; margin: 0px auto;\"]";
    @FindBy(xpath = adLocator)
    private WebElement ad;

    public RezkaFilmsFictionPage adBlock(){
        driver.manage().window().maximize();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(adLocator)));
        ((JavascriptExecutor) driver).executeScript("let element = document.evaluate(adLocator, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        return this;
    }
}
