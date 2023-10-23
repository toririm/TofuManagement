package com.tohu.tohumanagement.Services;

import com.google.gson.Gson;
import com.tohu.tohumanagement.Models.Authorized;
import com.tohu.tohumanagement.Models.Tohu;

public class AuthorizedUtil {
    public static boolean getAuthorized(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Authorized.class).authorized;
    }
}
