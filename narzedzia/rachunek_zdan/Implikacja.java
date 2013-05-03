package narzedzia.rachunek_zdan;

public class Implikacja extends Operator2Arg{

	public Implikacja(Formula arg1, Formula arg2){
		super(arg1, arg2);
	}

	@Override
	public boolean oblicz(){
		super.oblicz();

//	true  -> true  return true
//	false -> true  return true
//	false -> false return true
//	true  -> false return false
		if( _wynik1 &&  _wynik2) return true;
		if(!_wynik1 &&  _wynik2) return true;
		if(!_wynik1 && !_wynik2) return true;
		if( _wynik1 && !_wynik2) return false;
		return false;
	}

}