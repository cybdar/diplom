package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class QuotesPage {

    public QuotesPage checkQuoteVisible(String quoteText) {
        onView(withText(quoteText)).check(matches(isDisplayed()));
        return this;
    }
}