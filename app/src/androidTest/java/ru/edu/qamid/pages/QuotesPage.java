package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;

import io.qameta.allure.kotlin.Allure;

public class QuotesPage {

    public QuotesPage checkQuoteVisible(String quoteText) {
        Allure.step("Проверка отображения цитаты: " + quoteText);
        onView(withSubstring(quoteText)).check(matches(isDisplayed()));
        return this;
    }
}