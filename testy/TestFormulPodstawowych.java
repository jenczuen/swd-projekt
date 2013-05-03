import narzedzia.obliczenia.*;

import java.util.HashMap;

public class TestFormulPodstawowych {
	public static void main(String[] args){
		Formula f;
		int i=1;

		Zmienna a1 = new Zmienna("a1");
		Zmienna a2 = new Zmienna("a2");

		//koniunkcja
		f = new Koniunkcja(a1, a2);
//	true  /\ true  return true
		a1.ustal(true);	a2.ustal(true); test(i++, true, f.oblicz());
//	false /\ true  return false
		a1.ustal(false);	a2.ustal(true); test(i++, false, f.oblicz());
//	false /\ false return false
		a1.ustal(false);	a2.ustal(false); test(i++, false, f.oblicz());
//	true  /\ false return false
		a1.ustal(true);	a2.ustal(false); test(i++, false, f.oblicz());

		//alternatywa
		f = new Alternatywa(a1, a2);
//	true  \/ true  return true
		a1.ustal(true);	a2.ustal(true); test(i++, true, f.oblicz());
//	false \/ true  return true
		a1.ustal(false);	a2.ustal(true); test(i++, true, f.oblicz());
//	false \/ false return false
		a1.ustal(false);	a2.ustal(false); test(i++, false, f.oblicz());
//	true  \/ false return true
		a1.ustal(true);	a2.ustal(false); test(i++, true, f.oblicz());

		//implikacja
		f = new Implikacja(a1, a2);
//	true  -> true  return true
		a1.ustal(true);	a2.ustal(true); test(i++, true, f.oblicz());
//	false -> true  return true
		a1.ustal(false);	a2.ustal(true); test(i++, true, f.oblicz());
//	false -> false return true
		a1.ustal(false);	a2.ustal(false); test(i++, true, f.oblicz());
//	true  -> false return false
		a1.ustal(true);	a2.ustal(false); test(i++, false, f.oblicz());


		//rownowaznosc
		f = new Rownowaznosc(a1, a2);
//	true  <-> true  return true
		a1.ustal(true);	a2.ustal(true); test(i++, true, f.oblicz());
//	false <-> true  return false
		a1.ustal(false);	a2.ustal(true); test(i++, false, f.oblicz());
//	false <-> false return true
		a1.ustal(false);	a2.ustal(false); test(i++, true, f.oblicz());
//	true  <-> false return false
		a1.ustal(true);	a2.ustal(false); test(i++, false, f.oblicz());

	}

	public static void test(int index, boolean oczekiwana, boolean otrzymana) {
		System.out.println(Integer.toString(index) + (oczekiwana == otrzymana ? " good\n" : " bad\n"));
	}
}