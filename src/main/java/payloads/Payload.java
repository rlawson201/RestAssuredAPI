package payloads;

public class Payload {
	
	public static String addPlacePayload = 
			"{\n" + 
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
				"}";
	
	
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
