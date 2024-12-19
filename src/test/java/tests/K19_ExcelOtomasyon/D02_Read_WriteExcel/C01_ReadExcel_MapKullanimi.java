package tests.K19_ExcelOtomasyon.D02_Read_WriteExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel_MapKullanimi {

    @Test
    public void test01() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String excelDosyaYolu = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        /*
            Eger Ingilizce ulke isimleri ve Turkce baskent isimleri ile
            birden fazla test varsa
            her seferinde for loop yapmak yerine
            data'lara daha rahat ulasabilecegimiz bir Java objesi olan Map'e kaydedebiliriz
            Ingilizce ulke isimleri ==> key
            Turkce baskent isimleri ==> value
         */

        Map<String, String> ulkelerMap = new TreeMap<>();

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i)
                                                        .getCell(0)
                                                        .getStringCellValue();

            String satirdakiTurkceBaskentIsmi = sayfa1.getRow(i)
                                                        .getCell(3)
                                                        .getStringCellValue();


            ulkelerMap.put(satirdakiIngilizceUlkeIsmi,satirdakiTurkceBaskentIsmi);

        }



        // Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

        String expectedBaskentIsmi = "Amsterdam";
        String actualBaskentIsmi = ulkelerMap.get("Netherlands");

        Assertions.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);


        // Turkce baskent isimlerinde Ankara bulundugunu test edin

        Assertions.assertTrue(ulkelerMap.containsValue("Ankara"));



        // Ulkeler excel'inde ingilizce ismi Ghana olan bir ulke var mi test edin

        Assertions.assertTrue(ulkelerMap.containsKey("Ghana"));

    }
}
