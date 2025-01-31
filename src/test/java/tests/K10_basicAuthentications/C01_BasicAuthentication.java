package tests.K10_basicAuthentications;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C01_BasicAuthentication extends TestBase_Each {

    @Test
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        // driver.get("https://testotomasyonu.com/basicauth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        //

        /*
         driver.get("https://testotomasyonu.com/basicauth");
         sadece url'e gidersek UI ile kullanici adi ve sifre girmemiz gerekir
         ancak otomasyon ile gittigimizde
         kullanici adi ve sifresi bolumunu locate edemedigimizden kullanamayiz
         bunun yerine kullandigimiz url'in sahibi olan sirketin
         bize verecegi kullanici adi ve sifresini
         yine sirketin bize tarif edecegi yontemle URL'e eklemeliyiz
         */
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");


        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String expectedYazi = "Basic Auth";

        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(10);




    }
}
