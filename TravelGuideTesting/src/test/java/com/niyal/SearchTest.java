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

public class SearchTest {
    @Test
    public void testSearchDestination() {
        WebDriver driver = new ChromeDriver();
        try {
            // 1. Open the Browse Page
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/posts/browse.php");
            Thread.sleep(3000);
            
            // 2. Type "Coxs Bazar" in the search box
            driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Coxs Bazar");
            Thread.sleep(2000);
            
            // 3. Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("6_Search_Screenshot.png"));
            System.out.println("Search Screenshot Saved successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}