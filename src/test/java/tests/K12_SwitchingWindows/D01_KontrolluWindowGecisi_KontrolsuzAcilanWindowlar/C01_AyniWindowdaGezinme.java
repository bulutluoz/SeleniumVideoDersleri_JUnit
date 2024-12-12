package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;


public class C01_AyniWindowdaGezinme extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Testotomasyonu Window handle : " + driver.getWindowHandle());
        System.out.println("Testotomasyonu Url : " + driver.getCurrentUrl());

        // Electronics linkini tiklayin
        driver.findElement(By.xpath("(//*[@class='has-sub'])[1]"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Electronics Window handle : " + driver.getWindowHandle());
        System.out.println("Electronics Url : " + driver.getCurrentUrl());

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Ilk urun Window handle : " + driver.getWindowHandle());
        System.out.println("Ilk urun Url : " + driver.getCurrentUrl());

        // account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Account Window handle : " + driver.getWindowHandle());
        System.out.println("Account Url : " + driver.getCurrentUrl());

    }
}
