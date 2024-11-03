package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.Mecanica;
import br.com.fiap.dao.InicializadorDAO;

public class TesteSelecionar {

    public static void main(String[] args) {
        try {
            // Instanciar objetos
            InicializadorDAO dao = new InicializadorDAO();
            
            List<Mecanica> lista = dao.selecionar();
            
            if (lista != null && !lista.isEmpty()) {
                // foreach 
                for (Mecanica mecanica : lista) {
                    System.out.println(mecanica.getEstado() + " " + 
                                       mecanica.getCidade() + " " + 
                                       mecanica.getBairro() + " ");
                }
            } else {
                System.out.println("Nenhuma mecânica encontrada.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
