package tests.K20_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


import java.io.File;
import java.io.IOException;

public class C01_GetScreenshotTumSayfa extends TestBase_Each {

    @Test
    public void test01() throws IOException {

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
        ReusableMethods.bekle(1);
        // tum sayfanin screenshot'ini alin

        // 1.adim tss objesi olusturalim
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        String dosyaYolu = "target/screenshots/tumSayfaResmi.jpeg";
        File tumSayfaResmi = new File(dosyaYolu);

        // 3.adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,tumSayfaResmi);


    }
}
