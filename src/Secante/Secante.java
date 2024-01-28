package Secante;

import java.lang.Math;

public class Secante {
	//TODO Valor inicial e intervalo
	private static Double x = -10.0;
	private static Double a = -13.0;
	private static Double b = 2.0;
	private static boolean parada = false;
	
	public static void main(String []args) {
		Double h = 0.001;
		Double e = 0.001;
		

		Double orientacao = f(a) * f(b);
		
		if(orientacao < 0) {
			analise(e, h);
		} else {
			if(orientacao > 0) {
				System.out.println("Por favor melhore o intervalo");
			} else {
				if(f(a) == 0) {
					x = a;
				} else {
					x = b;
				}
				System.out.println("Uma das extremidades do intervalo é um zero da função");
			}
		}
		
		if (parada) {
			System.out.println("Uma aproximação para a raiz foi encontrada: " + x);
		}
		else {
			System.out.println("Não foi encontrada uma aproximação para a raiz dessa função no intervalo provido");
			System.out.println("Você pode tentar mudar a g(x) também, existem muitas possibilidades");
		}
	}
	
	public static void analise(Double e, Double h) {
		Double xk2 = x - h;
		Double xk1 = x;
		int i = 0;
		
		System.out.println("X0: " + x + "\n");
		
		if (f(x) < e) {
			parada = true;
		} else {
			while (!parada)	{
				i++;
				
				x = xk1 - ((f(xk1))/((f(xk1) - f(xk2))/(xk1 - xk2)));
				xk2 = xk1;
				xk1 = x;
				
				System.out.println("valor atual: " + x);
				System.out.println("iteração: " + i + "\n");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				checagem(e, xk2);
			}
		}
	}
	
	public static void checagem(Double e, Double x0) {
		if (Math.abs(f(x)) < e || Math.abs(x - x0) < e) {
			parada = true;
		} else {
			parada = false;
		}
	}
	
	public static Double f(Double x) {
		//TODO Insira sua função principal
		Double resp = (x*x*x) + 12*(x*x) - 9;
		return resp;
	}
	
	public static Double fD(Double x, Double h) {
		Double resp = (f(x + h) - f(x - h))/(2 * h);
		return resp;
	}
}
