package com.ahao.photoshare.dao.impl;

import com.ahao.photoshare.dao.IUserDao;
import com.ahao.photoshare.pojo.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class UserMapper implements RowMapper<AppUser> {

        @Override
        public AppUser mapRow(ResultSet resultSet, int i) throws SQLException {
            Long userId = resultSet.getLong("user_id");
            String userName = resultSet.getString("user_name");
            String password = resultSet.getString("encrypted_password");
            return new AppUser(userId, userName, password);
        }
    }

    @Override
    public AppUser getAccount(String userName) {
        Object[] params = new Object[]{userName};
        String sql = "select u.user_id,u.user_name,u.encrypted_password,u.enabled from user u where u.user_name = ?";
        try {
            AppUser appUser = jdbcTemplate.queryForObject(sql, params, new UserMapper());
            return appUser;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
