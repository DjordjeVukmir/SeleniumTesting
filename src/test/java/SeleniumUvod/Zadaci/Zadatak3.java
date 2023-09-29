package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {

    public static void main(String[] args) {

        ////Zadatak 2
        ////Otvoriti browser i jos 5 tabova
        ////Na svakom tabu otvoriti URL po zelji
        ////Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.navigate().to("https://www.google.com");
        for (int i = 0; i < 5; i++){
            js.executeScript("window.open()");
        }
        ArrayList<String> lista = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(lista.get(1));
        driver.navigate().to("https://www.linkedin.com");
        driver.switchTo().window(lista.get(2));
        driver.navigate().to("https://www.youtube.com");
        driver.switchTo().window(lista.get(3));
        driver.navigate().to("https://www.joberty.com");
        driver.switchTo().window(lista.get(4));
        driver.navigate().to("https://www.google.com");
        driver.switchTo().window(lista.get(5));
        driver.navigate().to("https://www.youtube.com");

        driver.switchTo().window(lista.get(1));
        driver.close();
        driver.switchTo().window(lista.get(2));
        driver.close();
        driver.switchTo().window(lista.get(3));
        driver.close();
        driver.switchTo().window(lista.get(4));
        driver.close();
        driver.switchTo().window(lista.get(5));
        driver.close();


        driver.quit();



    }
}
