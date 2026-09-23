package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.edu.qamid.R;

public class MainPage {

    private final int menuButtonId = R.id.main_menu_image_button;
    private final int allNewsButtonId = R.id.all_news_text_view;
    private final int quotesButtonId = R.id.our_mission_image_button;
    private final int profileButtonId = R.id.authorization_image_button;

    public MainPage checkMainScreenVisible() {
        Allure.step("Проверка отображения главного экрана");
        onView(withId(allNewsButtonId)).check(matches(isDisplayed()));
        return this;
    }

    public NewsPage goToAllNews() {
        Allure.step("Переход в раздел All news");
        onView(withId(allNewsButtonId)).perform(click());
        return new NewsPage();
    }

    public QuotesPage goToQuotes() {
        Allure.step("Переход в раздел цитат");
        onView(withId(quotesButtonId)).perform(click());
        return new QuotesPage();
    }

    public MainPage openMenu() {
        Allure.step("Открытие меню");
        onView(withId(menuButtonId)).perform(click());
        return this;
    }

    public AuthorizationPage logout() {
        Allure.step("Выход из аккаунта");
        onView(withId(profileButtonId)).perform(click());
        onView(withText("Log out")).perform(click());
        return new AuthorizationPage();
    }
}