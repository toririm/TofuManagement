package com.tohu.tohumanagement.Models;

public class McWorldRole {
    public McWorldRole mc_world_role;

    public int id;
    public int mc_world_id;

    public int user_id;
    public String auth_code;

    public String deleted_at, created_at, updated_at;

    public McWorldRole(McWorldRole mc_world_role, int id, int mc_world_id, int user_id, String auth_code, String deleted_at, String created_at, String updated_at) {
        this.mc_world_role = mc_world_role;
        this.id = id;
        this.mc_world_id = mc_world_id;
        this.user_id = user_id;
        this.auth_code = auth_code;
        this.deleted_at = deleted_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
