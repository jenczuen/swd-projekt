package narzedzia.modulA;

public class KonwenterWejsciaNaFormuly {

	public static boolean[] konwertuj_wejscie(double[] args){
		if(args.length == 5){
			// wejscia
			// c1 - Ciśnienie krwi (skurczowe)
			// c2 - Ciśnienie krwi (rozkurczowe)
			// p - Puls
			// t1 - Temperatura ciała
			// t2 - Temperatura na zewnątrz
			double c1 = args[0];
			double c2 = args[1];
			double p  = args[2];
			double t1 = args[3];
			double t2 = args[4];

			// wyjscia
			// a0 – temperatura na zewnątrz jest za wysoka
			// a1 – temperatura ciała jest za wysoka
			// a2 – ciśnienie jest niskie
			// a3 – ciśnienie jest wysokie
			// a4 – puls jest niski
			// a5 – puls jest wysoki
			int ilosc_formul = 6;
			boolean[] a_u = new boolean[ilosc_formul];

			// reguly konwersji
			// a0 - temperatura na zewnątrz jest za wysoka, gdy t2 > 70
			a_u[0] = t2 > 70.0 ? true : false;
			// a1 - temperatura ciała jest za wysoka, gdy t1 > 37
			a_u[1] = t1 > 37.0 ? true : false;
			// a2 - ciśnienie jest za niskie, gdy c1 < 100 i c2 < 65
			a_u[2] = (c1 < 100.0 && c2 < 65.0) ? true : false;
			// a3 - ciśnienie jest za wysokie, gdy c1 > 150 i c2 > 100
			a_u[3] = (c1 > 150.0 && c2 > 100.0) ? true : false;
			// a4 - puls jest za niski, gdy p < 60
			a_u[4] = p < 60.0 ? true : false;
			// a5 - puls jest za wysoki, gdy p > 120
			a_u[5] = p > 120.0 ? true : false;

			return a_u;
		}
		return null;
	}
}