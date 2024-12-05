package tests.K05_Webelements_Locators.D05_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin

                // 1- Relative locator'i kullanmak icin oncelikle
                //    hedef webelement'e ait bir ozelligi bulmamiz gerekir
                //    bunun icin locate edecek gibi webelementi inceleyelim
                //    <a id="pictext7" class="overlay" href="http://testotomasyonu.com/product/32">
                //      <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
                //      <span>DSLR Camera</span></a>


                // 2- hedef webelementin etrafinda kullanabildigimiz bir webelementi
                //    locate edip kaydedelim
        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));

                // 3- Artik Relative locator ile hedef elementi locate edip kaydedebiliriz
        driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon))
                .click();

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        WebElement urunIsimElementi= driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("Dslr camera 1. test PASSED");
        }else System.out.println("Dslr camera 1. test FAILED");

        Thread.sleep(1000);


        // 2.olarak Apple kulakligin saginda diye relative locator kullanalim
        driver.get("https://testotomasyonu.com/relativeLocators");
        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));

        driver.findElement(RelativeLocator.with(By.className("overlay")).toRightOf(appleKulaklik))
                .click();

        expectedUrunIsmi = "DSLR Camera";
        urunIsimElementi= driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();
        // StaleElementReferenceException
        // Bir web sayfasindaki elementi locate ettikten sonra
        // baska sayfalara gidilip yeniden locate ettigimiz webelementin oldugu sayfaya donersek
        // driver daha onceden locate ettigi elementlerin ayni kaldigindan emin olmak ister
        // bize NoSuchElementException (elementi bulamadim) demiyor
        // onun yerine StaleElementReferenceException (bu webelementi locate etmistik ama ustunden cok zaman gecti) diyor
        // StaleElementReferenceException karsilasinca daha once locate edip kaydettigimiz
        // webelement'e yeniden deger atamasi yapmamiz gerekir.

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("Dslr camera 2. test PASSED");
        }else System.out.println("Dslr camera 2. test FAILED");

        Thread.sleep(1000);
        // 3.olarak Bat kulakligin altinda diye relative locator kullanalim
        driver.get("https://testotomasyonu.com/relativeLocators");
        WebElement batKulaklik = driver.findElement(By.id("pic2_thumb"));

        driver.findElement(RelativeLocator.with(By.id("pictext7")).below(batKulaklik))
                .click();


        expectedUrunIsmi = "DSLR Camera";
        urunIsimElementi= driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("Dslr camera 3. test PASSED");
        }else System.out.println("Dslr camera 3. test FAILED");



        Thread.sleep(3000);
        driver.quit();

    }
}
