package se.mah.k3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Helpers {
	
	
	/**
	 *Extracts hour and minutes from a dateDimestring
	 * @param HashMap<String, Integer> stoppa in FirebaseDatas HashMap "inData"
	 * @return HashMap<String, Double> få ut procent som decimaltal mellan 0,0 och 1
	 * */
	@SuppressWarnings("null")
	public static HashMap<String, Double> calcPercent(HashMap<String, Integer> hash){
		HashMap<String, Double> result = null;
		Integer total = 0;
		
		// Get all values from the HashMap.
		Collection<Integer> values = hash.values();
		for (Integer value : values) {
		    total += value;
		}
		
		// Get keys.
		Set<String> keys = hash.keySet();
		// Loop over String keys.
		for (String key : keys) {
		    result.put(key, (double) (hash.get(key)/total));
		}
		
		return result;
	}
}
