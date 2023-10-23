package com.tohu.tohumanagement.Models;

public class McPlayer {
    public McPlayer mc_player;
    public int id;
    public String uuid;
    public String name;

    public int user_id;

    public String deleted_at, created_at, updated_at;

    public McPlayer(McPlayer mc_player, int id, String uuid, String name, int user_id,
                   String deleted_at, String created_at, String updated_at) {
        this.mc_player = mc_player;
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.user_id = user_id;
        this.deleted_at = deleted_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
