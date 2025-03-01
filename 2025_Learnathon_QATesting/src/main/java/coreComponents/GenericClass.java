package coreComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericClass {


    public void clickElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            clickableElement.click();
            ExtentManager.logPass("Clicked on element: " + element.toString());
        } catch (Exception e) {
            ExtentManager.logFail("Failed to click on element: " + element.toString() + " - " + e.getMessage());
        }
    }

    public void enterText(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            visibleElement.clear();
            visibleElement.sendKeys(text);
            ExtentManager.logPass("Entered text '" + text + "' into element: " + element.toString());
        } catch (Exception e) {
            ExtentManager.logFail("Failed to enter text '" + text + "' into element: " + element.toString() + " - " + e.getMessage());
        }
    }

    public WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ExtentManager.logPass("Element is visible: " + locator.toString());
            return visibleElement;
        } catch (Exception e) {
            ExtentManager.logFail("Element is not visible: " + locator.toString() + " - " + e.getMessage());
            return null;
        }
    }
}
