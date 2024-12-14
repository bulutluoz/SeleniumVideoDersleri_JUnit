package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;


public class C04_Actions extends TestBase_Each {

    @Test
    public void test01(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverFirstElementi = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(hoverOverFirstElementi).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"))
                .click();

        //4- Popup mesajini yazdirin
        System.out.println( "alert yazisi : " + driver.switchTo().alert().getText() );

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo()
                .alert()
                .accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldElementi = driver.findElement(By.xpath("(//p)[3]"));

        actions.clickAndHold(clickAndHoldElementi)
                .perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        clickAndHoldElementi = driver.findElement(By.id("click-box"));
        System.out.println("basili tutarken yazi : " + clickAndHoldElementi.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickElementi = driver.findElement(By.id("double-click"));

        //System.out.println("cift click yapilmadan class attribute : " + doubleClickElementi.getAttribute("class"));
        //div-double-click

        actions.doubleClick(doubleClickElementi)
                .perform();


        // cift tiklandigini test edin
        //System.out.println("cift click yapildiktan sonra class attribute : " + doubleClickElementi.getAttribute("class"));
        //div-double-click double

        String expectedClassAttributeDegeri = "div-double-click double";
        String actualClassAttributeDegeri = doubleClickElementi.getAttribute("class");

        Assertions.assertEquals(expectedClassAttributeDegeri,actualClassAttributeDegeri);



    }
}
