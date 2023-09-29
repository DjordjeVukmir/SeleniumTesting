package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WordPressLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://wordpress.com");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.cssSelector("#wpcom-home > nav > ul:nth-child(2) > li:nth-child(1) > a"));
        loginButton.click();

        WebElement usernameOrEmailField = driver.findElement(By.id("usernameOrEmail"));
        usernameOrEmailField.sendKeys("lanicor91chef@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("nerapas123qa");
        Thread.sleep(2000);
        WebElement submitLogin = driver.findElement(By.cssSelector(".button.form-button.is-primary"));

        submitLogin.click();
        String expectedUrl = "https://wordpress.com/read";
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/read"));

        WebElement writeButton = driver.findElement(By.className("masterbar__item-content"));
        WebElement userTabAvatar = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertTrue(userTabAvatar.isDisplayed());
        Assert.assertTrue(writeButton.isDisplayed());






        //driver.quit();

    }
}
