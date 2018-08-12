package com.ahao.photoshare.service;

import com.ahao.photoshare.dao.IRoleDao;
import com.ahao.photoshare.dao.IUserDao;
import com.ahao.photoshare.pojo.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = iUserDao.getAccount(userName);
        if (null == appUser) {
            throw new UsernameNotFoundException("appUser " + userName + " was not found.");
        }

        List<String> roleNames = iRoleDao.getRoles(appUser.getUserId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (null != roleNames) {
            for (String roleName : roleNames) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
                grantedAuthorities.add(grantedAuthority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), appUser.getEncryptedPassword(), grantedAuthorities);
        return userDetails;
    }
}
