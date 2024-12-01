package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(1000);

        driver.navigate().to("https://www.wisequarter.com");
        // driver.get() ile ayni isleve sahiptir

        Thread.sleep(1000);

        // geriye testotomasyonu sayfasina donun
        driver.navigate().back();

        Thread.sleep(1000);

        // yeniden wisequarter sayfasina gidin
        driver.navigate().forward();

        Thread.sleep(1000);
        driver.quit();

    }

}
