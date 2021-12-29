package io.unity.autoweb.random;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class get_data {
    static Faker faker = null;

    get_data() {
        faker = new Faker();

    }

    public static String random_alpha_numeric_string(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String random_alphabetic_string(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String random_numeric_string(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String email() {
        return faker.name().username() + "@mailinator.com";
    }

    public static String first_name() {
        return faker.name().firstName();
    }

    public static String last_name() {
        return faker.name().lastName();
    }


}
