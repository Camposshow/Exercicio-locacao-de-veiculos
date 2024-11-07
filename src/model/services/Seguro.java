package model.services;

public class Seguro {
	
	private final static Double valorPadraoSeguro = 100.00; // Constante com o valor padrão do seguro
	
	
	public Seguro() {
		
	}

	public Double getValorPadraoSeguro() {
		return valorPadraoSeguro;
	}
	
	//O seguro é calculado de acordo com algumas informações do cliente 
	public static Double calcularSeguro(int dias, int idade) {
		if(idade >= 18 && idade <= 21) {
			return valorPadraoSeguro * 3 + (dias * 10);
		}
		else if(idade >= 60){
			return valorPadraoSeguro * 2 + (dias * 10);
		}
		else {
			return valorPadraoSeguro + (dias * 5);
		}
				
	}
	
	
	
	
}
