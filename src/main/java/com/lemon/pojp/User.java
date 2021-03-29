package com.lemon.pojp;

import lombok.Data;

@Data
public class User {
    public User(int userId, String userName, String userPwd) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    private int userId;

    private String userName;

    private String userPwd;



    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }
}
