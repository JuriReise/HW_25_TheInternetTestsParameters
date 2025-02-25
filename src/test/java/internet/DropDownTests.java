package internet;

import internet.core.TestBase;
import internet.pages.DropdownPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static internet.pages.HomePage.HOME_PAGE_URL;

public class DropDownTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/dropdown");
    }

    @Test
    @Parameters({"optionByName"})
    public void selectDropdownOptionByNamePositiveTest(String optionByName) {
        new DropdownPage(app.driver, app.wait)
                .selectOptionByText(optionByName)
                .verifySelectedOption(optionByName);
    }

    @Test
    @Parameters({"optionByValue"})
    public void selectDropdownOptionByValuePositiveTest(String optionByValue) {
        new DropdownPage(app.driver, app.wait)
                .selectOptionByValue(optionByValue)
                .verifySelectedOption(optionByValue);
    }

    @Test
    @Parameters({"optionByIndex"})
    public void selectDropdownOptionByIndexPositiveTest(int optionByIndex) {
        String option = "Option " + optionByIndex;
        new DropdownPage(app.driver, app.wait)
                .selectOptionByIndex(optionByIndex)
                .verifySelectedOption(option);
    }
}
