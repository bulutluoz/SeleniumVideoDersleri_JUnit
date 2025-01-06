package tests.K05_Webelements_Locators.D04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class C03_Locators {

    public static void main(String[] args) {


        //2-  https://www.testotomasyonu.com/ adresine gidin

        //3-  Browseri tam sayfa yapin

        //4-  Sayfayi “refresh” yapin

        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin

        //6-  Furniture linkine tiklayin

        /*
            Bir HTML element acilan sayfada asagida kaldigi icin
            ilk acilan bolumde gorunmuyorsa
            o webElementi kullanip kullanamayacagimiz
            TAMAMEN sayfayi dizayn edenlerin yazmis olduklari koda baglidir
            bazi sayfalarda alt tarafta kalan HTML elementler kullanilabilirken
            bazi sayfalarda kullanilamayabilir

            Bizim yapabilecegimiz tek sey
            kullanmayi denemek
            kullanilabiliyorsa sorun yok,
            kullanamiyorsak o zaman sayfayi asagi kaydirmak

            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();

         */

        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin

        //filtrele butonuna basalim

        //8-  filtreleme sonucunda urun bulunabildigini test edin

        //9-Ilk urunu tiklayin

        //10- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin

        //11-Sayfayi kapatin



    }
}
