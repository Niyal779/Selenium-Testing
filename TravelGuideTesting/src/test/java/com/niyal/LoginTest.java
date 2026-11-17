package com.niyal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginTest {
    @Test
    public void testLogin() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/auth/login.php");
            Thread.sleep(2000);
            
            driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
            driver.findElement(By.name("password")).sendKeys("password123");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            
            // Wait 5 seconds for the page to load
            Thread.sleep(5000); 
            
            // Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("1_Login_Screenshot.png"));
            System.out.println("Login Screenshot Saved successfully!");
            
            // Keep the browser open for 10 more seconds so you can see it
            System.out.println("Waiting 10 seconds before closing browser...");
            Thread.sleep(10000); 
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}