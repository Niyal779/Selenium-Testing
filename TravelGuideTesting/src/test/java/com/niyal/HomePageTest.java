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

public class HomePageTest {
    @Test
    public void testHomePageAndLogin() {
        WebDriver driver = new ChromeDriver();
        try {
            // 1. Open the login page
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/auth/login.php");
            Thread.sleep(2000);
            
            // 2. Fill in the credentials
            driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
            driver.findElement(By.name("password")).sendKeys("password123");
            
            // 3. Click login button
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            
            // 4. Wait for the page to load after login
            Thread.sleep(4000); 
            
            // 5. Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("HomePage_Login_Screenshot.png"));
            System.out.println("Home Page Screenshot Saved successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}