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

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("SetUp calisti");
    }

    @AfterAll
    public static void teardown(){
        System.out.println("Teardown calisti");
        driver.quit();
    }

    @Test
    public void test01(){

        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //    Url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu1";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualBulunanUrunSayisi>0);

        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        //    ve acilan sayfadaki urun isminde
        //    case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerigi = "phone";
        String actualIsim = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerigi));


    }





}
