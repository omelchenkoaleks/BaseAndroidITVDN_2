package com.omelchenkoaleks.baseandroiditvdn_2.register_or_login;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String login;
    private String password;

    private static List<User> allUsers = new ArrayList<>();

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            User user = (User) obj;
            return login.equals(user.login);
        }
        return false;
    }

    public static List<User> getAllUsers() {
        return allUsers;
    }
}
