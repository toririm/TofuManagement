package com.tohu.tohumanagement.Models;

import java.time.DateTimeException;
import java.util.Date;

public class Tohu {
//    public Tohu user;
//    public int id;
//    public String user_id;
//    public String name;
//    public String email;
//    public int role;
//    public String auth_code;
//    public Tohu mc_player;
//    public String playerName;
//    public boolean authorized;
//    public DateTimeException created_at, updated_at, deleted_at;
//
//    public Tohu(Tohu tohuUser, int id, String userId, String name, String email, int role, String authCode,
//                Tohu mcPlayer, String playerName,
//                boolean authorized, DateTimeException createdAt, DateTimeException updatedAt, DateTimeException deletedAt) {
//        this.user = tohuUser;
//        this.id = id;
//        this.user_id = userId;
//        this.name = name;
//        this.email = email;
//        this.role = role;
//        this.auth_code = authCode;
//        this.mc_player = mcPlayer;
//        this.playerName = playerName;
//        this.authorized = authorized;
//        this.created_at = createdAt;
//        this.updated_at = updatedAt;
//        this.deleted_at = deletedAt;
//    }
    public Tohu user;
    public int id;
    public Tohu mc_player;

    public boolean authorized;

    public DateTimeException created_at, updated_at, deleted_at;

    public Tohu(Tohu user, Tohu mc_player, boolean authorized, int id,
                DateTimeException created_at, DateTimeException updated_at, DateTimeException deleted_at
    ) {
        this.user = user;
        this.id = id;
        this.mc_player = mc_player;
        this.authorized = authorized;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

}
