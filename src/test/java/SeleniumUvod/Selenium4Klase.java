package SeleniumUvod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium4Klase {
    WebDriver driver;

    @BeforeMethod
    public void goToWebsite(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/");

    }

    @Test
    public void getElements(){
        List<WebElement> cards = driver.findElements(By.className("card-body"));
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getText().equals("Elements")){
                cards.get(i).click();
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/elements");

    }


}
