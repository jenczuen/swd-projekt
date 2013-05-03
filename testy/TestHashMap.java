import narzedzia.obliczenia.*;

import java.util.HashMap;

public class TestHashMap {
	public static void main(String[] args){
		HashMap zbior = new HashMap();
		zbior.put("Jeden", new Boolean(true));
		zbior.put("Dwa", new Boolean(false));

		System.out.println(((Boolean)zbior.get("Jeden")).booleanValue());
		System.out.println(((Boolean)zbior.get("Dwa")).booleanValue());
	}
}