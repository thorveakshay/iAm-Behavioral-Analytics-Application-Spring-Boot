package com.akshaythorve;

import com.akshaythorve.analyze.HomeSurveyAnalyzer;
import com.akshaythorve.dao.StoreToMongoDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
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
    // inject via application.properties
    @Value("${app.welcome.message}")
    private String MESSAGE = "";
    @Value("${app.welcome.title}")
    private String TITLE = "";

    @RequestMapping("/")
    public String welcomeSurvey(Principal principal) {

        if (principal != null) {
            System.out.println("===========================================");
            System.out.println("User name is: " + principal.getName());
            System.out.println("Facebook principal userAuthentication object: " + principal);
            // return "Hey there! Your email address is: " + principal.getName();
        }

        return "index";
    }

    // test 5xx errors
    @RequestMapping("/5xx")
    public String ServiceUnavailable() {
        throw new RuntimeException("ABC");
    }

    // landing page
    @RequestMapping("/welcome")
    public String home(Map<String, Object> model) {
        model.put("title", TITLE);
        model.put("message", MESSAGE);
        return "welcome";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public @ResponseBody
    String getSearchUserProfiles(@RequestBody String data, HttpServletRequest request,
                                 Map<String, Object> model) {

        String iAm = analyserObj.getPersonalCharacter(data);
        System.out.println("getPersonalCharacter: " + iAm);

        // String jsonData= JSON.stringify(data);
        StoreToMongoDB obj = new StoreToMongoDB();
        String DbStatus = obj.saveToMongoDB(data, "todays_mood");
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
