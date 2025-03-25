package com.codigomaestro.actividad8agr.model;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private static Map<String, User> users = new HashMap<>();

    static {
        // Hardcoded users
        users.put("admin", new User("admin", "adminpass", "admin"));
        users.put("user", new User("user", "userpass", "user"));
    }

    public static void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public static User getUser(String username) {
        return users.get(username);
    }

    public static boolean userExists(String username) {
        return users.containsKey(username);
    }
}