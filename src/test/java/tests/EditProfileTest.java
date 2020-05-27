package tests;

import org.testng.annotations.Test;

public class EditProfileTest extends BaseTest {

    @Test(description = "Verifying user can eddit personal info")
    public void verifyUserCanEditAndSavePersonalInfo() {
        loginPage
                .openPage()
                .login("testtetst@mail.com", "test123");
        editProfilePage
                .openPage()
                .editPersonalDetails("Gleb","C", "1992", "Cis" );
    }

    @Test(description = "Verifying usr can edit and save log info")
    public void verifyUserCanEditAndSaveLoginInfo() {
        loginPage
                .openPage()
                .login("testtetst@mail.com", "test123");
        editProfilePage
                .openPage()
                .editLoginDetails("testtetst@mail.com", "test123", "test123");
    }

    @Test(description = "Verifying error message for missing password")
    public void verifyErrorMessageForMissingPassword() {
        loginPage
                .openPage()
                .login("testtetst@mail.com", "test123");
        editProfilePage
                .openPage()
                .saveInfoWithOptionalPasswordError("123", "New Password and New Password Confirm do not match");
    }




}
