package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyDiaryPage extends BasePage {

    public MyDiaryPage openPage() {
        return null;
    }

    public MyDiaryPage isPageOpened() {
        $(By.id("ContentPlaceHolderContent_MyMoodPandaNav1_UserStats")).waitUntil(Condition.visible, 30000);
        return this;
    }
}
