package Mail.tests.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import Mail.pages.AuthorizationPage;
import Mail.tests.TestBase;

import static Mail.config.ConfigHelper.webConfig;

public class SendMailNewTests extends TestBase {

    @Test
    @Tag("mail")
    @DisplayName("Отправка письма с почтового ящика mail.ru")
    void mailSend() {
        navigatorPage
                .autorizationBlock();
        AuthorizationPage.openUrlWithAuthorizationUI(webConfig().loginMail(), webConfig().passwordMail());
        navigatorPage
                .buttonWriteMail()
                .newWindowsMail();
        locatorsPage
                .typeEmail()
                .typeThemes()
                .typeText();
        navigatorPage
                .sendButton();
    }
}
