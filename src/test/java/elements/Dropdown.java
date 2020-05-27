package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class Dropdown {
    private static final String DROPDOWN_LOCATOR_XPATH = "//*[contains(text(),'%s')]/..//select";
    private static final String SELECTION_LOCATOR_XPATH = "//option[text() ='%s']";
    WebElement element;

    public Dropdown(String label) {
        element = $(By.xpath(String.format(DROPDOWN_LOCATOR_XPATH, label)));
    }

    public void clickOnDropdownAndSelectElement(String elementName) {
        element.click();
        selectElement(elementName);
    }

    public void selectElement(String elementName) {
        $(By.xpath(String.format(SELECTION_LOCATOR_XPATH, elementName))).click();
    }
}

