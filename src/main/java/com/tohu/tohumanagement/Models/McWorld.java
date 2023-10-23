package com.tohu.tohumanagement.Models;

public class McWorld {
    public McWorld mc_world;
    public int id;
    public String name;
    public String description;
    public int server_id;
    public int user_id;

    public String path;
    public String deleted_at, created_at, updated_at;

    public McWorld(McWorld mc_world, int id, String name, String description, int server_id, int user_id,
                   String path, String deleted_at, String created_at, String updated_at) {
        this.mc_world = mc_world;
        this.id = id;
        this.name = name;
        this.description = description;
        this.server_id = server_id;
        this.user_id = user_id;
        this.path = path;
        this.deleted_at = deleted_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
