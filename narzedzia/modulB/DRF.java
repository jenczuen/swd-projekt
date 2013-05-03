package narzedzia.modulB;

import narzedzia.rachunek_zdan.*;

public class DRF {
	private int ILOSC_FORMUL = 7;
	private int ILOSC_FORMUL_WE = 6;

	private Formula drf;
	private Zmienna[] a;

	public void stworz_drzewo(){
		a = new Zmienna[ILOSC_FORMUL];

		for(int i=0; i < ILOSC_FORMUL; i++){
			a[i] = new Zmienna("a"+Integer.toString(i));
		}

		drf = new Implikacja(
			new Alternatywa(
				new Alternatywa(
					new Alternatywa(a[0], a[1]),
					new Koniunkcja(a[2], a[5])	
				),
				new Koniunkcja(a[2], a[3])
			), 
			a[6]
		);
	}

	public boolean oblicz_drzewo(boolean[] args){

		for(int i=0; i < ILOSC_FORMUL_WE; i++){
			a[i].ustal(args[i]);
			System.out.println("a" + Integer.toString(i) + " - " + a[i].oblicz());
		}
		a[6].ustal(false);

		System.out.println("a6 - " + a[6].oblicz());

		boolean f = drf.oblicz();
		System.out.println("F - " + f);		

		return !f;
	}
}