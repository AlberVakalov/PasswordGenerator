package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private static final String passwordLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String passwordSymbols = "/?>.<,|{{[}]*()";
    private static final String passwordNumbers = "1234567890";
    private static final List<String> passwordList = new ArrayList<>();


    static char[] password(int length) {
        String values = passwordLetter + passwordSymbols + passwordNumbers;
        Random randomSymbols = new Random();
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            password[i] = values.charAt(randomSymbols.nextInt(values.length()));
        }

        System.out.println("Generator activate, your new password: " + String.valueOf(password));
        return password;

    }



}
