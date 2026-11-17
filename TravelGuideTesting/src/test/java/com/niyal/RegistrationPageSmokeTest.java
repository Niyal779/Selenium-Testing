package com.niyal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPageSmokeTest {
    @Test
    public void testRegistrationPage() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/auth/register.php");

            assertTrue(driver.getTitle().contains("Register"));
            assertTrue(driver.findElement(By.name("name")).isDisplayed());
            assertTrue(driver.findElement(By.name("email")).isDisplayed());
            assertTrue(driver.findElement(By.name("password")).isDisplayed());
            assertTrue(driver.findElement(By.name("confirm_password")).isDisplayed());
            assertTrue(driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed());
        } finally {
            driver.quit();
        }
    }
}
