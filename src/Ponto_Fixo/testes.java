package Ponto_Fixo;

public class testes {
	public static void main(String []args) {
		System.out.println(f(-2.0));
	}
	
	public static Double f(Double x) {
		//TODO Insira sua função principal
		Double resp = (x*x) + 5*x + 6;
		return resp;
	}
	
	public static Double g(Double x) {
		//TODO Insira uma função tal que quando f(x) = 0 => g(x) = x
		Double resp = (-(x*x) - 6/5);
		return resp;
	}
}
