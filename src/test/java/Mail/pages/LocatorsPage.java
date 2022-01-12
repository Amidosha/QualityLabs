package Mail.pages;

import Mail.utils.RandomUtils;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class LocatorsPage {

    Faker faker = new Faker();

    private final SelenideElement emailInput = $x(("//label[@class='container--zU301']//input"));
    private final SelenideElement themesInput = $x(("//div[@class='subject__wrapper--2mk6m']//input"));
    private final SelenideElement textInput = $("div[role='textbox']");


    public LocatorsPage typeEmail() {
        step("Заполнить поле email", () ->
                emailInput.setValue(faker.internet().emailAddress()));
        return this;
    }

    public LocatorsPage typeThemes() {
        step("Заполнить поле тема", () ->
                themesInput.setValue(RandomUtils.getRandomString(10)));
        return this;
    }

    public LocatorsPage typeText() {
        step("Заполнить поле текст письма", () ->
        textInput.setValue(RandomUtils.getRandomMessage(5, 10)));
        return this;
    }
}
