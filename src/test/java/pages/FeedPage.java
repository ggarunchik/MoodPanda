package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage extends BasePage {

    By updateButton = By.id("LinkUpdate");

    @Step("Opening Feed Page")
    public FeedPage openPage() {
        open("https://moodpanda.com/Feed/");
        isPageOpened();
        return this;
    }

    @Step("Verifying is Feed Page open")
    public FeedPage isPageOpened() {
        $(byText("Control my privacy")).waitUntil(Condition.visible, 30000);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Opening Rate Happiness Modal")
    public RateHappinessModal openRateHappinessModal() {
        $(updateButton).click();
        RateHappinessModal rateHappinessModal = new RateHappinessModal();
        rateHappinessModal.isModalOpened();
        AllureUtils.takeScreenshot(driver);
        return rateHappinessModal;
    }
}
