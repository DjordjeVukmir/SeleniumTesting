package SeleniumUvod.Domaci1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DomaciTextBoxTest {

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

        fullNameField.sendKeys("Djordje Vukmir");
        emailField.sendKeys("djordjevukmirqa@gmail.com");
        currentAdressField.sendKeys("Ulica Ulicic br 5");
        permAdressField.sendKeys("Permanentno 50/B");
        submitButton.click();

        Thread.sleep(3000);
        String expectedOutput = "Name:Djordje Vukmir\n" +
                "Email:djordjevukmirqa@gmail.com\n" +
                "Current Address :Ulica Ulicic br 5\n" +
                "Permananet Address :Permanentno 50/B";

        Assert.assertTrue(outputTab.isDisplayed());
        Assert.assertEquals(expectedOutput, outputTab.getText());
        driver.quit();



    }
}
