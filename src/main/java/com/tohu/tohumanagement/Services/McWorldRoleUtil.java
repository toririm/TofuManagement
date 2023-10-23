package com.tohu.tohumanagement.Services;

import com.google.gson.Gson;
import com.tohu.tohumanagement.Models.McWorldRole;

public class McWorldRoleUtil {
    public static McWorldRole getMcWorldRole(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, McWorldRole.class).mc_world_role;
    }

    public static int getId(String json) {
        return getMcWorldRole(json).id;
    }

    public static int getMcWorldId(String json) {
        return getMcWorldRole(json).mc_world_id;
    }

    public static int getUserId(String json) {
        return getMcWorldRole(json).user_id;
    }

    public static String getAuthCode(String json) {
        return getMcWorldRole(json).auth_code;
    }

    public static String getDeletedAt(String json) {
        return getMcWorldRole(json).deleted_at;
    }

    public static String getCreatedAt(String json) {
        return getMcWorldRole(json).created_at;
    }

    public static String getUpdatedAt(String json) {
        return getMcWorldRole(json).updated_at;
    }
}
