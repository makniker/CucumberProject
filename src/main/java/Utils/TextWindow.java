package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextWindow
{
    private final WebDriver driver_;
    public TextWindow(WebDriver driver)
    {
        driver_ = driver;
    }
    public TextWindow insertText(String text)
    {
        String xPathToWindow = "//*[@data-module = 'postingForm/mediaText']";
        WebElement loginField = driver_.findElement(By.xpath(xPathToWindow));
        loginField.sendKeys(text);
        return this;
    }

    public String getText()
    {
        String xPathToText = "//*[@class = 'media-text_a']";
        String text = driver_.findElement(By.xpath(xPathToText)).getText();
        return text;
    }

    public TextWindow post()
    {
        String xPathToButton = "//*[@class = 'posting_submit button-pro']";
        driver_.findElement(By.xpath(xPathToButton)).click();
        return this;
    }
}
