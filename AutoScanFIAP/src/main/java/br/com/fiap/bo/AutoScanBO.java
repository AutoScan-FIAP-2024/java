package br.com.fiap.bo;

import java.sql.SQLException;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.PcdOuIdoso;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.InicializadorDAO;


public class AutoScanBO {

	InicializadorDAO dao;
	
		// Inserir
		public void inserirCadastro(Cliente cliente, PcdOuIdoso pcd) throws ClassNotFoundException, SQLException {
			InicializadorDAO Inidao = new InicializadorDAO();
			
			Inidao.inserirCadastro(cliente, pcd);
		}
		
		
		public void inserirRegistro(Veiculo veiculo) throws ClassNotFoundException, SQLException {
			InicializadorDAO Inidao = new InicializadorDAO();
			
			Inidao.inserirRegistro(veiculo);
		}
	
}
