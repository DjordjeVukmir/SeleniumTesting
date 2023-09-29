package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestLoginValidUsernameEmptyPassword {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://practicetestautomation.com");
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();
        String usernameCurrent = "student";
        String username = usernameCurrent;
        String password = "";

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();

        Thread.sleep(2000);

        WebElement error = driver.findElement(By.id("error"));

        Assert.assertTrue(error.isDisplayed());

        String errorText = error.getText();

        Assert.assertEquals(errorText, "Your password is invalid!");
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(currentURL, expectedURL);
        driver.quit();
    }
    }

