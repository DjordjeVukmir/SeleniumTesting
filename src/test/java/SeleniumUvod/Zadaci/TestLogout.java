


package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestLogout {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://practicetestautomation.com");
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameInput.sendKeys("student");
        passwordInput.sendKeys("Password123");
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
        Assert.assertTrue(logoutButton.isDisplayed());

        WebElement succLogin = driver.findElement(By.className("post-title"));
        String actualText = succLogin.getText();
        String succLoginText = "Logged In Successfully";
        Assert.assertEquals(actualText, succLoginText);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";

        Assert.assertEquals(actualURL, expectedURL);

        logoutButton.click();

        String currentURLlogout = driver.getCurrentUrl();
        String expectedURLlogout = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(currentURLlogout, expectedURLlogout);

        WebElement testLogin = driver.findElement(By.id("login"));
        Assert.assertTrue(testLogin.isDisplayed());
        driver.quit();
    }
}