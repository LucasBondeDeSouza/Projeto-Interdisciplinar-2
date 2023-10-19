package model;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Usuario;
import data.Venda;

public class DAO {
    // Parâmetros de Conexão
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/vendas?useTimezone=true&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "bondelucas";

    // Método de Conexão
    public static Connection conectar() throws SQLException {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    public void inserirUsuario(Usuario usuario) {
        String create = "insert into usuarios (nome, email, senha, cargo) values (?,?,?,?)";

        try {
            // Abrir a conexão
            Connection con = conectar();

            // Preparar a Query para execução no Banco de Dados
            PreparedStatement pst = con.prepareStatement(create);

            // Substituir os parametros (?) pelo conteúdo das variáveis Javabeans
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            
            String senhaHash = hashSenha(usuario.getSenha());
            pst.setString(3, senhaHash);
            pst.setString(4, usuario.getCargo());

            // Executar a Query
            pst.executeUpdate();

            // Encerrar a conexão com o Banco
            con.close();
        } catch (Exception e) {
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

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String read = "select * from usuarios order by nome";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String iduser = rs.getString(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String senha = rs.getString(4);
                String cargo = rs.getString(5);

                usuarios.add(new Usuario(iduser, nome, email, senha, cargo));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuarios;
    } 

    public boolean verificarLogin(String email, String senha) {
        String query = "SELECT senha FROM usuarios WHERE email=?";
        
        try {
            Connection con = conectar();
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
    
    public void inserirVenda(Venda venda) {
        String create = "insert into vendas (comprador, categoria, nome_produto, data_venda, quantidade, valor_unitario) values (?,?,?,?,?,?)";

        try {
            // Abrir a conexão
            Connection con = conectar();

            // Preparar a Query para execução no Banco de Dados
            PreparedStatement pst = con.prepareStatement(create);

            // Substituir os parametros (?) pelo conteúdo das variáveis Javabeans
            pst.setString(1, venda.getComprador());
            pst.setString(2, venda.getCategoria());
            pst.setString(3, venda.getNomeProduto());
            pst.setString(4, venda.getDataVenda());
            pst.setString(5, venda.getQuantidade());
            pst.setString(6, venda.getValorUnitario());

            // Executar a Query
            pst.executeUpdate();

            // Encerrar a conexão com o Banco
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Venda> listarVendas() {
        ArrayList<Venda> vendas = new ArrayList<>();
        String read = "select * from vendas order by venda_id";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String vendaId = rs.getString(1);
                String comprador = rs.getString(2);
                String categoria = rs.getString(3);
                String nomeProduto = rs.getString(4);
                String dataVenda = rs.getString(5);
                String quantidade = rs.getString(6);
                String valorUnitario = rs.getString(7);

                vendas.add(new Venda(vendaId, comprador, categoria, nomeProduto, dataVenda, quantidade, valorUnitario));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return vendas;
    } */
}