package org.prog.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

//TODO: create separate test-ng.xml file with this class only
//TODO: move your selenium test to this class
//TODO: Add assertion that goods name is not null
//TODO: Add assertion that goods name has > 0 length

public class AlloUaNGTest {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }


    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

@Test
    public void AlloUaNGTest(){
        driver.get("https://allo.ua");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120L));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
        searchBox.sendKeys("Samsung");
        searchBox.submit();

//        Thread.sleep(2000);
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Samsung Galaxy S24FE 8/256 GRAPHITE(SM-S721BZKGEUC)']")
        ));
        firstProduct.click();

        WebElement productTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@itemprop='name' and contains(@class, 'p-view__header-title')]")));
         Assert.assertNotNull(productTitle.getText(), "name is not null");
         Assert.assertTrue(productTitle.getText().length() > 0, "name has > 0 length");
        System.out.println("Знайдено телефон: " + productTitle.getText());

    }
}


//    @BeforeClass
//    public void beforeAllo() {
//        System.out.println(">>>>>>>>>>ALLO.START");
//    }
//
//    @AfterClass
//    public void afterAllo() {
//        System.out.println(">>>>>>>>>>ALLO.END");
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("Test!<<<<<<<<<<<<<<<<<<<<");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("Test!<<<<<<<<<<<<<<<<<<<<");
//    }

//    @Test
//    public void ngTest1() {
//        System.out.println("Hello Allo UA Test! 5");
//    }
//
//    @Test
//    public void ngTest2() {
//        System.out.println("Hello Allo UA Test 1!");
//    }
//
//    @Test
//    public void ngTest3() {
//        System.out.println("Hello Allo UA Test 2!");
//    }
//
//    @Test
//    public void ngTest4() {
//        System.out.println("Hello Allo UA Test 3!");
//    }
//
//    @Test
//    public void ngTest5() {
//        System.out.println("Hello Allo UA Test! 4");
//    }
//}
