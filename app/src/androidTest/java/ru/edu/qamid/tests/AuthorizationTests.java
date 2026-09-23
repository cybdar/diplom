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
import ru.edu.qamid.pages.AuthorizationPage;
import ru.edu.qamid.utils.TestData;

@RunWith(AndroidJUnit4.class)
@Epic("Авторизация")
@Feature("Вход в приложение")
public class AuthorizationTests extends BaseTest {

    @Test
    @Story("Позитивный сценарий")
    @Description("Проверка успешного входа с валидными данными")
    public void successfulLogin() {
        Allure.step("Проверка отображения главного экрана после входа");
        mainPage.checkMainScreenVisible();
    }

    @Test
    @Story("Негативный сценарий")
    @Description("Проверка, что вход не выполняется при пустых полях")
    public void loginWithEmptyFields() {
        mainPage.logout();
        AuthorizationPage authPage = new AuthorizationPage();
        authPage.clickSignIn();
        Allure.step("Проверка, что остались на экране авторизации");
        onView(withId(R.id.login_edit_text)).check(matches(isDisplayed()));
    }

    @Test
    @Story("Негативный сценарий")
    @Description("Проверка, что вход не выполняется при неверном пароле")
    public void loginWithWrongPassword() {
        mainPage.logout();
        AuthorizationPage authPage = new AuthorizationPage();
        authPage.enterLogin(TestData.VALID_LOGIN);
        authPage.enterPassword(TestData.INVALID_PASSWORD);
        authPage.clickSignIn();
        Allure.step("Проверка, что остались на экране авторизации");
        onView(withId(R.id.login_edit_text)).check(matches(isDisplayed()));
    }

    @Test
    @Story("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта через иконку человечка")
    public void logoutFromAccount() {
        mainPage.logout();
        onView(withId(R.id.login_edit_text)).check(matches(isDisplayed()));
    }
}