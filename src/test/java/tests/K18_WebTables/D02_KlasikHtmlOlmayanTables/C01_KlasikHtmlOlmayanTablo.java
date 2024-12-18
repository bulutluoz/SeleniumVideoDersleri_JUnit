package tests.K18_WebTables.D02_KlasikHtmlOlmayanTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikHtmlOlmayanTablo extends TestBase_Each {

    @Test
    public void test01(){
        //       //*[@role='trow'][4]/*[@role='tdata'][1]

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));

        System.out.println("Basliklar : " + ReusableMethods.stringListeDondur(baslikElementleriList));

        //  3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslikElementleriList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDataListesi = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));
        System.out.println("Tablodaki tum datalar : " +
                            ReusableMethods.stringListeDondur(tumDataListesi));


        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki data sayisi : " + tumDataListesi.size());

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("Satir sayisi : " + satirElementleriList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //     WebTablo'da sutun yapisi yoktur
        //     Herhangi bir satirdaki data sayisina bakabiliriz
        //     Yukarda kaydettigimiz icin baslik sayisini alalim
        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        //     WebTablo'da sutun yapisi yoktur
        //     3.sutun yerine, her satirdaki 3.datayi alabiliriz
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));

        //10. Bir method olusturun,
        //    Test method'undan satir ve sutun verildiginde datayi dondursun
        System.out.println( getCellData(1,2) ); // Electronics

        System.out.println( getCellData(1,3) ); // $399.00

        System.out.println( getCellData(2,1) ); // Medium 25 L Laptop Backpack

        System.out.println( getCellData(3,4) ); // Go
        
        //  9. Tabloda "Category" si Furniture olan urunun fiyatini yazdirin
        //     satirlari tek tek dolasip, istenen bilgiyi kontrol etmeli
        //     ve sarti saglayanlar icin yazdirilmasi istenen bilgiyi yazdirmaliyiz
        System.out.println("=====Kategoriye gore element listesi======");

        for (int i = 1; i <= satirElementleriList.size() ; i++) {

            String satirdakiKategory = getCellData(i,2);

            if (satirdakiKategory.equalsIgnoreCase("Furniture")){

                System.out.println(   getCellData(i,3)  );

            }


        }


    }

    public String getCellData(int satirNo , int sutunNo){

         //           //*[@role='trow'][    4     ]/*[@role='tdata'][   1   ]
        String dinamikXpath = "//*[@role='trow'][" + satirNo + "]/*[@role='tdata'][" + sutunNo + "]";

        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElementi.getText();

    }


}
