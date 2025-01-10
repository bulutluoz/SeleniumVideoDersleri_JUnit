package tests.K07_CheckBox_RadioButton_TestBase;


import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class C03_TestBaseKullanimi extends TestBase_Each {

    /*
        Java'da OOP consept'in en buyuk avantaji REUSABILITY'dir

        @BeforeEach - @AfterEach
        @BeforeAll - @AfterAll
        method'lari her class'da ayni sekilde yeniden yazmak yerine
        baska bir class'da olusturabiliriz

        Baska bir class'da bulunan class uyelerine
        ulasmanin en kisa yolu inheritance'dir

        biz de utilities altinda TestBase class'i olusturup
        before ve after method'larini o class'lara koyabiliriz

     */

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(2);

    }

    @Test
    public void test02(){

        driver.get("https://www.wisequarter.com");
        ReusableMethods.bekle(2);

    }




}
