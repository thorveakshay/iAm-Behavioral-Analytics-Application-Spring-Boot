package com.akshaythorve;

import com.akshaythorve.dao.StoreToMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@EnableOAuth2Sso
@EnableResourceServer
@SpringBootApplication
public class SpringBootWebApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2ClientContext oauth2ClientContext;


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest()
//                .authenticated().and().exceptionHandling()
//                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")).and().logout()
//                .logoutSuccessUrl("/").permitAll().and().csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
//                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
//        // @formatter:on
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()

                .antMatchers("/api/**", "/dashboard", "/welcome").authenticated().antMatchers("/**").permitAll()
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/").permitAll();

    }

    @GetMapping("/aa")
    public String echoTheUsersEmailAddress(Principal principal) {
        return "Hey there! Your email address is: " + principal.getName();
    }

    @RequestMapping("/user")
    public String user(Principal principal) {
        //System.out.println("User is: "+ principal.getName());

        return principal.getName();
    }

    @RequestMapping("/behaviour")
    public String viewbehaviour(Map<String, Object> model, Principal principal) {


        StoreToMongoDB obj = new StoreToMongoDB();
        String behaviour = obj.getProfile(principal.getName(), "todays_mood");


        model.put("userName", principal.getName());
        model.put("behaviour", behaviour);


        return behaviour.toUpperCase();
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
