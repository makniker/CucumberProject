package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage{

    WebDriver driver;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

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

    String FORM_LOCATOR = ".//form[contains(@action, 'settings')]";

    String CURRENT_CITY_LOCATOR = ".//input[@id='field_citySugg_SearchInput']";
    String CURRENT_CITY_INPUT_LOCATOR = ".//div[@id='citySugg_InputContainer']";

    String NATIVE_CITY_INPUT_LOCATOR = ".//div[@id='cityBSugg_InputContainer']";
    String NATIVE_CITY_LOCATOR = ".//input[@id='field_cityBSugg_SearchInput']";
    String CITY_VALUE = " and @value=";

    String PERSONAL_DATA_EDIT = ".//div[text()='Личные данные']";
    String CONFIRM_BUTTON = ".//input[contains(@class, 'yes')]";

    public void openChangingPersonalDataSpace(){
        clickOnElement(driver, PERSONAL_DATA_EDIT);
    }

    public SettingsPage saveChanges(){
        clickOnElement(driver, CONFIRM_BUTTON);
        return new SettingsPage(driver);
    }

    private void changeCity(String newCity, String CITY_LOCATOR, String CITY_INPUT_LOCATOR){
        changeField(driver, CITY_LOCATOR, newCity);
        driver.findElement(By.xpath(CITY_INPUT_LOCATOR)).click();
        driver.findElement(By.xpath(FORM_LOCATOR)).click();
    }

    public void changeCurrentCity(String newCity){
        changeCity(newCity, CURRENT_CITY_LOCATOR, CURRENT_CITY_INPUT_LOCATOR);
    }

    public void changeNativeCity(String newCity){
        changeCity(newCity, NATIVE_CITY_LOCATOR, NATIVE_CITY_INPUT_LOCATOR);
    }
}
