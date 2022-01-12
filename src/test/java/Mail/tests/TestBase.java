
package Mail.tests;

import Mail.helpers.AllureAttachments;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import Mail.drivers.DriverConfig;
import Mail.pages.LocatorsPage;
import Mail.pages.NavigatorPage;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@ExtendWith({AllureJunit5.class})
public class TestBase {

    protected NavigatorPage navigatorPage = new NavigatorPage();
    protected LocatorsPage locatorsPage = new LocatorsPage();

    @BeforeAll
    static void  beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverConfig.configure();
    }

    @AfterEach
    public void afterEach() {
        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();
        closeWebDriver();
    }
}