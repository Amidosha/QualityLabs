package Mail.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static Mail.config.ConfigHelper.webConfig;

public class NavigatorPage {

    /**
     * Блок с полями для ввода логина и пароля
     */
    public NavigatorPage autorizationBlock() {
        step("Проверка блока с полями логина и пароля", () -> {
            open(webConfig().webUrl());
            $x(("//div[@data-testid='mailbox']")).shouldBe(visible);
        });
        return this;
    }

    /**
     * Окно нового письма.
     */
    public NavigatorPage newWindowsMail() {
        step("Форма нового письма открыта", () ->
                $(".compose-app__compose").shouldBe(visible));
        return this;
    }

    /**
     * Кнопка написать письмо.
     */
    public NavigatorPage buttonWriteMail() {
        step("Нажатие кнопки написать письмо", () ->
                $x(("//span[@class='compose-button__txt']")).click());
        return this;
    }


    /**
     * Кнопка отправить письмо.
     */
    public NavigatorPage sendButton() {
        step("Нажатие кнопки отправить письмо", () -> {
                $("span[title='Отправить']").click();
        $x(("//div[@class='layer-sent-page']")).shouldBe(visible);
        });
        return this;
    }
}
