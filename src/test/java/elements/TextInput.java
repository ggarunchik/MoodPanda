package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class TextInput {
    private static final String INPUT_LOCATOR_XPATH = "//*[contains(text(),'%s')]/..//input";
    WebElement element;

    public TextInput(String label) {
        element = $(By.xpath(String.format(INPUT_LOCATOR_XPATH, label)));
    }

    public void write(String text) {
        if (null != text) {
            if(element.getText() != null) {
               clear();
            }
            element.sendKeys(text);
        } else {
           clear();
        }
    }

    public void clear() {
        element.clear();
    }
}
