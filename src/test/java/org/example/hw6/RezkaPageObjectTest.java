package org.example.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RezkaPageObjectTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driver.get("http://hdrezkabbdh4d.net");
    }
    @Test
    @DisplayName("Проверка авторизации")
    void authTest(){
        new RezkaMainPage(driver).rezkaClickSingButton()
                .login("Ирина Щепетова", "08021991I")
                .rezkaMainMenuBlock.checkProfile();
    }
    @Test
    @DisplayName("Метод проверки поиска")
    void hdrezkaFindTest() {
        new RezkaMainPage(driver).addCookie()
                .findMovie("Звездные войны")
                .moviesClick()
                .walkerPlay();
    }
    @Test
    @DisplayName("Метод проверки футера")
    void hdrezkaFooterTest(){
        new FooterBlock(driver).viewLinksToMovieClick()
                .abuseLinkClick()
                .supportLinkClick()
                .vkLinkClick()
                .twitterLinkClick()
                .checkLogo();
    }
    @Test
    @DisplayName("Метод проверки всплывающего меню и удаления рекламы")
    //Подскажите, почему этот тест не работает. Реклама постоянно меняется, но по этому локатору должна любая находиться, т.к. размеры у нее одни и те же всегда(
    void hdrezkaSaggestTest(){
        new RezkaMainMenuBlock(driver).filmsSuggestClick()
                .adBlock();

    }
    @AfterEach
    void killBrowser(){
        driver.quit();
    }
}
