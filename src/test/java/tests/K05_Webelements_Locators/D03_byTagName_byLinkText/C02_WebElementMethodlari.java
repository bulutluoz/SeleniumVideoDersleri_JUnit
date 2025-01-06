package tests.K05_Webelements_Locators.D03_byTagName_byLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WebElementMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // https://www.testotomasyonu.com/form adresine gidin
        driver.get("https://www.testotomasyonu.com/form");

        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // Cinsiyet bolumunden size uygun radio button secin
        erkekRadioButton.click();

        // istediginiz radio button'un secili oldugunu test edin
        if (erkekRadioButton.isSelected()){
            System.out.println("sectigimiz radio button testi PASSED");
        } else  System.out.println("sectigimiz radio button testi FAILED");

        // sizin isaretlediginiz disindaki butonlarin secili olmadigini test edin

        if (!kadinRadioButton.isSelected()){
            System.out.println("secmedigimiz radio button testi1 PASSED");
        } else  System.out.println("secmedigimiz radio button testi1 FAILED");

        if (!digerRadioButton.isSelected()){
            System.out.println("secmedigimiz radio button testi2 PASSED");
        } else  System.out.println("secmedigimiz radio button testi2 FAILED");

        // soyisim kutusunun boyutlarini ve konumunu yazdirin
        WebElement soyisimKutuElementi = driver.findElement(By.id("surname"));

        System.out.println("Soyisim kutusu boyut : "+ soyisimKutuElementi.getSize());
        System.out.println("Soyisim kutusu konum : " + soyisimKutuElementi.getLocation());

        // soyisim kutusunun HTML kodundaki class attribute degerinin
        // "form-control" oldugunu test edin

        String expectedAtrDegeri = "form-control";
        String actualAtrDegeri = soyisimKutuElementi.getAttribute("class");

        if (expectedAtrDegeri.equals(actualAtrDegeri)){
            System.out.println("soyisim kutusu class attribute testi PASSED");
        } else  System.out.println("soyisim kutusu class attribute testi FAILED");

        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();


    }
}
