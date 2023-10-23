package com.tohu.tohumanagement.Services;

import com.google.gson.Gson;
import com.tohu.tohumanagement.Models.McPlayer;

public class McPlayerUtil {
    public static McPlayer getMcPlayer(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, McPlayer.class).mc_player;
    }

    public static int getMcPlayerId(String json) {
        Gson gson = new Gson();
        return getMcPlayer(json).id;
    }

    public static String getMcPlayerUuid(String json) {
        Gson gson = new Gson();
        return getMcPlayer(json).uuid;
    }

    public static String getMcPlayerName(String json) {
        Gson gson = new Gson();
        return getMcPlayer(json).name;
    }

    public static int getMcPlayerUserId(String json) {
        Gson gson = new Gson();
        return getMcPlayer(json).user_id;
    }

    public static String getMcPlayerDeletedAt(String json) {
        Gson gson = new Gson();
        return getMcPlayer(json).deleted_at;
    }

    public static String getMcPlayerCreatedAt(String json) {
        Gson gson = new Gson();
        return getMcPlayer(json).created_at;
    }

    public static String getMcPlayerUpdatedAt(String json) {
        Gson gson = new Gson();
        return getMcPlayer(json).updated_at;
    }
}
