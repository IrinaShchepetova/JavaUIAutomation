package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HDrezkaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String HDREZKA_BASE_URL = "http://hdrezkabbdh4d.net/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(HDREZKA_BASE_URL);
    }
    @Test
    @DisplayName("Метод проверки авторизации")
    void hdrezkaAuth (){
        driver.findElement(By.className("b-tophead__login")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_name")));
        driver.findElement(By.id("login_name")).sendKeys("Ирина Щепетова");
        driver.findElement(By.id("login_password")).sendKeys("08021991I");
        driver.findElement(By.xpath("//button[@class=\"login_button btn btn-action\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"b-tophead-dropdown\"]")));
        Assertions.assertEquals(driver.findElement(By.xpath("//span[@class=\"b-tophead-dropdown\"]")).isDisplayed(), true);

    }
    @Test
    @DisplayName("Метод проверки поиска")
    void hdrezkaFind() {
        Cookie cookie = new Cookie("dle_user_id","91221");
        driver.manage().addCookie(cookie);
        Cookie cookie1 = new Cookie("dle_password","7de36eee0752624d729c401b9cefa900");
        driver.manage().addCookie(cookie1);
        Cookie cookie2 = new Cookie("dle_user_token","fa104a1c301468bbb278e9e2cdfa2ca8");
        driver.manage().addCookie(cookie2);
        driver.navigate().refresh();
        driver.findElement(By.id("search-field")).click();
        driver.switchTo().activeElement().sendKeys("Звездные войны");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("b-search__submit")));
        driver.findElement(By.className("b-search__submit")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"http://hdrezkabbdh4d.net/films/fantasy/1054-zvezdnye-voyny-epizod-1-skrytaya-ugroza-1999.html\"]")));
        driver.findElement(By.xpath("//a[@href=\"http://hdrezkabbdh4d.net/films/fantasy/1054-zvezdnye-voyny-epizod-1-skrytaya-ugroza-1999.html\"]")).click();
        driver.findElement(By.xpath("//pjsdiv[@style=\"position: absolute; top: -11.5px; left: -20px; width: 40px; height: 23px; border-radius: 2.3px; background: rgb(23, 35, 34); opacity: 0.7; transition: opacity 0.1s linear 0s, background 0.1s linear 0s, transform 0.1s linear 0s; cursor: pointer; pointer-events: auto; transform: scale(1.6);\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"http://hdrezkabbdh4d.net/films/fiction/1058-zvezdnye-voyny-epizod-5-imperiya-nanosit-otvetnyy-udar-1980.html\"]")));
        Assertions.assertEquals(driver.findElement(By.xpath("//a[@href=\"http://hdrezkabbdh4d.net/films/fiction/1058-zvezdnye-voyny-epizod-5-imperiya-nanosit-otvetnyy-udar-1980.html\"]")).isDisplayed(), true);
    }
    @Test
    @DisplayName("Метод проверки футера")
    void hdrezkaFooter(){
        driver.findElement(By.xpath("//footer//a[@href=\"/films/\"]")).click();
        driver.findElement(By.xpath("//footer//a[@href=\"/cartoons/\"]")).click();
        driver.findElement(By.xpath("//footer//a[@href=\"/series/\"]")).click();
        driver.findElement(By.xpath("//footer//a[@href=\"/show/\"]")).click();
        String window1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href=\"/abuse.html\"]")).click();
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;
        for (String window : currentWindows){
            if (!window.equals(window1)){
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/support.html\"]")));
        driver.findElement(By.xpath("//a[@href=\"/support.html\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer//a[@title=\"ВКонтакте\"]")));
        driver.findElement(By.xpath("//footer//a[@title=\"ВКонтакте\"]")).click();
        driver.switchTo().window(window1);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer//a[@title=\"Twitter\"]")));
        driver.findElement(By.xpath("//footer//a[@title=\"Twitter\"]")).click();
        driver.switchTo().window(window1);
        Assertions.assertEquals(driver.findElement(By.className("b-tophead__logo")).isDisplayed(), true);

    }
    @Test
    @DisplayName("Метод проверки всплывающего меню и удаления рекламы")
    void hdrezkaSaggest() {

        actions.moveToElement(driver.findElement(By.xpath("//li[@class=\"b-topnav__item i1\"]//a[@class=\"b-topnav__item-link\"]")))
                .build()
                .perform();
        driver.findElement(By.xpath("//a[@href=\"/films/fiction/\"]")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "http://hdrezkabbdh4d.net/films/fiction/");
        ((JavascriptExecutor) driver).executeScript("let element = document.evaluate(\"//img[@src='//s.sarafan.fun/media/6/2/62253310159716_740.gif']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
    }
    @AfterEach
    void quitBrowser(){
        driver.quit();
    }
}

