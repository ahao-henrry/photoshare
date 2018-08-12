package com.ahao.photoshare.dao;

import com.ahao.photoshare.pojo.AppUser;

public interface IUserDao {
    public AppUser getAccount(String userName);
}
