package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.entities.Veiculo;
import model.utils.LerArquivos;

public class Program {

    public static void main(String[] args) throws ParseException {
    	try {
	        Scanner sc = new Scanner(System.in);
	
	        String path = "C:\\ws- eclipse\\curso_programacao\\src\\Veiculos\\Carros.txt"; // Caminho do arquivo csv com os dados dos carros
	        
	        //Lista de carros
	        List<Veiculo> carros = LerArquivos.ler(path); // Envie o path para a leitura do arquivo e recebe uma lista dos veiculos presentes no arquivo 
	      
	        path = "C:\\ws- eclipse\\curso_programacao\\src\\Veiculos\\Motos.txt"; // Caminho do arquivo csv com os dados das motos
	        
	        //Lista de motos
	        List<Veiculo> motos = LerArquivos.ler(path); // Envie o path para a leitura do arquivo e recebe uma lista dos veiculos presentes no arquivo 
	        
	        //Lista unida
	        List<Veiculo> veiculos = new ArrayList<>(); // Unindo as duas listas
	        veiculos.addAll(carros);
	        veiculos.addAll(motos);
	        
	        System.out.println("Veiculos disponiveis para aluguel: \n");
	        for(Veiculo v : veiculos) {
	        	if(v.getDisp() == true) // Verificando se o veiculo está disponivel
	        	System.out.println(v.toString());
	        }
	        
	        
	        Boolean veiculoExistente = false;
	        
	        System.out.print("\nDigite o número do veiculo que deseja alugar: ");
	        int x = sc.nextInt();
	        for(Veiculo v1 : veiculos) {
	        	if(v1.getDisp() == true && v1.getId() == x)  {
	        		veiculoExistente = true; // Verifica se o veiculo está disponivel
	        	}
	        }

	        if(veiculoExistente == true) {
		        System.out.print("Por quantos dias deseja alugar o veiculo: ");
		        int dias = sc.nextInt();
		        
		        char seguro = '-';
		        while(seguro != 'c' && seguro != 's' ) { // Se repete até seguro receber um valor desejado
		        System.out.print("Com ou sem seguro? c/s: ");
		        seguro = sc.next().charAt(0);
		        }
		        
		        for(Veiculo v : veiculos) {
		        	if(v.getId() == x) { // Selecionando o veiculo vinculado ao Id fornecido pelo usuario
		        		
		        		v.calcularAluguel(dias, seguro); // Função para calcular o aluguel.
		        		
		        		char confirm = '-';
		        		while(confirm != 'y' && confirm != 'n' ) { // Se repete até confirm receber um valor desejado
		        			System.out.printf("\nDeseja confirmar a locação do veiculo %s %s? y/n " , v.getMarca(), v.getModelo());
			                confirm = sc.next().charAt(0);
		    		        }
		    		        
		                v.confirmarAluguel(confirm, dias); // Função para confirmar o aluguel
		        	}
		        }
	        }
	        else {
	        	System.out.print("***Veículo indisponível***");
	        }
	        
	        
	        
	        sc.close();
	    }
    	catch(InputMismatchException e) { // Exceção -> erros de digitação
    		System.out.println("Erro: por favor, insira uma tecla válida");
    	}
    	catch(NumberFormatException e) { // Exceção -> arquivo com dados errados
            System.out.println("Erro ao ler os dados dos veículos: " + e.getMessage());
        }
    }
}
