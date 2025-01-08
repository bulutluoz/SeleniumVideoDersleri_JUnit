package tests.K06_JUnitFramework.D02_Annotations;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class C01_TestNotasyonu {
    /*
        @Test notasyonu siradan bir method'u
        tek basina Run edilebilir hale getirir

        @Test notasyonu sayesinde
        her bir testi bagimsiz olarak calistirabilecegimiz gibi
        class isminin yanindaki run tusu ile
        class'daki TUM test method'larini toplu olarak da calistirabiliriz
    */
    /*
        JUnit @Test method'larin calisma sirasini
        kendine gore duzenler
        belirlenmis bir siralama duzeni yoktur
        siralamayi ongoremeyiz ve kontrol edemeyiz

        eger sirali calismasini istediginiz
        test method'lari olursa
        @TestMethodOrder kullanmamiz gerekir
     */

    @Test @Order(10)
    public void testOtomasyonuTest()  {

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

    @Test @Order(2)
    public void wisequarterTesti(){
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

    @Test @Order(3)
    public void junitTesti(){

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
