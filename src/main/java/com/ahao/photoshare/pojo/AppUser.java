package com.ahao.photoshare.pojo;

import lombok.Data;

@Data
public class AppUser {
    private Long userId;
    private String userName;
    private String encryptedPassword;

    public AppUser(Long userId, String userName, String encryptedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.encryptedPassword = encryptedPassword;
    }
}
