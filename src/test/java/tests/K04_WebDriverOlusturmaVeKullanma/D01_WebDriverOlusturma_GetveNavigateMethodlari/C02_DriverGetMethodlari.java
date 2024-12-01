package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testotomasyonu.com");


        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu
        // sayfanin basligini (Title) getirir


        System.out.println(driver.getCurrentUrl());
        //   https://www.testotomasyonu.com/
        // gidilen sayfadaki actual url'i getirir


        System.out.println(driver.getPageSource());


        System.out.println(driver.getWindowHandle()); // ACD4E31E98AF4C1C0C3ACD5A3BF368AD
        System.out.println(driver.getWindowHandles()); // [ACD4E31E98AF4C1C0C3ACD5A3BF368AD]

          /*
         WebDriver olusturulan her bir objeye
         benzersiz (unique) bir Window Handle Degeri atar.

         Bu konu ilerde ayrica anlatilacak

         Eger bir class calistiginda birden fazla windows acilirsa
         herbirinin ayri bir Window Handle Degeri olur

         getWindowHandle() driver'in actigi son window'un window handle degerini verir
         getWindowHandles() ise acilan tum window'larin window handle degerlerini
         bir Set olarak verir

         driver'in acilan Window'lar arasinda gecis yapabilmesi icin
         gecegi window'un window handle degerini bilmesi gerekir

         */


        Thread.sleep(3000);
        // driver.close();
        driver.quit();

         /*
         actigimiz driver'i kapatir
         driver.close(); // actigimiz driver'i kapatir
         aralarindaki fark; close() sadece 1 window kapatir
         quit() ise test sirasinda birden fazla window acilsa da hepsini kapatir
         */
    }
}
