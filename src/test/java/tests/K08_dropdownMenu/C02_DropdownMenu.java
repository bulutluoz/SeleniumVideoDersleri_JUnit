package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C02_DropdownMenu extends TestBase_Each {

    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunun 4 olduğunu test edin



    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement ddmElementi = driver.findElement(By.id("dropdown"));
        Select select = new Select(ddmElementi);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);

        System.out.println("index ile secenek 1 : "+ select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("Value ile secenek 2 : "+ select.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("Visible text ile secenek 1 : "+ select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın

            // 1.alternatif tum listeyi text olarak yazdirma
        System.out.println("Webelement'ten tum liste : \n"+ ddmElementi.getText());

        // 2.alternatif, Reusable class'daki String listeye cevirme method'unu kullanalim
        System.out.println("ReusableMethods ile liste : " + ReusableMethods.stringListeDondur(select.getOptions()));


        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedMenuBoyutu = 4;
        int actualMenuBoyutu = select.getOptions().size();

        Assertions.assertEquals(expectedMenuBoyutu,actualMenuBoyutu);
        //Expected :4
        //Actual   :3

        ReusableMethods.bekle(1);
    }
}
