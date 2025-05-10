package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static final DriverManager INSTANCE = new DriverManager();
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public DriverManager createWebDriver() {
        driver.set(new ChromeDriver());
        return this;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public static DriverManager getInstance() {
        return INSTANCE;
    }

}
