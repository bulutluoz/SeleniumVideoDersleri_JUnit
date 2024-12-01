package tests.K04_WebDriverOlusturmaVeKullanma.D02_farkliDriverKullanimi_driverManageMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverManage_WindowMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();


        // 1. https://www.testotomasyonu.com/ sayfasina gidin
        driver.get("https://www.testotomasyonu.com/");

        // 2. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Acilista konum : "+ driver.manage().window().getPosition());
        // Acilista konum : (22, 60)
        System.out.println("Acilista boyut : "+ driver.manage().window().getSize());
        // Acilista boyut : (1200, 989)
        Thread.sleep(2000);

        // 3. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();


        // 4. Simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        // 5. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Maximize konum : "+ driver.manage().window().getPosition());
        System.out.println("Maximize boyut : "+ driver.manage().window().getSize());
        Thread.sleep(2000);

        // 6. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        // 7. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Fullscreen konum : "+ driver.manage().window().getPosition());
        System.out.println("Fullscreen boyut : "+ driver.manage().window().getSize());
        // calistigi ekranin cozunurlugunu verir
        Thread.sleep(2000);

        // 8. Sayfanin konumunu pixel olarak (200,200)’ye getirin
        driver.manage().window().setPosition(new Point(200,200));

        // 9. Sayfa boyutunu pixel olarak (1000,500)’ye ayarlayin
        driver.manage().window().setSize(new Dimension(1000,500));
        System.out.println("Ozel boyut konum : "+ driver.manage().window().getPosition());
        System.out.println("Ozel boyut : "+ driver.manage().window().getSize());


        //10. Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }
}
