package ba.pehli.cinema.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class CinemaSeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        //Create firefox drive to drive the browser
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        //Open cinema home page
        driver.get("http://localhost:8080/cinema/movies");
        //Fill in username
        Thread.sleep(2000);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        //Fill in password
        Thread.sleep(2000);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        //Submit credentials
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();
        //New Movie
        Thread.sleep(2000);
        driver.findElement(By.linkText("New movie")).click();
        //Back to Home
        Thread.sleep(2000);
        driver.findElement(By.linkText("Home")).click();
        //Like button
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("img[alt=\"Like\"]")).click();
        //Back to Home
        Thread.sleep(2000);
        driver.findElement(By.linkText("Home")).click();
        //Change button
        Thread.sleep(2000);
        driver.findElement(By.linkText("Change")).click();
        //Back to Home
        Thread.sleep(2000);
        driver.findElement(By.linkText("Home")).click();
        //Go to page 6-10
        Thread.sleep(2000);
        driver.findElement(By.linkText("6-10")).click();
        //Log out
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        //Catalog
        Thread.sleep(2000);
        driver.findElement(By.linkText("Catalog")).click();
        //Close browser
        Thread.sleep(3000);
        driver.close();
    }
}

