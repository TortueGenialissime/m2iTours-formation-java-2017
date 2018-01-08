package Formation;
public class Calcul
{
	static int arg1;
	static int arg2;
public void setArg1(int arg1) {
		this.arg1 = arg1;
	}
	public void setArg2(int arg2) {
		this.arg2 = arg2;
	}
public static int getSomme(){
return arg2+arg1;
}
public static int getProduit(){
	return arg2*arg1;
}
}