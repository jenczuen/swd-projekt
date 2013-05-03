package narzedzia.rachunek_zdan;

public class Negacja extends Formula{

	private Formula _arg1;

	public Negacja(Formula arg1){
		_arg1 = arg1;
	}

	public boolean oblicz(){
		return !_arg1.oblicz();
	}

}