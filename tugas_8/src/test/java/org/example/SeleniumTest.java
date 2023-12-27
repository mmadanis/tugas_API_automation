package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;

    @Test
    public void  testSearchEmail(){
//        open browser
        WebDriverManager.firefoxdriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.yopmail.com/");
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = driver.findElement(By.id("login"));
        searchBox.sendKeys("automationtest");
        WebElement checkInboxButton = driver.findElement(By.cssSelector("button.md"));
        checkInboxButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame("ifinbox");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().defaultContent();
        WebElement iframeElement = driver.findElement(By.id("ifmail"));
        driver.switchTo().frame(iframeElement);

        WebElement emailContent = driver.findElement(By.id("mail"));
        String content = emailContent.getText();

        System.out.println("Email Content:\n" + content);

        driver.quit();
    }

    @Test
    public void searchTrip() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // open makemytrip.com
        driver.get("https://www.makemytrip.com/");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a"));
        searchButton.click();

        try {
            Thread.sleep(50000);

            WebElement closePopUp = driver.findElement(By.cssSelector("span.bgProperties.overlayCrossIcon.icon20"));

            closePopUp.click();

        } catch (Exception e) {
            System.out.println("Pop-up tidak ditemukan atau tidak dapat ditutup: " + e.getMessage());
        }

        // get top price
        WebElement topPriceElement = driver.findElement(By.xpath("//*[@id=\"listing-id\"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/div/div"));
        String topPrice = topPriceElement.getText();
        System.out.println("Top Price: " + topPrice);

        driver.quit();
    }
}
