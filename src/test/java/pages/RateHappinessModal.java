package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateHappinessModal extends BaseRateModal {
    By SLIDER_CSS = By.cssSelector(".ui-slider-handle");
    By UPDATE_BUTTON_CSS = By.cssSelector(".ButtonUpdate");
    By MY_DIARY_BUTTON_CSS = By.cssSelector(".ButtonMyDiary");

    public RateHappinessModal isModalOpened() {
        $(UPDATE_BUTTON_CSS).waitUntil(Condition.visible, 30000);
        return this;
    }

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
        $(UPDATE_BUTTON_CSS).click();
        return this;
    }

    public MyDiaryPage goToMyDiary() {
        $(MY_DIARY_BUTTON_CSS).click();
        MyDiaryPage myDiaryPage = new MyDiaryPage();
        myDiaryPage.isPageOpened();
        return myDiaryPage;
    }

}
