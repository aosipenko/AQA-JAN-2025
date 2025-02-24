package pages;

import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageObject {
    public BasePage() {
        PageFactory.initElements(this.driver, this);
    }

    public void openMainPage() {
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
    }

    public void closeBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }

}
