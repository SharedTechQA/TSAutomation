package automationFramework;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class testMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		test1 ();
		
		verifySocialAccounts("twitter", "instagram");
		
		
		
	}
		
		public static void test1 () {
			System.out.println("what an idiot");
		}
	
		public static void verifySocialAccounts(String sTwitter, String sInstagram) throws Exception {	
			String sExpectedTwitter = "https://twitter.com/WheelsUp";
			String sExpectedInstagram = "http://instagram.com/wheelsup8760";
			
			try {
			
			URL url = new URL("https://marketingapi.wheelsup.com/api/initial-data/%E2%80%8Bformat%3Djson?format=json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

		    
			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
			entireResponse += scan.nextLine();
			
//			System.out.println("Response :" +entireResponse);
			scan.close();
			
			File file = new File (".\\wheelsup.json");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(entireResponse);
			
			fileWriter.flush();
			fileWriter.close();
			

			 // parsing file "wheelsup.json" 
		    Object obj = new JSONParser().parse(new FileReader(".\\wheelsup.json")); 
		      
		    // typecasting obj to JSONObject 
		    JSONObject jo = (JSONObject) obj; 
		      
		    
		    
		    //keys/twitter
		    HashMap sValue1 = (HashMap) jo.get("keys"); 
		    System.out.println("Got: " + sValue1.get(sTwitter).toString()); 
		    System.out.println("Got: " + sValue1.get(sInstagram).toString());
		    
		    String sTwitterSocial = sValue1.get("twitter").toString();
		    String sInstagramSocial = sValue1.get("instagram").toString();
		    
		    assertEquals(sTwitterSocial, sExpectedTwitter);
		    assertEquals(sInstagramSocial, sExpectedInstagram);
		    
		    

			
			conn.disconnect();
				
			}
			catch (MalformedURLException e) {
			e.printStackTrace();
			
				} 
			catch (IOException e) {
			
			e.printStackTrace();
			
				}
			
			}
	}


