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
    public WebDriver getRemoteDriver() throws MalformedURLException {
        return new RemoteWebDriver(
                new URL("http://selenoid-selenoid-1:4444/wd/hub"), new ChromeOptions());
    }

    @Test
    public void testForAllo() throws MalformedURLException {
        getRemoteDriver().manage().window().maximize();
        getRemoteDriver().get("https://allo.ua/");
        List<WebElement> logos = getRemoteDriver().findElements(By.className("v-logo__img"));
        Assert.assertFalse(logos.isEmpty());
        getRemoteDriver().quit();
    }

}
