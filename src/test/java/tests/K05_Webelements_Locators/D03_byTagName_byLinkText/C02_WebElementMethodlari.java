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

        // Cinsiyet bolumunden size uygun radio button secin
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        erkekRadioButton.click();

        // istediginiz radio button'un secili oldugunu test edin
        if (erkekRadioButton.isSelected()){
            System.out.println("Secim testi PASSED");
        }else System.out.println("Secim testi FAILED");

        // sizin isaretlediginiz disindaki butonlarin secili olmadigini test edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        if (  ! kadinRadioButton.isSelected() ){
            System.out.println("Kadin secim testi PASSED");
        }else System.out.println("Kadin secim testi FAILED");


        if (  ! digerRadioButton.isSelected() ){
            System.out.println("Diger secim testi PASSED");
        }else System.out.println("Diger secim testi FAILED");


        // soyisim kutusunun boyutlarini ve konumunu yazdirin
        WebElement soyisimKutusu = driver.findElement(By.id("surname"));
        System.out.println("Soyisim kutusu boyut : " + soyisimKutusu.getSize());
        System.out.println("Soyisim kutusu konum : " + soyisimKutusu.getLocation());


        // soyisim kutusunun HTML kodundaki class attribute degerinin
        // "form-control" oldugunu test edin

        String expectedClassValue = "form-control";
        String actualClassValue = soyisimKutusu.getAttribute("Class");

        if (expectedClassValue.equals(actualClassValue)){
            System.out.println("Atribute testi PASSED");
        }else System.out.println("Atribute testi FAILED");


        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();

    }
}
