package model.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Carro;
import model.entities.Veiculo;
import model.services.Seguro;

/* Classe exclusiva para leitura de arquivo csv que contém os dados de um veiculo.
 * No método static ler é feito a leitura, cria-se os objetos Veiculo e retorna uma lista com os objetos */

public class LerArquivos {
	
	public static List<Veiculo> ler(String path) { 

        List<Veiculo> veiculos = new ArrayList<>();
       
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] vetor = line.split(",");
                              
                Integer id = Integer.parseInt(vetor[0]);
                String marca = vetor[1];
                String modelo = vetor[2];
                Integer ano = Integer.parseInt(vetor[3]);
                Double valorDia = Double.parseDouble(vetor[4]);
                Boolean disp = Boolean.parseBoolean(vetor[5]);
                Seguro s = new Seguro(150.00);
                Veiculo c = new Carro(id, marca, modelo, ano, valorDia, disp, s); //Polimorfismo 
                veiculos.add(c);
                line = br.readLine();

            }
        }
        catch(IOException e) {
        	System.out.println("Error: " + e.getMessage());
        }
        
        return veiculos;
	}
}
