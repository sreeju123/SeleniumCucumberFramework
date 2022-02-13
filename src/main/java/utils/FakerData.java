package utils;

import com.github.javafaker.Faker;

/**
 * @author Sreej
 */
public class FakerData {

    public static String setEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String setFirstName() {
        return new Faker().name().firstName();
    }

    public static String setLastName() {
        return new Faker().name().lastName();
    }

    public static String setCompanyName() {
        return new Faker().company().name();
    }

}
