package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;

import data.Vendedor;

public class VendedorDAO {
	
	public void inserirVendedor(Vendedor vendedor) {
		
		String create = "insert into tabela_vendedor (vendedor_nome, vendedor_email, vendedor_senha) values (?,?,?)";

        try (Connection con = DAO.conectar()){

            // Preparar a Query para execução no Banco de Dados
            PreparedStatement pst = con.prepareStatement(create);

            // Substituir os parametros (?) pelo conteúdo das variáveis Javabeans
            pst.setString(1, vendedor.getNome());
            pst.setString(2, vendedor.getEmail());
            
            String senhaHash = hashSenha(vendedor.getSenha());
            pst.setString(3, senhaHash);

            // Executar a Query
            pst.executeUpdate();

            // Encerrar a conexão com o Banco
            con.close();
        } catch (SQLException e) {
        	System.out.println(e);
        }
    }
	
	private String hashSenha(String senha) {
    	try {
    		MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(senha.getBytes());
            
         // Converter bytes do hash para representação hexadecimal
            StringBuilder hash = new StringBuilder();
            for (byte b : hashBytes) {
                hash.append(String.format("%02x", b));
            }
            
            return hash.toString();
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
	
	public boolean verificarLogin(String email, String senha) {
        String query = "SELECT vendedor_senha FROM tabela_vendedor WHERE vendedor_email=?";
        
        try (Connection con = DAO.conectar()){
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String senhaHashArmazenada = rs.getString("vendedor_senha");
                String senhaHashDigitada = hashSenha(senha);

                // Comparar os hashes da senha armazenada e da senha digitada
                return senhaHashArmazenada.equals(senhaHashDigitada);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
}
