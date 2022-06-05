package Pages;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class MenuWindow extends BasePage{
    private final String xPathToDropDown = "//*[@data-l = 't,toggler']";
    public MenuWindow(WebDriver driver)
    {
        super(driver);
    }

    public MenuWindow dropDownMenu()
    {
        clickOnElement(xPathToDropDown);
        return this;
    }

    boolean isAppear(List<String> list)
    {
        boolean isHere = false;
        for (String s : list) {
            isHere = isElementHere(s);
            if (!isHere) {
                return false;
            }
        }
        return isHere;
    }
}
