package Mail.drivers;

import Mail.config.ConfigHelper;
import Mail.config.RemoteConfig;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class DriverConfig {

    private static RemoteConfig credentials = ConfigFactory.create(RemoteConfig.class);
    private static String login = credentials.login();
    private static String password = credentials.password();
    private static String selenoidURL = System.getProperty("remoteURL");
    private static String remoteURL = format("https://%s:%s@%s", login, password, selenoidURL);

    public static void configure() {

        Configuration.baseUrl = ConfigHelper.webConfig().webUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--enable-automation");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");


        if (!System.getProperty("remoteURL").equals("")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = remoteURL;
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}










