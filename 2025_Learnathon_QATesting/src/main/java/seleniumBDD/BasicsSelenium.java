package seleniumBDD;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class BasicsSelenium {

    WebDriver driver;

    @Test
    public void LaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Browser launched successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/links");
        System.out.println("Executing getLinks method");
        if (driver == null) {
            System.out.println("Driver is not initialized");
            return;
        }
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links present on the Webpage: " + links.size());
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

    @Test
    public void getLinks() {
        driver.get("https://demoqa.com/links");
        System.out.println("Executing getLinks method");
        if (driver == null) {
            System.out.println("Driver is not initialized");
            return;
        }
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links present on the Webpage: " + links.size());
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }


    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully");
        }
    }

    public static void interviewPreparation()
    {
        WebDriver driver = new ChromeDriver();
        WebElement element = driver.findElement(By.xpath("//input[text()='Colony State']"));
        boolean isDisplayed= element.isDisplayed();
        if(isDisplayed)
        {
            System.out.println("Element is displayed");
        }
        else
        {
            System.out.println("Element is not displayed");
        }

    }

}