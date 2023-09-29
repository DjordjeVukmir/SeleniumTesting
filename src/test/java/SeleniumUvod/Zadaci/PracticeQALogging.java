package SeleniumUvod.Zadaci;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeQALogging {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://practicetestautomation.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void verifyThatUserCanLogIn(){
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.clear();
        username.sendKeys("student");
        password.clear();
        password.sendKeys("Password123");
        password.click();
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));

        Assert.assertTrue(logoutButton.isDisplayed());


    }

    @Test
    public void verifyThatUserCannotLogIn(){
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.clear();
        username.sendKeys("student1");
        password.clear();
        password.sendKeys("Password124");
        password.click();
        submitButton.click();

        boolean logOut = false;
        try{
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();

        }
        catch (Exception e){
            System.out.println("Element not found.");
        }
        Assert.assertFalse(logOut);
    }
}
