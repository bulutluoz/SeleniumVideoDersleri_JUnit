package tests.K06_JUnitFramework.D03_Assertions;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.util.List;

public class C01_OtomatikSonucRaporlama {

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    /*
        JUnit bir test method'unun
        PASSED veya FAILED olmasina
        kodlarin sorunsuz olarak calisip bitip bitmemesine gore karar verir

        Biz if-else ile test yaparsak
        if else FAILED yazdirsa bile
        kodlar problem olmadan calismaya devam ettigi icin
        method'un sonunda JUnit test PASSED olarak algilar
        ve yesil tik koyar

        Ozellikle toplu test calistirmalarda
        konsolu inceleyip
        birsuru yazi arasinda
        Test PASSED veya test FAILED sonucunu aramak
        ve kac testin failed oldugunu hesaplamak
        neredeyse imkansizdir

        Eger if ile test yapiyorsak
        ve failed oldugunda JUnit'in de bunu algilamasini istiyorsak
        throw keyword'u ile kontrollu olarak exception olusturabiliriz
     */

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

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        } else {
            System.out.println("Url testi FAILED");
            throw new AssertionFailedError();
        }

    }

    @Test
    public void test02(){

        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        if (actualBulunanUrunSayisi > 0 ){
            System.out.println("Urun bulma testi PASSED");
        } else {
            System.out.println("Urun bulma testi FAILED");
            throw new AssertionFailedError();
        }

    }

    @Test
    public void test03(){
        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        //    ve acilan sayfadaki urun isminde
        //    case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerigi = "phone";
        String actualIsim = ilkUrunIsimElementi.getText().toLowerCase();

        if (actualIsim.contains(expectedIsimIcerigi)){
            System.out.println("Ilk urun isim testi PASSED");
        } else {
            System.out.println("Ilk urun isim testi FAILED");
            throw new AssertionFailedError();
        }

    }









}
