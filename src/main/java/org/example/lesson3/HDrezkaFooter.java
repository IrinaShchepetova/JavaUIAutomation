package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HDrezkaFooter {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hdrezkabbdh4d.net/");
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
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/support.html\"]")));
        driver.findElement(By.xpath("//a[@href=\"/support.html\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer//a[@title=\"ВКонтакте\"]")));
        driver.findElement(By.xpath("//footer//a[@title=\"ВКонтакте\"]")).click();
        Thread.sleep(5000);
        driver.switchTo().window(window1);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer//a[@title=\"Twitter\"]")));
        driver.findElement(By.xpath("//footer//a[@title=\"Twitter\"]")).click();
        Thread.sleep(30000);
        driver.quit();
    }
}
