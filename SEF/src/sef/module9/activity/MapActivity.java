package sef.module9.activity;
//Needs to be completed

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import sef.module9.sample.MapSample;


public class MapActivity {

		public static void main(String[] args) {
			//1 - Type code to create a HashMap of key value pair
			//where key is id of type String and value is a name
			Map map = new HashMap();
			map.put("1", "Name 1");
			map.put("2", "Name 2");
			map.put("3", "Name 3");
			map.put("4", "Name 4");

			
			//2 - Call print method to print the map passed as its parameter.
			print(map);
		
		}
		
		static void print(Map map)
		{
			//3 - Type code to print this map
			Set keySet = map.keySet();
			
			Iterator it=keySet.iterator();
			while(it.hasNext())
			{
				String key=(String)it.next();
				System.out.println(key+"\t"+map.get(key));
			}
		
		}
	}
