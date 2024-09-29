package org.ascension.userregazureadb2c.security;

import com.microsoft.azure.spring.autoconfigure.b2c.AADB2COidcLoginConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AADB2COidcLoginConfigurer configurer;

    public WebSecurityConfig(AADB2COidcLoginConfigurer configurer) {
        this.configurer = configurer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .apply(configurer)
        ;
    }
}
