package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C02_Actions_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement draggableElementi = driver.findElement(By.id("draggable2"));
        WebElement dropHereKutusuElementi = driver.findElement(By.id("droppable2"));

        //System.out.println("Tasimadan once yazi : " + dropHereKutusuElementi.getText());
        //Tasimadan once yazi : Drop Here

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(draggableElementi,dropHereKutusuElementi)
                .perform();
        //System.out.println("Tasimadiktan sonra yazi : " + dropHereKutusuElementi.getText());
        //Tasimadiktan sonra yazi : Dropped!

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedYazi = "Dropped!";
        String actualYazi = dropHereKutusuElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();


        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptableButonu = driver.findElement(By.id("draggable-nonvalid2"));
        dropHereKutusuElementi = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableButonu,dropHereKutusuElementi)
                .perform();

        //6- “Drop Here” yazisinin degismedigini test edin

        expectedYazi = "Drop Here";
        actualYazi = dropHereKutusuElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);



    }
}
