package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Moto extends Veiculo{
	
	private Double valorAluguel = 0.0;
	private String seguroIncluido = "null";
	
	public Moto() {
		super();
	}

	public Moto(Integer id, String marca, String modelo, Integer ano, Double valorDia, Boolean disp) {
		super(id, marca, modelo, ano, valorDia, disp);
	}
	
	@Override
	public String calcularAluguel(Integer dias, char seguro, Double valorSeguro) {
		
		if(seguro == 'c') {
			valorAluguel = dias * this.valorDia + valorSeguro;
			System.out.println("\nValor com seguro: ");
			System.out.println("R$" + valorAluguel);
			seguroIncluido = "Sim";
			
			return "Valor com seguro: " + "R$" + valorAluguel;
		}
		else if(seguro == 's') {
			valorAluguel = dias * this.valorDia;
    		System.out.println("\nValor sem seguro: ");
    		System.out.println( "R$" + valorAluguel);
    		seguroIncluido = "Não";
    		
    		return "Valor sem seguro: " + "R$" + valorAluguel;
		}
		else {
			return "*** Opção invalida, tente novamente ***";
		}
	}
	
	@Override
	public void confirmarAluguel(char confirm, int dias) {
			
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			
			if(confirm == 'y') {
	        	System.out.println("\n*** Locação confirmada *** ");
	        	System.out.println("Data e hora da locação: " + LocalDateTime.now().format(fmt));
	        	System.out.println("Aluguel do veiculo: " + getMarca() + getModelo());
	        	System.out.println("Por: " + dias + " dias");
	        	System.out.println("Seguro incluido: " + seguroIncluido);
	        	System.out.println("Valor total da locação: " + valorAluguel );
	        	System.out.println("Obrigado, volte sempre.");
	        	
	        	setDisp(false); // Tirando o veiculo da lista de disponivel
			}
	        else if(confirm == 'n') {
				System.out.println("*** Seção finalizada ***");
			}
			else {
				System.out.println("*** Opção invalida, tente novamente ***");
			}
		}
	

	@Override
	public String toString() {
		return "Moto: " + id + ", " + marca + " " + modelo + ", ano: " + ano + ", Valor da diaria: "
				+ valorDia;
	}
}
