package tests.K21_javascriptExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C01_JavaScriptExecutor extends TestBase_Each {

    @Test
    public void test01(){

        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");


        // isitme kaybi checkbox gorunecek kadar asagi inin

            // 1.adim jse objesi olustur
        JavascriptExecutor jse = (JavascriptExecutor) driver;

            // 2.adim kullanmak istedigimiz Webelementi locate edip kaydedin
        WebElement isitmeKaybiCheckbox = driver.findElement(By.id("hastalikCheck5"));
        ReusableMethods.bekle(1);
            //3.adim jse.executeScript() ile istenen islemi yapin
            // isitme kaybi checkbox gorunecek kadar asagi inin
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",isitmeKaybiCheckbox);
        ReusableMethods.bekle(3);

        // jse kullanarak isitme kaybi checkbox'i isaretleyin
        jse.executeScript("arguments[0].click();",isitmeKaybiCheckbox);
        ReusableMethods.bekle(3);

        // javascript Alert kullanarak "JUnit BITTTIIIII" yazdirin
        jse.executeScript("alert('JUnit BITTTIIIII!');");

        ReusableMethods.bekle(3);




    }
}
