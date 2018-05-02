package com.akshaythorve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;

@EnableOAuth2Sso
@RestController
@SpringBootApplication
public class SpringBootWebApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()

                .antMatchers("/api/**", "/dashboard", "/welcome").authenticated().antMatchers("/**").permitAll()
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/").permitAll();

    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {

        return principal;
    }

    @RequestMapping(value = "/akshay", method = RequestMethod.GET)
    public LinkedHashMap user(OAuth2Authentication authentication) {
        LinkedHashMap<String, Object> properties = null;
        if (authentication != null) {
            properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();

            System.out.println("User name is: " + properties.get("name"));
            System.out.println("User ID is: " + properties.get("id"));
            System.out.println("Authentication scope object is: " + properties);
        }
        return properties;
    }

}
