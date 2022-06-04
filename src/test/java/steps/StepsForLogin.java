package steps;

import Pages.LoginPage;
import Pages.MainPage;
import Utils.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepsForLogin extends TestBase {
    LoginPage loginPage;
    User testUser;
    MainPage mainPage;

    @Before
    public void initialisation(){
        start();
    }

    @After
    public void teardown(){
        finish();
    }
    
    @Given("I Open login page")
    public void iOpenLoginPage() {
        loginPage = new Pages.LoginPage(driver);
    }

    @When("I login as {string} with {string} and {string}")
    public void iLoginAsNameWithLoginAndPassword(String name, String login, String password) {
        testUser = new Utils.User(name, login, password);
        mainPage = loginPage.logIn(testUser);
    }

    @Then("I have been successfully logged")
    public void iHaveBeenSuccessfullyLogged() {
        Assertions.assertEquals(mainPage.getName(), testUser.getName());
    }

}
