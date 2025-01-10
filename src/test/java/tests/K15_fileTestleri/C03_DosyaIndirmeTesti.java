package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_DosyaIndirmeTesti extends TestBase_Each {

    @Test
    public void test01(){
        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //2. webDriverIO.png dosyasını indirelim
        driver.findElement(By.xpath("//*[.='webdriverIO.png']"))
                .click();


        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim
        ReusableMethods.bekle(1);

        // Dosya downloads'a inecektir

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/webDriverIO.png";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }
}
