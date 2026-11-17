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

public class RegistrationTest {
    @Test
    public void testRegistration() {
        WebDriver driver = new ChromeDriver();
        try {
            // Open the registration page
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/auth/register.php");
            Thread.sleep(2000);

            // Fill in the name
            driver.findElement(By.name("name")).sendKeys("Test User");
            
            // Generate a unique email to avoid duplicate entry errors
            String uniqueEmail = "testuser" + System.currentTimeMillis() + "@gmail.com";
            driver.findElement(By.name("email")).sendKeys(uniqueEmail);
            
            // Fill in the password
            driver.findElement(By.name("password")).sendKeys("password123");
            
            // Try to fill confirm password if it exists
            try {
                driver.findElement(By.name("confirm_password")).sendKeys("password123");
            } catch (Exception e) {
                System.out.println("Confirm password field not found, skipping.");
            }
            
            // Click the Register button
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            
            // Wait for the process to complete
            Thread.sleep(14000); 
            
            // Take a screenshot and save it
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("2_Registration_Screenshot.png"));
            System.out.println("Registration Screenshot Saved successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}