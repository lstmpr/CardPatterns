package ru.netology.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import java.time.Duration;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDelivPattern {


    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldSendCorrectForm() {
        $(".input__control[type='text'][placeholder='Город']").setValue(DataGenerator.city());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE); // предварительная чистка поля с датой по умолчанию
        $("[data-test-id='date'] input").setValue(DataGenerator.dateMeeting());
        $("[name='name']").setValue(DataGenerator.name());
        $("[name='phone']").setValue(DataGenerator.phone());
        $(".checkbox__box").click();
        $(".button").click();
        //$(".notification").setValue("");
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.dateMeeting()));
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE); // предварительная чистка поля с датой по умолчанию
        $("[data-test-id='date'] input").setValue(DataGenerator.dateMeeting2());
        $(".button").click();
        $(withText("Необходимо подтверждение")).shouldBe(visible, Duration.ofSeconds(15));
        $(".notification_status_error .button").click();
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.dateMeeting2()));

    }


}
