package narzedzia.rachunek_zdan;

public class Operator2Arg extends Formula{

	protected Formula _arg1;
	protected Formula _arg2;

	protected boolean _wynik1;
	protected boolean _wynik2;	

	public Operator2Arg(Formula arg1, Formula arg2){
		_arg1 = arg1;
		_arg2 = arg2;
	}

	public boolean oblicz(){
		_wynik1 = _arg1.oblicz();
		_wynik2 = _arg2.oblicz();
		return true;
	}

}