package org.example.hw6;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RezkaMainPage extends RezkaBasePage {
    @FindBy(className = "b-tophead__login")
    private WebElement rezkaSingInButton;

    public RezkaMainPage(WebDriver driver) {
        super(driver);
        rezkaMainMenuBlock = new RezkaMainMenuBlock(driver);
    }
    public RezkaMainMenuBlock rezkaMainMenuBlock;

    public Cookie cookie = new Cookie("dle_user_id","91221");
    public Cookie cookie1 = new Cookie("dle_password","7de36eee0752624d729c401b9cefa900");
    public Cookie cookie2 = new Cookie("dle_user_token","fa104a1c301468bbb278e9e2cdfa2ca8");

    public RezkaMainMenuBlock addCookie(){
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.navigate().refresh();
        return new RezkaMainMenuBlock(driver);
    }

    public RezkaLoginPage rezkaClickSingButton() {
        rezkaSingInButton.click();
        return new RezkaLoginPage(driver);
    }


}
