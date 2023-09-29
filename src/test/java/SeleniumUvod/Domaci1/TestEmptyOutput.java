package SeleniumUvod.Domaci1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestEmptyOutput {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/text-box");
        WebElement outputTab = driver.findElement(By.id("output"));

        Assert.assertFalse(outputTab.isDisplayed());
        driver.quit();
    }
}
