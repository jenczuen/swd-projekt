import narzedzia.modulA.*;
import narzedzia.modulB.*;

public class Test {

	private static final int ILOSC_WEJSC = 10;

	public static void main(String[] args){
		GeneratorFormul generator = new GeneratorFormul();
		//U0 - {bieg z gory,  bieg na rownym, bieg pod gore}
		//U1 - {wiatr jest slaby, wiatr jest silny}		
		//U2 - {wiatr jest w plecy, wiatr jest w twarz}		
		//U3 - {podloze asfalt, podloze bierznia, podloze trawa}		
		//U4 - {biegacz wytrenowany, biegacz niewytrenowany}
		//U5 - {oddech rowny, oddech nierowny}
		//U6 - {cisnienie w normie, cisnienie niew w normie}
		//U7 - {puls w normie, puls niew w normie}	
		//U8 - {zmeczenie male, srednie, wysokie, skrajnie wysokie}	
		//U9 - {
		//				spalanie tluszczu, 
		//				wzmocnienie kondycji, 
		//				zwiększenie szybkości, 
		//				utrata przytomnosci,
		//				rekreacja
		//			}	
		int[] input = new int[ILOSC_WEJSC];
		for(int i=0; i < ILOSC_WEJSC; i++){
			input[0] = 0;
		}

		generator.wprowadzWejscia(input);
		Object[] keys = generator.formuly().keySet().toArray();
		Object[] values = generator.formuly().values().toArray();
		for(int i=0; i < values.length; i++){
			System.out.println(keys[i] + " - "  + values[i]);
		}

		DRF drzewo = new DRF(generator.formuly());
		drzewo.oblicz_drzewo();
	}
}
