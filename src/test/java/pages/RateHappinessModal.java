package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.AllureUtils;

import static com.codeborne.selenide.Selenide.$;

public class RateHappinessModal extends BaseRateModal {
    By SLIDER_CSS = By.cssSelector(".ui-slider-handle");
    By UPDATE_BUTTON_CSS = By.cssSelector(".ButtonUpdate");
    By MY_DIARY_BUTTON_CSS = By.cssSelector(".ButtonMyDiary");

    @Step("Verifying is Rate Modal opened")
    public RateHappinessModal isModalOpened() {
        $(UPDATE_BUTTON_CSS).waitUntil(Condition.visible, 30000);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Updating mood to '{moodRating}'")
    public RateHappinessModal updateMood(int moodRating) {
        $(SLIDER_CSS).click();
        int currentIntMood = 5;
        int difference = moodRating - currentIntMood;
        Keys arrowValue;
        if (difference > 0) {
            arrowValue = Keys.ARROW_RIGHT;
        } else {
            arrowValue = Keys.ARROW_LEFT;
        }

        for (int i = 0; i < Math.abs(difference) ; i++) {
            $(SLIDER_CSS).sendKeys(arrowValue);
        }
        AllureUtils.takeScreenshot(driver);
        $(UPDATE_BUTTON_CSS).click();
        return this;
    }

    @Step("Opening My Diary screen")
    public MyDiaryPage goToMyDiary() {
        $(MY_DIARY_BUTTON_CSS).click();
        MyDiaryPage myDiaryPage = new MyDiaryPage();
        myDiaryPage.isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return myDiaryPage;
    }

}
