package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C01_Actions_ContextClick extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
        WebElement dgiDronesElementi = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.contextClick(dgiDronesElementi)
                .perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedYazi = "Tebrikler!... Sağ click yaptınız.";
        String actualYazi = driver.switchTo()
                                    .alert()
                                    .getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //4- Tamam diyerek alert’i kapatin
        driver.switchTo()
                .alert()
                .accept();



    }

}
