package com.ahao.photoshare.dao;

import java.util.List;

public interface IRoleDao {
    public List<String> getRoles(Long userId);
}
