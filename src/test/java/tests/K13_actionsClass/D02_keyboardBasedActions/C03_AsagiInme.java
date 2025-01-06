package tests.K13_actionsClass.D02_keyboardBasedActions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_AsagiInme extends TestBase_Each {
    @Test
    public void test01(){

        //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //2- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();

        //3- videoyu izlemek icin Play tusuna basin

        // video'nun bir iframe icinde oldugunu farkettik
        // once iframe'i kaydedip, iframe'e gecis yapmamiz gerekir

        WebElement videoIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(videoIframe);

        driver.findElement(By.xpath("//button[@title='Play']"))
                .click();

        ReusableMethods.bekle(12);




    }
}
