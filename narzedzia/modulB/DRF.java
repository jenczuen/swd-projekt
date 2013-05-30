package narzedzia.modulB;

import java.util.HashMap;
import narzedzia.rachunek_zdan.*;

public class DRF {
	private int ILOSC_FORMUL = 29;
	private int ILOSC_FORMUL_IN = 5;

	private Formula drf;
	private HashMap _formuly;
	private String[] mapa;

	public DRF(HashMap formuly){
		_formuly = formuly;
		Zmienna.zbiorWartosci = _formuly;
	}

	private void stworz_drzewo(){
		Formula f1, f2, f3, f4, f5, f6, f7, f8, f9;

		//F1 = [~(aw1) i (au19)] lub [(aw1) i (au20)] -> (aw3)
		f1 = new Implikacja(
					new Alternatywa(
						new Koniunkcja(new Negacja(new Zmienna("w1")), new Zmienna("u19")),
						new Koniunkcja(new Zmienna("w1"), new Zmienna("u20"))
					), 
					new Zmienna("w3")
				);

		//F2 = ~(aw1) lub (au16) -> (aw4)
		f2 = new Implikacja(
					new Alternatywa(new Negacja(new Zmienna("w1")), new Zmienna("u16")), 
					new Zmienna("w4")
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
						new Negacja(new Zmienna("w4")),
						new Koniunkcja(
							new Alternatywa(new Zmienna("u1"), new Zmienna("u2")),
							new Koniunkcja(
								new Alternatywa(new Zmienna("u3"), new Zmienna("u4")),
								new Alternatywa(
									new Koniunkcja(
										new Alternatywa(new Zmienna("u5"), new Zmienna("u6")),
										new Alternatywa(new Zmienna("u8"), new Zmienna("u9"))
									),
									new Zmienna("u7")
								)
							)
						)
					),
					new Zmienna("w1")
				);

		//F4 = (au11) i (au12) i (au13) i ~(au17) -> (aw2)
		f4 = new Implikacja(
					new Koniunkcja(
						new Zmienna("u11"),
						new Koniunkcja(
							new Zmienna("u12"),
							new Koniunkcja(
								new Zmienna("u13"),
								new Negacja(new Zmienna("u17"))
							)
						)
					), 
					new Zmienna("w2")
				);

		//F5 = (aw1) i ~(au10) i (aw3) i [(au15) lub (au16)] -> (ay1)
		f5 = new Implikacja(
					new Koniunkcja(
						new Zmienna("w1"),
						new Koniunkcja(
							new Negacja(new Zmienna("u10")),
							new Koniunkcja(
								new Zmienna("w3"),
								new Alternatywa(new Zmienna("u15"), new Zmienna("u16"))
							)
						)
					), 
					new Zmienna("y1")
				);

		//F6 = (au10) i (aw3) i [(au15) lub (au16)] -> (ay2)
		f6 = new Implikacja(
					new Koniunkcja(
						new Zmienna("u10"),
						new Koniunkcja(
							new Zmienna("w3"),
							new Alternatywa(new Zmienna("u15"),new Zmienna("u16"))
						)
					), 
					new Zmienna("y2")
				);


		//F7 =  (aw1) i  (au10) i (aw3) i (au20) i [(au15) lub (au16)] -> (ay3)
		f7 = new Implikacja(
					new Koniunkcja(
						new Zmienna("w1"),
						new Koniunkcja(
							new Zmienna("u10"),
							new Koniunkcja(
								new Zmienna("w3"),
								new Koniunkcja(
									new Zmienna("u20"),
									new Alternatywa(new Zmienna("u15"), new Zmienna("u16"))
								)
							)
						)
					), 
					new Zmienna("y3")
				);

		//F8 = ~(aw2) i ~(au10) i [(aw4) lub (au17)] -> (ay4)
		f8 = new Implikacja(
					new Koniunkcja(
						new Negacja(new Zmienna("w2")),
						new Koniunkcja(
							new Negacja(new Zmienna("u10")),
							new Alternatywa(new Zmienna("w4"), new Zmienna("u17"))
						)
					), 
					new Zmienna("y4")
				);

		//F9 =  (aw2) i (aw1) i (au14) i [(au18) lub (au19)] -> (ay5)
		f9 = new Implikacja(
					new Koniunkcja(
						new Zmienna("w2"),
						new Koniunkcja(
							new Zmienna("w1"),
							new Koniunkcja(
								new Zmienna("u14"),
								new Alternatywa(new Zmienna("u18"), new Zmienna("u19"))
							)
						)
					), 
					new Zmienna("y5")
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

	public boolean oblicz_drzewo(){
/*		for(int i=0; i < ILOSC_FORMUL_IN; i++){
			_a[mapa[i]].ustal(args[i]);
			System.out.println("a" + Integer.toString(i) + " - " + _a[mapa[i]].oblicz());
		}
		_a[6].ustal(false);*/

		//System.out.println("a6 - " + _a[6].oblicz());

		stworz_drzewo();

		boolean f = drf.oblicz();
		System.out.println("F - " + f);		

		return !f;
	}
}	