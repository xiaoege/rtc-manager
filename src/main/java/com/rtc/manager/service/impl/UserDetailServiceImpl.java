package com.rtc.manager.service.impl;

import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.dto.RtcUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenHang
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    RtcUserMapper rtcUserMapper;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        RtcUserDTO rtcUser = rtcUserMapper.selectByPhoneOrAccount(account);
        if (rtcUser == null) {
            throw new InternalAuthenticationServiceException("该账号不存在");
        }

        // 角色
        if ("user".equals(rtcUser.getRoleName())) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            grantedAuthorities.add(grantedAuthority);
            return new User(account, rtcUser.getPassword(), grantedAuthorities);
        } else if ("vip".equals(rtcUser.getRoleName())) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_VIP");
            grantedAuthorities.add(grantedAuthority);
            return new User(account, rtcUser.getPassword(), grantedAuthorities);
        }

        return null;
    }

}
