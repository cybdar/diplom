package ru.edu.qamid.tests;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
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
        String uniqueTitle = "AutoTest " + System.currentTimeMillis();
        mainPage
                .goToAllNews()
                .openControlPanel()
                .clickAdd()
                .fillCategory(TestData.CATEGORY)
                .fillTitle(uniqueTitle)
                .fillDate(TestData.DATE)
                .fillTime(TestData.TIME)
                .fillDescription(TestData.DESCRIPTION)
                .setActive(true)
                .save()
                .checkNewsWithTitleVisible(uniqueTitle);
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
                .save()
                .checkFormVisible();
    }

    @Test
    @Story("Редактирование новости")
    @Description("Проверка редактирования новости")
    public void editNews() {
        String oldTitle = "OldTitle " + System.currentTimeMillis();
        String newTitle = "NewTitle " + System.currentTimeMillis();

        mainPage
                .goToAllNews()
                .openControlPanel()
                .clickAdd()
                .fillCategory(TestData.CATEGORY)
                .fillTitle(oldTitle)
                .fillDescription(TestData.DESCRIPTION)
                .fillDate(TestData.DATE)
                .fillTime(TestData.TIME)
                .setActive(true)
                .save()
                .checkNewsWithTitleVisible(oldTitle)
                .clickEditOnFirstNews()
                .fillTitle(newTitle)
                .save()
                .checkNewsWithTitleVisible(newTitle);
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
    @Description("Проверка применения фильтра новостей по категории")
    public void openFilterAndApplyFilter() {
        mainPage
                .goToAllNews()
                .openFilter()
                .checkFilterScreenVisible()
                .selectCategoryInFilter(TestData.CATEGORY) // Выбираем "День рождения"
                .applyFilter()
                .checkNewsScreenVisible();
    }

    @Test
    @Story("Фильтрация новостей")
    @Description("Проверка отмены фильтрации новостей")
    public void openFilterAndCancel() {
        mainPage
                .goToAllNews()
                .openFilter()
                .checkFilterScreenVisible()
                .cancelFilter()
                .checkNewsScreenVisible();
    }
}