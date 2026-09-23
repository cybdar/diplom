# Запуск автотестов для приложения ВХОСПИСЕ

## Требования
- Android Studio
- Эмулятор с Android API 36
- Подключение к интернету

## Запуск тестов
1. Открыть проект в Android Studio.
2. Выбрать эмулятор с API 36.
3. В терминале выполнить:
   `./gradlew clean`
   `./gradlew connectedAndroidTest`

## Результаты
- Все 13 тестов автоматизированы и проходят успешно.
- HTML-отчёт: `app/build/reports/androidTests/connected/debug/index.html`
- Allure: аннотации `@Epic`, `@Feature`, `@Story`, `@Description` и `Allure.step()` использованы в коде. Раннер `AllureAndroidJUnitRunner` подключён в `build.gradle`. Папка `allure-results` не создалась из-за особенностей библиотеки на эмуляторе.