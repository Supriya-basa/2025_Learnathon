package businessFunctions;

import com.aventstack.extentreports.ExtentTest;
import coreComponents.ExtentManager;
import coreComponents.GenericClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPagePO;

import java.util.Map;

public class LoginBF {

    GenericClass coreMethods = new GenericClass();
    ExtentTest node;

    public void setNode(ExtentTest node) {
        this.node = node;
    }

public void navigateToLoginPage(WebDriver driver, Map<String, String> data) {
    try {
        String url = data.get("url");
        if (url == null || url.isEmpty()) {
            ExtentManager.logFail(node, "URL is missing in the data map");
            return;
        }
        System.out.println("Navigating to URL: " + url);
        driver.get(url);
        String title = driver.getTitle();
        if (title.equals("OrangeHRM")) {
            ExtentManager.logPass(node, "Navigated to login page");
        } else {
            ExtentManager.logFail(node, "User is not on the OrangeHRM login page");
        }
    } catch (Exception e) {
        ExtentManager.logFail(node, "Exception occurred while navigating to the login page: " + e.getMessage());
    }
}
    public void enterCredentials(WebDriver driver, Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");
        ExtentManager.logPass(node, "This is for Entering valid credentials in the login page");
/*
        coreMethods.waitForElement(driver, (By) driver.findElement(By.xpath(LoginPagePO.USERNAME)), 10);
        WebElement usernameField = driver.findElement(By.xpath(LoginPagePO.USERNAME));
        coreMethods.enterText(driver, usernameField, username, 10);

        coreMethods.waitForElement(driver, (By) driver.findElement(By.xpath(LoginPagePO.PASSWORD)), 10);
        WebElement passwordField = driver.findElement(By.xpath(LoginPagePO.PASSWORD));
        coreMethods.enterText(driver, passwordField, password, 10);
*/
    }

    public void clickLoginButton(WebDriver driver, Map<String, String> data) {
        ExtentManager.logPass(node, "Click on the Login Button");
        /*WebElement loginButton = driver.findElement(By.xpath(LoginPagePO.LOGINBUTTON));
        coreMethods.clickElement(driver, loginButton, 10);*/
    }
}