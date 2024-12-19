package tests.K20_Screenshots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_MethodIleScreenshot extends TestBase_Each {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidelim
        driver.get("https://www.testotomasyonu.com");

        // Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        // Kullanici adi olarak wise@gmail.com girin
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys("wise@gmail.com");

        // password olarak 12345 girin
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("12345");

        // sign in butonuna basarak sisteme giris yapin
        driver.findElement(By.id("submitlogin"))
                .click();

        // giris yapilabildigini test etmek icin
        // Logout butonunun gorunur oldugunu test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());
        ReusableMethods.bekle(1);

        // Logout butonunun fotografini cekin
        ReusableMethods.webElementResimCek(logoutButonu);
        ReusableMethods.webElementResimCek(logoutButonu,"positiveLoginTesti");
        ReusableMethods.tarihliWebElementResimCek(logoutButonu);
        ReusableMethods.tarihliWebElementResimCek(logoutButonu,"positiveLoginTesti");

        // logout butonuna basarak sistemden cikis yapin

        logoutButonu.click();

    }
}
