package tests;

import org.testng.annotations.Test;

public class EditProfileTest extends BaseTest {

    @Test
    public void verifyUserCanEditAndSavePersonalInfo() {
        loginPage
                .openPage()
                .login("testtetst@mail.com", "test123");
        editProfilePage
                .openPage()
                .editPersonalDetails("Gleb","C", "1992", "Cis" );
    }

    @Test
    public void verifyUserCanEditAndSaveLoginInfo() {
        loginPage
                .openPage()
                .login("testtetst@mail.com", "test123");
        editProfilePage
                .openPage()
                .editLoginDetails("testtetst@mail.com", "test123", "test123");
    }

    @Test
    public void verifyErrorMessageForMissingPassword() {
        loginPage
                .openPage()
                .login("testtetst@mail.com", "test123");
        editProfilePage
                .openPage()
                .saveInfoWithOptionalPasswordError("123", "New Password and New Password Confirm do not match");
    }




}
