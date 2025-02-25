package internet.pages;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DropdownPage extends BasePage {
    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    //* 🔹 Выбирает элемент по его отображаемому тексту (тому, что видит пользователь).
    //* 🔹 Работает с текстом, который находится между тегами <option>.
    public DropdownPage selectOptionByText(String optionText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
        System.out.println("✅ Выбрана опция по видимому тексту: " + optionText);
        return this;
    }

    //* 🔹 Выбирает элемент по его атрибуту value.
    //* 🔹 Работает с value="", который обычно используется для идентификации значений.
    public DropdownPage selectOptionByValue(String optionValue) {
        Select select = new Select(dropdown);
        select.selectByValue(optionValue);
        System.out.println("✅ Выбрана опция по ID: " + optionValue);
        return this;
    }

    //* 🔹 Выбирает элемент по его порядковому номеру в списке.
    //* 🔹 Нумерация начинается с 0.
    public DropdownPage selectOptionByIndex(int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);
        System.out.println("✅ Выбрана опция по индексу: " + index);
        return this;
    }

    public DropdownPage verifySelectedOption(String expectedText) {
        //System.out.println(dropdown.getText());
        Select select = new Select(dropdown);
        WebElement selectedOption = select.getFirstSelectedOption();
        //Assert.assertEquals(selectedOption.getText(),expectedText);
        shouldHaveText(selectedOption, expectedText,500);
        System.out.println("✅ Проверена опция: " + selectedOption.getText());
        return this;
    }

}
