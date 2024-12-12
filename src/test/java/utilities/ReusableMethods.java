package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {


    public static void bekle(int saniye){

        try {

            Thread.sleep(saniye*1000);

        } catch (InterruptedException e) {
            System.out.println("Thread.sleep komutu calismadi");
        }

    }

    public static List<String> stringListeDondur(List<WebElement> webElementListesi){

        List<String> stringList = new ArrayList<>();

        for ( WebElement eachElement : webElementListesi){

            stringList.add( eachElement.getText() );
        }

        return stringList;
    }

    public static void titleIleWindowGecisYap(WebDriver driver , String hedefWindowunTitle ){
        // 1- acik olan tum window'larin WHD'lerini alip kaydedelim

        Set<String> acikWindowlarinWhdleri = driver.getWindowHandles();

        //   [E7DF36DB6F21C9F3FACD1171BE7A52E1, 0FD94DE1BF431FA11ECEFA6FF529A3CE]

        for (String eachWhd :acikWindowlarinWhdleri){

            driver.switchTo().window(eachWhd);
            // gectigimiz window'un title'ini alip
            // gecmek istedigimiz window'un title'ina esit mi diye kontrol edelim

            if (driver.getTitle().equals(hedefWindowunTitle)){
                //dogru window'dayiz demektir, burada kalabiliriz
                break;
            }

        }
    }

    public static void urlIleWindowGecisYap(WebDriver driver , String hedefUrl){
        // 1.adim acik tum window'larin whd'lerini alip kaydedelim

        Set<String> acikTumWindowsWhdSeti = driver.getWindowHandles();

        for (String eachWhd :acikTumWindowsWhdSeti){

            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                // actual url, hedef url'e esit ise
                // dogru yerdeyiz demektir, orada kalalim
                break;
            }

        }
    }




}
