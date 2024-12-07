package tests.K06_JUnitFramework.D03_Assertions;



public class C01_AssertionsMethodlari {

    /*
        assertEquals(a,b) ile assertTrue(a==b)
        eger assertion PASSED olursa yukardaki method'lar arasinda hic bir fark yoktur

        ANCAAAKKK assertion FAILED oldugunda
        assertEquals(a,b) expected (a) ve actual (b) degerlerini karsilastirip
        aradaki farki otomatik olarak bize gosterir

        ama assertTrue(a==b) kullanildiginda
        sadece true bekliyorduk false oldu der

        Bu sebeple MUMKUN OLDUGU surece assertEquals() kullanmayi tercih ederiz
     */

    int a = 10;
    int b = 20;
    int c = 30;
    String url1 = "https://www.testotomasyonu.com";
    String url2 = "https://www.testotomasyonu.com/";


    public void test01(){
        // c'nin a ile b'nin toplamina esit oldugunu test edin


        // b'nin a ile c'nin toplamina esit oldugunu test edin


        // b'nin a ile c'nin toplamina esit olmadigini test edin



        // url1 ile url2'nin ayni oldugunu test edin


        // url1 ile url2'nin ayni olmadigini test edin


        //url1'in "test" kelimesi icerdigini test edin


        //url1'in "best" kelimesi icermedigini test edin

    }

}
