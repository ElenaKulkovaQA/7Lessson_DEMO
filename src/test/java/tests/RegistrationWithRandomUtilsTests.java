package tests;

import org.junit.jupiter.api.Test;
import pages.components.CheckResultComponent;
import pages.components.RegistrationPage;
import utils.TestData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithRandomUtilsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultComponent results = new CheckResultComponent();
    TestData testData = new TestData();

    @Test
    void fillFormTests() {

        registrationPage.openPage();
        registrationPage.closeBanner();

        registrationPage
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.birthday.get("day"), testData.birthday.get("month"), testData.birthday.get("year"))
                .uploadPicture(testData.uploadFile)
                .setAddress(testData.address)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobbies)
                .setState(testData.state)
                .setCity(testData.userCity);


        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        String fullName = testData.firstName + " " + testData.lastName;
        String fulldate = testData.birthday.get("day") + " " + testData.birthday.get("month") + "," + testData.birthday.get("year");
        String AbsolutAddress = testData.state + " " + testData.userCity;

        results
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", fulldate)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.uploadFile)
                .checkResult("Address", testData.address)
                .checkResult("State and City", AbsolutAddress);

    }
}