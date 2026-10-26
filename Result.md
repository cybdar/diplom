# Результаты тестирования

## Сравнение времени
| Подход | Время |
| :--- | :--- |
| Ручное тестирование (58 проверок) | ~8 часов |
| Автотесты (13 кейсов) | ~2 минуты |

## Автоматизированные тесты (13 из 13)
1. `successfulLogin` - успешный вход
2. `loginWithEmptyFields` - вход с пустыми полями
3. `loginWithWrongPassword` - вход с неверным паролем
4. `logoutFromAccount` - выход из аккаунта
5. `openNewsSection` - открытие раздела News
6. `createNews` - создание новости
7. `createNewsWithEmptyDescription` - создание с пустым описанием (ошибка "Fill empty fields")
8. `editNews` - редактирование новости
9. `openFilter` - открытие фильтра
10. `openFilterAndApplyFilter` - применение фильтра по категории
11. `openFilterAndCancel` - отмена фильтра
12. `openQuotesSection` - открытие цитат
13. `checkQuotesSectionOpened` - проверка раздела цитат

## Найденные баги
1. **Пробелы в логине/пароле не обрезаются** — Приоритет: Medium.  
   При вводе " login2 " и " password2 " вход выполняется, хотя должна быть ошибка.

2. **Некорректная дата создания (Creation date)** — Приоритет: High.  
   После создания новости 22.09.2026 в поле Creation date отображается 13.04.58696.

3. **Фильтр без выбора статуса показывает все новости** — Приоритет: Medium.  
   В Control Panel при фильтрации без выбора Active/Not active система показывает все новости.

## Allure
Подключены зависимости `allure-kotlin-*` (2.4.0), раннер `AllureAndroidJUnitRunner` в `build.gradle`, создан `allure.properties` с путём `allure-results`, добавлен флаг `android.injected.androidTest.leaveApksInstalledAfterRun=true`. В коде использованы аннотации `@Epic`, `@Feature`, `@Story`, `@Description` и логирование `Allure.step()`.

После прогона тестов папка `allure-results` была получена с эмулятора через **Device Explorer** (`data/data/ru.edu.qamid/files/allure-results`), сохранена в проект и заархивирована в **`allure-results.zip`** в корне репозитория.

## Вывод
Автоматизация сократила время проверки приложения с 8 часов до 2 минут. Все 13 запланированных тестов проходят успешно. Найдены 3 бага, оформленные как Issues на GitHub.