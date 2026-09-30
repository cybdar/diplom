package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import io.qameta.allure.kotlin.Allure;
import ru.edu.qamid.R;

public class AuthorizationPage {

    private final int loginFieldId = R.id.login_edit_text;
    private final int passwordFieldId = R.id.password_edit_text;
    private final int signInButtonId = R.id.enter_button;

    private final UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

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

    public AuthorizationPage clickSignInWithError() {
        Allure.step("Нажатие кнопки SIGN IN (ожидается ошибка)");
        onView(withId(signInButtonId)).perform(click());
        return this;
    }

    public AuthorizationPage checkLoginScreenVisible() {
        Allure.step("Проверка отображения экрана авторизации");
        onView(withId(loginFieldId)).check(matches(isDisplayed()));
        return this;
    }

    public AuthorizationPage checkErrorToast(String errorText) {
        Allure.step("Проверка всплывающей ошибки: " + errorText);
        device.wait(Until.findObject(By.text(errorText)), 5000);
        return this;
    }
}