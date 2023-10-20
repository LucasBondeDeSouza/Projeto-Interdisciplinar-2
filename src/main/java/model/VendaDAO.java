package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Venda;
import data.Produto;
import data.Vendedor;

public class VendaDAO {

	private List<Venda> vendas;
	
	public VendaDAO() {
		this.vendas = new ArrayList<>();
	}
	
	public void cadastrarVenda(Venda venda) {
		
		String create = "INSERT INTO tabela_vendas (comprador, categoria, nome_produto, valor_produto, data_venda, quantidade_produto, nome_vendedor) values (?,?,?,?,?,?,?)";
		
		try (Connection con = DAO.conectar()) {
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, venda.getComprador());
            pst.setString(2, venda.getCategoria());
            pst.setString(3, venda.getNomeProduto());
            pst.setDouble(4, venda.getPrecoProduto());
            pst.setString(5, venda.getDataVenda());
            pst.setInt(6, venda.getQuantidadeProduto());
            
         // Executar a Query
            pst.executeUpdate();
            
            vendas.add(venda);
            
         // Encerrar a conexão com o Banco
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Venda> listarVendas() {
		List<Venda> vendas = new ArrayList<>();
		
		String create = "SELECT * FROM tabela_vendas order by vendas_id";
		
		try (Connection con = DAO.conectar()) {
			
			PreparedStatement pst = con.prepareStatement(create);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Venda venda = new Venda();
                Produto produto = new Produto();
                Vendedor vendedor = new Vendedor();
				
                venda.setIdVenda(rs.getInt("vendas_id"));
                venda.setComprador(rs.getString("comprador"));
                venda.setCategoria(rs.getString("categoria"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setPrecoProduto(rs.getDouble("valor_produto"));
                venda.setDataVenda(rs.getString("data_venda"));
                produto.setQuantidadeProduto(rs.getInt("quantidade_produto"));
                vendedor.setNome(rs.getString("nome_vendedor"));

                venda.setProduto(produto);
                venda.setVendedor(vendedor);
                
                vendas.add(venda);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return vendas;
	}
}