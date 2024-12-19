package tests.K20_Screenshots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C02_MethodIleGetScreenshot extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);

        // tum sayfa screenshot alin
        ReusableMethods.tumSayfaResimCek(driver);
        // her seferinde verdigimiz isim olan tumSayfaResmi.jpeg  olarak resmi kaydeder
        // onceki cekilenler silinmis olur

        ReusableMethods.tumSayfaResimCek(driver,"aramaTesti19Aralik");

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsim = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));

        ReusableMethods.bekle(1);
        // sayfanin fotografini cekin

        ReusableMethods.tumSayfaResimCek(driver);

        ReusableMethods.tumSayfaResimCek(driver,"IlkUruntesti19Aralik");

        ReusableMethods.tarihliTumSayfaResimCek(driver);

        ReusableMethods.tarihliTumSayfaResimCek(driver,"IlkUrunTesti");


    }
}
