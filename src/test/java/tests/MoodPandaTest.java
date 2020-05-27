package tests;

import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test
    public void login() {
        loginPage
                .openPage()
                .login("testtetst@mail.com", "test123")
                .openRateHappinessModal()
                .updateMood(1)
                .goToMyDiary();
    }


}
