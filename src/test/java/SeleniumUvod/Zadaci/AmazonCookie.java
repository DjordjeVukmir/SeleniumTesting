package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AmazonCookie {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        WebElement checkout = driver.findElement(By.className("a-button-input"));
        addToCart.click();
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement emptyCart = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));



        String expectedUrl = "https://www.amazon.com/cart/ref=sw_rv_inscr?app-nav-type=none&dc=df";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(emptyCart.getText(),
                "Your Amazon Cart is empty");

        WebElement cart = driver.findElement(By.id("nav-cart-count-container"));
        cart.click();
        Thread.sleep(3000);
        String newEmptyCartUrl = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";

        Assert.assertEquals(driver.getCurrentUrl(), newEmptyCartUrl);
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        String i = "0";

        Assert.assertEquals(i, cartCount.getText());

    }
}
