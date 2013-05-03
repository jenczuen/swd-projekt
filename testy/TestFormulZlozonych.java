import narzedzia.obliczenia.*;

public class TestFormulZlozonych {
	public static void main(String[] args){

		int ilosc_formul=7;
		Zmienna[] a = new Zmienna[ilosc_formul];

		for(int i=0; i < ilosc_formul; i++){
			a[i] = new Zmienna("a"+Integer.toString(i));
		}

		Formula f;
		f = new Implikacja(
			new Alternatywa(
				new Alternatywa(
					new Koniunkcja(a[0], a[1]),
					new Koniunkcja(a[2], a[5])	
				),
				new Koniunkcja(a[2], a[3])
			), 
			a[6]
		);

		a[0].ustal(false);
		a[1].ustal(false);
		a[2].ustal(true);
		a[3].ustal(true);
		a[4].ustal(false);
		a[5].ustal(false);
		a[6].ustal(true);

		test(1, true, f.oblicz()); 
	}

	public static void test(int index, boolean oczekiwana, boolean otrzymana) {
		System.out.println(Integer.toString(index) + (oczekiwana == otrzymana ? " good\n" : " bad\n"));
	}
}