package tests.K11_iFrames;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C02_IFrame extends TestBase_Each {

    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) Cookies cikarsa kabul edin
        ReusableMethods.bekle(10);
        //3) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));

        System.out.println("Sayfadaki iframe sayisi : " + iframeList.size());

        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        //   once iFrame gecis yapalim

        driver.switchTo().frame( iframeList.get(0) );
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();


        //5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //6) ikinci iframe'deki (Jmeter Made Easy) linke
        //   (https://www.guru99.com/live-selenium-project.html) tıklayınız

        // once 2.iframe'e gecis yapmaliyiz
        driver.switchTo().frame( iframeList.get(1)   );

        driver.findElement(By.tagName("a")).click();



        ReusableMethods.bekle(5);

    }
}
