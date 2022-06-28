package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver webDriver_;
    public BasePage(WebDriver webDriver)
    {
        webDriver_ = webDriver;
    }

    public void clickOnElement(String XPATH){
        Assertions.assertTrue(isElementHere(XPATH));
        webDriver_.findElement(By.xpath(XPATH)).click();
    }

    public boolean isElementHere(String XPATH){
        try{
            webDriver_.findElement(By.xpath(XPATH));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
