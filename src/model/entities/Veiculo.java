package model.entities;




import model.services.Seguro;

public class Veiculo {
	protected Integer id;
	protected String marca;
	protected String modelo;
	protected Integer ano;
	protected Double valorDia;
	protected Boolean disp;

	protected Seguro seguro = new Seguro();
	

	public Veiculo() {
		
	}

	public Veiculo(Integer id, String marca, String modelo, Integer ano, Double valorDia, Boolean disp, Seguro seguro) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valorDia = valorDia;
		this.disp = disp;
		this.seguro = seguro;
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

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public String calcularAluguel(Integer dias, char seguro) {
		return null;
		
	}
	
	public void confirmarAluguel(char confirm, int dias) {
		
	}
	
	@Override
	public String toString() {
		return id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", valorDia="
				+ valorDia + ", disp=" + disp + ", seguro=" + seguro + "]";
	}
}
