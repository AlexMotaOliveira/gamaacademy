package com.gama.autenticacao.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/usuario", "/carros" ).permitAll()
            .antMatchers(HttpMethod.GET, "/usuario", "/carros/**").authenticated()
        	.antMatchers(HttpMethod.DELETE, "/usuario", "/carros/**").authenticated()
        	.antMatchers(HttpMethod.PUT, "/usuario", "/carros/**").authenticated();
    }
}