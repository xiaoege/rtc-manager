package com.rtc.manager.filter;

import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.service.impl.UserDetailServiceImpl;
import com.rtc.manager.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token验证
 *
 * @author ChenHang
 */
@Configuration
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String bearer = "Bearer ";
        if (authHeader != null && authHeader.startsWith(bearer)) {
            /*if (stringRedisTemplate.hasKey(authHeader)) {
//                String username = stringRedisTemplate.opsForValue().get(authHeader);
                String uuid = stringRedisTemplate.opsForValue().get(authHeader);
                if (uuid != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailService.loadUserByUsername(uuid);
                    if (userDetails != null) {
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }*/
            String jwt = authHeader.substring(bearer.length());
            // Redis JWT 黑名单
            if (stringRedisTemplate.opsForSet().isMember("jwt-blacklist", jwt)) {
                throw new ServletException("该token已废弃");
            }
            String userId = UserUtils.verifyJWT(jwt);
            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailService.loadUserByUsername(userId);
                    if (userDetails != null) {
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
            }
        }

        chain.doFilter(request, response);
    }

}
