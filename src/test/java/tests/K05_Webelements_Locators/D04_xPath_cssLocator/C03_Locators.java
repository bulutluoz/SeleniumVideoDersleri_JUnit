package tests.K05_Webelements_Locators.D04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class C03_Locators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2-  https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");

        //6-  Furniture linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]")).click();

        /*
            Bir HTML element acilan sayfada asagida kaldigi icin
            ilk acilan bolumde gorunmuyorsa
            o webElementi kullanip kullanamayacagimiz
            TAMAMEN sayfayi dizayn edenlerin yazmis olduklari koda baglidir
            bazi sayfalarda alt tarafta kalan HTML elementler kullanilabilirken
            bazi sayfalarda kullanilamayabilir

            Bizim yapabilecegimiz tek sey
            kullanmayi denemek
            kullanilabiliyorsa sorun yok,
            kullanamiyorsak o zaman sayfayi asagi kaydirmak

            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();

         */


        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        //Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement minFiyatKutusu = driver.findElement(By.xpath("//*[@class='form-control minPrice']"));
        minFiyatKutusu.clear();
        minFiyatKutusu.sendKeys("40");


        WebElement maxFiyatKutusu = driver.findElement(By.xpath("//*[@class='form-control maxPrice']"));
        maxFiyatKutusu.clear();
        maxFiyatKutusu.sendKeys("200");

        //filtrele butonuna basalim
        driver.findElement(By.xpath("//*[@class='price-range-button']"))
                .click();

        //8-  filtreleme sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        int actualUrunSayisi = bulunanUrunElementleriList.size();

        if (actualUrunSayisi > 0 ){
            System.out.println("Urun filtreleme testi PASSED");
        } else System.out.println("Urun filtreleme testi FAILED");

        //9-Ilk urunu tiklayin

        bulunanUrunElementleriList.get(0).click();


        //10- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin

        WebElement ilkUrunFiyatElementi = driver.findElement(By.id("priceproduct"));

        String ilkUrunFiyatiStr = ilkUrunFiyatElementi.getText(); // "$50.00"

        ilkUrunFiyatiStr = ilkUrunFiyatiStr.replaceAll("\\D",""); // "5000"

        double ilkUrunFiyatiDbl = Double.parseDouble(ilkUrunFiyatiStr) / 100;  // 50.00

        if (ilkUrunFiyatiDbl>=40 && ilkUrunFiyatiDbl<=200){
            System.out.println("Ilk urun fiyat testi PASSED");
        } else System.out.println("Ilk urun fiyat testi FAILED");



        //11-Sayfayi kapatin
        Thread.sleep(1000);
        driver.quit();


    }
}
