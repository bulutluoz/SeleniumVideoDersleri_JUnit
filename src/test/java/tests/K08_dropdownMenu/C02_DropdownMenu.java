package tests.K08_dropdownMenu;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C02_DropdownMenu extends TestBase_Each {

    //● https://testotomasyonu.com/form adresine gidin.
    //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //4. Secilen değerleri konsolda yazdirin
    //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
    //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    @Test
    public void test01(){
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

            // 1.adim : dropdown menuyu locate edip, bir webelement olarak class'da kaydedelim
        WebElement ddmGun = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        // 2.adim : bir select objesi olusturun ve parametre olarak
            //          kullanmak istediginiz dropdown menuyu girin
        Select selectGun = new Select(ddmGun);

            // 3.adim : olusturdugumuz selectGun objesi sayesinde
            //          Select class'indaki hazir method'lar ile istenen islemleri yapabiliriz
        selectGun.selectByIndex(5);

        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ddmAy = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ddmAy);
        selectAy.selectByValue("nisan");

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement ddmYil = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(ddmYil);
        selectYil.selectByVisibleText("1990");

        //4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());


        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        //   Ay dropdown menusunde "Ocak" degerinin bulundugunu test edin

        //1.yontem : dropdown uzerinden olusturdugumuz ayDdm.getText()
        //           menudeki tum ay isimlerini getirir
        System.out.println(ddmAy.getText());
        Assertions.assertTrue(ddmAy.getText().contains("Ocak"));

        // 2.yontem : tum opsiyonlarin yazilarini olusturdugumuz
        //            String bir listeye ekleyebiliriz
        //            sonra list.contains() ile testimizi yapabiliriz
        List<String> ayDdmYazilariList = new ArrayList<>();
        List<WebElement> ayDdmElementleriList = selectAy.getOptions();

        for (WebElement each:ayDdmElementleriList){
            ayDdmYazilariList.add(each.getText());
        }

        System.out.println(ayDdmYazilariList);

        Assertions.assertTrue(ayDdmYazilariList.contains("Ocak"));

        // 3.yontem ReusableMethods class'indaki method'u kullanalim

        Assertions.assertTrue(ReusableMethods.stringListeDondur(selectAy.getOptions()).contains("Ocak"));

        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedMenuBoyutu = 13;
        int actualMenuBoyutu = selectAy.getOptions().size();

        Assertions.assertEquals(expectedMenuBoyutu,actualMenuBoyutu);


    }


}
