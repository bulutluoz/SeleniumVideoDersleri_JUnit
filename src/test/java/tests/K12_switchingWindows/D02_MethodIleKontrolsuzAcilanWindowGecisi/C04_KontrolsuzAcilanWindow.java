package tests.K12_switchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

import java.util.Set;

public class C04_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();

        // acilan yeni window'a gecip
        // gecisi yeni window'un title'ini kullanarak yapin

        // 1- acik olan tum window'larin WHD'lerini alip kaydedelim

        Set<String> acikWindowlarinWhdleri = driver.getWindowHandles();

        //   [E7DF36DB6F21C9F3FACD1171BE7A52E1, 0FD94DE1BF431FA11ECEFA6FF529A3CE]

        String hedefWindowunTitle = "Home | Elemental Selenium";

        for (String eachWhd :acikWindowlarinWhdleri){

            driver.switchTo().window(eachWhd);
            // gectigimiz window'un title'ini alip
            // gecmek istedigimiz window'un title'ina esit mi diye kontrol edelim

            if (driver.getTitle().equals(hedefWindowunTitle)){
                //dogru window'dayiz demektir, burada kalabiliriz
                break;
            }

        }


        // buyuk basligin "Elemental Selenium" oldugunu test edin

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

    }
}
