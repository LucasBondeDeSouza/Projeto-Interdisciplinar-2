package model;

import data.Produto;
import data.Venda;
import model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	
	public void salvar(Produto produto) {
        String create = "insert into tabela_produto (produto_nome, produto_quantidade, produto_preco) values (?,?,?)";

        try (Connection con = DAO.conectar()) {
            // Abrir a conexão
            //Connection con = conectar();

            // Preparar a Query para execução no Banco de Dados
            PreparedStatement pst = con.prepareStatement(create);

            // Substituir os parametros (?) pelo conteúdo das variáveis Javabeans
            pst.setString(1, produto.getNomeProduto());
            pst.setInt(2, produto.getQuantidade());
            pst.setDouble(3, produto.getValor());

            // Executar a Query
            pst.executeUpdate();

            // Encerrar a conexão com o Banco
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}