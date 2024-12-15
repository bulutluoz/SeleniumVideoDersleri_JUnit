package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String dosyaYoluDownloadsDeneme = "/Users/ahmetbulutluoz/Downloads/deneme.txt";

        /*
            /Users/ahmetbulutluoz       /Users/ahmetbulutluoz        /Downloads/deneme.txt
            \\Users\\Cansu              C:\Users\Cansu               \\Downloads\\deneme.txt
            C:\\Users\\Hamza            C:\Users\Hamza               \\Downloads\\deneme.txt
            C:\\Users\\coban            C:\Users\coban               \\Downloads\\deneme.txt
            C:\\Users\\GS               C:\Users\GS                  \\Downloads\\deneme.txt
         */

        System.out.println(    System.getProperty("user.home")    ); //   /Users/ahmetbulutluoz

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        /*
            eger dosya yolunu normal olarak yazarsak
            /Users/ahmetbulutluoz/Downloads/deneme.txt
            sadece dosya yolunu olusturan kisinin bilgisayarinda calisir
            baska bilgisayarlarda calismaz

            Java ortak calisabilmemiz icin
            her kisinin bilgisayarinda farkli olan bastaki kismi
            alabilecegimiz bir kod hazirlamistir

            herkeste farkli olan kisim  :  /Users/ahmetbulutluoz
            herkeste ortak olan kisim   :  /Downloads/deneme.txt


         */

        String dinamikDownloadsDosyaYoluDeneme = System.getProperty("user.home") + "/Downloads/deneme.txt";

        Assertions.assertTrue( Files.exists( Paths.get(dinamikDownloadsDosyaYoluDeneme)) );


        // K15 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin

        String dosyaYoluProjedekiDeneme = "/Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Wise_SeleniumVideoDersleri_JUnit" +
                                            "/src/test/java/tests/K15_fileTestleri/deneme.txt";

        System.out.println( System.getProperty("user.dir"));
        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Wise_SeleniumVideoDersleri_JUnit



        /*
             /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team148_JUnit/src/test/java/day09_actionsClass_fileTestleri/deneme.txt

             herkeste farkli olan kisim :    /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team148_JUnit
             herkeste ayni olan kisim   :    /src/test/java/day09_actionsClass_fileTestleri/deneme.txt
         */

        String dinamikDosyaYoluProjedekiDeneme = System.getProperty("user.dir") +
                                                 "/src/test/java/tests/K15_fileTestleri/deneme.txt";


        Assertions.assertTrue( Files.exists(Paths.get(dinamikDosyaYoluProjedekiDeneme)));

    }
}
