package tests.K13_actionsClass.D02_keyboardBasedActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;


public class C02_FormDoldurma {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim

        //2- Account linkine tiklayin

        //3- Sign Up linkine basalim

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim

        /*
            Formdaki tum kutulari tek tek locate etmek yerine
            firstName kutusuna click yapip, isim gonderelim
            sonraki kutulara gecisi de TAB tusu ile yapabiliriz
         */

        //   ve Sign Up butonuna basalim

        //5- Kaydin olusturuldugunu test edin

        /*
            Kayit yapinca bizi otomatik olarak giris sayfasina yonlendiriyor
            kaydin olustugunu test edebilmek icin
            giris yapalim
         */


    }
}
