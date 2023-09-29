package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();//setujemo chrome driver

        WebDriver driver = new ChromeDriver();//Kreiramo objekat od chrome drivera
        driver.manage().window().maximize();
        //driver.get("https://www.google.com");//Dajemo komandu driveru na koji link da ode
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://www.youtube.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.quit();
        /*

       Ranije da bi smo setovali driver:

       System.setProperty("webdriver.chrome.driver", "...path");






         */
    }
}
