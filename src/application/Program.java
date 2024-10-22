package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Carro;
import model.entities.Moto;
import model.entities.Veiculo;
import model.services.Seguro;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String path = "C:\\ws- eclipse\\curso_programacao\\src\\Veiculos\\Carros.txt";
        
        String seguroIncluido = null;
        double valorAluguel = 0;
        
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
        
        path = "C:\\ws- eclipse\\curso_programacao\\src\\Veiculos\\Motos.txt";
        
        Seguro s = new Seguro(150.00);
        
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
                Veiculo c = new Moto(id, marca, modelo, ano, valorDia, disp, s); //Polimorfismo 
                veiculos.add(c);
                line = br.readLine();

            }
        }
        catch(IOException e) {
        	System.out.println("Error: " + e.getMessage());
        }
        
        
        System.out.println("Veiculos disponiveis para aluguel: \n");
        for(Veiculo v : veiculos) {
        	if(v.getDisp() == true) // Verificando se o veiculo está disponivel
        	System.out.println(v.toString());
        }
        
        System.out.print("\nDigite o número do veiculo que deseja alugar: ");
        int x = sc.nextInt();
        System.out.print("Por quantos dias deseja alugar o veiculo: ");
        int dias = sc.nextInt();
        System.out.print("Com ou sem seguro? c/s: ");
        char seguro = sc.next().charAt(0);
        
        for(Veiculo v : veiculos) {
        	if(v.getDisp() == true && v.getId() == x) { // Verificando se o veiculo está disponivel e selecionando o veiculo vinculado ao Id fornecido pelo usuario
        		if(seguro == 'c') {
        			valorAluguel = v.calcularAluguel(dias);
        			System.out.println("\nValor com seguro: ");
        			System.out.println("R$" + valorAluguel);
        			seguroIncluido = "Sim";
        		}
        		else if(seguro == 's') {
        			valorAluguel = v.calcularAluguel(dias) - s.getValorSeguro();
            		System.out.println("\nValor sem seguro: ");
            		System.out.println( "R$" + valorAluguel);
            		seguroIncluido = "Não";
        		}
        		else {
        			System.out.println("*** Opção invalida, tente novamente ***");
        		}
        		
        		System.out.printf("\nDeseja confirmar a locação do veiculo %s %s? y/n " , v.getMarca(), v.getModelo());
                char confirm = sc.next().charAt(0);
                if(confirm == 'y') {
                	System.out.println("\n*** Locação confirmada *** ");
                	System.out.println("Data e hora da locação: " + LocalDateTime.now().format(fmt));
                	System.out.println("Aluguel do veiculo: " + v.getMarca() + v.getModelo());
                	System.out.println("Por: " + dias + " dias");
                	System.out.println("Seguro incluido: " + seguroIncluido);
                	System.out.println("Valor total da locação: " + valorAluguel );
                	System.out.println("Obrigado, volte sempre.");
                	
                	v.setDisp(false); // Tirando o veiculo da lista de disponivel
        		}
                else if(confirm == 'n') {
        			System.out.println("*** Seção finalizada ***");
        		}
        		else {
        			System.out.println("*** Opção invalida, tente novamente ***");
        		}
        	}
        }
        
        
        
        sc.close();
    }
}
