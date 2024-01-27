package Bissecao;

import java.lang.Math;

public class Bissecao {
	private static Double x;
	
	public static void main(String []args) {
		//Intervalo [a, b] e precisão e
		Double a = -2.5;
		Double b = 1.0;
		Double e = 0.001;
		
		Double orientacao = f(a) * f(b);
		int k = int_max(a, b, e);
		
		if (orientacao < 0) {
			analise(a, b, e);
		} 
		else {
			if (orientacao > 0) {
				analise(a, b, e, k);
			}
			else {
				if(f(a) == 0) {
					x = a;
				} else {
					x = b;
				}
				System.out.println("Uma das extremidades do intervalo é um zero da função");
			}
		}
		
		if (Math.abs(f(x)) < e) {
			System.out.println("Uma aproximação para a raiz foi encontrada: " + x);
			System.out.println(Math.abs(f(x)));
		}
		else {
			System.out.println("Não foi encontrada uma aproximação para a raiz dessa função no intervalo provido");
		}
	}
	
	public static Double f(Double x) {
		//TODO Insira sua função
		Double resp = (x * x) + 5*x + 6;
		return resp;
	}
	
	public static void analise(Double a, Double b, Double e) {
		boolean continuar = true;
		int k = 0;	
		
		while (continuar) {
			x = (a + b)/2;
			k++;
			
			System.out.println("a atual: " + a);
			System.out.println("b atual: " + b);
			System.out.println("x atual: " + x);
			System.out.println("k atual: " + (k + 1) + "\n");
			
			Double fa = f(a);
			Double fb = f(b);
			Double fx = f(x);
			
			
			  if (fa * fx < 0){
				  b = x;
				  
			  } else if (fb * fx < 0) {
					  a = x;
					  
			  }
			  
			/*if ((Math.abs(fa) - Math.abs(fx)) < (Math.abs(fb) - Math.abs(fx))) {
				b = x;
			}
			else {
				a = x;
			}*/
			
			continuar = checagem(x, e);
		}
	}
	
	public static void analise(Double a, Double b, Double e, int k) {
		for(int i = 0; i < k; i++) {
			x = (a + b)/2;
			
			System.out.println("a atual: " + a);
			System.out.println("b atual: " + b);
			System.out.println("x atual: " + x);
			System.out.println("k atual: " + (i + 1));
			
			Double fa = f(a);
			Double fb = f(b);
			Double fx = f(x);
			
			System.out.println("fa: " + fa + "\nfb: " + fb + "\nfx: " + fx + "\n" + Math.abs(fa - fx) + ", " + Math.abs(fb - fx) + "\n");
			
			  if (fa * fx < 0){
				  b = x;
				  
			  } else if (fb * fx < 0) {
					  a = x;
					  
			  }
			
			/*if ((Math.abs(fa) - Math.abs(fx)) < (Math.abs(fb) - Math.abs(fx))) {
				b = x;
			}
			else {
				a = x;
			}*/
			
			if (!checagem(x, e)) {
				i = k;
			}
		}
	}
	
	public static int int_max(Double a, Double b, Double e) {
		int resp = (int) Math.ceil((Math.log10(b - a) - Math.log10(e))/Math.log10(2));
		return resp;
	}
	
	
	public static boolean checagem(Double x, Double e) {
		if (Math.abs(f(x)) < e) {
			return false;
		}
		else {
			return true;
		}
	}
}
