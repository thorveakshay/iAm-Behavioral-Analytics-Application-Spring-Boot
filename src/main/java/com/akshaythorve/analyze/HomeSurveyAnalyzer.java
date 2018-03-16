package com.akshaythorve.analyze;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeSurveyAnalyzer {

	public void getPersonalCharacter(String data) {
		// JSONParser parser = new JSONParser();

		int O=0,G=0,D=0,I=0;
		
		String iAm;
		 
		JSONObject obj;
		try {
			System.out.println("Data inserted is ");
			System.out.println(data);
			
			obj = new JSONObject(data); // converting String to JSON
			
			System.out.println("json obj: "+obj.toString());
			// static code for basic understanding of algorithm
			// Implementing this algorithm from mongoDB 
			System.out.println("string 1: "+obj.getString("question1").equals("1")+" int1: "+obj.getString("question1").equals(1)); 
			if (obj.getString("question1").equals("1")) O++; else G++;
			if (obj.getString("question2").equals("1")) I++; else D++;
			if (obj.getString("question3").equals("1")) G++; else O++;
			if (obj.getString("question4").equals("1")) D++; else I++;
			if (obj.getString("question5").equals("1")) O++; else G++;
			if (obj.getString("question6").equals("1")) I++; else D++;
			if (obj.getString("question7").equals("1")) G++; else O++;
			if (obj.getString("question8").equals("1")) D++; else I++;
			if (obj.getString("question9").equals("1")) O++; else G++;//
			if (obj.getString("question10").equals("1")) I++; else D++;
			if (obj.getString("question11").equals("1")) G++; else O++;
			if (obj.getString("question12").equals("1")) D++; else I++;
			if (obj.getString("question13").equals("1")) O++; else G++;//
			if (obj.getString("question14").equals("1")) I++; else D++;
			if (obj.getString("question15").equals("1")) G++; else O++;
			if (obj.getString("question16").equals("1")) D++; else I++;
			if (obj.getString("question17").equals("1")) O++; else G++;//
			if (obj.getString("question18").equals("1")) I++; else D++;
			
		
			
			System.out.println("O: "+O+" G: "+G+ "D: "+D+" I: "+I);
			String group1= O>G? "O":"G";
			String group2= D>I? "D":"I";
			
			System.out.println("group1: "+group1+" group2:"+group2);
			
			if("G".equals(group1) && "D".equals(group2)) {
				iAm="Controller/Director";
				
			}else if("O".equals(group1) && "D".equals(group2)) {
				iAm="Promoter/Socializer";
				
			}else if ("O".equals(group1) && "I".equals(group2)) {
				iAm="Supporter/Relater";
				
			}else if("G".equals(group1) && "I".equals(group2)) {
				iAm="Analyzer/Thinker";
				
			}else {
				iAm="Unknown";
				
			}
			System.out.println("O: "+O+" G: "+G+ "D: "+D+" I: "+I);
			System.out.println("========================================");
			System.out.println("getPersonalCharacter is: "+iAm);
			System.out.println("========================================");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}
