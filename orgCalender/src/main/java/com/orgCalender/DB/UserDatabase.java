package com.orgCalender.DB;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static final Map<String, String> users = new HashMap<>();

    public static void addUser(String username, String password) {
        users.put(username, password);
    }

    public static boolean userExists(String username) {
        return users.containsKey(username);
    }

    public static boolean isValidUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static Map<String, String> getAllUsers() {
        return users;
    }
}
