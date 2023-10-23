package com.tohu.tohumanagement.Models;

import javax.jws.soap.SOAPBinding;
import java.time.DateTimeException;

public class User {
    public User user;
    public int id;
    public String user_id;
    public String name;
    public String email;
    public int role;
    public String auth_code;
    public String created_at, updated_at, deleted_at;

    public User(User user, int id, String userId, String name, String email, int role, String authCode,
                String createdAt, String updatedAt, String deletedAt) {
        this.user = user;
        this.id = id;
        this.user_id = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.auth_code = authCode;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
        this.deleted_at = deletedAt;
    }
}
