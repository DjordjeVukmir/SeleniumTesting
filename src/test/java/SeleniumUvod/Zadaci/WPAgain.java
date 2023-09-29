package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WPAgain {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in","djordjevukmir%7C1790531479%7C799lILyXHEaeQN2CARVCZHqCaF9TxidhsEZVEbJ1zcW%7C88937b9acab2b46ad80033c8624e2875346219fc3c117b50c4bd0c923a1b9de5" );


        driver.manage().addCookie(cookie);
        driver.navigate().refresh();


    }
}
