package SeleniumUvod.Domaci1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestSymbolsBeforeText {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/text-box");
        Thread.sleep(2000);
        WebElement fullNameField = driver.findElement(By.id("userName"));
        WebElement emailField = driver.findElement(By.id("userEmail"));
        WebElement currentAdressField = driver.findElement(By.id("currentAddress"));
        WebElement permAdressField = driver.findElement(By.id("permanentAddress"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        WebElement outputTab = driver.findElement(By.id("output"));

        String expectedUrl = "https://demoqa.com/text-box";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        String symbols = "!@*#(!@*#(!@*#()!@#)...///";
        fullNameField.sendKeys(symbols + "Djordje Vukmir");
        emailField.sendKeys(symbols + "djordjevukmirqa@gmail.com");
        currentAdressField.sendKeys(symbols + "Ulica Ulicic br 5");
        permAdressField.sendKeys(symbols + "Permanentno 50/B");
        submitButton.click();

        Thread.sleep(3000);
        Assert.assertFalse(outputTab.isDisplayed());



        driver.quit();



    }
}
