package com.example.portalback.common.config;

import com.example.portalback.sys.service.SysAccountService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

import javax.annotation.Resource;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private SysAccountService sysAccountService;

	@Resource
	private StringPasswordEncoder stringPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(sysAccountService).passwordEncoder(stringPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// CRSF禁用
		http.csrf().disable();

		// 开启cors过滤
		http.cors();
		http.authorizeRequests()
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				// 这里是硬编码权限 只限于简单的用户权限 这里的角色名称严格区分大小写
				.antMatchers("/sys/admin/**").access("hasRole('ADMIN')") // 管理员角色鉴权
				.antMatchers("/ledger/**").access("hasRole('FINANCE')") // 财务角色鉴权
				.anyRequest().authenticated() // 认证
				.and()
				.formLogin() // 开启formLogin默认配置
				.loginProcessingUrl("/process")
				.successForwardUrl("/login/success")
				.failureForwardUrl("/login/failure")
				.and()
				.logout()
				.addLogoutHandler(new CustomLogoutHandler())
				.logoutSuccessHandler(new CustomLogoutSuccessHandler());

	}

}
