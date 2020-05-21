package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class MoodPandaTest extends BaseTest {

    @Test
    public void login() {
        loginPage
                .openPage()
                .login("testtetst@mail.com", "user776e6")
                .openRateHappinessModal()
                .updateMood(1)
                .goToMyDiary();
    }
}
