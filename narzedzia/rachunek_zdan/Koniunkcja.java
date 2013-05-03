package narzedzia.rachunek_zdan;

public class Koniunkcja extends Operator2Arg{

	public Koniunkcja(Formula arg1, Formula arg2){
		super(arg1, arg2);
	}

	@Override
	public boolean oblicz(){
		super.oblicz();

//	true  /\ true  return true
//	false /\ true  return false
//	false /\ false return false
//	true  /\ false return false
		if( _wynik1 &&  _wynik2) return true;
		if(!_wynik1 &&  _wynik2) return false;
		if(!_wynik1 && !_wynik2) return false;
		if( _wynik1 && !_wynik2) return false;
		return false;
	}

}