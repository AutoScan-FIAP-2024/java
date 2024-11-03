package br.com.fiap.main;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.beans.Registro;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.InicializadorDAO;

public class TesteRegistro {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        InicializadorDAO dao = new InicializadorDAO();
        Scanner scanner = new Scanner(System.in);
        
        // Criar um veículo de exemplo
        Veiculo veiculo = new Veiculo();
        Registro reg = new Registro();

        System.out.print("Digite o modelo: ");
        veiculo.setModelo(scanner.nextLine());

        System.out.print("Digite a marca: ");
        veiculo.setMarca(scanner.nextLine());

        System.out.print("Digite a placa: ");
        veiculo.setPlaca(scanner.nextLine());

        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Data Atual: " + reg.obterDataAtual());
        System.out.println("ID Marca: " + veiculo.getMarca());
        System.out.println("ID Modelo: " + veiculo.getModelo());
        
        // Inserir registro
        boolean resultado = dao.inserirRegistro(veiculo) != null;
        System.out.println("Cadastro realizado com sucesso: " + resultado);
       
        
        // Fechar o scanner
        scanner.close();
    }
}
