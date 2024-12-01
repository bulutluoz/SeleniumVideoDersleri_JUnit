package tests.K04_WebDriverOlusturmaVeKullanma.D02_farkliDriverKullanimi_driverManageMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManage_TimeOuts {

    public static void main(String[] args) throws InterruptedException {

         /*
            Test otomasyonu bizim kodlarimizin
            bizim yerimize internette
            Web sayfalarinda islem yapmasidir

            Bizim yazdigimiz Java kodlarinin hizi ile

            1- bilgisayarimiz
            2- internetimiz
            3- ve ulasmaya calistigimiz sayfanin
            hizlari arasinda fark olur.

            Bu hizlar arasindaki fark
            kodlarimizin calisamamasina
            veya testin FAILED olmasina sebep olur

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));




        /*
            Thread.sleep(3000) Java'dan gelir ve mutlak bir bekleme suresidir
            icine yazilan sure boyunca, kodlari bekletir
            ve alt satira gecmez

            implicitlyWait(Duration.ofSeconds(10))
            ise Selenium'dan gelir ve dinamiktir.
            Yani 10 saniyeyi sonuna kadar kullanmaz,
            asil amac sayfanin acilmasi veya
            sayfada kullanacagimiz herhangi bir webelementin kullanilir hale gelmesini beklemektir.

            10 saniye icerisinde sayfanin acilmasini
            veya kullanacagi webelementi bulmayi bekler
            10 saniye icerisinde Ne zaman islemi yapabilirse,
            daha fazla beklemez yoluna devam eder

            10 saniye beklemesine ragmen
            sayfa acilmazsa veya
            aradigi webelementi bulamazsa
            exception firlatir ve calismayi durdurur
         */
        Thread.sleep(2000);
        driver.quit();

    }
}
