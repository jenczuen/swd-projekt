package narzedzia.modulB;

import java.util.HashMap;
import narzedzia.rachunek_zdan.*;

public class DRF {
	private int ILOSC_FORMUL = 29;
	private int ILOSC_FORMUL_IN = 5;

	private Formula drf;
	private HashMap _a;
	private String[] mapa;

	public DRF(HashMap a){
		_a = a;
		mapa = new String[ILOSC_FORMUL];
		mapa[0] = "w1" //warunki do biegu sa dobre
		mapa[1] = "w2" //parametry zyciowe biegacza ok
		mapa[2] = "w3" //bieg jest intensywny
		mapa[3] = "w4" //bieg jest bardzo męczący	
		mapa[4] = "u1" //bieg z gory
		mapa[5] = "u2" //bieg na rownym
		mapa[6] = "u3" //wiatr jest slaby
		mapa[7] = "u4" //wiatr jest w plecy
		mapa[8] = "u5" //podloze asfalt
		mapa[9] = "u6" //podloze bierznia
		mapa[10] = "u7" //podloze trawa
		mapa[11] = "u8" //obuwie rekreacyjne
		mapa[12] = "u9" //obuwie wyczynowe
		mapa[13] = "u10" //biegacz wytrenowany
		mapa[14] = "u11" //oddech rowny
		mapa[15] = "u12" //cisnienie w normie
		mapa[16] = "u13" //puls w normie
		mapa[17] = "u14" //zmeczenie male
		mapa[18] = "u15" //zmeczenie srednie
		mapa[19] = "u16" //zmeczenie wysokie
		mapa[20] = "u17" //zmeczenie skrajnie wysokie (poziom zmeczenia < 8)
		mapa[21] = "u18" //predkosc niska
		mapa[22] = "u19" //predkosc srednia
		mapa[23] = "u20" //predkosc wysoka
		mapa[24] = "y1" //spalanie tluszczu
		mapa[25] = "y2" //wzmocnienie kondycji
		mapa[26] = "y3" //zwiększenie szybkości
		mapa[27] = "y4" //utrata przytomnosci
		mapa[28] = "y5" //rekreacja
	}

	public void stworz_drzewo(){
		//F1 = [~(aw1) i (au19)] lub [(aw1) i (au20)] -> (aw3)
		f1 = new Implikacja(
					new Alternatywa(
						new Koniunkcja(new Negacja(_a["w1"]), _a["u19"]),
						new Koniunkcja(_a["w1"], _a["u20"])
					), 
					_a["w3"]
				);

		//F2 = ~(aw1) lub (au16) -> (aw4)
		f2 = new Implikacja(
					new Alternatywa(new Negacja(_a["w1"]), _a["u16"]), 
					_a["w4"]
				);
		
		/*
		F3 = ~(aw4) lub
			(	
				[(au1) lub (au2)] i
				[(au3) lub (au4)] i
				[
					[((au5) lub (au6)) i ((au8) lub (au9))] lub (au7) 
				]
			) -> (aw1)
		*/
		f3 = new Implikacja(
					new Alternatywa(
						new Negacja(_a["w4"]),
						new Koniunkcja(
							new Alternatywa(_a["u1"], _a["u2"]),
							new Koniunkcja(
								new Alternatywa(_a["u3"], _a["u4"]),
								new Alternatywa(
									new Koniunkcja(
										new Alternatywa(_a["u5"], _a["u6"]),
										new Alternatywa(_a["u8"], _a["u9"])
									),
									_a["u7"]
								}
							)
						), 
						_a["w1"]
					)
				);

		//F4 = (au11) i (au12) i (au13) i ~(au17) -> (aw2)
		f4 = new Implikacja(
					new Koniunkcja(
						_a["u11"],
						new Koniunkcja(
							_a["u12"],
							new Koniunkcja(
								_a["u13"],
								new Negacja(_a["u13"])
							}
						)
					), 
					_a["w2"]
				);

		//F5 = (aw1) i ~(au10) i (aw3) i [(au15) lub (au16)] -> (ay1)
		f5 = new Implikacja(
					new Koniunkcja(
						_a["w1"],
						new Koniunkcja(
							new Negacja(_a["u10"]),
							new Koniunkcja(
								_a["w3"],
								new Alternatywa(_a["u15"], _a["u16"])
							}
						)
					), 
					_a["y1"]
				);

		//F6 = (au10) i (aw3) i [(au15) lub (au16)] -> (ay2)
		f6 = new Implikacja(
					new Koniunkcja(
						_a["u10"],
						new Koniunkcja(
							_a["w3"],
							new Alternatywa(_a["u15"], _a["u16"])
						)
					), 
					_a["y2"]
				);


		//F7 =  (aw1) i  (au10) i (aw3) i (au20) i [(au15) lub (au16)] -> (ay3)
		f7 = new Implikacja(
					new Koniunkcja(
						_a["w1"],
						new Koniunkcja(
							_a["u10"],
							new Koniunkcja(
								_a["w3"],
								new Koniunkcja(
									_a["u20"],
									new Alternatywa(_a["u15"], _a["u16"])
								)
							)
						)
					), 
					_a["y3"]
				);

		//F8 = ~(aw2) i ~(au10) i [(aw4) lub (au17)] -> (ay4)
		f8 = new Implikacja(
					new Koniunkcja(
						new Negacja(_a["w2"]),
						new Koniunkcja(
							new Negacja(_a["u10"]),
							new Alternatywa(_a["w4"], _a["u17"])
						)
					), 
					_a["y4"]
				);

		//F9 =  (aw2) i (aw1) i (au14) i [(au18) lub (au19)] -> (ay5)
		f9 = new Implikacja(
					new Koniunkcja(
						_a["w2"],
						new Koniunkcja(
							_a["w1"],
							new Koniunkcja(
								_a["u14"],
								new Alternatywa(_a["u18"], _a["u19"])
							)
						)
					), 
					_a["y5"]
				);


		drf = new Koniunkcja(
						f1,
						new Koniunkcja(
							f2,
							new Koniunkcja(
								f3,
								new Koniunkcja(
									f4,
									new Koniunkcja(
										f5,
										new Koniunkcja(
											f6,
											new Koniunkcja(
												f7,
												new Koniunkcja(f8, f9)
											)
										)
									)
								)
							)
						)
					); 
	}

	public boolean oblicz_drzewo(boolean[] args){

		for(int i=0; i < ILOSC_FORMUL_IN; i++){
			_a[mapa[i]].ustal(args[i]);
			System.out.println("a" + Integer.toString(i) + " - " + _a[mapa[i]].oblicz());
		}
		_a[6].ustal(false);

		System.out.println("a6 - " + _a[6].oblicz());

		boolean f = drf.oblicz();
		System.out.println("F - " + f);		

		return !f;
	}
}	