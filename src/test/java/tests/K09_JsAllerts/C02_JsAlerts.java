package tests.K09_JsAllerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C02_JsAlerts extends TestBase_Each {

    //3 test method'u olusturup asagidaki gorevi tamamlayin
    /*
        Bir webelement'e click yaptigimizda
        driver objesi ortam degisikligi beklemez

        ayni window'da kalip, farkli bir url'e gitmeyi bekler

        ANCAAKKKK bazi islemler yapildiginda
        farkli bir ortam olusabilir

        driver'i bu farkli ortama gecirmek icin
        driver.switchTo() kullanmamiz gerekir

        Bu durumlardan birisi JavaScript alert'lerdir.
        JsAlert calistiginda normal window uzerinde islem yapamayiz
        sag tus yapip locate alamadigimiz icin alert uzerinde driver'i calistiramayiz

        driver'in jsAlert'e gecmesi ve orada islem yapabilmesi icin
        oncelikle jsAlert evrenine switch yapmasi gerekir
     */

    @Test
    public void jsAlertsTest(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']"))
                .click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertyazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo()
                                        .alert()
                                        .getText();

        Assertions.assertEquals(expectedAlertyazi,actualAlertYazi);

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo()
                .alert()
                .accept();


    }

    @Test
    public void jsConfirmTest(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"))
                .click();


        //	- Cancel'a basip,
        driver.switchTo()
                .alert()
                .dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedSonucyazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedSonucyazisi,actualSonucYazisi);

    }

    @Test
    public void jsPromptTest(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        //	- Cikan prompt ekranina "Cansu" yazdiralim
        driver.switchTo().alert().sendKeys("Cansu");


        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo()
                .alert()
                .accept();

        //	- Cikan sonuc yazisinin Cansu icerdigini test edelim
        String expectedSonucYaziIcerigi = "Cansu";
        String actualSonucYazisi = driver.findElement(By.id("result")).getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYaziIcerigi));


    }


}
