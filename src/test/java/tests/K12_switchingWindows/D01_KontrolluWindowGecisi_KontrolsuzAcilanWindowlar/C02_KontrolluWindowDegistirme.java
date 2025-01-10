package tests.K12_switchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C02_KontrolluWindowDegistirme  extends TestBase_Each {

    @Test
    public void test01(){

        /*

            Eger bize verilen gorevde
            yeni bir Tab veya yeni bir Window acilmasi isteniyorsa
            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.WINDOW);
            ile yeni bir Tab veya Window acip, driver'i yeni window'a otomatik olarak gecirebiliriz

            Eger testimiz sirasinda birden fazla window aciliyorsa
            driver'i istedigimiz window'a gecirmek icin
            hedef window'un WindowHandle degerini girmeliyiz
            driver.switchTo().window(wisequarterWhd);

            Eger birden fazla window aciyorsak ve geri donmemiz gerekecekse
            acilan her window'un window handle degerini kaydetmek
            faydali olacaktir.

         */

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // whd'ini kaydedin ve yazdirin
        String testotomasyonuWhd = driver.getWindowHandle();
        System.out.println("testotomasyonu window handle degeri : " + testotomasyonuWhd);
        ReusableMethods.bekle(1);

        System.out.println("Acik olan tum window'larin whd'leri : "+ driver.getWindowHandles());

        // yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");


        // whd'ini kaydedin ve yazdirin
        String wisequarterWhd = driver.getWindowHandle();
        System.out.println("wisequarter window handle degeri : " + wisequarterWhd);
        ReusableMethods.bekle(1);

        System.out.println("Acik olan tum window'larin whd'leri : "+ driver.getWindowHandles());

        // yeni bir window acarak, arabam.com sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.arabam.com");

        // whd'ini kaydedin ve yazdirin
        String arabamWhd = driver.getWindowHandle();
        System.out.println("arabam window handle degeri : " + arabamWhd);
        ReusableMethods.bekle(1);

        System.out.println("Acik olan tum window'larin whd'leri : "+ driver.getWindowHandles());

        // wisequarter'in acik oldugu window'a donun
        // ve url'in wisequarter icerdigini test edin
        driver.switchTo().window(wisequarterWhd);
        String expectedUrlIcerik = "wisequarter";
        String  actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);

        // testotomasyonu'nun acik oldugu window'a donun
        driver.switchTo().window(testotomasyonuWhd);

        // ve url'in testotomasyonu icerdigini test edin

        expectedUrlIcerik = "testotomasyonu";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);



    }
}
