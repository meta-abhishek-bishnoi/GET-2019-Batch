package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import utility.BalancedTree;
import utility.Dictonary;
import utility.Loader;
import utility.Service;

public class TestTree {

	private static BalancedTree bst;
	private static Service service;
	private static Dictonary root;
	private static JSONArray elementList;
	private static int resultKey[];
	private static String resultValue[];
	@BeforeClass
	public static void init(){
		bst = new BalancedTree();
		service = new Service();
		service.setMap();
		root = service.getMap();
		elementList = new Loader().loadJSON();
		resultKey = new int[elementList.size()];
		resultValue = new String[elementList.size()];
		for(int i=0; i<elementList.size(); i++){
			JSONObject element = (JSONObject) elementList.get(i);
			JSONObject elementObject = (JSONObject) element.get("keyValue");
			resultKey[i] = (int)((Long) elementObject.get("key")).intValue();  
			resultValue[i] = (String) elementObject.get("value");
		}
	}
	
	@Test
	public void getSortedPair(){
		List<Dictonary> list = service.getSortedPair();
		int count=0;
		for(Dictonary dir: list){
			//System.out.println(dir.getKey()+" " +resultKey[count]);
			assertEquals(resultKey[count],dir.getKey());
			assertEquals(resultValue[count],dir.getValue());
			count++;
		}
	}
	@Test
	public void getSortedPairInRange(){
		List<Dictonary> list = service.getSortedPair(2,4);
		int count=0;
		for(Dictonary dir: list){
			if(resultKey[count]>=2 && resultKey[count]<=4){
				System.out.println(dir.getKey()+" " +resultKey[count]);
				assertEquals(resultKey[count],dir.getKey());
				assertEquals(resultValue[count],dir.getValue());
			}
			count++;
		}
	}
}
