package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Venda;

public class VendaDAO {
	
	Connection con;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<Venda> lista = new ArrayList<>();
	
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
            
         // Encerrar a conexão com o Banco
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Venda> listarVendas() throws SQLException {
		
		String sql = "select * from vendas";
		new DAO();
		con = DAO.conectar();
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery(sql);
			
			while (rs.next()) {
				Venda objVenda = new Venda();
				objVenda.setIdVendas(rs.getInt("idVendas"));
				objVenda.setComprador(rs.getString("comprador"));
				objVenda.setCategoria(rs.getString("categoria"));
				objVenda.setNomeProduto(rs.getString("nomeProduto"));
				objVenda.setDataVenda(rs.getString("dataVenda"));
				objVenda.setValor(rs.getDouble("valor"));
				objVenda.setQuantidade(rs.getInt("quantidade"));
				objVenda.setNomeVendedor(rs.getString("nomeVendedor"));
				
				lista.add(objVenda);
			}
			
		} catch (SQLException e) {
			
		}
		
		return lista;
	}
	
	public void selecionarVenda(Venda venda) {
		String read2 = "select * from vendas where idVendas = ?";
		
		try {
			Connection con = DAO.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, venda.getIdVendas());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				venda.setIdVendas(rs.getInt(1));
				venda.setComprador(rs.getString(2));
				venda.setCategoria(rs.getString(3));
				venda.setNomeProduto(rs.getString(4));
				venda.setDataVenda(rs.getString(5));
				venda.setValor(rs.getDouble(6));
				venda.setQuantidade(rs.getInt(7));
				venda.setNomeVendedor(rs.getString(8));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	} 
	
	public void alterarVenda(Venda venda) {
		String create = "update vendas set comprador=?, categoria=?, nomeProduto=?, dataVenda=?, valor=?, quantidade=?, nomeVendedor=? where idVendas=?";
		
		try {
			Connection con = DAO.conectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, venda.getComprador());
			pst.setString(2, venda.getCategoria());
			pst.setString(3, venda.getNomeProduto());
			pst.setString(4, venda.getDataVenda());
			pst.setDouble(5, venda.getValor());
			pst.setInt(6, venda.getQuantidade());
			pst.setString(7, venda.getNomeVendedor());
			pst.setInt(8, venda.getIdVendas());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void excluirVenda(int idVendas) {
	    String delete = "DELETE FROM vendas WHERE idVendas = ?";

	    try {
	        Connection con = DAO.conectar();
	        PreparedStatement pst = con.prepareStatement(delete);
	        pst.setInt(1, idVendas);
	        pst.executeUpdate();
	        con.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
}