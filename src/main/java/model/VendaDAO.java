package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
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
		
		String create = "INSERT INTO vendas (comprador, categoria, nomeProduto, valor, dataVenda, quantidade, nomeVendedor) values (?,?,?,?,?,?,?)";
		
		try (Connection con = DAO.conectar()) {
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, venda.getComprador());
            pst.setString(2, venda.getCategoria());
            pst.setString(3, venda.getNomeProduto());
            pst.setDouble(4, venda.getValor());
            pst.setString(5, venda.getDataVenda());
            pst.setInt(6, venda.getQuantidade());
            pst.setString(7, venda.getNomeVendedor());
            
         // Executar a Query
            pst.executeUpdate();
            
            vendas.add(venda);
            
         // Encerrar a conexão com o Banco
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	public ArrayList<Venda> listarVendas() {
		// Criando um objeto para acessar a Classe JavaBeans
		ArrayList<Venda> vendas = new ArrayList<>();
		
		String read = "SELECT * FROM vendas order by idVenda";
		
		try (Connection con = DAO.conectar()) {
			
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Venda venda = new Venda();
                Produto produto = new Produto();
                Vendedor vendedor = new Vendedor();
				
                int idVenda = rs.getInt(1);
                String comprador = rs.getString(2);
                String categoria = rs.getString(3);
                String nomeProduto = rs.getString(4);
                Double preco = rs.getDouble(5);
                String dataVenda = rs.getString(6);
                int quantidade = rs.getInt(7);
                String nomeVendedor = rs.getString(8);

                vendas.add(new Venda(idVenda, comprador, categoria, nomeProduto, preco, dataVenda, quantidade, nomeVendedor));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return vendas;
	} */
	
	public ArrayList<Venda> listarVendas() {
		ArrayList<Venda> vendas = new ArrayList<>();
		String read = "select * from vendas order by idVendas";
		
		try(Connection con = DAO.conectar()) {
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int idVenda = rs.getInt(1);
				String comprador = rs.getString(2);
				String categoria = rs.getString(3);
				String nomeProduto = rs.getString(4);
				double valor = rs.getDouble(5);
				String dataVenda = rs.getString(6);
				int quantidade = rs.getInt(7);
				String nomeVendedor = rs.getString(8);
				
				vendas.add(new Venda(idVenda, comprador, categoria, nomeProduto, valor, dataVenda, quantidade, nomeVendedor));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return vendas;
	}
}