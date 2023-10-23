package com.tohu.tohumanagement.Services;

import com.google.gson.Gson;
import com.tohu.tohumanagement.Models.McWorld;

public class McWorldUtil {
    public static McWorld getMcWorld(String url) {
        Gson gson = new Gson();
        return gson.fromJson(url, McWorld.class).mc_world;
    }

    public static int getId(String url) {
        return getMcWorld(url).id;
    }

    public static String getName(String url) {
        return getMcWorld(url).name;
    }

    public static int getServerId(String url) {
        return getMcWorld(url).server_id;
    }

    public static int getUserId(String url) {
        return getMcWorld(url).user_id;
    }

    public static String getPath(String url) {
        return getMcWorld(url).path;
    }

    public static String getDeletedAt(String url) {
        return getMcWorld(url).deleted_at;
    }

    public static String getCreatedAt(String url) {
        return getMcWorld(url).created_at;
    }

    public static String getUpdatedAt(String url) {
        return getMcWorld(url).updated_at;
    }
}
