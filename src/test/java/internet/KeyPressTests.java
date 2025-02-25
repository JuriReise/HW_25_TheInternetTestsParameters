package internet;

import internet.core.TestBase;
import internet.pages.KeyPressPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static internet.pages.HomePage.HOME_PAGE_URL;

public class KeyPressTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/key_presses");
    }

    @Test
    @Parameters({"key"})
    public void keyPressTest(String key) {
        new KeyPressPage(app.driver, app.wait)
                .pressKey(key)
                .verifyKeyPressResult(key);
    }
}
