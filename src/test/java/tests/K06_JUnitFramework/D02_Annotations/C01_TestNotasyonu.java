package tests.K06_JUnitFramework.D02_Annotations;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    public void testotomasyonuTesti() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        } else System.out.println("Testotomasyonu testi FAILED");

        Thread.sleep(1000);
        driver.quit();

    }


    @Test @Order(2)
    void junitTesti() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://junit.org/junit5/");

        String expectedUrl = "https://junit.org/junit5/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Junit testi PASSED");
        } else System.out.println("Junit testi FAILED");

        Thread.sleep(1000);
        driver.quit();

    }


    @Test  @Order(5)    //@Disabled   gecici sureligine calistirilmasini istemedigimiz method'lar icin kullanilabilir
    public void wisequarterTesti() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("wisequarter testi PASSED");
        } else System.out.println("wisequarter testi FAILED");

        Thread.sleep(1000);
        driver.quit();

    }








}
