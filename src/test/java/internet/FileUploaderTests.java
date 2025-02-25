package internet;

import internet.core.TestBase;
import internet.pages.FileUploaderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static internet.pages.HomePage.HOME_PAGE_URL;

public class FileUploaderTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/upload");
    }

    @Test
    @Parameters({"filePath"})
    public void fileUploadTest(String filePath) {
        new FileUploaderPage(app.driver, app.wait)
                .uploadFile(filePath)
                .verifyUploadedFileName(filePath);
    }
}
