package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;


public class C01_DropdownMenu extends TestBase_Each {

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

            // 1.adim dropdown menuyu locate edip kaydedelim
        WebElement ddm = driver.findElement(By.id("dropdown"));
            // 2.adim Select class'indan obje olusturup, parametre olarak ddm'yu girin
        Select select = new Select(ddm);
            // 3.adim olusturulan select objesi ile istenen islemleri yapin

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText()); // Option 1

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");

        System.out.println(select.getFirstSelectedOption().getText()); // Option 2

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");

        System.out.println(select.getFirstSelectedOption().getText()); // Option 1

        //4.Tüm dropdown değerleri(value) yazdırın

            // 1.alternatif tum listeyi text olarak yazdirma
        System.out.println(ddm.getText());
        //    Please select an option
        //    Option 1
        //    Option 2

            // 2.alternatif, Reusable class'daki String listeye cevirme method'unu kullanalim
         List<WebElement> tumOptionElementleriList = select.getOptions();

        System.out.println(ReusableMethods.stringListeDondur(tumOptionElementleriList));

        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedDropdownBoyutu = 4;
        int actualDropdownBoyutu = tumOptionElementleriList.size();

        Assertions.assertEquals(expectedDropdownBoyutu,actualDropdownBoyutu);


    }
}
