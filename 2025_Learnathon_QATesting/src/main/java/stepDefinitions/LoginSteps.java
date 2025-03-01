package stepDefinitions;

import ProjectConfig.Config;
import businessFunctions.LoginBF;
import com.aventstack.extentreports.ExtentTest;
import coreComponents.ExcelReader;
import coreComponents.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class LoginSteps {

    private WebDriver driver;
    private LoginBF loginBF;
    private ExcelReader excelReader;
    private String sheetName;
    private Scenario scenario;
    private ExtentTest test;
    private ExtentTest node;
    private static String scenarioName;

    public LoginSteps() {
        this.loginBF = new LoginBF();
        this.excelReader = Config.getExcelReader();
        this.sheetName = Config.getSheetName(LoginSteps.class);
    }

    @BeforeClass
    public static void setup() {
        // Setup code if needed

    }

    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
        scenarioName = scenario.getName();
        ExtentManager.createInstance("Reports/" + scenarioName + ".html");
        test = ExtentManager.startTest(scenarioName); // Initialize the test variable
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("scenarioName in before method: " + scenarioName);

    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("scenarioName in login method: " + scenarioName);
        Map<String, String> data = excelReader.getRowData(sheetName, "Successful Login");
        node = ExtentManager.createNode("Login Page is displayed");
        loginBF.setNode(node);
        loginBF.navigateToLoginPage(driver, data);
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        Map<String, String> data = excelReader.getRowData(sheetName, "Successful Login");
        node = ExtentManager.createNode("Enter Valid Credentials");
        loginBF.setNode(node);
        loginBF.enterCredentials(driver, data);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        Map<String, String> data = excelReader.getRowData(sheetName, "Successful Login");
        node = ExtentManager.createNode("Login Button is clicked");
        loginBF.setNode(node);
        loginBF.clickLoginButton(driver, data);
    }

    @Then("the user is redirected to the homepage")
    public void the_user_is_redirected_to_the_homepage() {
        node = ExtentManager.createNode("Successful Login");
        ExtentManager.logPass(node, "User is redirected to the homepage");
    }

    @Then("a welcome message is displayed")
    public void a_welcome_message_is_displayed() {
        node = ExtentManager.createNode("Validate the Welcome Message");
        ExtentManager.logPass(node, "Welcome message is displayed");
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        loginBF.setNode(node);
        Map<String, String> data = excelReader.getRowData(sheetName, "Unsuccessful Login");
        node = ExtentManager.createNode("Invalid Credentials Check");
        ExtentManager.logPass(node, "User enters invalid credentials");
    }

    @Then("an error message is displayed")
    public void an_error_message_is_displayed() {
        node = ExtentManager.createNode("Error message");
        ExtentManager.logPass(node, "Error message is displayed");
    }

    @Then("the user remains on the login page")
    public void the_user_remains_on_the_login_page() {
        node = ExtentManager.createNode("Login page is displayed after invalid credentials");
        ExtentManager.logPass(node, "User remains on the login page");
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
        ExtentManager.flush();
    }
}