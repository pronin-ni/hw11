package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static pages.TestData.*;

public class PracticeFormTest extends TestBase {

    @Test
    @Tag("practiceForm")
    void successfulRegistrationWithRequiredFieldsTest(){
        registrationPage.openPage().removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setPhoneNumber(phoneNumber)
                .setGender(gender)
                .submitClick().checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail).
                checkResult("Gender", gender);
    }
    @Test
    @Tag("practiceForm")
    void successfulRegistrationWithAllFieldsTest(){
        registrationPage.openPage().removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitClick()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail).
                checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
    @Test
    @Tag("practiceForm")
    void registrationFailsWithoutRequiredFieldsTest(){
        registrationPage.openPage().removeBanners().setUserEmail(userEmail)
        .setPhoneNumber(phoneNumber)
        .submitClick().resultTableNotAppear().checkFirstNameBorderColor("rgb(220, 53, 69)");
    }
}
