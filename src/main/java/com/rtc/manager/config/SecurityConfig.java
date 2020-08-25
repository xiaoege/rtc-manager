package com.rtc.manager.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.filter.LoginFilter;
import com.rtc.manager.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
    private LoginFilter loginFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(new MyProvider());
//        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Map map = new HashMap<>();
        map.put("data", null);
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

        http.cors().and()
                // 禁用 CSRF
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/user/login").successForwardUrl("/user/success").permitAll()//使用 spring security 默认登录页面
                .and()
                //添加自定义Filter
                // 不需要session（不创建会话）
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
//                .addFilterAfter(successFilter, );
        http.headers().cacheControl();


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

}
