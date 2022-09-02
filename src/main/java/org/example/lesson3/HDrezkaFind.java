package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDrezkaFind {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://hdrezkabbdh4d.net/");
        Cookie cookie = new Cookie("dle_user_id","91221");
        driver.manage().addCookie(cookie);
        Cookie cookie1 = new Cookie("dle_password","7de36eee0752624d729c401b9cefa900");
        driver.manage().addCookie(cookie1);
        Cookie cookie2 = new Cookie("dle_user_token","fa104a1c301468bbb278e9e2cdfa2ca8");
        driver.manage().addCookie(cookie2);
        Thread.sleep(5000);
        driver.navigate().refresh();
        driver.findElement(By.id("search-field")).click();
        driver.switchTo().activeElement().sendKeys("Звездные войны");
        Thread.sleep(5000);
        driver.findElement(By.className("b-search__submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href=\"http://hdrezkabbdh4d.net/films/fantasy/1054-zvezdnye-voyny-epizod-1-skrytaya-ugroza-1999.html\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//video[@crossorigin=\"anonymous\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("player")).click();

        driver.quit();
    }
}
