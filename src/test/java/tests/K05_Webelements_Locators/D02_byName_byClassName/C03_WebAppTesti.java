package tests.K05_Webelements_Locators.D02_byName_byClassName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_WebAppTesti {

    public static void main(String[] args){

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //3- “ONLINE BANKING” linkine tiklayin
        driver.findElement(By.id("onlineBankingMenu"))
                .click();

        //4- Resim altinda 6 islem basligi oldugunu test edin
        List<WebElement> baslikElementleriList = driver.findElements(By.className("headers"));

        int expectedBaslikSayisi = 6;
        int actualBaslikSayisi = baslikElementleriList.size();

        if (expectedBaslikSayisi == actualBaslikSayisi){
            System.out.println("Baslik sayisi testi PASSED");
        } else System.out.println("Baslik sayisi testi FAILED");

        //5- Islem basliklari icinde “Pay Bills” oldugunu test edin
         /*
            1.yontem : for loop ile her bir webelementi gozden gecirip
                       bir flag ile eger istenen metne esit olan baslik varsa
                       sonucu true olarak kaydedebiliriz
          */

        boolean payBillsVarMi = false;

        for ( WebElement eachElement  :baslikElementleriList){

            if (eachElement.getText().equals("Pay Bills")){
                payBillsVarMi = true;
            }

        }

        if (payBillsVarMi){
            System.out.println("Pay Bills testi1 PASSED");
        } else System.out.println("Pay Bills testi1 FAILED");

         /*
               2.yontem : Bos bir String list olusturup
               for loop ile webelement'ler uzerindeki yazilari alip
               String list'e ekleriz,
               Sonra o String listede aranan basligin olup olmadigini test ederiz
          */

        List<String> baslikYazilariList = new ArrayList<>();

        for ( WebElement eachElement  :baslikElementleriList){
            baslikYazilariList.add(eachElement.getText());
        }

        System.out.println("Baslik yazilari : " + baslikYazilariList);

        if (baslikYazilariList.contains("Pay Bills")){
            System.out.println("Pay Bills testi2 PASSED");
        } else System.out.println("Pay Bills testi2 FAILED");


        //6- Sayfayi kapatin
        driver.quit();


    }
}
