package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final Pattern exitPattern = Pattern.compile("(?i)Exit");

    private final Scanner scanner = new Scanner(System.in);

    protected static void startGenerator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину нового пароля: ");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            Matcher exitMatcher = exitPattern.matcher(input);
            if (exitMatcher.matches()) {
                break;
            }

            try {
                int len = Integer.parseInt(input);
                PasswordGenerator.password(len);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите длину пароля или 'Exit' для выхода.");
            }
        }

        scanner.close();
    }
}