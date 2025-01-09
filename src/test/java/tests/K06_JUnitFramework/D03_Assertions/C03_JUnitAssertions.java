package tests.K06_JUnitFramework.D03_Assertions;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C03_JUnitAssertions {

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in test otomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    static WebDriver driver;

    @BeforeAll // class'in basinda 1 kere calisir
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll // class'in en sonunda 1 kere calisir
    static void teardown()  {
        driver.quit();
    }

    @Test
    public void test01(){
        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //    Url'in testotomasyonu icerdigini test edin

        String expectedurlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedurlIcerik),"url expected kelimeyi icermiyor");

//        if (actualUrl.contains(expectedurlIcerik)){
//            System.out.println("Url testi PASSED");
//        }else {
//            System.out.println("Url testi FAILED");
//            throw new AssertionFailedError();
//        }
        ReusableMethods.bekle(1);
    }

    @Test
    public void test02(){
        // 2- phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@class='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualSonucSayisi>0,"Istenen urun websayfasinda bulunamadi");

//        if (actualSonucSayisi>0){
//            System.out.println("phone arama testi PASSED");
//        } else {
//            System.out.println("phone arama testi FAILED");
//            throw new AssertionFailedError();
//        }

        ReusableMethods.bekle(1);
    }

    @Test
    public void test03(){
        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsim = ilkUrunIsimElementi.getText()
                .toLowerCase(); // case sensitive olmamasi icin

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));

//        if(actualIsim.contains(expectedIsimIcerik)){
//            System.out.println("Urun isim testi PASSED");
//        } else {
//            System.out.println("Urun isim testi FAILED");
//            throw new AssertionFailedError();
//        }


    }








}
