package ru.edu.qamid.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.edu.qamid.R;

@RunWith(AndroidJUnit4.class)
@Epic("Цитаты")
@Feature("Раздел Love is all")
public class QuotesTests extends BaseTest {

    @Test
    @Story("Открытие раздела цитат")
    @Description("Проверка открытия раздела Love is all")
    public void openQuotesSection() {
        Allure.step("Переход в раздел цитат");
        mainPage.goToQuotes().checkQuoteVisible("Хоспис для меня");
    }

    @Test
    @Story("Открытие раздела цитат")
    @Description("Проверка, что раздел цитат отображается с заголовком Love is all")
    public void checkQuotesSectionOpened() {
        Allure.step("Переход в раздел цитат");
        mainPage.goToQuotes();
        onView(withId(R.id.our_mission_image_button)).check(matches(isDisplayed()));
    }
}