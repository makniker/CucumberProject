package steps;

import Pages.MainPage;
import Pages.MenuWindow;
import Utils.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StepsForMenu extends TestBase{
    MainPage mainPage;
    User testUser;

    @Before
    public void initialisation(){
        start();
    }

    @After
    public void teardown(){
        finish();
    }

    @Given("I log in and stay on main page as {string} with {string} and {string}")
    public void iLogInAndStayOnMainPage(String name, String login, String password) {
        testUser = new Utils.User(name, login, password);
        mainPage = new Pages.LoginPage(driver).logIn(testUser);
    }

    @When("I click on drop-down menu")
    public void iClickOnDropMenu() {
        mainPage.addMenuWindow(new MenuWindow(driver).dropDownMenu());
    }

    @Then("^should appear$")
    public void itShouldAppearOnIt(List<String> arg) {
        Assertions.assertTrue(mainPage.checkMenu(arg));
    }
}
