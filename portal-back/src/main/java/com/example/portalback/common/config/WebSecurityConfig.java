package com.example.portalback.common.config;

import com.example.portalback.sys.service.SysAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SysAccountService sysAccountService;

    @Autowired
    private StringPasswordEncoder stringPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysAccountService).passwordEncoder(stringPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //CRSF禁用
        http.csrf().disable();

        //开启cors过滤
        http.cors();
        http.authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest)
				.permitAll()
                .antMatchers("/ledger/download", "/ledger/downloadSelect").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin() //开启formLogin默认配置
                .loginProcessingUrl("/process")
                .successForwardUrl("/login/success")
                .failureForwardUrl("/login/failure")
                .and()
                .logout()
                .addLogoutHandler(new CustomLogoutHandler())
                .logoutSuccessHandler(new CustomLogoutSuccessHandler());

    }

}
