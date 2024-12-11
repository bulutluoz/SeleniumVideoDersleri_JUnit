package tests.K11_iFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C01_IFrame extends TestBase_Each {

    // 1- https://testotomasyonu.com/discount adresine gidin
    // 2- Elektronics Products yazisinin gorunur olduğunu test edin
    // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
    // 4- Sale Up To 50% yazisinin gorunur oldugunu test edin
    // 5- Fashion bolumundeki ilk urunu tiklayin
    //    ve ilk urun isminde "Men Slim Fit" gectigini test edin

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        /*
                 electronics products yazisini unique olarak locate etmemize ragmen kullanamadik
                 HTML kodlarini inceleyince kullanmak istedigimiz webelementin
                 bir iframe(gomulu HTML sayfa) icerisinde oldugunu belirledik
                 bir iframe icerisindeki elementi kullanabilmek icin
                 once o iframe'e gecis yapmamiz gerekir
             */
        WebElement electronicsIFrame= driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIFrame);
        ReusableMethods.bekle(1);

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement electronicsProductsElementi = driver.findElement(By.xpath("//*[.='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        String expectedUrunIsmi = "DELL Core I3 11th Gen";

        WebElement dellElementi = driver.findElement(By.id("pictext1"));
        String actualUrunIsmi = dellElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Sale Up To 50% yazisinin gorunur oldugunu test edin

        /*
            iframe icine gecis yapinca , biz driver'i oradan cikarincaya kadar
            driver iframe'in icinde kalir
            driver'i icinde oldugu iFrame'den cikarmak icin iki farkli method kullanilabilir

            driver.switchTo().parentFrame();
            ic ice birden fazla katman olarak iFrame'ler varsa
            bir ust katman'a cikartir

            driver.switchTo().defaultContent();
            ic ice birden fazla katman olarak iFrame'ler varsa
            direk anasayfaya cikartir
         */

        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        WebElement saleUpYaziElementi = driver.findElement(By.xpath("//*[.='Sale Up To 50%']"));

        Assertions.assertTrue(saleUpYaziElementi.isDisplayed());


        // 5- Fashion bolumundeki ilk urunu tiklayin
        //    fashion bolumu ayri bir IFrame icerisinde oldugundan , once o iFrame'e gecis yapmaliyiz
        WebElement fashionIFrame= driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        // ve ilk urun isminde "Men Slim Fit" gectigini test edin

        WebElement fashionIlkUrun = driver.findElement(By.id("pictext1"));

        String expectedUrunIsimIcerik = "Men Slim Fit";
        actualUrunIsmi = fashionIlkUrun.getText();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerik));



    }
}
