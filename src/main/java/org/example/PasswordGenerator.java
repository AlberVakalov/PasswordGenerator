package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private static final String passwordLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String passwordSymbols = "/?>.<,|{{[}]*()";
    private static final String passwordNumbers = "1234567890";
    private static final List<String> passwordList = new ArrayList<>();


    protected static String password(int length) {
        String values = passwordLetter + passwordSymbols + passwordNumbers;
        Random randomSymbols = new Random();
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            password[i] = values.charAt(randomSymbols.nextInt(values.length()));
        }

        String generatedPassword = String.valueOf(password);

        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "INSERT INTO passwords (password) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, generatedPassword);
            statement.executeUpdate();
            System.out.println("Generator activate, your new password: " + generatedPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedPassword;

    }



}
