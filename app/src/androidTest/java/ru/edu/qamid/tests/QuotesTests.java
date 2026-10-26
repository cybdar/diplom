package ru.edu.qamid.tests;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.edu.qamid.pages.QuotesPage;

@RunWith(AndroidJUnit4.class)
@Epic("Цитаты")
@Feature("Раздел Love is all")
public class QuotesTests extends BaseTest {

    private final QuotesPage quotesPage = new QuotesPage();

    @Test
    @Story("Открытие раздела цитат")
    @Description("Проверка открытия раздела Love is all")
    public void openQuotesSection() {
        Allure.step("Переход в раздел цитат");
        mainPage.goToQuotes().checkQuoteVisible("Хоспис для меня");
    }

    @Test
    @Story("Открытие раздела цитат")
    @Description("Проверка, что раздел цитат отображается с заголовком Love is all")
    public void checkQuotesSectionOpened() {
        Allure.step("Переход в раздел цитат");
        mainPage.goToQuotes();
        quotesPage.checkQuotesSectionOpened();
    }
}