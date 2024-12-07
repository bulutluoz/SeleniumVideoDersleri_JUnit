package tests.K07_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_CheckBoxTesti {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }



    @Test
    public void checkBoxTesti(){
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));

        sirtAgrisiCheckBox.click();
        carpintiCheckBox.click();
        ReusableMethods.bekle(1);
        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());


        //	d. Seker ve Epilepsi checkbox’larininin seçili
        //     olmadigini test edin

        WebElement sekerCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckbox.isSelected());
        Assertions.assertFalse(epilepsiCheckbox.isSelected());

        ReusableMethods.bekle(1);
    }
}
