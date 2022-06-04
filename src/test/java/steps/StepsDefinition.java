package steps;

import Pages.LoginPage;
import Pages.MainPage;
import Utils.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepsDefinition extends TestBase {
    LoginPage loginPage;
    User testUser;
    MainPage mainPage;

    @Before
    public void initialisation(){
        start();
    }

    @After
    public void teardown(Scenario scenario){
        finish();
    }
    
    @Given("I go to login page")
    public void iGoToLoginPage() {
        driver.get("https://ok.ru");
        loginPage = new Pages.LoginPage(driver);
    }

    @When("I login as {string} with password {string}")
    public void iLoginAsWithPassword(String name, String password) {
        testUser = new Utils.User("Никита Ермаков", name, password);
        mainPage = loginPage.logIn(testUser);
    }

    @Then("I have been successfully logged")
    public void iHaveBeenSuccessfullyLogged() {
        Assertions.assertEquals(mainPage.getName(), testUser.getName());
    }
}
