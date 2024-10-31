package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Veiculo;
import model.utils.LerArquivos;

public class Program {

    public static void main(String[] args) throws ParseException {

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
        
       
        System.out.print("\nDigite o número do veiculo que deseja alugar: ");
        int x = sc.nextInt();
        System.out.print("Por quantos dias deseja alugar o veiculo: ");
        int dias = sc.nextInt();
        System.out.print("Com ou sem seguro? c/s: ");
        char seguro = sc.next().charAt(0);
        
        for(Veiculo v : veiculos) {
        	if(v.getDisp() == true && v.getId() == x) { // Verificando se o veiculo está disponivel e selecionando o veiculo vinculado ao Id fornecido pelo usuario
        		v.calcularAluguel(dias, seguro); // Função para calcular o aluguel.
        		
        		System.out.printf("\nDeseja confirmar a locação do veiculo %s %s? y/n " , v.getMarca(), v.getModelo());
                char confirm = sc.next().charAt(0);
            
                v.confirmarAluguel(confirm, dias); // Função para confirmar o aluguel
        	}
        }
        
        
        
        sc.close();
    }
}
