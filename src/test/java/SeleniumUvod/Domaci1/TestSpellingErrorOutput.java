package SeleniumUvod.Domaci1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestSpellingErrorOutput {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/text-box");
        WebElement outputTab = driver.findElement(By.id("output"));

        Assert.assertFalse(outputTab.isDisplayed());

        String expectedBadString = "Permanenat";
        String actualOutputText = outputTab.getText();

        Assert.assertTrue(actualOutputText.contains(expectedBadString), "The 'bad' string is not present.");
        driver.quit();
    }
}