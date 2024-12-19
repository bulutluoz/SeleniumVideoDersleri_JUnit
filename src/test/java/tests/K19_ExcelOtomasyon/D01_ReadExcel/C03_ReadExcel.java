package tests.K19_ExcelOtomasyon.D01_ReadExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String excelDosyaYolu = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // 1.satirdaki 2.hucreye gidin ve yazdirin
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)


        // 1.satirdaki 2.hucreyi bir string degiskene atayin
        //	 ve degerinin “Başkent (İngilizce)” oldugunu test edin

        String satir1Hucre2 = sayfa1.getRow(0).getCell(1).getStringCellValue();
        String expectedHucreBilgisi = "Başkent (İngilizce)";

        Assertions.assertEquals(expectedHucreBilgisi,satir1Hucre2);

        // 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin

        expectedHucreBilgisi = "Kabil";
        String satir2Hucre4 = sayfa1.getRow(1).getCell(3).getStringCellValue();

        Assertions.assertEquals(expectedHucreBilgisi,satir2Hucre4);


        // Ulke sayisinin 190 oldugunu test edin

        int actualUlkeSayisi = sayfa1.getLastRowNum() + 1 -1 ;
        int expectedUlkeSayisi = 190;
        /*
            +1  method bize index getiriyor, satir sayisini bulmak icin +1 ekliyoruz
            -1  basta baslik satiri oldugundan satir sayisindan 1 cikartarak ulke sayisini bulabiliriz

         */

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

        // Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin

        int fizikiKullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();

        int expectedKullanilanSatirSayisi = 191;

        Assertions.assertEquals(expectedKullanilanSatirSayisi,fizikiKullanilanSatirSayisi);



        // Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

        /*
            butun satirlari tek tek kontrol edip
            0.index'deki data Netherlands ise 3.index'deki data'nin Amsterdam oldugunu test edelim
         */

        String expectedBaskent = "Amsterdam";

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).getStringCellValue();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Netherlands")){

                String satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).getStringCellValue();
                 Assertions.assertEquals(satirdakiTurkceBaskentIsmi,expectedBaskent);
                 break;
            }


        }

        // Turkce baskent isimlerinde Ankara bulundugunu test edin
        // Turkce baskent isimleri her satirin 3.index'inde
        // bir flag olusturup, her satirdaki baskent ismini kontrol edelim
        // Ankara olan varsa flag'i degistirelim

        boolean ankaraVarMi = false;

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiTurkceBaskentIsmi = sayfa1.getRow(i)
                                                        .getCell(3)
                                                        .getStringCellValue();

            if (satirdakiTurkceBaskentIsmi.equalsIgnoreCase("Ankara")){
                ankaraVarMi = true;
                break;
            }

        }

        Assertions.assertTrue(ankaraVarMi);

        // Turkce baskent isminde A olan ulke sayisini bulun




        // Ingilizce ismi B ile baslayan kac ulke bulundugunu test edin




    }
}
