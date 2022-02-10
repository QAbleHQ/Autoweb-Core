package io.unity.autoweb.random;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class random_data {


    static Faker faker = new Faker(new Locale("en-IND"));

    public static void main(String[] args) {
        System.out.println(random_data.first_name());
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

    public static String time_stamp()
    {
       return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    }


}
