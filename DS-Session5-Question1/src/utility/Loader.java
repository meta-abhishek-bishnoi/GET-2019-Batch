package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Loader {
	public JSONArray loadJSON(){
		 JSONParser jsonParser = new JSONParser();
		 JSONArray elementList = null;
	     try (FileReader reader = new FileReader("dictonary.json"))
	     {
	          Object obj = jsonParser.parse(reader);
	          elementList = (JSONArray) obj; 
	     } catch (FileNotFoundException e) {
	          e.printStackTrace();
	     } catch (IOException e) {
	          e.printStackTrace();
	     } catch (ParseException e) {
	         	e.printStackTrace();
	     }
	     return elementList;
	}
}
