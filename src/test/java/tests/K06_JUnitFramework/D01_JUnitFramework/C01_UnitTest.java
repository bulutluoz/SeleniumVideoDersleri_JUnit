package tests.K06_JUnitFramework.D01_JUnitFramework;

import java.util.Random;

public class C01_UnitTest {

    public static void main(String[] args) {

        // verilen bir sayi 3 basamakli pozitif bir sayi ise true
        //                  3 basamakli pozitif bir sayi degilse false
        // donduren bir method olusturun


            ucBasamakliPozitifSayiTrueDonmeli();
            ikiBasamakliPozitifSayiFalseDonmeli();
            binVeyaDahaBuyukPozitifSayilarFalseDonmeli();
            negatifSayilarFalseDonmeli();

    }

    public static boolean sayiyiKontrolEt(int sayi){

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



    public static void ucBasamakliPozitifSayiTrueDonmeli(){
        // - verilen sayi pozitif 3 basamakli sayi ise expectedSonuc = true
        //   100 - 999

        Random random = new Random();
        int denenecekSayi = random.nextInt(899) + 100;

        boolean methodSonucu = sayiyiKontrolEt(denenecekSayi);

        if (methodSonucu){
            System.out.println("ucBasamakliPozitifSayiTrueDonmeli methodu PASSED");
        } else System.out.println("ucBasamakliPozitifSayiTrueDonmeli methodu FAILED");
    }

    public static void ikiBasamakliPozitifSayiFalseDonmeli(){
        // - verilen sayi pozitif 100'den kucuk bir sayi ise expectedSonuc = false
        //   1 - 99
        Random random = new Random();
        int denenecekSayi = random.nextInt(99);

        boolean methodSonucu = sayiyiKontrolEt(denenecekSayi);

        if (!methodSonucu){ // methodSonucu == false
            System.out.println("ikiBasamakliPozitifSayiFalseDonmeli testi PASSED");
        } else System.out.println("ikiBasamakliPozitifSayiFalseDonmeli testi FAILED");

    }

    public static void binVeyaDahaBuyukPozitifSayilarFalseDonmeli(){
        // - verilen sayi pozitif 999'dan buyuk bir sayi ise expectedSonuc = false
        //   1000 - .....

        Random random = new Random();
        int denenecekSayi = random.nextInt(99999999)+ 1000;

        boolean methodSonucu = sayiyiKontrolEt(denenecekSayi);

        if (!methodSonucu){ // methodSonucu == false
            System.out.println("binVeyaDahaBuyukPozitifSayilarFalseDonmeli testi PASSED");
        } else System.out.println("binVeyaDahaBuyukPozitifSayilarFalseDonmeli testi FAILED");


    }

    public static void negatifSayilarFalseDonmeli(){
        // - verilen sayi negatif bir sayi ise expectedSonuc = false
        //  - ..... - 0

        Random random = new Random();
        int denenecekSayi = (random.nextInt(99999999) + 1 ) * (-1);

        boolean methodSonucu = sayiyiKontrolEt(denenecekSayi);

        if (!methodSonucu){ // methodSonucu == false
            System.out.println("negatifSayilarFalseDonmeli testi PASSED");
        } else System.out.println("negatifSayilarFalseDonmeli testi FAILED");





    }


}
