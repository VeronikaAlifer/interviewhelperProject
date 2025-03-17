package com.demoqaPrTests.utility;

import java.time.LocalDate;
import java.util.Random;

public class UserGenerator {

    public static String getRandomFirstName() {
        return "Name_" + getRandomValue();
    }

    public static String getRandomLastName() {
        return "LastName_" + getRandomValue();
    }

    public static String getRandomEmail() {
        return getRandomValue() + "@gmail.com";
    }

    public static String getRandomPhone() {
        return "489" + getRandomValue();
    }

    public static String getDateOfBirth() {
        return getRandomDateOfBirth().toString();
    }

    private static int getRandomValue() {
        return (int) (Math.random() * 90000000);
    }


    private static LocalDate getRandomDateOfBirth() {
        Random random = new Random();
        int minAge = 18;
        int maxAge = 90;

        LocalDate currentDate = LocalDate.now();
        int randomYear = random.nextInt(minAge, maxAge);

        int birthYear = currentDate.getYear() - randomYear;

        int birthMonth = random.nextInt(1, 13);
        int birthDay = random.nextInt(1, 29);

        return LocalDate.of(birthYear, birthMonth, birthDay);
    }
}
