package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak5 {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");

        WebElement googleSearch = driver.findElement(By.id("APjFqb"));
        googleSearch.sendKeys("Nikola Tesla");
        googleSearch.sendKeys(ENTER);
        Thread.sleep(1000);
        WebElement wikiLinkToTesla = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikiLinkToTesla.click();

        String expectedUrl = "https://sr.wikipedia.org/sr-ec/%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0_%D0%A2%D0%B5%D1%81%D0%BB%D0%B0";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedUrl);

        WebElement wikiTeslaHousePicture = driver.findElement(By.className("mw-file-element"));
        Assert.assertTrue(wikiTeslaHousePicture.isDisplayed());


        WebElement teslaPersonalInfo = driver.findElement(By.cssSelector(".infobox-header.navbox-title"));
        Assert.assertTrue(teslaPersonalInfo.getText().equals("Лични подаци"));


        WebElement teslinaSlika = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(teslinaSlika.isDisplayed());



        driver.quit();

    }
}
