package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDrezkaAuth {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://hdrezkabbdh4d.net/");
        driver.findElement(By.className("b-tophead__login")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("login_name")).sendKeys("Ирина Щепетова");
        driver.findElement(By.id("login_password")).sendKeys("08021991I");
        driver.findElement(By.xpath("//button[@class=\"login_button btn btn-action\"]")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}
