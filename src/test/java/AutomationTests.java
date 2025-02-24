import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AutomationTests {
    WebDriver driver;

    @Test
    public void testForAllo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        List<WebElement> logos = driver.findElements(By.className("v-logo__img"));
        Assert.assertFalse(logos.isEmpty());
        driver.quit();
    }
}
