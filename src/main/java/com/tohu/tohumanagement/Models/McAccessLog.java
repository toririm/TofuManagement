package com.tohu.tohumanagement.Models;

public class McAccessLog {
    public int id;
    public String uuid;
    public String name;
    public String ip_address;

    public String created_at;

    public McAccessLog(int id, String uuid, String name, String ip_address, String created_at) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.ip_address = ip_address;
        this.created_at = created_at;
    }
}
