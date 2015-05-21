package se.mah.k3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Helpers {
	
	
	/**
	 * Konverterar r�ster i anal till procent
	 * @param HashMap<String, Integer> stoppa in FirebaseDatas HashMap "inData"
	 * @return HashMap<String, Double> f� ut procent som decimaltal mellan 0,0 och 1
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
	
	/**
	 * R�knar ut var en stapel som v�xewr upp�t ska b�rja i Y led 
	 * @param int T�nk dig grafens yta som en rektangel, detta �r Y-v�rdet f�r det �vre v�nstra h�rnet.
	 * @param int T�nk dig grafens yta som en rektangel, detta �r hur h�g den �r.
	 * @param double Detta �r antalet votes i procent som decimaltal mellan 0,0 och 1
	 * @return float ett yv�rde i pixlar
	 * */
	public static float getYOrgin(int graphYPos, int graphMaxHeight, double votesInPercent){
		return (float) ((graphYPos + graphMaxHeight) - (graphMaxHeight * votesInPercent));
	}
}
