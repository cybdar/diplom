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
- Allure: аннотации `@Epic`, `@Feature`, `@Story`, `@Description` и `Allure.step()` в коде. Раннер `AllureAndroidJUnitRunner` в `build.gradle`, `allure.properties` с путём `allure-results`, флаг `android.injected.androidTest.leaveApksInstalledAfterRun=true`.