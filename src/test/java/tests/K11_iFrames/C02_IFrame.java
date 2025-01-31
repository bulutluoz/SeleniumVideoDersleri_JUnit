package tests.K11_iFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;


public class C02_IFrame extends TestBase_Each {

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

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIFrame);

        WebElement electronicsProducts = driver.findElement(By.xpath("//*[.='Electronics Products']"));

        Assertions.assertTrue(electronicsProducts.isDisplayed());


        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = driver.findElement(By.id("pictext1"))
                                        .getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Sale Up To 50% yazisinin gorunur oldugunu test edin
        //   bu yazi anasayfada oldugu icin
        //   once electronics iframe'inden anasayfaya gecis yapmaliyiz
        driver.switchTo().parentFrame();

        WebElement baslikElementi = driver.findElement(By.tagName("h2"));
        String expectedBaslikYazisi = "Sale Up To 50%";
        String actualBaslikYazisi = baslikElementi.getText();

        Assertions.assertEquals(expectedBaslikYazisi,actualBaslikYazisi);

        // 5- Fashion bolumundeki ilk urun ismini locate edin
        //    fashion bolumu ayri bir IFrame icerisinde oldugundan , once o iFrame'e gecis yapmaliyiz

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(fashionIFrame);

        // simdi ilk urun ismini locate edin
        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("(//p)[1]"));


        // ve ilk urun isminde "Men Slim Fit" gectigini test edin

        String expectedIsimIcerigi = "Men Slim Fit";
        actualUrunIsmi = ilkUrunIsimElementi.getText();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));




    }
}
