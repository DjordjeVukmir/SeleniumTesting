package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak4 {

    public static void main(String[] args) {
        ////Zadatak 3
        ////Otici na Google
        ////Zatim ukucati "Wikipedia" u polje za pretragu
        ////Odraditi pretragu i otvoriti stranicu
        ////Na stranici Wikipedia pretraziti "Nikola Tesla"


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");

        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(ENTER);
        driver.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input")).sendKeys("Nikola Tesla");
        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input")).sendKeys(ENTER);



        driver.quit();


    }
}
