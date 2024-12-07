package tests.K06_JUnitFramework.D01_JUnitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_CokluTest {

    // 3 farkli method olusturun
    // 1.method testotomasyonu anasayfaya gidin
    //          title'in Test Otomasyonu icerdigini test edin
    // 2.method wisequarter anasayfaya gidin
    //          url'in wisequarter icerdigini test edin
    // 3.method junit.org adresine gidin
    //          url'in "https://junit.org/junit5/" oldugunu test edin

    public static void main(String[] args)  {
        testOtomasyonuTest();
        wisequarterTesti();
        junitTesti();
    }


    public static void testOtomasyonuTest()  {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 1.method testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //          title'in Test Otomasyonu icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();

    }

    public static void wisequarterTesti(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 2.method wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //          url'in wisequarter icerdigini test edin

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else  System.out.println("Wisequarter testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();

    }

    public static void junitTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 3.method junit.org adresine gidin
        driver.get("https://www.junit.org");

        //          url'in "https://junit.org/junit5/" oldugunu test edin

        String expectedUrl = "https://junit.org/junit5/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Junit testi PASSED");
        }else System.out.println("Junit testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();
    }

}
