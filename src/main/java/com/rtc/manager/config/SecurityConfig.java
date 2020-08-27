package com.rtc.manager.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.filter.CustomAuthenticationFilter;
import com.rtc.manager.filter.TokenFilter;
import com.rtc.manager.util.UserUtils;
import com.rtc.manager.vo.RtcUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenHang
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenFilter tokenFilter;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RtcUserMapper rtcUserMapper;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        Map map = new HashMap<>();
//        map.put("data", null);
        /*http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated()
//                .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
                .and().formLogin().permitAll()//使用 spring security 默认登录页面
                .successHandler((request, response, authentication) -> {
                    map.put("code", 200);
                    map.put("message", "登录成功");
                    map.put("data", authentication);
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    PrintWriter out = response.getWriter();
                    map.put("code", 401);
                    if (exception instanceof InternalAuthenticationServiceException) {
                        map.put("message", "该账号不存在");
                    }
                    if (exception instanceof BadCredentialsException) {
//                        String message = exception.getMessage();
                        map.put("message", "密码错误");
                    }
                    map.put("data", null);
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .and().logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    map.put("code", 200);
                    map.put("message", "登出成功");
                    map.put("data", authentication);
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().httpBasic()//启用http 基础验证
                // 未登录
                .authenticationEntryPoint((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    PrintWriter out = response.getWriter();
                    map.put("code", 1001);
                    map.put("message", "未登录");
                    map.put("data", null);
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                });*/

        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().httpBasic()
                .authenticationEntryPoint((request, response, authenticationException) -> {
                    Map map = new HashMap();
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    PrintWriter out = response.getWriter();
                    map.put("code", 1001);
                    map.put("message", "Unauthorized");
                    if (authenticationException instanceof InsufficientAuthenticationException) {
                        map.put("message", "未登录");
                    }
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/api/**").permitAll()
//                .antMatchers("/news/getNews").hasRole("VIP")
//                .antMatchers("/news/listNews").hasRole("USER")
                .antMatchers("/user/phoneRegister").permitAll()
                .antMatchers("/user/verificationCodeRegistered").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()//使用 spring security 默认登录页面
                .successHandler((request, response, authentication) -> {
                    Map map = new HashMap<>();
                    map.put("code", 200);
                    map.put("message", "登录成功");
//                    map.put("authentication", authentication);
                    UserDetails principal = (UserDetails) authentication.getPrincipal();
                    Map data = new HashMap();
                    data.put("account", principal.getUsername());
                    data.put("Authorization", UserUtils.getToken(principal.getUsername()));
                    map.put("data", data);
                    response.setHeader("Authorization", "cat");
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .failureHandler((request, response, exception) -> {
                    Map map = new HashMap();
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    PrintWriter out = response.getWriter();
                    map.put("code", 401);
                    map.put("data", null);
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    Map map = new HashMap<>();
                    String authHeader = request.getHeader("Authorization");
                    if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                authHeader = authHeader.substring("Bearer ".length());
                        if (stringRedisTemplate.hasKey(authHeader)) {
//                            map.put("message", stringRedisTemplate.opsForValue().get(authHeader) + "登出成功");
                            stringRedisTemplate.delete(authHeader);
                        }
                    }
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.setContentType("application/json;charset=utf-8");
                    map.put("code", 200);
                    map.put("message", "登出成功");
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .and().exceptionHandling()
                .accessDeniedHandler((request, response, authentication) -> {
                    Map map = new HashMap<>();
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    PrintWriter out = response.getWriter();
                    Map data = new HashMap();
                    map.put("code", 403);
                    map.put("message", "没有权限");
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                });
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }


    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler((request, response, authentication) -> {
            Map map = new HashMap<>();
            map.put("code", 200);
            map.put("message", "登录成功");
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            Map data = new HashMap();
            data.put("account", principal.getUsername());
            RtcUserVO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(principal.getUsername());
            data.put("Authorization", UserUtils.getToken(rtcUserDTO.getUuid()));
            data.put("user", rtcUserDTO);
            Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
            ArrayList<SimpleGrantedAuthority> authoritieList = new ArrayList(authorities);
            SimpleGrantedAuthority simpleGrantedAuthority = authoritieList.get(0);
            data.put("role", simpleGrantedAuthority.getAuthority());
            map.put("data", data);
            response.setHeader("Authorization", "cat");
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(objectMapper.writeValueAsString(map));
            out.flush();
            out.close();
        });
        // 覆盖http.authenticationEntryPoint
        filter.setAuthenticationFailureHandler((request, response, authenticationException) -> {
            Map map = new HashMap();
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter out = response.getWriter();
            map.put("code", 401);
            map.put("message", "登录失败");
            if (authenticationException instanceof InternalAuthenticationServiceException) {
                map.put("code", 1002);
                map.put("message", "该账号不存在");
            }else if (authenticationException instanceof BadCredentialsException) {
                 map.put("code", 1003);
                map.put("message", "密码错误");
            }
            out.write(objectMapper.writeValueAsString(map));
            out.flush();
            out.close();
        });

        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

}
