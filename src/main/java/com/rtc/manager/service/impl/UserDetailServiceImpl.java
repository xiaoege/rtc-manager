package com.rtc.manager.service.impl;

import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.dto.RtcUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
 * spring security专用
 *
 * @author ChenHang
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    RtcUserMapper rtcUserMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * @param account uuid/phone/email/nickname
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        RtcUserDTO rtcUser = rtcUserMapper.selectByPhoneOrAccount(account);
        if (rtcUser == null) {
            throw new InternalAuthenticationServiceException("该账号不存在");
        }
        // 角色
        String roleName = rtcUser.getRoleName();
        if (roleName != null) {
            GrantedAuthority grantedAuthority = null;
            switch (roleName) {
                case "user":
                    grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
                    break;
                case "vip":
                    grantedAuthority = new SimpleGrantedAuthority("ROLE_VIP");
                    break;
                case "rtc":
                    grantedAuthority = new SimpleGrantedAuthority("ROLE_RTC");
                    break;
                case "root":
                    grantedAuthority = new SimpleGrantedAuthority("ROLE_ROOT");
                    break;
                default:
            }
            grantedAuthorities.add(grantedAuthority);
            return new User(account, rtcUser.getPassword(), grantedAuthorities);
        }
        return null;
    }

}
