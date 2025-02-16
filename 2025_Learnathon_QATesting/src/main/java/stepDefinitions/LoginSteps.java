package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String title = driver.getTitle();

        if(title.equals("OrangeHRM")){
            System.out.println("User is on the OrangeHRM login page");
        } else {
            System.out.println("User is not on the OrangeHRM login page");
        }
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User enters valid credentials");
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User clicks the login button");
    }

    @Then("the user is redirected to the homepage")
    public void the_user_is_redirected_to_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is redirected to the homepage");
    }

    @Then("a welcome message is displayed")
    public void a_welcome_message_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Welcome message is displayed");
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User enters invalid credentials");
    }

    @Then("an error message is displayed")
    public void an_error_message_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Error message is displayed");
    }

    @Then("the user remains on the login page")
    public void the_user_remains_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Error message is displayed");
    }


}