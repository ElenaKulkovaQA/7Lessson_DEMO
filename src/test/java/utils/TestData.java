package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en-GB"));

    public String

            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            invalidUserNumber = faker.internet().password(9, 10),
            month = getRandomMonth(),
            calendarYear = String.format("%s", faker.number().numberBetween(1900, 2014)),
            calendarDay = String.format("%s", faker.number().numberBetween(1, 28)),
            subject = getRandomSubject(),
            hobbies = getRandomHobbies(),
            uploadFile = faker.options().option("2.png", "mountains.jpg"),
            address = faker.address().fullAddress(),
            state = getRandomStates(),
            userCity = getRandomCity();


    String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        return faker.options().option(gender);
    }


    String getRandomMonth() {
        String[] month = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};
        return faker.options().option(month);
    }


    String getRandomSubject() {
        String[] subject = {"English", "Maths", "Arts", "Hindi", "History"};
        return faker.options().option(subject);
    }


    String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    String getRandomStates() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(state);
    }

    public String getRandomCity(String value) {

        if (state.equals("NCR")) userCity = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) userCity = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) userCity = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) userCity = faker.options().option("Jaipur", "Jaiselmer");

        return userCity;
    }

}
