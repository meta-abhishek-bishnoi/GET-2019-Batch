/**
 * This Class is Loder Class For Getting Data From JSON File
 * @author Abhishek Bishnoi
 * @since Aug 4, 2019
 */
package meta.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoadElements {
	public Map<Character,Integer> map = new HashMap<Character,Integer>();
	public Map<Character,Integer> loadElements(){
		map.put('(',0);
		readJSON();
		return map;
	}
	private void readJSON() {
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("components.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray elementList = (JSONArray) obj;
            //Iterate over employee array
            elementList.forEach( element -> parseEmployeeObject( (JSONObject) element ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
	}
	private void parseEmployeeObject(JSONObject element) {
		JSONObject elementObject = (JSONObject) element.get("element");
		String symbol = (String) elementObject.get("symbol");
		String atomicWeight = (String) elementObject.get("atomicWeight");
		int weight = Integer.parseInt(atomicWeight);
		map.put(symbol.charAt(0), weight);
	}
}
