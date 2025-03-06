import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AutomationTests {
    WebDriver driver;

//    public WebDriver getRemoteDriver() throws MalformedURLException {
//        return new RemoteWebDriver(
//                new URL("http://selenoid-selenoid-1:4444/wd/hub"), new ChromeOptions());
//    }

    public WebDriver getRemoteDriver() throws MalformedURLException {
        return new RemoteWebDriver(
                new URL("http://localhost:8080/"), new ChromeOptions());
    }

    @Test
    public void testAllo() throws MalformedURLException {
        driver = getRemoteDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        List<WebElement> logos = driver.findElements(By.className("v-logo__img"));
        Assert.assertFalse(logos.isEmpty());
        driver.quit();
    }

}
