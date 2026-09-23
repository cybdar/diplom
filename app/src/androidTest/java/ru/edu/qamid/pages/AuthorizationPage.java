package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.edu.qamid.R;

public class AuthorizationPage {

    private final int loginFieldId = R.id.login_edit_text;
    private final int passwordFieldId = R.id.password_edit_text;
    private final int signInButtonId = R.id.enter_button;

    public AuthorizationPage enterLogin(String login) {
        Allure.step("Ввод логина: " + login);
        onView(withId(loginFieldId)).perform(clearText(), typeText(login), closeSoftKeyboard());
        return this;
    }

    public AuthorizationPage enterPassword(String password) {
        Allure.step("Ввод пароля: " + password);
        onView(withId(passwordFieldId)).perform(clearText(), typeText(password), closeSoftKeyboard());
        return this;
    }

    public MainPage clickSignIn() {
        Allure.step("Нажатие кнопки SIGN IN");
        onView(withId(signInButtonId)).perform(click());
        return new MainPage();
    }

    public AuthorizationPage checkErrorVisible(String errorText) {
        Allure.step("Проверка ошибки: " + errorText);
        onView(withText(errorText))
                .inRoot(RootMatchers.isPlatformPopup())
                .check(matches(isDisplayed()));
        return this;
    }
}