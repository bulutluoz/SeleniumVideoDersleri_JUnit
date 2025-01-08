package tests.K06_JUnitFramework.D02_Annotations;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void teardown()  {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }


    @Test
    public void testotomasyonuTesti()  {
        setup();
        driver.get("https://www.testotomasyonu.com");

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        } else System.out.println("Testotomasyonu testi FAILED");
        teardown();
    }

    @Test
    void junitTesti() throws InterruptedException {
        setup();
        driver.get("https://junit.org/junit5/");

        String expectedUrl = "https://junit.org/junit5/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Junit testi PASSED");
        } else System.out.println("Junit testi FAILED");

        teardown();
    }

    @Test
    public void wisequarterTesti() throws InterruptedException {
        setup();

        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("wisequarter testi PASSED");
        } else System.out.println("wisequarter testi FAILED");

        teardown();
    }








}
