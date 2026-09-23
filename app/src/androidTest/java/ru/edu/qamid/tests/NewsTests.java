package ru.edu.qamid.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.edu.qamid.pages.NewsPage;
import ru.edu.qamid.utils.TestData;

@RunWith(AndroidJUnit4.class)
@Epic("Новости")
@Feature("Управление новостями")
public class NewsTests extends BaseTest {

    @Test
    @Story("Открытие раздела новостей")
    @Description("Проверка открытия раздела News")
    public void openNewsSection() {
        Allure.step("Переход в раздел новостей");
        mainPage.goToAllNews().checkNewsScreenVisible();
    }

    @Test
    @Story("Создание новости")
    @Description("Проверка создания новости со всеми заполненными полями")
    public void createNews() {
        mainPage
                .goToAllNews()
                .openControlPanel()
                .clickAdd()
                .fillCategory(TestData.CATEGORY)
                .fillTitle(TestData.TITLE)
                .fillDate(TestData.DATE)
                .fillTime(TestData.TIME)
                .fillDescription(TestData.DESCRIPTION)
                .setActive(true)
                .save()
                .checkControlPanelVisible();
    }

    @Test
    @Story("Создание новости")
    @Description("Проверка ошибки при создании новости с пустым заголовком")
    public void createNewsWithEmptyTitle() {
        mainPage
                .goToAllNews()
                .openControlPanel()
                .clickAdd()
                .fillCategory(TestData.CATEGORY)
                .fillDate(TestData.DATE)
                .fillTime(TestData.TIME)
                .fillDescription(TestData.DESCRIPTION)
                .setActive(true)
                .cancel();
    }

    @Test
    @Story("Создание новости")
    @Description("Проверка ошибки при создании новости с пустым описанием")
    public void createNewsWithEmptyDescription() {
        mainPage
                .goToAllNews()
                .openControlPanel()
                .clickAdd()
                .fillCategory(TestData.CATEGORY)
                .fillTitle(TestData.TITLE)
                .fillDate(TestData.DATE)
                .fillTime(TestData.TIME)
                .setActive(true)
                .cancel();
    }

    @Test
    @Story("Редактирование новости")
    @Description("Проверка редактирования новости")
    public void editNews() {
        mainPage
                .goToAllNews()
                .openControlPanel()
                .clickAdd()
                .fillCategory(TestData.CATEGORY)
                .fillTitle("Old title")
                .fillDescription("Old description")
                .fillDate(TestData.DATE)
                .fillTime(TestData.TIME)
                .setActive(true)
                .save()
                .checkControlPanelVisible();
    }

    @Test
    @Story("Фильтрация новостей")
    @Description("Проверка открытия фильтра новостей")
    public void openFilter() {
        mainPage
                .goToAllNews()
                .openFilter()
                .checkFilterScreenVisible();
    }

    @Test
    @Story("Фильтрация новостей")
    @Description("Проверка применения фильтра новостей")
    public void openFilterAndApplyFilter() {
        NewsPage newsPage = mainPage.goToAllNews();
        newsPage.openFilter();
        newsPage.checkFilterScreenVisible();
        Allure.step("Нажатие кнопки FILTER");
        onView(withText("FILTER")).perform(click());
        Allure.step("Проверка, что вернулись на экран новостей");
        newsPage.checkNewsScreenVisible();
    }
}