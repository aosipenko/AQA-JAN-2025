package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AlloUAPhonesPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        public AlloUAPhonesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "products-layout__item")
    private List<WebElement> phones;

    @FindBy(id = "search-form__input")
    private WebElement searchField;

    @FindBy(css = ".search-form__form .search-form__submit-button")
    private WebElement searchButton;

    @FindBy(css = ".search-form__form .search-form__clear-button")
    private WebElement clearButton;

    @FindBy(className = "product-card__title")
    private List<WebElement> nameOfPhones;

    @FindBy(css = ".v-pb__cur")
    private List<WebElement> priceOfPhones;


    public Phone getPhone(String phone) {
        Random random = new Random();
        int randomNumber = random.nextInt(29);
        Assert.assertTrue(searchField.isDisplayed());
        searchField.sendKeys(phone);
        searchButton.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("products-layout__item")));
        Assert.assertFalse(nameOfPhones.isEmpty());
        Assert.assertFalse(priceOfPhones.isEmpty());
        String nameOfPhone = nameOfPhones.get(randomNumber).getText();
        String priceOfPhoneString = priceOfPhones.get(randomNumber).getText();
        String priceWithoutCurrency = priceOfPhoneString.substring(0, priceOfPhoneString.length() - 2);
        String priceWithoutEmptySpace = priceWithoutCurrency.replace(" ", "");
        int priceOfPhone = Integer.parseInt(priceWithoutEmptySpace);
        Phone foundPhone = new Phone(nameOfPhone, priceOfPhone);
        return foundPhone;
    }

}
