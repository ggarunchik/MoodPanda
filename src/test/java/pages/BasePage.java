package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    WebDriver driver;

    public abstract BasePage openPage();
    public abstract BasePage isPageOpened();
}
