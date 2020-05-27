package pages;

import com.codeborne.selenide.Condition;
import elements.Dropdown;
import elements.TextInput;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EditProfilePage extends BasePage {

    public static final String UPDATE_BUTTON_XPATH = "ContentPlaceHolderContent_ButtonSave";
    public static final String SUCCESS_ALERT_ID = "ContentPlaceHolderContent_MessageSuccess";
    public static final String ERROR_ALERT_CSS = "[class='alert alert-dismissable alert-danger']";

    @Step("Opening Edit Profile Page")
    public EditProfilePage openPage() {
        open("https://moodpanda.com/Account/");
        isPageOpened();
        return this;
    }

    @Step("Verifying is Edit Page opened")
    public EditProfilePage isPageOpened() {
        $(By.id(UPDATE_BUTTON_XPATH)).waitUntil(Condition.visible, 30000);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Editing personal details to: '{firstNme}','{surname}','{yearOfBirth}','{gender}'")
    public EditProfilePage editPersonalDetails(String firstNme, String surname, String yearOfBirth, String gender) {
        new TextInput("First Name").write(firstNme);
        new TextInput("Surname Initial").write(surname);
        new Dropdown("Year of Birth").clickOnDropdownAndSelectElement(yearOfBirth);
        new Dropdown("Gender").clickOnDropdownAndSelectElement(gender);
        new TextInput("New Password [optional]").clear();
        AllureUtils.takeScreenshot(driver);
        $(By.id(UPDATE_BUTTON_XPATH)).click();
        verifySuccessAlert();
        return this;
    }

    @Step("Editing Login details to: '{email}','{password}','{confirmPassword}'")
    public EditProfilePage editLoginDetails(String email, String password, String confirmPassword) {
        new TextInput("Email Address").write(email);
        new TextInput("New Password [optional]").write(password);
        new TextInput("Confirm New Password").write(confirmPassword);
        AllureUtils.takeScreenshot(driver);
        $(By.id(UPDATE_BUTTON_XPATH)).click();
        verifySuccessAlert();
        return this;
    }

    @Step("Saving personal data without optional password")
    public EditProfilePage saveInfoWithOptionalPasswordError(String password, String errorMessage) {
        new TextInput("New Password [optional]").write(password);
        AllureUtils.takeScreenshot(driver);
        $(By.id(UPDATE_BUTTON_XPATH)).click();
        verifyErrorAlert(errorMessage);
        return this;
    }

    @Step("Verifying success alert")
    public EditProfilePage verifySuccessAlert() {
        $(By.id(SUCCESS_ALERT_ID)).waitUntil(Condition.visible, 20000);
        $(By.id(SUCCESS_ALERT_ID)).shouldHave(text("Your changes were saved"));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Verifying error alert")
    public EditProfilePage verifyErrorAlert(String alertMessage) {
        $(By.cssSelector(ERROR_ALERT_CSS)).waitUntil(Condition.visible, 20000);
        $(By.cssSelector(ERROR_ALERT_CSS)).shouldHave(text(alertMessage));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}
