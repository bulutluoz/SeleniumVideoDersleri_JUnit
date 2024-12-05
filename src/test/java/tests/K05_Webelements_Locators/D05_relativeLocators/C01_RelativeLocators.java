package tests.K05_Webelements_Locators.D05_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin
                /*
                 1- Relative locator'i kullanmak icin oncelikle
                    hedef webelement'e ait bir ozelligi bulmamiz gerekir
                    bunun icin locate edecek gibi webelementi inceleyelim

                    <a id="pictext7" class="overlay" href="http://testotomasyonu.com/product/32">
                      <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
                      <span>DSLR Camera</span></a>
                 */

                /*
                 2- hedef webelementin etrafinda kullanabildigimiz bir webelementi
                    locate edip kaydedelim
                    MotorE13 telefonun solunda diyelim
                 */
        WebElement motorTelefonElementi = driver.findElement(By.id("pic8_thumb"));

                /*
                3- Artik Relative locator ile hedef elementi locate edip kaydedebiliriz
                 */

        WebElement dslrCamera1=
                driver.findElement(RelativeLocator.with(By.className("overlay")).toLeftOf(motorTelefonElementi));

        dslrCamera1.click();
        Thread.sleep(2000);

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        WebElement dslrCameraIsimElementi = driver.findElement(By.xpath(" //*[@class= ' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR Camera 1.test PASSED");
        }else System.out.println("DSLR Camera 1.test FAILED");



        // 2.olarak Apple kulakligin saginda diye relative locator kullanalim

        /*
         StaleElementReferenceException
         Bir web sayfasindaki elementi locate ettikten sonra
         baska sayfalara gidilip yeniden locate ettigimiz webelementin oldugu sayfaya donersek

         driver daha onceden locate ettigi elementlerin ayni kaldigindan emin olmak ister
         bize NoSuchElementException (elementi bulamadim) demiyor

         onun yerine StaleElementReferenceException (bu webelementi locate etmistik ama ustunden cok zaman gecti) diyor

         StaleElementReferenceException karsilasinca daha once locate edip kaydettigimiz
         webelement'e yeniden deger atamasi yapmamiz gerekir.
         */

        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));

        WebElement dslrCamera2 =
                driver.findElement(RelativeLocator.with(By.className("overlay")).toRightOf(appleKulaklik));

        dslrCamera2.click();

        Thread.sleep(2000);

        dslrCameraIsimElementi = driver.findElement(By.xpath(" //*[@class= ' heading-sm mb-4']"));
        actualUrunIsmi = dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR camera 2.test PASSED");
        } else System.out.println("DSLR camera 2.test FAILED");



        // 3.olarak Bat kulakligin altinda diye relative locator kullanalim
        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement batKulaklik = driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCamera3 =
                driver.findElement(RelativeLocator.with(By.id("pictext7")).below(batKulaklik));

        Thread.sleep(1000);
        dslrCamera3.click();

        Thread.sleep(2000);

        dslrCameraIsimElementi = driver.findElement(By.xpath(" //*[@class= ' heading-sm mb-4']"));
        actualUrunIsmi = dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR camera 3.test PASSED");
        } else System.out.println("DSLR camera 3.test FAILED");


        Thread.sleep(1000);
        driver.quit();


    }
}
