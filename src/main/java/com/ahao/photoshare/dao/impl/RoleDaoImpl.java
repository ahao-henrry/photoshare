package com.ahao.photoshare.dao.impl;

import com.ahao.photoshare.dao.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements IRoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getRoles(Long userId) {
        Object[] params = new Object[]{userId};
        String sql = "select r.role_name from role r, user_role ur where r.role_id = ur.role_id and ur.user_id = ?";
        List<String> roleNames = jdbcTemplate.queryForList(sql, params, String.class);
        return roleNames;
    }
}
