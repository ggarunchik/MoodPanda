package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;

import static com.codeborne.selenide.Selenide.$;

public class MyDiaryPage extends BasePage {

    @Step("Opening page")
    public MyDiaryPage openPage() {
        return null;
    }

    @Step("Verifying is page opened")
    public MyDiaryPage isPageOpened() {
        $(By.id("ContentPlaceHolderContent_MyMoodPandaNav1_UserStats")).waitUntil(Condition.visible, 30000);
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
