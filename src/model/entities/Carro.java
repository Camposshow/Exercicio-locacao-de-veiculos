package model.entities;

import model.services.Seguro;

public class Carro extends Veiculo{
	
	public Carro() {
		super();
	}

	public Carro(Integer id, String marca, String modelo, Integer ano, Double valorDia, Boolean disp, Seguro seguro) {
		super(id, marca, modelo, ano, valorDia, disp, seguro);
	}
	
	@Override
	public Double calcularAluguel(int dias) {
		return valorDia * dias;
	}	
	
	@Override
	public String toString() {
		return "Carro: " + id + ", " + marca + " " + modelo + ", ano: " + ano + ", Valor da diaria: "
				+ valorDia + ", Valor seguro: " + seguro.getValorSeguro();
	}
	
	
	


}
