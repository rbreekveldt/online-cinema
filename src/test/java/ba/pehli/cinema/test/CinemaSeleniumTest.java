package ba.pehli.cinema.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class CinemaSeleniumTest {

    @Test
    public void main() throws InterruptedException {
        //Create firefox drive to drive the browser
        //WebDriver driver = new ChromeDriver();
        HtmlUnitDriver driver = new HtmlUnitDriver();
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


