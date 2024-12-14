package tests.K14_fakerClass;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C01_FakerClassKullanimi {

    @Test
    public void test01(){

        Faker faker = new Faker();

        System.out.println(faker.lordOfTheRings().character()); // Shelob

        System.out.println(faker.name().firstName()); // Vena
        System.out.println(faker.name().name()); // Emmanuel Ebert DDS
        System.out.println(faker.name().lastName()); // Hegmann
        System.out.println(faker.name().fullName()); // Miquel Feil
        System.out.println(faker.name().nameWithMiddle());// Dimple Ferry Aufderhar
        System.out.println(faker.name().username()); // roselle.emmerich

        System.out.println(faker.address().cityName()); // Lake Horaceview
        System.out.println(faker.address().fullAddress()); // Suite 612 431 Harlan Island, Lindton, CO 40993-5216
        System.out.println(faker.address().city());// Santosside
        System.out.println(faker.address().buildingNumber()); // 37130
        System.out.println(faker.address().country()); // Gabon
        System.out.println(faker.address().countryCode()); // KE
        System.out.println(faker.address().state()); // Pennsylvania
        System.out.println(faker.address().streetName()); // Dickinson Loaf

        System.out.println(faker.internet().password()); // qfzpb6rsmnmva6
        System.out.println(faker.internet().emailAddress()); // maris.osinski@hotmail.com
        System.out.println(faker.internet().safeEmailAddress()); // murray.padberg@example.com
        System.out.println(faker.internet().userAgentAny());





    }
}
