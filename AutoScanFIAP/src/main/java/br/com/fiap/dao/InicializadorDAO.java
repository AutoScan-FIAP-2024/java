package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Mecanica;
import br.com.fiap.beans.PcdOuIdoso;
import br.com.fiap.beans.PecaMecanica;
import br.com.fiap.beans.Registro;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.conexoes.ConexaoFactory;

public class InicializadorDAO {
	
	Registro reg = new Registro();
	
    public Connection conexao;

    public InicializadorDAO() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoFactory().conexao();
    }

    public String inserirCadastro(Cliente cliente, PcdOuIdoso pcd) {
        String resultado = "Cadastro realizado com sucesso";
        
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_AS_CLIENTE (id_nome, id_email, cd_senha, cd_cep, pcd, idoso) VALUES (?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getCep());
            stmt.setBoolean(5, pcd.getPcd() != null ? pcd.getPcd() : false);
            stmt.setBoolean(6, pcd.getIdoso() != null ? pcd.getIdoso() : false);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            resultado = "Erro no cadastro: " + e.getMessage();
        }

        return resultado;
    }
    
    public String inserirRegistro(Veiculo veiculo) {
        String resultado = "Registro guardado com sucesso!";
        
        try (PreparedStatement stmt = conexao.prepareStatement(
                "INSERT INTO T_AS_REGISTROS (cd_placa, id_marca, id_modelo) VALUES (?, ?, ?)")) {
            
        	stmt.setString(1, veiculo.getPlaca()); 
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            resultado = "Erro no registro: " + e.getMessage();
        }
        
        return resultado;
    }
    
    public String inserirPecas(PecaMecanica peças, Cliente cliente) {
        String resultado = "Registro de peças guardado com sucesso!";
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_AS_REGISTRO_PECAS (id_nome_peca, id_email, nr_quantidade) VALUES (?, ?, ?)")) {
            
            stmt.setString(1, peças.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, peças.getQuantidade());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            resultado = "Erro no registro de peças: " + e.getMessage();
        }
        
        return resultado;
    }

    public List<Mecanica> selecionar() throws SQLException {
        List<Mecanica> listaMec = new ArrayList<Mecanica>();
        
        // Verifique se a conexão está estabelecida
        if (conexao == null || conexao.isClosed()) {
            System.out.println("A conexão com o banco de dados não está estabelecida.");
            return listaMec; // Retorna lista vazia se a conexão não estiver disponível
        }

        PreparedStatement stmt = conexao.prepareStatement("SELECT sg_estado, id_cidade, id_bairro FROM T_AS_CENTRO_AUTOMOTIVO");
        ResultSet rs = stmt.executeQuery();

        // Debug: Quantidade de linhas retornadas
        int count = 0;
        while (rs.next()) {
            Mecanica mec = new Mecanica();
            mec.setEstado(rs.getString(1));
            mec.setCidade(rs.getString(2));
            mec.setBairro(rs.getString(3));
            listaMec.add(mec);
            count++;
        }

        // Informar a quantidade de registros encontrados
        System.out.println("Número de mecânicas encontradas: " + count);
        
        // Feche o ResultSet e o PreparedStatement para liberar recursos
        rs.close();
        stmt.close();

        return listaMec;		
    }


	

}
