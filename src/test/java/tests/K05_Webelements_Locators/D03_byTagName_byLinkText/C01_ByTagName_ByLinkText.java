package tests.K05_Webelements_Locators.D03_byTagName_byLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByTagName_ByLinkText {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //   cikan cookies kabul edin

        driver.findElement(By.className("fc-button-label")).click();

        //3- Sayfada 147 adet link bulundugunu test edin.

        List<WebElement> sayfadakiLinkListesi = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = sayfadakiLinkListesi.size();

        if (expectedLinkSayisi == actualLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        }else{
            System.out.println("Link sayisi testi FAILED");
            System.out.println("sayfada bulunan link sayisi 147 degil " + actualLinkSayisi);
        }


        //4- Products linkine tiklayin
        // driver.findElement(By.linkText(" Products")).click();

        driver.findElement(By.partialLinkText("oducts"))
                .click();
        Thread.sleep(1000);
        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferYaziElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferYaziElementi.isDisplayed()){
            System.out.println("special offer yazi elementi testi PASSED");
        }else System.out.println("special offer yazi elementi testi FAILED");


        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();


    }
}
