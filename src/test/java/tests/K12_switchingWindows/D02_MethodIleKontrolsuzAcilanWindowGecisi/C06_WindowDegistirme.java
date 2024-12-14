package tests.K12_switchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C06_WindowDegistirme extends TestBase_Each {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        ReusableMethods.bekle(1);

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();

        // acilan yeni window'da buyuk basligin "Elemental Selenium" oldugunu test edin
        // once title kullanarak yeni window'a gecelim
        ReusableMethods.titleIleWindowGecisYap(driver,"Home | Elemental Selenium");

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);
        ReusableMethods.bekle(1);

        // ilk window'a geri donun
        ReusableMethods.urlIleWindowGecisYap(driver,"https://the-internet.herokuapp.com/windows");

        // "Opening a new window" yazisinin gorunur oldugunu test edin
        WebElement openingWindowElementi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(openingWindowElementi.isDisplayed());
        ReusableMethods.bekle(1);

        // Click here'a basin
        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

        // Acilan yeni window'a gecip,
        ReusableMethods.titleIleWindowGecisYap(driver,"New Window");

        // oradaki yazinin "New Window" oldugunu test edin
        expectedYazi = "New Window";
        actualYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);
        ReusableMethods.bekle(1);


        // Elemental selenium'un acik oldugu window'a gecip
        ReusableMethods.urlIleWindowGecisYap(driver,"https://elementalselenium.com/");

        // Tips linkinin erisilebilir oldugunu test edin
        WebElement tipsElementi = driver.findElement(By.xpath("//*[.='Tips']"));

        Assertions.assertTrue(tipsElementi.isEnabled());
        ReusableMethods.bekle(1);

    }
}
