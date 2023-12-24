package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    public void  loginTest(){
//        open browser
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //login
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        String txtActualBerhasilLogin = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
        String txtExpectedBerhasilLogin = "Welcome to the Secure Area. When you are done click logout below.";

        Assert.assertEquals(txtActualBerhasilLogin, txtExpectedBerhasilLogin);

        driver.quit();
    }
}
