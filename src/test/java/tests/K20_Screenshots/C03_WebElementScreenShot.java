package tests.K20_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C03_WebElementScreenShot extends TestBase_Each {

    @Test
    public void test01() throws IOException {

        // Testotomasyonu anasayfaya gidelim
        driver.get("https://www.testotomasyonu.com");

        // Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        // Kullanici adi olarak wise@gmail.com girin
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys("wise@gmail.com");

        // password olarak 12345 girin
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("12345");

        // sign in butonuna basarak sisteme giris yapin
        driver.findElement(By.id("submitlogin"))
                .click();

        // giris yapilabildigini test etmek icin
        // Logout butonunun gorunur oldugunu test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());
        ReusableMethods.bekle(1);
        // Logout butonunun fotografini cekin

        // 1.adim screenshot alacagimiz webelementi locate edip kaydedelim
        //        biz yukarda Logout butonunu locate ettik

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        String dosyaYolu = "target/screenshots/webElementResmi.jpeg";
        File webElementResim = new File(dosyaYolu);

        // 3.adim webElement'i kullanarak screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = logoutButonu.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,webElementResim);

        // logout butonuna basarak sistemden cikis yapin

        logoutButonu.click();

    }
}
