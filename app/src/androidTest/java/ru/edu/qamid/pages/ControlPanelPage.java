package ru.edu.qamid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.edu.qamid.R;

public class ControlPanelPage {

    private final int addButtonId = R.id.add_news_image_view;
    private final int categoryFieldId = R.id.news_category_text_input_layout;
    private final int titleFieldId = R.id.news_title_text_input_layout;
    private final int dateFieldId = R.id.news_publish_date_text_input_layout;
    private final int timeFieldId = R.id.news_publish_time_text_input_layout;
    private final int descriptionFieldId = R.id.news_description_text_input_layout;
    private final int activeSwitchId = R.id.news_active_switch;
    private final int saveButtonId = R.id.news_save_button;
    private final int cancelButtonId = R.id.news_cancel_button;

    private void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ControlPanelPage clickAdd() {
        waitFor(1000);
        onView(withId(addButtonId)).perform(click());
        return this;
    }

    public ControlPanelPage fillCategory(String category) {
        waitFor(1000);
        onView(withId(categoryFieldId)).perform(click());
        waitFor(1000);
        onView(withText(category)).perform(click());
        return this;
    }

    public ControlPanelPage fillTitle(String title) {
        waitFor(500);
        onView(withId(titleFieldId)).perform(clearText(), typeText(title), closeSoftKeyboard());
        return this;
    }

    public ControlPanelPage fillDate(String date) {
        waitFor(500);
        onView(withId(dateFieldId)).perform(clearText(), typeText(date), closeSoftKeyboard());
        return this;
    }

    public ControlPanelPage fillTime(String time) {
        waitFor(500);
        onView(withId(timeFieldId)).perform(clearText(), typeText(time), closeSoftKeyboard());
        return this;
    }

    public ControlPanelPage fillDescription(String description) {
        waitFor(500);
        onView(withId(descriptionFieldId)).perform(clearText(), typeText(description), closeSoftKeyboard());
        return this;
    }

    public ControlPanelPage setActive(boolean active) {
        waitFor(500);
        onView(withId(activeSwitchId)).perform(click());
        return this;
    }

    public NewsPage save() {
        waitFor(500);
        onView(withId(saveButtonId)).perform(click());
        return new NewsPage();
    }

    public ControlPanelPage cancel() {
        waitFor(500);
        onView(withId(cancelButtonId)).perform(click());
        return this;
    }
}