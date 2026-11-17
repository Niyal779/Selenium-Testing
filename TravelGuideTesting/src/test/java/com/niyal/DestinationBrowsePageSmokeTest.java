package com.niyal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DestinationBrowsePageSmokeTest {
    @Test
    public void testBrowsePage() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://localhost/Travel-Guide%20-%20Copy/view/posts/browse.php");

            assertTrue(driver.getTitle().contains("Explore destinations"));
            assertTrue(driver.findElement(By.id("searchBox")).isDisplayed());
        } finally {
            driver.quit();
        }
    }
}
