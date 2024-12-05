package tests.K05_Webelements_Locators.D04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath_TextKullanimi {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
       driver.findElement(By.xpath("//*[.='Add']"))
               .click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonu = driver.findElement(By.xpath("//button[text()='Remove']"));

        if (removeButonu.isDisplayed()){
            System.out.println("Remove butonu gorunme testi PASSED");
        }else System.out.println("Remove butonu gorunme testi FAILED");

        //4- Remove tusuna basin

        removeButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        //WebElement addRemoveElementsYaziElementi = driver.findElement(By.xpath("//h2"));
        WebElement addRemoveElementsYaziElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));


        if (addRemoveElementsYaziElementi.isDisplayed()){
            System.out.println("Add remove testi PASSED");
        } else System.out.println("Add remove testi FAILED");

        //6- sayfayi kapatin

        driver.quit();
    }
}
