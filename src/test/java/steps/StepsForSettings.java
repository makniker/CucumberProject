package steps;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.SettingsPage;
import Utils.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepsForSettings extends TestBase {
    SettingsPage settingsPage;
    MainPage mainPage;
    User User;

    @Before
    public void initialisation(){ start(); }

    @After
    public void teardown(){
        finish();
    }

    @Given("I log in and go to settings page by {string} with {string} and {string}")
    public void iOpenSettingsPage(String name, String login, String password) {
        User = new Utils.User(name, login, password);
        mainPage = new Pages.LoginPage(driver).logIn(User);
        settingsPage.openChangingPersonalDataSpace();
    }

    @When("I write native city {string}")
    public void iChangeCity(String city) {
        settingsPage.changeNativeCity(city);
        settingsPage.saveChanges();
    }

    @Then("I have successfully changed info about living place")
    public void iHaveBeenSuccessfullyCangedInfo(String city, boolean check) {
        //if(!check) settingsPage.closeChangingPersonalDataSpace();
        //settingsPage.openChangingPersonalDataSpace();
        //if(check) settingsPage.checkCorrectNativeCity(city);
        //else settingsPage.checkIncorrectNativeCity(city);
    }
}
