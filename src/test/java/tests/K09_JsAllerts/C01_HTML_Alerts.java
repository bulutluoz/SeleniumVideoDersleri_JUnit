package tests.K09_JsAllerts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C01_HTML_Alerts extends TestBase_Each {

    @Test
    public void test01(){

        // google anasayfaya gidin

        driver.get("https://www.google.com");


        // cookies kabul edin

        driver.findElement(By.xpath("//div[.='Accept all']"))
                .click();

        ReusableMethods.bekle(1);

    }

}
