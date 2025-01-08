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

    public static void main(String[] args) throws InterruptedException {
        testotomasyonuTesti();
        wisequarterTesti();
        junitTesti();
    }


    public static void testotomasyonuTesti() throws InterruptedException {

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

    public static void wisequarterTesti() throws InterruptedException {

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

    public static void junitTesti() throws InterruptedException {

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
}
