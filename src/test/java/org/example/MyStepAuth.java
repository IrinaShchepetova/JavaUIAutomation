package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.lesson8.RezkaLoginPage;
import org.example.lesson8.RezkaMainMenuBlock;
import org.example.lesson8.RezkaMainPage;

import static com.codeborne.selenide.Selenide.open;

public class MyStepAuth {

    @Given("^Пользователь зашел на сайт$")
    public void пользовательЗашелНаСайт() {
        open("http://hdrezkafjk2he.net");
    }

    @When("Клик на кнопку войти")
    public void кликНаКнопкуВойти() {
        new RezkaMainPage().rezkaClickSingButton();
    }

    @And("Логин")
    public void логин() {
        new RezkaLoginPage().login("Ирина Щепетова", "08021991I");
    }

    @Then("Проверка отображения профиля")
    public void проверкаОтображенияПрофиля() {
        new RezkaMainMenuBlock().checkProfile();
    }

    @After(value = "@close")
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }


}
