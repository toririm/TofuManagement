package com.tohu.tohumanagement.Services;

import com.google.gson.Gson;
import com.tohu.tohumanagement.Models.User;

public class UserUtil {
    public static User getUser(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, User.class).user;
    }

    public static int getId(String url) {
        return getUser(url).id;
    }

    public static String getUserId(String url) {
        return getUser(url).user_id;
    }

    public static String getName(String url) {
        return getUser(url).name;
    }

    public static String getEmail(String url) {
        return getUser(url).email;
    }

    public static int getRole(String url) {
        return getUser(url).role;
    }

    public static String getAuthCode(String url) {
        return getUser(url).auth_code;
    }

    public static String getCreatedAt(String url) {
        return getUser(url).created_at;
    }

    public static String getUpdatedAt(String url) {
        return getUser(url).updated_at;
    }

    public static String getDeletedAt(String url) {
        return getUser(url).deleted_at;
    }
}
