package com.company.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    /*
        Fio (example names):
            - Peter Müller
            - François Hollande
            - Patrick O'Brian
            - Silvana Koch-Mehrin

        User name:
            - Length >=3
            - Valid characters: a-z, A-Z, 0-9, points, dashes and underscores.

        Password:
            - At least 8 chars
            - Contains at least one digit
            - Contains at least one lower alpha char and one upper alpha char
            - Contains at least one char within a set of special chars (@#%$^ etc.)
            - Does not contain space, tab, etc.
     */

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final String LOGIN_REGEX = "^[a-zA-Z0-9._-]{3,}$";
    private static final String FIO_REGEX = "^[\\p{L} .'-]+$";

    public static boolean checkFio(String fio) {
        Pattern pattern = Pattern.compile(FIO_REGEX);
        Matcher matcher = pattern.matcher(fio);
        return matcher.matches();
    }

    public static boolean checkLogin(String login) {
        Pattern pattern = Pattern.compile(LOGIN_REGEX);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }

    public static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
