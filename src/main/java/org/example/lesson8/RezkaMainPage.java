package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RezkaMainPage {

    private SelenideElement rezkaSingInButton = $(By.className("b-tophead__login"));

    public RezkaMainMenuBlock rezkaMainMenuBlock;

    public Cookie cookie = new Cookie("dle_user_id","91221");
    public Cookie cookie1 = new Cookie("dle_password","7de36eee0752624d729c401b9cefa900");
    public Cookie cookie2 = new Cookie("dle_user_token","fa104a1c301468bbb278e9e2cdfa2ca8");

    @Step("Добавить куки")
    public RezkaMainMenuBlock addCookie(){
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie1);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie2);
        WebDriverRunner.getWebDriver().navigate().refresh();
        return page(RezkaMainMenuBlock.class);
    }

    @Step("Клик на кнопку Войти")
    public RezkaLoginPage rezkaClickSingButton() {
        rezkaSingInButton.click();
        return page(RezkaLoginPage.class);
    }


}
