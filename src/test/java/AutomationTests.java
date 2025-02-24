import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AutomationTests {
    //WebDriver driver;
    RemoteWebDriver remoteWebDriver;

    @Test
    public void testForAllo() {
        //driver = new ChromeDriver();
        remoteWebDriver = new ChromeDriver();
        remoteWebDriver.manage().window().maximize();
        remoteWebDriver.get("https://allo.ua/");
        List<WebElement> logos = remoteWebDriver.findElements(By.className("v-logo__img"));
        Assert.assertFalse(logos.isEmpty());
        remoteWebDriver.quit();
    }
}
