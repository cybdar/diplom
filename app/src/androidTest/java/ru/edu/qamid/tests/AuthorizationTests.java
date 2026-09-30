package ru.edu.qamid.tests;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.edu.qamid.pages.AuthorizationPage;
import ru.edu.qamid.utils.TestData;

@RunWith(AndroidJUnit4.class)
@Epic("Авторизация")
@Feature("Вход в приложение")
public class AuthorizationTests extends BaseTest {

    private final AuthorizationPage authPage = new AuthorizationPage();

    @Test
    @Story("Позитивный сценарий")
    @Description("Проверка успешного входа с валидными данными")
    public void successfulLogin() {
        Allure.step("Проверка отображения главного экрана после входа");
        mainPage.checkMainScreenVisible();
    }

    @Test
    @Story("Негативный сценарий")
    @Description("Проверка ошибки при пустых полях логина и пароля")
    public void loginWithEmptyFields() {
        mainPage.logout();
        authPage
                .clickSignInWithError()
                .checkErrorToast("Login and password cannot be empty");
    }

    @Test
    @Story("Негативный сценарий")
    @Description("Проверка ошибки при неверном пароле")
    public void loginWithWrongPassword() {
        mainPage.logout();
        authPage
                .enterLogin(TestData.VALID_LOGIN)
                .enterPassword(TestData.INVALID_PASSWORD)
                .clickSignInWithError()
                .checkErrorToast("Something went wrong. Try again later.");
    }

    @Test
    @Story("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта через иконку человечка")
    public void logoutFromAccount() {
        mainPage.logout();
        authPage.checkLoginScreenVisible();
    }
}