package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * 定義WebSecurityConfig類別
 *
 * @author SamChen
 * @version 1
 * @CreateDate 2021-07-13
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * 設定登入頁面導向
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 全部腳色可以瀏覽
                .antMatchers("users/list").permitAll()
                // 只有ADMIN可以瀏覽
                .antMatchers("/users/non-list*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 對應LoginController的/loginPage
                .loginPage("/loginPage")
                // 對應自訂的登入action
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /**
     * 從DB取得Security需要的登入資訊
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from user where username=?")
                .authoritiesByUsernameQuery("select username, authority "
                        + "from user where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

//    這邊是用寫在程式裡的方式記憶登入資訊
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
