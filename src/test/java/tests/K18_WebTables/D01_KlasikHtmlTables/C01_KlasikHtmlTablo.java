package tests.K18_WebTables.D01_KlasikHtmlTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikHtmlTablo extends TestBase_Each {

    @Test
    public void test01(){


        //1. "https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2. Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body   : \n" + tumBodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String actualTumTablo = tumBodyElementi.getText();

        Assertions.assertTrue(actualTumTablo.contains(expectedTabloIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> tumsatirElementleriList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = tumsatirElementleriList.size();

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin
        System.out.println("==========Tum satirlar===========");
        System.out.println(ReusableMethods.stringListeDondur(tumsatirElementleriList));

        // eger satirlari belirterek yazdirmak isterseniz
        // bir for-each loop ile satirlari yazdirabilirsiniz
        int satirNo = 1;

        for (WebElement eachSatirElementi :tumsatirElementleriList){
            System.out.println(satirNo+". satir : \n" + eachSatirElementi.getText());
            satirNo++;
        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        /*
           Web tablolarinda sutun olarak gruplama yoktur
           body / satirlar / datalar vardir
           eger sutun sayisini bulmak isterseniz
           her hangi bir satirdaki data sayisina bakabiliriz
           ornegin 1.satirdaki datalara bakalim
         */

        List<WebElement> birinciSatirElementleriList = driver.findElements(By.xpath("//tr[1]/td"));

        int expectedSutunsayisi = 4;
        int actualSutunsayisi = birinciSatirElementleriList.size();

        Assertions.assertEquals(expectedSutunsayisi,actualSutunsayisi);

        //7. 3.sutunu yazdirin
        /*
           Web tablolarinda sutun olarak gruplama yoktur
           3.sutun diyemedigimiz icin
           her satirdaki 3.datayi alip sutunu olustururuz
         */

        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tr[*]/td[3]"));
        System.out.println("Ucuncu sutun : " + ReusableMethods.stringListeDondur(ucuncuSutunElementleriList));

        //8. Tablodaki basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//thead//th"));

        System.out.println("Basliklar : " + ReusableMethods.stringListeDondur(baslikElementleriList));

        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println("1.satir, 2.sutun : " + getCellData(1,2)); // Electronics
        System.out.println("2.satir, 2.sutun : " + getCellData(2,2)); // Electronics
        System.out.println("3.satir, 1.sutun : " + getCellData(3,1));
        //Medium 25 L Laptop Backpack For Office/College/Travel (Black, Yellow)
        System.out.println("4.satir, 3.sutun : " + getCellData(4,3)); // $39.00


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        //    4.satir , 2.sutundaki datanin "Furniture" oldugunu test edin

        String expected42 = "Furniture";
        String actual42 = getCellData(4,2);

        Assertions.assertEquals(expected42,actual42);

    }


    public String getCellData(int satirNo, int sutunNo){

        String istenenCellData = "";

        //      //tr[   4    ]/td[   2   ]

        String dinamikXpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));
        istenenCellData = istenenHucreElementi.getText();

        return istenenCellData;
    }


}
