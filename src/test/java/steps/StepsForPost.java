package steps;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.TextWindow;
import Utils.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepsForPost extends TestBase{
    MainPage mainPage;
    User testUser;
    String textForPost;
    TextWindow textWindow;

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

    @When("I post {string} on main page")
    public void iPostOnMainPage(String text) {
        textWindow = new TextWindow(driver);
        mainPage.addTextWindow(textWindow)
                .postSomething(text);
        textForPost = text;
    }

    @Then("It should appear on it")
    public void itShouldAppearOnIt() {
        Assertions.assertEquals(textForPost, textWindow.getText());
    }
}
