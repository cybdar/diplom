# Запуск автотестов для приложения ВХОСПИСЕ

## Требования
- Android Studio
- Эмулятор с Android API 36
- Подключение к интернету

## Запуск тестов
1. Открыть проект в Android Studio.
2. Выбрать эмулятор с API 36.
3. В терминале выполнить:
   `./gradlew connectedAndroidTest`
4. Результаты тестов отображаются в консоли и в отчёте `app/build/reports/androidTests/connected/debug/index.html`
