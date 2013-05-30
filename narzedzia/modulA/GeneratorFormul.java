package narzedzia.modulA;

import java.util.HashMap;

public class GeneratorFormul {

	private HashMap _a;

	public GeneratorFormul(){
		_a = new HashMap();
		//wypelniamy domyslnymi wartosciami wszystko 
		for(int i=1; i <= 20; i++){
			_a.put("u" + i, false);
		}
		for(int i=1; i <= 5; i++){
			_a.put("y" + i, false);
		}
		for(int i=1; i <= 4; i++){
			_a.put("w" + i, false);
		}
	}

	public void wprowadzWejscia(int[] input){
		//U0 {bieg z gory,  bieg na rownym, bieg pod gore}
		//"u1" - bieg z gory
		//"u2" - bieg na rownym
		if(input[0] == 0){
			_a.put("u1", true);
		} else if(input[0] == 1){
			_a.put("u2", true);
		}
		//U1 {wiatr jest slaby, wiatr jest silny}		
		//"u3" - wiatr jest slaby
		if(input[1] == 0){
			_a.put("u3", true);
		}
		//U2 - {wiatr jest w plecy, wiatr jest w twarz}		
		//"u4" - wiatr jest w plecy	
		if(input[2] == 0){
			_a.put("u4", true);
		}
		//U3 - {podloze asfalt, podloze bierznia, podloze trawa}		
		//"u5" - podloze asfalt
		//"u6" - podloze bierznia
		//"u7" - podloze trawa
		if(input[3] == 0){
			_a.put("u5", true);
		} else if(input[3] == 1){
			_a.put("u6", true);
		} else if(input[3] == 2){
			_a.put("u7", true);
		}
		//U4 - {biegacz wytrenowany, biegacz niewytrenowany}
		//"u10" - biegacz wytrenowany
		if(input[4] == 0){
			_a.put("u10", true);
		}
		//U5 - {oddech rowny, oddech nierowny}
		//"u11" - oddech rowny
		if(input[5] == 0){
			_a.put("u11", true);
		}
		//U6 - {cisnienie w normie, cisnienie niew w normie}
		//"u12" - cisnienie w normie
		if(input[6] == 0){
			_a.put("u12", true);
		}
		//U7 - {puls w normie, puls niew w normie}	
		//"u13" - puls w normie
		if(input[7] == 0){
			_a.put("u13", true);
		}
		//U8 - {zmeczenie male, srednie, wysokie, skrajnie wysokie}	
		//"u14" - zmeczenie male
		//"u15" - zmeczenie srednie
		//"u16" - zmeczenie wysokie
		//"u17" - zmeczenie skrajnie wysokie (poziom zmeczenia < 8)
		if(input[8] == 0){
			_a.put("u14", true);
		} else if(input[8] == 1){
			_a.put("u15", true);
		} else if(input[8] == 2){
			_a.put("u16", true);
		} else if(input[8] == 3){
			_a.put("u17", true);
		}
		//U9 - {
		//				spalanie tluszczu, 
		//				wzmocnienie kondycji, 
		//				zwiększenie szybkości, 
		//				utrata przytomnosci,
		//				rekreacja
		//			}	
		//"y1" - spalanie tluszczu
		//"y2" - wzmocnienie kondycji
		//"y3" - zwiększenie szybkości
		//"y4" - utrata przytomnosci
		//"y5" - rekreacja
		if(input[9] == 0){
			_a.put("y1", true);
		} else if(input[9] == 1){
			_a.put("y2", true);
		} else if(input[9] == 2){
			_a.put("y3", true);
		} else if(input[9] == 3){
			_a.put("y4", true);
		}		
	}

	public HashMap formuly(){
		return _a;
	}

}