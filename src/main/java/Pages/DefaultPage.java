package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefaultPage {

    private By userFullName = By.xpath("//*[contains(@class,\"tico ellip\")]");
    WebDriver driver = new ChromeDriver();

    public void clickOnElement(WebDriver driver, String XPATH){
        int attempt = 0;

        while(attempt < 2) {
            try {
                driver.findElement(By.xpath(XPATH)).click();
                break;
            } catch(Exception e) {
            }
            attempt++;
        }
    }

    public void changeField(WebDriver driver, String FIELD_LOCATOR, String newValue) {
        driver.findElement(By.xpath(FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(FIELD_LOCATOR)).sendKeys(newValue);
    }

    public boolean isElementHere(WebDriver driver, String XPATH){
        try{
            driver.findElement(By.xpath(XPATH));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getName(){

        boolean visible = driver.findElement(userFullName).isDisplayed();
        boolean enabled = driver.findElement(userFullName).isEnabled();

        if(visible==true && enabled==true) {
            return driver.findElement(userFullName).getText();
        }

        return "User name is not visible";
    }

    public abstract class BasePage {
        public abstract void isLoaded();
    }
}