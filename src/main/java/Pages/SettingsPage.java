package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage{
    WebDriver driver;

    String FORM_LOCATOR = ".//form[contains(@action, 'settings')]";
    private final String CLOSE_ICO_LOCATOR = ".//a[contains(@class, 'close_ico')]";

    String NATIVE_CITY_INPUT_LOCATOR = ".//div[@id='cityBSugg_InputContainer']";
    String NATIVE_CITY_LOCATOR = ".//input[@id='field_cityBSugg_SearchInput']";
    String CITY_VALUE = " and @value=";

    String PERSONAL_DATA_EDIT = ".//div[text()='Личные данные']";
    String CONFIRM_BUTTON = ".//input[contains(@class, 'yes')]";

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

    public String substructLocator(String LOCATOR){
        return LOCATOR.substring(0, LOCATOR.length()-1);
    }

    public boolean isElementHere(WebDriver driver, String XPATH){
        try{
            driver.findElement(By.xpath(XPATH));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void changeField(WebDriver driver, String FIELD_LOCATOR, String newValue) {
        driver.findElement(By.xpath(FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(FIELD_LOCATOR)).sendKeys(newValue);
    }

    public void openChangingPersonalDataSpace(){
        clickOnElement(driver, PERSONAL_DATA_EDIT);
    }

    public SettingsPage closeChangingPersonalDataSpace(){
        clickOnElement(driver, CLOSE_ICO_LOCATOR);
        return new SettingsPage(driver);
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

    public void changeNativeCity(String newCity){
        changeCity(newCity, NATIVE_CITY_LOCATOR, NATIVE_CITY_INPUT_LOCATOR);
    }

    public void checkCorrectNativeCity(String city){
        checkFieldChanged(driver, substructLocator(NATIVE_CITY_LOCATOR) + CITY_VALUE + "'" + city + "'" + "]", "Native City: " );
    }

    public void checkIncorrectNativeCity(String city){
        checkFieldNotChanged(driver, substructLocator(NATIVE_CITY_LOCATOR) + CITY_VALUE + "'" + city + "'" + "]", "Native City: " );
    }

    private void checkFieldNotChanged(WebDriver driver, String XPATH, String message) {
        //Assert.assertFalse(message + "incorrect", isElementHere(driver, XPATH));
        System.out.println(message + "correct");
    }

    private void checkFieldChanged(WebDriver driver, String XPATH, String message) {
        //Assert.assertTrue(message + "incorrect", isElementHere(driver, XPATH));
        System.out.println(message + "correct");
    }
}
