package narzedzia.rachunek_zdan;

import java.util.HashMap;

public class Zmienna extends Formula{
	public static HashMap zbiorWartosci;
	private String _klucz;
//	private Boolean _wartosc;

	public Zmienna(String klucz){
		_klucz = klucz;
	}

	public boolean oblicz(){
		return ((Boolean)zbiorWartosci.get(_klucz)).booleanValue();
		//return _wartosc;
	}

	//tego nie potrzebujemy
	public void ustal(boolean wartosc){
		//zbior.put(_klucz, new Boolean(wartosc));
		//_wartosc = wartosc;
	}

}