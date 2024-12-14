package tests.K12_switchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazi = "Opening a new window";
        String actualyazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        String ilkWindowWhd = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin

        /*
            driver.getWindowHandle();
            method'u icerisinde oldugu window'un window handle degerini bize getirir
            ve biz de kaydedebiliriz

            bir window'un whd'ini kaydettikten sonra
            nerede olursak olalim
            driver.switchTo().window(hedefWindowunWHDi); ile bu window'a gecis yapabiliriz

            Kontrolsuz window acildiginda
            driver beklemedigi bir durum oldugundan
            yeni window'a gecmez, eski window'da kalir

            yeni window'a gecemedigimiz icin
            yeni window'un whd'ini de alamayiz
         */
        System.out.println("ilk window whd : " + ilkWindowWhd );
        System.out.println("Click'e bastiktan sonra driver'in oldugu window'un whd : " + driver.getWindowHandle());

        Set<String> acikTumWindowlarinWhdSeti = driver.getWindowHandles();
        System.out.println(acikTumWindowlarinWhdSeti);

        /*
            Yeni window'un whd'ini bulmak icin mini bir bulmaca cozmeliyiz
            Baslangicta alip kaydettigimiz
            ilk window whd'ini biliyoruz

            Acik olan tum window'larin whd'lerini
            getWindowHandles() ile alip bir Set'e kaydedebiliriz.

            Set'i bir for-each loop ile gozden gecirip
            ilk window'un whd'ne esit olmayan elemani
            ikinci window'un whd'i olarak atayabiliriz
         */

        String ikinciWindowWhd = "";

        for (String eachWhd :acikTumWindowlarinWhdSeti){

            if ( ! eachWhd.equals(ilkWindowWhd) ){
                ikinciWindowWhd = eachWhd;
            }
        }


        /*
            ilk window'un whd'ini en basta kaydetmistik
            simdi ikinci window'un whd'ine de sahibiz

            artik switchTo() ile istedigimiz window'a gecis yapabiliriz

         */
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin

        /*
            yeni window kontrolsuz olarak acildigi icin
            driver hala eski window'da
            yeni window ile ilgili islem yapmadan once
            driver'i yeni window'a gecirmeliyiz
         */


        driver.switchTo().window(ikinciWindowWhd);
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        yaziElementi = driver.findElement(By.tagName("h3"));
        expectedYazi = "New Window";
        actualyazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualyazi);


        //● Bir önceki pencereye geri dönun
        driver.switchTo().window(ilkWindowWhd);

        //  ve sayfa başlığının “The Internet” olduğunu test edin

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);


    }
}
