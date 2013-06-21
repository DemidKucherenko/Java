package ru.ifmo.ctddev.kucherenko.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyMap {
	/**
	 *	Map, which contains all information: index and list of stings, which have this index.
	 */
	 private Map<Integer, List<String>> myMap;
	 
	 /**
	  * Constructs object of this class
	  */
	 MyMap() {
		 myMap = new TreeMap<Integer, List<String>>(); 
	 }
	 
	 /**
	  * Adds pair index-string to map.
	  * @param index Index of string
	  * @param string String, which we add
	  * @return
	  */
	 public boolean add(int index, String string) {
		 if (myMap.containsKey(index)) {
			 List<String> list = myMap.get(index);
			 list.add(string);
			 return true;
		 }
		 List<String> list = new ArrayList<String>();
		 list.add(string);
		 myMap.put(index, list);
		 return true;
	 }
	 
	 /**
	  * Remove all string, which have this index
	  * @param index Index of strings
	  * @return
	  */
	 public boolean remove(int index) {
		 if (!myMap.containsKey(index)) {
			 return true;
		 }
		 myMap.remove(index);
		 return true;
	 }
	 
	 /**
	  * Print all string in order of increase index. If index are equals
	  * print in order of adding
	  */
	 public void print() {
		 for (List<String> strings : myMap.values()) {
			 for (String string : strings) {
				 System.out.println(string);
			 }
		 }
	 }
	   
}
