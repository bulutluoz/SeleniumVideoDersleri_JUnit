package tests.K17_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_Cookies  extends TestBase_Each {

    @Test
    public void test01(){

        // Google anasayfaya gidin
        driver.get("https://www.google.com");

        // cookies cikarsa kabul edin
        driver.findElement(By.xpath("//div[.='Accept all']"))
                .click();
        ReusableMethods.bekle(1);

        // syfada kac adet cookies bulundugunu yazdirin
        Set<Cookie> sayfadakiCookieSeti = driver.manage().getCookies();

        System.out.println("Sayfadaki cookie sayisi : " + sayfadakiCookieSeti.size());

        // sayfadaki cookie'leri yazdirin

        System.out.println(sayfadakiCookieSeti);

        // daha anlasilir olmasi icin bir for-each loop ile cookie'leri yazdiralim

        System.out.println("===============");
        int siraNo = 1;
        for (Cookie eachCookie :sayfadakiCookieSeti){

            System.out.println(siraNo +". cookie   : " + eachCookie);
            siraNo++;
        }

        // cookie'lerin isimlerini yazdirin

        System.out.println("===============");
        siraNo = 1;
        for (Cookie eachCookie :sayfadakiCookieSeti){

            System.out.println(siraNo +". cookie ismi  : " + eachCookie.getName() );
            siraNo++;
        }


        // ismi SOCS olan cookie'nin degerinin
        // "CAISHAgBEhJnd3NfMjAyNDEyMTAtMF9SQzEaAmVuIAEaBgiAuPi6Bg" oldugunu test edin

        String expectedDeger = "CAISHAgBEhJnd3NfMjAyNDEyMTAtMF9SQzEaAmVuIAEaBgiAuPi6Bg";
        String actualDeger = driver.manage().getCookieNamed("SOCS").getValue();

        Assertions.assertEquals(expectedDeger,actualDeger);


        // ismi enSevdigimCookie, degeri cikolataliCookie olan bir cookie olusturup
        // sayfaya ekleyin

        Cookie yeniCookie = new Cookie("enSevdigimCookie","cikolataliCookie");
        driver.manage().addCookie(yeniCookie);


        // tum cookie'leri yazdiralim

        sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("===============");
        siraNo = 1;
        for (Cookie eachCookie :sayfadakiCookieSeti){

            System.out.println(siraNo +". cookie   : " + eachCookie);
            siraNo++;
        }

        // cookie'yi ekleyebildigimizi test edin

        Assertions.assertTrue(sayfadakiCookieSeti.contains(yeniCookie));

        // ismi SOCS olan cookie'yi silin

        driver.manage().deleteCookieNamed("SOCS");

        sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("===============");
        siraNo = 1;
        for (Cookie eachCookie :sayfadakiCookieSeti){

            System.out.println(siraNo +". cookie   : " + eachCookie);
            siraNo++;
        }

        // ve silindigini test edin

        boolean socsVarMi = false;

        for (Cookie eachCookie :sayfadakiCookieSeti){

            if (eachCookie.getName().equalsIgnoreCase("SOCS")){
                socsVarMi = true;
            }

        }

        /*
                tum cookie'lerin isimlerini kontrol ettik
                ismi SOCS olan varsa socsVarMi= true,
                ismi SOCS olan yoksa socsVarMi= false, olacak
         */

        Assertions.assertFalse( socsVarMi );


        // tum cookie'leri silin

        driver.manage().deleteAllCookies();

        // ve silindigini test edin
        sayfadakiCookieSeti = driver.manage().getCookies();

        Assertions.assertEquals(0, sayfadakiCookieSeti.size());


        ReusableMethods.bekle(1);

    }
}
