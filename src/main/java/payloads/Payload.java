package payloads;

import java.util.HashMap;

public class Payload {
	
	
	//public static String addPlacePayload =
			
		/*	"{\n" + 
				"  \"location\": {\n" + 
				"    \"lat\": -38.383494,\n" + 
				"    \"lng\": 33.427362\n" + 
				"  },\n" + 
				"  \"accuracy\": 50,\n" + 
				"  \"name\": \"Frontline house\",\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\n" + 
				"  \"types\": [\n" + 
				"    \"shoe park\",\n" + 
				"    \"shop\"\n" + 
				"  ],\n" + 
				"  \"website\": \"http://google.com\",\n" + 
				"  \"language\": \"French-IN\"\n" + 
				"}";  */
	
	public static HashMap<String, Object> addPlacePayload()
	{
		HashMap<String, Object> location = new HashMap<>();
		location.put("accuracy", "50");
		location.put("name", "Frontline house");
		location.put("phone_number", "(+91) 983 893 3937");
		location.put("address", "29, side layout, cohen 09");
		location.put("website", "http://google.com");
		location.put("language", "French-IN");
		
		HashMap<String, String> coordinates = new HashMap<>();
		coordinates.put("lat", "-38.383494");
		coordinates.put("lng", "33.427362");
		
		location.put("location", coordinates);
		
		String[] typeValues = {"shoe park" , "shop"};
		location.put("types", typeValues);
		
		return location;
		
	}
			
	
	public static String updatePlacePayload(String placeId)
	{			
		return "{\n" + 
				"\"place_id\":\""+placeId+"\",\n" + 
				"\"address\":\"70 Summer walk, USA\",\n" + 
				"\"key\":\"qaclick123\"\n" + 
				"}";
	}
	
	
	public static String deletePlacePayload(String placeId)
	{
		return "{\n" + 
				"\"place_id\":\""+placeId+"\n" + 
				"}";
	}
	
	
	public static String addBookPayload(String isbn, String aisle) {
		
		return "{\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\n" + 
				"\"isbn\":\""+isbn+"\",\n" + 
				"\"aisle\":\""+aisle+"\",\n" + 
				"\"author\":\"John foe\"\n" + 
				"}";
	}
	
	
	public static String deleteBooks(String Id) {
		
		return "{\n" + 
				"\"ID\" : \""+Id+"\"\n" + 
				"}";		
	}

}
