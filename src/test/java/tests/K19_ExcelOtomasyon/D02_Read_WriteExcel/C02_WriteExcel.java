package tests.K19_ExcelOtomasyon.D02_Read_WriteExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTesti() throws IOException {


        //3) Adimlari takip ederek Sayfa1’e kadar gidelim
        String excelDosyaYolu = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");


        //4) 1.satir 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(250000);

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(54000);



        // bos olan ilk satira
        // ingilizce ulke ismi JavaRepublic  ingilizce baskent olarak Selenium yazdiralim

        int ilkBosSatirIndex = sayfa1.getLastRowNum() + 1;

        sayfa1.createRow(ilkBosSatirIndex);

        sayfa1.getRow(ilkBosSatirIndex).createCell(0).setCellValue("Java Republic");
        sayfa1.getRow(ilkBosSatirIndex).createCell(1).setCellValue("Selenium");



        //9) Dosyayi kaydedelim
        /*
            Biz yaptigimiz tum degisikleri
            workbook uzerinde yaptik

            workbook objesi fiziki excel dosyasinda
            FileInputStream ile aldigimiz bilgilerle olusturuldu
            ve excel'in bir kopyasi oldu

            eger workbook uzerinde yaptigimiz degisiklikleri
            excel dosyasina islemek istiyorsak
            kaydetme islemi yapmamiz gerekir.

            ONEMLI NOT :
            workbook'da yaptigimiz degisiklikleri
            excel'e kaydetme islemi yapmadan once
            excel dosyasinin kapali oldugundan emin OLMALISINIZ.
         */
        FileOutputStream fileOutputStream = new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);


        //10)Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();


    }


}
