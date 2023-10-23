package com.tohu.tohumanagement.Services;

import com.google.gson.Gson;
import com.tohu.tohumanagement.Models.McAccessLog;

public class McAccessLogUtil {
    public static McAccessLog getDate(String url) {
        Gson gson = new Gson();
        return gson.fromJson(url, McAccessLog.class);
    }

    public static int getId(String url) {
        Gson gson = new Gson();
        return gson.fromJson(url, McAccessLog.class).id;
    }

    public static String getUuid(String url) {
        Gson gson = new Gson();
        return gson.fromJson(url, McAccessLog.class).uuid;
    }

    public static String getIp(String url) {
        Gson gson = new Gson();
        return gson.fromJson(url, McAccessLog.class).ip_address;
    }

    public static String getCreatedAt(String url) {
        Gson gson = new Gson();
        return gson.fromJson(url, McAccessLog.class).created_at;
    }


}
