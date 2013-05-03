package narzedzia.rachunek_zdan;

import java.util.HashMap;

public class Zmienna extends Formula{
	private static HashMap zbior = new HashMap();
	private String _klucz;

	public Zmienna(String klucz){
		_klucz = klucz;
	}

	public boolean oblicz(){
		return ((Boolean)zbior.get(_klucz)).booleanValue();
	}

	public void ustal(boolean wartosc){
		zbior.put(_klucz, new Boolean(wartosc));
	}

}