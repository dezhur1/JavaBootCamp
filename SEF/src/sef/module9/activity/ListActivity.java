package sef.module9.activity;
//Needs to be completed

import java.util.*;

public class ListActivity {

	public static void main(String[] args) {
		//1 - Type code to create a list of names. Use ArrayList.
		List list = new ArrayList();
		list.add("A");
		list.add("B");
		list.add("C");
		
		//2 - Call print method to print the list passed as its parameter.
//		ListSample obj = new ListSample();
//		obj.
		print(list);
		
	}
	
	static void print(List list)
	{
		//3 - Type code to print this list
		//Notice the order in which elements get printed.
		Set keySet = list.keySet();
		
		Iterator it=keySet.iterator();
		while(it.hasNext())
		{
			String key=(String)it.next();
			System.out.println(key+"\t"+list.get(key));
		}
	
	}
}
