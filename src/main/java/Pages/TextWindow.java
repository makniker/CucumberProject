package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextWindow extends BasePage
{
    String xPathToWindow = "//*[@data-module = 'postingForm/mediaText']";
    String xPathToText = "//*[@class = 'media-text_cnt']";
    String xPathToButton = "//*[@class = 'posting_submit button-pro']";

    public TextWindow(WebDriver driver)
    {
        super(driver);
    }

    public TextWindow insertText(String text)
    {
        Assertions.assertTrue(isElementHere(xPathToWindow));
        webDriver_.findElement(By.xpath(xPathToWindow)).sendKeys(text);
        return this;
    }

    public String getText()
    {
        Assertions.assertTrue(isElementHere(xPathToText));
        return webDriver_.findElement(By.xpath(xPathToText)).getText();
    }

    public TextWindow post()
    {
        clickOnElement(xPathToButton);
        return this;
    }
}
