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

public class LogoutTest {
    @Test
    public void testLogout() {
        WebDriver driver = new ChromeDriver();
        try {
            // 1. Login
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/auth/login.php");
            Thread.sleep(2000);
            driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
            driver.findElement(By.name("password")).sendKeys("password123");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            Thread.sleep(3000);

            // 2. Click Logout button/link
            try {
                driver.findElement(By.linkText("Logout")).click(); 
            } catch (Exception e) {
                System.out.println("Logout link not found. Check header HTML.");
            }
            
            Thread.sleep(3000); 
            
            // 3. Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("5_Logout_Screenshot.png"));
            System.out.println("Logout Screenshot Saved!");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}