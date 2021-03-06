package pages;

import com.codeborne.selenide.Condition;
import elements.Dropdown;
import elements.TextInput;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EditProfilePage extends BasePage {

    public static final String UPDATE_BUTTON_XPATH = "ContentPlaceHolderContent_ButtonSave";
    public static final String SUCCESS_ALERT_ID = "ContentPlaceHolderContent_MessageSuccess";
    public static final String ERROR_ALERT_CSS = "[class='alert alert-dismissable alert-danger']";

    public EditProfilePage openPage() {
        open("https://moodpanda.com/Account/");
        isPageOpened();
        return this;
    }

    public EditProfilePage isPageOpened() {
        $(By.id(UPDATE_BUTTON_XPATH)).waitUntil(Condition.visible, 30000);
        return this;
    }

    public EditProfilePage editPersonalDetails(String firstNme, String surname, String yearOfBirth, String gender) {
        new TextInput("First Name").write(firstNme);
        new TextInput("Surname Initial").write(surname);
        new Dropdown("Year of Birth").clickOnDropdownAndSelectElement(yearOfBirth);
        new Dropdown("Gender").clickOnDropdownAndSelectElement(gender);
        new TextInput("New Password [optional]").clear();
        $(By.id(UPDATE_BUTTON_XPATH)).click();
        verifySuccessAlert();
        return this;
    }

    public EditProfilePage editLoginDetails(String email, String password, String confirmPassword) {
        new TextInput("Email Address").write(email);
        new TextInput("New Password [optional]").write(password);
        new TextInput("Confirm New Password").write(confirmPassword);
        $(By.id(UPDATE_BUTTON_XPATH)).click();
        verifySuccessAlert();
        return this;
    }

    public EditProfilePage saveInfoWithOptionalPasswordError(String password, String errorMessage) {
        new TextInput("New Password [optional]").write(password);
        $(By.id(UPDATE_BUTTON_XPATH)).click();
        verifyErrorAlert(errorMessage);
        return this;
    }

    public EditProfilePage verifySuccessAlert() {
        $(By.id(SUCCESS_ALERT_ID)).waitUntil(Condition.visible, 20000);
        $(By.id(SUCCESS_ALERT_ID)).shouldHave(text("Your changes were saved"));
        return this;
    }

    public EditProfilePage verifyErrorAlert(String alertMessage) {
        $(By.cssSelector(ERROR_ALERT_CSS)).waitUntil(Condition.visible, 20000);
        $(By.cssSelector(ERROR_ALERT_CSS)).shouldHave(text(alertMessage));
        return this;
    }

}
