package tests.K05_Webelements_Locators.D02_byName_byClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ByClassName {

    public static void main(String[] args) throws InterruptedException {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //2- https://www.testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");
        //3- urun arama kutusunu locate edin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        //4- arama kutusuna “shoe” yazdirin
        aramaKutusu.sendKeys("shoe");

        //5- arama islemini yapabilmek icin ENTER tusuna basin
        aramaKutusu.submit();

        //6- arama sonucunda urun bulunabildigini test edin.

        WebElement aramaSonucYazisiElementi = driver.findElement(By.className("product-count-text"));

        // System.out.println(aramaSonucYazisiElementi);
        // [[ChromeDriver: chrome on mac (4e1efdb1f0c796aeb508155e39e13aa0)] -> class name: product-count-text]
        // WebElement non-primitive data turudur.
        // WebElement'i direkt yazdiramazsiniz, direkt yazdirmak istediginizde referansini yazdirir
        // Eger WebElement ustundelki yaziyi gormek isterseniz getText() kullanmalisiniz

        // System.out.println(aramaSonucYazisiElementi.getText()); // "4 Products Found"

        String aramaSonucYazisi = aramaSonucYazisiElementi.getText(); // "4 Products Found"

        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // "4"

        int actualAramaSonucSayisi = Integer.parseInt(aramaSonucYazisi); // 4

        if (actualAramaSonucSayisi > 0){
            System.out.println("Urun arama testi PASSED");
        }else System.out.println("Urun arama testi FAILED");


        Thread.sleep(1000);
        driver.quit();

    }
}
