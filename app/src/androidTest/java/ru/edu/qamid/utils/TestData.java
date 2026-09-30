package ru.edu.qamid.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {
    public static final String VALID_LOGIN = "login2";
    public static final String VALID_PASSWORD = "password2";
    public static final String INVALID_PASSWORD = "wrong";
    public static final String CATEGORY = "День рождения";
    public static final String TITLE = "Автотест";
    public static final String DESCRIPTION = "Auto test description";
    public static final String DATE = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
    public static final String TIME = "12:00";
}