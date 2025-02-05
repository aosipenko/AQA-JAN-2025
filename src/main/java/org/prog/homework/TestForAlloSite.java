package org.prog.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestForAlloSite {
    WebDriver driver = null;


    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
    }

    @Test
    public void testForSamsungPhones() {
        List<WebElement> listWithAlloLogo = driver.findElements(By.className("v-logo__img"));
        WebElement searchField = driver.findElement(By.id("search-form__input"));
        WebElement searchButton = driver.findElement(By.cssSelector(".search-form__form .search-form__submit-button"));
        String actualNameOfFirstPhone = "";
        String expectedNameOfFirstPhone = "Samsung Galaxy S25 Ultra 12/512GB Titanium Black (SM-S938BZKGEUC)";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        Assert.assertFalse(listWithAlloLogo.isEmpty());
        Assert.assertEquals(listWithAlloLogo.size(), 2);
        searchField.sendKeys("Samsung");
        searchButton.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.className("products-layout__item"))));
        List<WebElement> listWithPhones = driver.findElements(By.className("products-layout__item"));
        List<WebElement> listWithNameOfPhones = driver.findElements(By.className("product-card__title"));
        Assert.assertFalse(listWithPhones.isEmpty());
        actualNameOfFirstPhone = listWithNameOfPhones.get(0).getText();
        Assert.assertEquals(expectedNameOfFirstPhone, actualNameOfFirstPhone);
    }

    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.quit();
        }

    }
}
