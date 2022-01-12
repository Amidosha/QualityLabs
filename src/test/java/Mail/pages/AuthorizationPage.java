package Mail.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AuthorizationPage {


    public static void openUrlWithAuthorizationUI(String login, String password) {
        step("Авторизация", () -> {
            $x(("//input[@name='login']")).setValue(login);
            $x(("//button[@data-testid='enter-password']")).click();
            $x(("//input[@name='password']")).setValue(password);
            $x(("//button[@data-testid='login-to-mail']")).click();
        });
    }

}