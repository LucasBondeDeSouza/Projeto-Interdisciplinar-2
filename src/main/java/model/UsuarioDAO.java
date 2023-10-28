package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;

import data.Usuario;

public class UsuarioDAO {
	
	public void inserirUsuario(Usuario usuario) {
		
		String create = "insert into usuarios (nome, email, senha) values (?,?,?)";

        try (Connection con = DAO.conectar()){
        	
        	if (!emailJaCadastrado(usuario.getEmail(), con) && !senhaJaCadastrada(usuario.getSenha(), con)) {
        		
        		// Preparar a Query para execução no Banco de Dados
                PreparedStatement pst = con.prepareStatement(create);
                
             // Substituir os parametros (?) pelo conteúdo das variáveis Javabeans
                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getEmail());
                
                String senhaHash = hashSenha(usuario.getSenha());
                pst.setString(3, senhaHash);

                // Executar a Query
                pst.executeUpdate();

                // Encerrar a conexão com o Banco
                con.close();
        	} else {
        		System.out.println("Email ou Senha já cadastrado no banco.");
        	}
        } catch (SQLException e) {
        	System.out.println(e);
        }
    }
	
	// Método para verificar se o email já está cadastrada no banco
	private boolean emailJaCadastrado(String email, Connection con) {
		String query = "SELECT COUNT(*) FROM usuarios WHERE email=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	// Método para verificar se a senha já está cadastrada no banco
	private boolean senhaJaCadastrada(String senha, Connection con) {
	    String query = "SELECT COUNT(*) FROM usuarios WHERE senha=?";
	    String senhaHash = hashSenha(senha);
	    try {
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setString(1, senhaHash);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);
	            return count > 0; 
	        }
	    } catch (SQLException e) {
	        System.out.println(e);
	    }
	    return false;
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
        String query = "SELECT senha FROM usuarios WHERE email=?";
        
        try (Connection con = DAO.conectar()){
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String senhaHashArmazenada = rs.getString("senha");
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