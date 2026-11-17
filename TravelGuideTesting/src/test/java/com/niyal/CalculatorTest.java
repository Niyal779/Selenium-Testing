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

public class CalculatorTest {
    @Test
    public void testCostCalculator() {
        WebDriver driver = new ChromeDriver();
        try {
            // Open a specific destination page (id=1)
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/posts/details.php?id=1");
            Thread.sleep(3000);

            // Fill the calculator inputs
            try {
                driver.findElement(By.name("travelers")).clear();
                driver.findElement(By.name("travelers")).sendKeys("2");
                
                driver.findElement(By.name("days")).clear();
                driver.findElement(By.name("days")).sendKeys("3");
                
                driver.findElement(By.cssSelector(".calculator-inputs button")).click();
                System.out.println("Clicked calculate button.");
            } catch (Exception e) {
                System.out.println("Calculator inputs not found. Check HTML names.");
            }

            Thread.sleep(3000);
            
            // Take screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("8_Calculator_Screenshot.png"));
            System.out.println("Calculator Screenshot Saved!");

            // Keep browser open for 10 seconds
            Thread.sleep(10000); 
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}