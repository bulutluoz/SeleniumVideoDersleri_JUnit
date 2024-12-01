package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigateMethodlariTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //1. Youtube ana sayfasina gidin . https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        //2. url’in “youtube” icerdigini test edin.
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        } else System.out.println("Url testi FAILED");

        //3. Testotomasyonu sayfasina gidin. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //4. Title’in “Test Otomasyonu” icerdigini test edin.

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");


        //5. Tekrar YouTube’sayfasina donun.
        driver.navigate().back();

        //6. Title’in “YouTube” oldugunu test edin

        String expectedTitle = "YouTube";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Youtube title testi PASSED");
        }else System.out.println("Youtube title testi FAILED");

        //7. Sayfayi Refresh(yenile) yapin.
        driver.navigate().refresh();

        //8. Sayfayi kapatalim / Tum sayfalari kapattin.

        Thread.sleep(2000);
        driver.quit();
    }
}
