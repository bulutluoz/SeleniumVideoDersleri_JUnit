package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExistTesti {

    @Test
    public void test01(){

        // K15 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin

        /*
            Selenium'da tum islerimizi WebDriver ile yapiyoruz
            Olusturdugumuz driver objesi bizim adimiza
            istedigimiz tum islemleri yapiyor

            ANNNNCAAAAK WebDriver adindan da anlasilacagi gibi
            Web'de kullanilabilir, bilgisayarimizdaki fiziki dosyalara erisemez

            Bilgisayarimizdaki dosyalara erismek icin Java'dan yardim aliriz
            Java ile dosyaya ulasabilmemiz icin ise
            dosyanin dosyayolunu bilmeliyiz
         */
        String dosyaYoluDeneme = "src/test/java/tests/K15_fileTestleri/deneme.txt";

        System.out.println(Files.exists(Paths.get(dosyaYoluDeneme))); // true

        Assertions.assertTrue( Files.exists(Paths.get(dosyaYoluDeneme))  );


        // K15 package'i altinda deneme1.txt dosyasinin
        // var olmadigini test edin
        String dosyaYoluDeneme1 = "src/test/java/tests/K15_fileTestleri/deneme1.txt";

        System.out.println(Files.exists(Paths.get(dosyaYoluDeneme1))); // false

        Assertions.assertFalse( Files.exists(Paths.get(dosyaYoluDeneme1))  );


        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String dosyaYoluDownloadsDeneme = "/Users/ahmetbulutluoz/Downloads/deneme.txt";

        Assertions.assertTrue( Files.exists(Paths.get(dosyaYoluDownloadsDeneme)) );

    }
}
