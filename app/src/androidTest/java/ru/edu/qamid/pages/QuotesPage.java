package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;

import io.qameta.allure.kotlin.Allure;
import ru.edu.qamid.R;

public class QuotesPage {

    private final int quotesButtonId = R.id.our_mission_image_button;

    public QuotesPage checkQuoteVisible(String quoteText) {
        Allure.step("Проверка отображения цитаты: " + quoteText);
        onView(withSubstring(quoteText)).check(matches(isDisplayed()));
        return this;
    }

    public QuotesPage checkQuotesSectionOpened() {
        Allure.step("Проверка, что раздел цитат открыт");
        onView(withId(quotesButtonId)).check(matches(isDisplayed()));
        return this;
    }
}