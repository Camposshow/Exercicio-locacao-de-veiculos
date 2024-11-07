package model.entities;

public class Veiculo {
	protected Integer id;
	protected String marca;
	protected String modelo;
	protected Integer ano;
	protected Double valorDia;
	protected Boolean disp;

	public Veiculo() {
		
	}

	public Veiculo(Integer id, String marca, String modelo, Integer ano, Double valorDia, Boolean disp) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valorDia = valorDia;
		this.disp = disp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getValorDia() {
		return valorDia;
	}

	public void setValorDia(Double valorDia) {
		this.valorDia = valorDia;
	}

	public Boolean getDisp() {
		return disp;
	}

	public void setDisp(Boolean disp) {
		this.disp = disp;
	}

	public String calcularAluguel(Integer dias, char seguro, Double valorSeguro) {
		return null;
		
	}
	
	public void confirmarAluguel(char confirm, int dias) {
		
	}
	
	@Override
	public String toString() {
		return null;
	}
}
