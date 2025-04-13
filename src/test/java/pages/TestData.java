package pages;

import com.github.javafaker.Faker;

public class TestData {
    private static final Faker faker = new Faker();
    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();
    public static final String userEmail = faker.internet().emailAddress();
    public static final String gender = faker.demographic().sex();
    public static final String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static final String dayOfBirth = String.format("%02d", faker.number().numberBetween(1,28));
    public static final String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public static final String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2024));
    public static final String subjects = faker.options().option("Maths", "English", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics");
    public static final String hobbies = faker.options().option("Sports", "Reading", "Music");
    public static final String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static final String city = randomCity();
    public static final String address = faker.address().fullAddress();
    public static final String picture = "cat.jpeg";

    private static String randomCity() {
        return switch (TestData.state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jodhpur");
            default -> throw new IllegalArgumentException("Неизвестный штат: " + TestData.state);
        };
    }
}
