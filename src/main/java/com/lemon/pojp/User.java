package com.lemon.pojp;

import lombok.Data;

@Data
public class User {
    private int userId;

    private String userName;

    private String userPwd;

    public User(int i, String zs, String s) {
    }
}
