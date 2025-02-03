package org.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TODO: go to allo.ua
//TODO: search for ANY PHONE
//TODO: print phone name for 1st phone in search
//TODO: For example: Apple iPhone 16 Pro Max 256GB Desert Titanium (MYWX3)

public class SeleniumHomeWork {

    public static void main(String[] args) {


// Запускаємо браузер
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Вимикає сповіщення
        options.addArguments("--disable-popup-blocking"); // Вимикає всі попапи

        WebDriver driver = new ChromeDriver(options);

        try {

            driver.get("https://allo.ua");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60L));
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
            searchBox.sendKeys("Samsung");
            searchBox.submit();

            Thread.sleep(2000);
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='product-card__title' and contains(@title, 'Samsung Galaxy S25 Ultra')]")
            ));
            firstProduct.click();

            WebElement productTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@itemprop='name' and contains(@class, 'p-view__header-title')]")));
            System.out.println("Знайдено телефон: " + productTitle.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}






