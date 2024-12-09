package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
}
