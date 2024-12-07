package tests.K06_JUnitFramework.D01_JUnitFramework;

import java.util.Random;

public class C01_UnitTest {
    public static void main(String[] args) {

        // verilen bir sayi 3 basamakli pozitif bir sayi ise true
        //                  3 basamakli pozitif bir sayi degilse false
        // donduren bir method olusturun

        uygunDegertesti();
        uygunOlmayanDegertesti1();
        uygunOlmayanDegertesti2();
        uygunOlmayanDegertesti3();


    }

    public static boolean ucBasmakliPozitifSayiKontrolEt(int sayi){

        if (sayi>=100 && sayi<=999) return true;
        else return false;

    }


    /*
        Bu method'u test etmek icin true veya false dondurmesi gereken
        sayi araliklarindan farkli testler yapmaliyiz

        ornegin
        - verilen sayi pozitif 3 basamakli sayi ise expectedSonuc = true
        - verilen sayi pozitif 100'den kucuk bir sayi ise expectedSonuc = false
        - verilen sayi pozitif 999'dan buyuk bir sayi ise expectedSonuc = false
        - verilen sayi negatif bir sayi ise expectedSonuc = false
     */


    public static void uygunDegertesti(){
        // - verilen sayi pozitif 3 basamakli sayi ise expectedSonuc = true
        //   100 - 999

        Random random = new Random();
        int sayi = random.nextInt(899) + 100;

        boolean expectedSonuc = true;
        boolean actualSonuc = ucBasmakliPozitifSayiKontrolEt(sayi);

        if (expectedSonuc == actualSonuc) {
            System.out.println("Uygun deger testi PASSED");
        }else System.out.println("Uygun deger testi FAILED");

    }

    public static void uygunOlmayanDegertesti1(){
        // - verilen sayi pozitif 100'den kucuk bir sayi ise expectedSonuc = false
        //   1 - 99

        Random random = new Random();
        int sayi = random.nextInt(98) + 1 ;

        boolean expectedSonuc = false;
        boolean actualSonuc = ucBasmakliPozitifSayiKontrolEt(sayi);

        if (expectedSonuc == actualSonuc) {
            System.out.println("Uygun olmayan deger testi1 PASSED");
        }else System.out.println("Uygun olmayan deger testi1 FAILED");

    }

    public static void uygunOlmayanDegertesti2(){
        // - verilen sayi pozitif 999'dan buyuk bir sayi ise expectedSonuc = false
        //   1000 - .....

        Random random = new Random();
        int sayi = random.nextInt(1000000000) + 1000 ;

        boolean expectedSonuc = false;
        boolean actualSonuc = ucBasmakliPozitifSayiKontrolEt(sayi);

        if (expectedSonuc == actualSonuc) {
            System.out.println("Uygun olmayan deger testi2 PASSED");
        }else System.out.println("Uygun olmayan deger testi2 FAILED");

    }

    public static void uygunOlmayanDegertesti3(){
        // - verilen sayi negatif bir sayi ise expectedSonuc = false
        //  - ..... - 0

        Random random = new Random();
        int sayi = -1 * random.nextInt(1000000000);

        boolean expectedSonuc = false;
        boolean actualSonuc = ucBasmakliPozitifSayiKontrolEt(sayi);

        if (expectedSonuc == actualSonuc) {
            System.out.println("Uygun olmayan deger testi3 PASSED");
        }else System.out.println("Uygun olmayan deger testi3 FAILED");

    }


}
