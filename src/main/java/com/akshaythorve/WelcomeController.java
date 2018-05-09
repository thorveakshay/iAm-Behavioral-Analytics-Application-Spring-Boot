package com.akshaythorve;

import com.akshaythorve.analyze.HomeSurveyAnalyzer;
import com.akshaythorve.dao.StoreToMongoDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
@Controller
public class WelcomeController {

    HomeSurveyAnalyzer analyserObj = new HomeSurveyAnalyzer();
    String userName = "";
    // inject via application.properties
    @Value("${app.welcome.message}")
    private String MESSAGE = "";
    @Value("${app.welcome.title}")
    private String TITLE = "";

    @RequestMapping("/")
    public String welcomeSurvey(ModelMap model, Principal principal) {

        if (principal != null) {
            userName = principal.getName();

            //get logged in username
            model.addAttribute("userName", userName);

            System.out.println("===========================================");
            System.out.println("User name is: " + principal.getName());
            System.out.println("Principal userAuthentication object: " + principal);
            // return "Hey there! Your email address is: " + principal.getName();
        }

        return "index";
    }


    @RequestMapping("/5xx")
    public String ServiceUnavailable() {
        throw new RuntimeException("ABC");
    }


    @RequestMapping("/welcome")
    public String homeSurvey(Map<String, Object> model) {
        model.put("title", TITLE);
        model.put("message", MESSAGE);
        return "welcome";
    }

    @RequestMapping("/about")
    public String about() {

        return "about";
    }


    @RequestMapping("/profile")
    public String viewProfile(Map<String, Object> model, Principal principal) {


        StoreToMongoDB obj = new StoreToMongoDB();
        String behaviour = obj.getProfile(principal.getName(), "todays_mood");


        model.put("userName", principal.getName());
        model.put("behaviour", behaviour);


        return "profile";
    }


    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public @ResponseBody
    String getSearchUserProfiles(@RequestBody String data, HttpServletRequest request,
                                 Map<String, Object> model, Principal principal) {

        String iAm = analyserObj.getPersonalCharacter(data);
        System.out.println("getPersonalCharacter: " + iAm);

        String userName = principal.getName();
        System.out.println("userName ++ " + userName);
        // String jsonData= JSON.stringify(data);
        StoreToMongoDB obj = new StoreToMongoDB();
            String DbStatus = obj.saveToMongoDB(data, "todays_mood", userName, iAm);
        System.out.println("DB Status: " + DbStatus);

        model.put("time", "time time time");
        model.put("message", "Hello World");
        model.put("title", "Hello App");

        return "result";

        // your logic next
    }

    @RequestMapping("/result")
    public String getResult(Map<String, Object> model) {

        // String iAm = analyserObj.getPersonalCharacter(data);
        // System.out.println("getPersonalCharacter: "+iAm);
        //
        // // String jsonData= JSON.stringify(data);
        // StoreToMongoDB obj = new StoreToMongoDB();
        // String DbStatus=obj.saveToMongoDB(data, "todays_mood");
        // System.out.println("DB Status: "+DbStatus);

        model.put("time", "time time time");
        model.put("message", "Hello World");
        model.put("title", "Hello App");

        return "result";

        // your logic next
    }

}
