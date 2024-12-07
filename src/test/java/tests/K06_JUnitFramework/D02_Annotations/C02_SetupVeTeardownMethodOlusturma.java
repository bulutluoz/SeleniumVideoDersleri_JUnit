package tests.K06_JUnitFramework.D02_Annotations;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_SetupVeTeardownMethodOlusturma {
    /*
        Java'da tekrar eden kodlari sevmeyiz

        Bir test method'u olusturuldugunda
        basta olusturmamiz gereken driver objesi
        ve sondaki kapatma islemi
        tum method'lar icin lazim

        her test method'unda bunlari tekrar tekrar olusturmak yerine
        method yapip methodCall ile kullanmayi tercih edebiliriz
     */

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void teardown(){
        driver.quit();
    }

    @Test
    public void testOtomasyonuTest()  {
        setup();
        // 1.method testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //          title'in Test Otomasyonu icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        ReusableMethods.bekle(1);
        teardown();
    }

    @Test
    public void wisequarterTesti(){
        setup();
        // 2.method wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //          url'in wisequarter icerdigini test edin

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else  System.out.println("Wisequarter testi FAILED");
        ReusableMethods.bekle(1);
        teardown();
    }

    @Test
    public void junitTesti(){
        setup();
        // 3.method junit.org adresine gidin
        driver.get("https://www.junit.org");

        //          url'in "https://junit.org/junit5/" oldugunu test edin

        String expectedUrl = "https://junit.org/junit5/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Junit testi PASSED");
        }else System.out.println("Junit testi FAILED");

        ReusableMethods.bekle(1);
        teardown();
    }






}
