package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    @Step("Opening Login page")
    public LoginPage openPage() {
        open("https://moodpanda.com/Login/");
        isPageOpened();
        return this;
    }

    @Step("Verifying is Login page open")
    public LoginPage isPageOpened() {
        $("[alt='MoodPanda Android App on Google Play'").waitUntil(Condition.visible, 30000);
        AllureUtils.takeScreenshot();
        return this;
    }

    @Step("Logging with user '{email}', {password}")
    public FeedPage login(String email, String password) {
        sleep(2000);
        $(By.id("ContentPlaceHolderContent_TextBoxEmail")).sendKeys(email);
        $(By.id("ContentPlaceHolderContent_TextBoxPassword")).sendKeys(password);
        AllureUtils.takeScreenshot();
        $(By.id("ContentPlaceHolderContent_ButtonLogin")).click();
        FeedPage feedPage = new FeedPage();
        feedPage.isPageOpened();
        return new FeedPage();
    }
}
