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

public class CommentTest {
    @Test
    public void testAddComment() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/auth/login.php");
            Thread.sleep(2000);
            driver.findElement(By.name("email")).sendKeys("user@gmail.com");
            driver.findElement(By.name("password")).sendKeys("password123");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            Thread.sleep(3000);

            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/posts/details.php?id=1");
            Thread.sleep(3000);

            try {
                driver.findElement(By.name("comment")).sendKeys("This is an automated test comment.");
                driver.findElement(By.cssSelector("form button[type='submit']")).click();
            } catch(Exception e) {
                System.out.println("Comment box not found. Check HTML.");
            }
            
            Thread.sleep(3000); 
            
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("9_Comment_Screenshot.png"));
            System.out.println("Comment Screenshot Saved!");
            
            Thread.sleep(5000); 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}