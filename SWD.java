import narzedzia.modulA.*;
import narzedzia.modulB.*;

public class SWD {
	public static void main(String[] args){
		
		KonwenterWejsciaNaFormuly konwerter = new KonwenterWejsciaNaFormuly();
		DRF drzewo = new DRF();

		// wejscia
		// c1 - Ciśnienie krwi (skurczowe)
		// c2 - Ciśnienie krwi (rozkurczowe)
		// p - Puls
		// t1 - Temperatura ciała
		// t2 - Temperatura na zewnątrz
		double[] u = {87.0, 50.0, 100.0, 39, 50.1};

		boolean[] a_u = konwerter.konwertuj_wejscie(u);

		drzewo.stworz_drzewo();
		String out = drzewo.oblicz_drzewo(a_u) ? "uciekaj!\n" : "jest git\n";
		System.out.println(out);
	}
}