package com.rtc.manager.filter;

import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChenHang
 */
@Configuration
public class TokenFilter extends OncePerRequestFilter {
    String tokenHead = "Bearer ";
    String tokenHeader = "Authorization";
    @Autowired
    UserDetailServiceImpl userDetailService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader(this.tokenHeader);
//        final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
//        String authHeader = request.getHeader(this.tokenHeader);
//        if (authHeader != null && authHeader.startsWith(tokenHead)) {
//            final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
//            if (authToken != null && stringRedisTemplate.hasKey(authToken)) {
//                String username = stringRedisTemplate.opsForValue().get(authToken);
        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        String username = request.getParameter("username");
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailService.loadUserByUsername(username);
            //可以校验token和username是否有效，目前由于token对应username存在redis，都以默认都是有效的
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                    request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

}
