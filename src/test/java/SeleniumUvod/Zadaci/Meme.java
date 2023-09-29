package SeleniumUvod.Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Meme {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String imageLocation = "C:\\Users\\Djole\\Desktop\\mim123.jpg";
        driver.navigate().to("https://imgflip.com/memegenerator");
        Thread.sleep(10000);
        WebElement searchMeme = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/input"));
        searchMeme.sendKeys("Anakin");
        Thread.sleep(2000);
        WebElement anakinPadme = driver.findElement(By.className("mm-search-result-img-td"));
        anakinPadme.click();

        WebElement text1 = driver.findElement(By.className("mm-text"));
        text1.sendKeys("Sad radite sami zadatak");
        WebElement text2 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[6]/div[2]/div[1]/textarea"));
        text2.sendKeys("Okacitete nam klasu na slack, je l' da?");
        WebElement text3 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[6]/div[3]/div[1]/textarea"));
        text3.sendKeys("Je l' da?");

        WebElement generateButton = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateButton.click();

        WebElement doneImage = driver.findElement(By.id("done-img"));












    }
}
