package tests.K06_JUnitFramework.D03_Assertions;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_AssertionsClassWork {

    // https://www.bestbuy.com/ Adresine gidin
    // farkli test method’lari olusturarak asagidaki testleri yapin
    //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //	○ logoTest => BestBuy logosunun görüntülendigini test edin
    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void urlTest(){
        //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);

    }

    @Test
    public void titleTest(){
        //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unExpectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assertions.assertFalse( actualTitle.contains(unExpectedTitleIcerik));

    }
    @Test
    public void logoTest(){
        //	○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assertions.assertTrue(logoElementi.isDisplayed());

    }

    @Test
    public void linkTest(){
        //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisLinkElementi = driver.findElement(By.xpath("//*[.='Français']"));

        Assertions.assertTrue(francaisLinkElementi.isDisplayed());

    }

}
