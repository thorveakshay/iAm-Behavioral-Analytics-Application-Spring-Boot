package com.akshaythorve;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.akshaythorve.dao.StoreToMongoDB;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${app.welcome.message}")
	private String MESSAGE = "";

	@Value("${app.welcome.title}")
	private String TITLE = "";

	@RequestMapping("/")
	public String welcomeSurvey() {

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

	@RequestMapping(value = "/json/survey.htm", method = RequestMethod.POST)

	public @ResponseBody String getSearchUserProfiles(@RequestBody String data, HttpServletRequest request) {

		System.out.println(data);

		// String jsonData= JSON.stringify(data);
		StoreToMongoDB obj = new StoreToMongoDB();
		obj.saveToMongoDB(data,"todays_mood");

		return "welcome to survey";

		// your logic next
	}

}
