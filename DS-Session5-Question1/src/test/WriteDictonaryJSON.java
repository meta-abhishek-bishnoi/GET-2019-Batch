package test;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteDictonaryJSON {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	        JSONArray list = new JSONArray();
	        // Adding A Component
	        JSONObject keyValue;
	     // Adding Component As Element
	        JSONObject keyValueObject;
	        int keys[] = Data.key;
	        String values[] = Data.values;
	        for(int i=0; i<keys.length; i++){
	        	keyValue = new JSONObject();
	        	keyValue.put("key", keys[i]);
	        	keyValue.put("value", values[i]);
	        	keyValueObject = new JSONObject();
	        	keyValueObject.put("keyValue", keyValue);
	            list.add(keyValueObject);
	        }
	        try (FileWriter file = new FileWriter("dictonary.json")) {
	        	 
	            file.write(list.toJSONString());
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
