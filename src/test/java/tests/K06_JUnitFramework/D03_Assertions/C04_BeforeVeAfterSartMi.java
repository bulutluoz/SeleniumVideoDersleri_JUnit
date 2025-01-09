package tests.K06_JUnitFramework.D03_Assertions;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C04_BeforeVeAfterSartMi {


    // tek test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in test otomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin
    WebDriver driver;

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void urunAramaTesti(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //    Url'in testotomasyonu icerdigini test edin

        String expectedurlIcerik = "testotomasyonu111";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedurlIcerik),"url expected kelimeyi icermiyor");

        ReusableMethods.bekle(1);

        // 2- phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@class='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualSonucSayisi>0,"Istenen urun websayfasinda bulunamadi");
        ReusableMethods.bekle(1);

        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsim = ilkUrunIsimElementi.getText()
                .toLowerCase(); // case sensitive olmamasi icin

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));
        ReusableMethods.bekle(1);


    }




}
