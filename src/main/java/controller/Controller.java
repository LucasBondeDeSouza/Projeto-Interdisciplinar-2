package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import data.Usuario;
import data.Venda;
import jakarta.servlet.http.HttpSession;
import model.VendaDAO;
import model.UsuarioDAO;
import model.DAO;

@WebServlet(urlPatterns = {
    "/controller", "/main", "/insert", "/login", "/cadastrarVenda", "/select", "/update", "/delete"
})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    DAO dao = new DAO();
    VendaDAO vendaDAO = new VendaDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario = new Usuario();
    Venda venda = new Venda();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);

        if (action.equals("/insert")) {
            novoUsuario(request, response);
        } else if (action.equals("/login")) {
            request.getRequestDispatcher("login.html").forward(request, response);
        } else if (action.equals("/cadastrarVenda")) {
        	novaVenda(request, response);
        } else if (action.equals("/select")) {
        	listarVenda(request, response);
        } else if (action.equals("/update")) {
        	editarVenda(request, response);
        } else if (action.equals("/delete")) {
        	excluirVenda(request, response);
        }else {
            response.sendRedirect("index.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            login(request, response);
        }
    }

    protected void novoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        String senha = request.getParameter("senha");
        
        if (senha != null) {
        	usuario.setSenha(senha);
        	usuarioDAO.inserirUsuario(usuario);
        	response.sendRedirect("login.html");
        } else {
        	String mensagemErro = "A senha é obrigatória. Preencha todos os campos.";
            request.setAttribute("erro", mensagemErro);
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean loginValido = usuarioDAO.verificarLogin(email, senha);
        if (loginValido) {
            HttpSession session = (HttpSession) request.getSession();
            //session.setAttribute("nomeVendedor", vendedorDAO.getNomeVendedorPorEmail(email));
            session.setAttribute("email", email);
            response.sendRedirect("menu.html");
        } else {
            request.setAttribute("erro",  "Email ou Senha Inválidos");
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
    
    protected void novaVenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	venda.setComprador(request.getParameter("comprador"));
    	venda.setCategoria(request.getParameter("categoria"));
    	venda.setNomeProduto(request.getParameter("nomeProduto"));
    	venda.setDataVenda(request.getParameter("dataVenda"));
    	venda.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
    	venda.setValor((Double.parseDouble(request.getParameter("valor"))));
    	venda.setNomeVendedor(request.getParameter("nomeVendedor"));
    	
    	vendaDAO.cadastrarVenda(venda);
    	
    	response.sendRedirect("tabela.jsp");
    }
    
    protected void listarVenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int idVendas = Integer.parseInt(request.getParameter("idVendas"));
    	
    	venda.setIdVendas(idVendas);
    	
    	vendaDAO.selecionarVenda(venda);
    	
    	request.setAttribute("idVendas", venda.getIdVendas());
    	request.setAttribute("comprador", venda.getComprador());
    	request.setAttribute("categoria", venda.getCategoria());
    	request.setAttribute("nomeProduto", venda.getNomeProduto());
    	request.setAttribute("dataVenda", venda.getDataVenda());
    	request.setAttribute("valor", venda.getValor());
    	request.setAttribute("quantidade", venda.getQuantidade());
    	request.setAttribute("nomeVendedor", venda.getNomeVendedor());
    	
    	RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
    	rd.forward(request, response);
    }
    
    protected void editarVenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	venda.setIdVendas(Integer.parseInt(request.getParameter("idVendas")));
    	venda.setComprador(request.getParameter("comprador"));
    	venda.setCategoria(request.getParameter("categoria"));
    	venda.setNomeProduto(request.getParameter("nomeProduto"));
    	venda.setDataVenda(request.getParameter("dataVenda"));
    	venda.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
    	venda.setValor((Double.parseDouble(request.getParameter("valor"))));
    	venda.setNomeVendedor(request.getParameter("nomeVendedor"));
    	
    	vendaDAO.alterarVenda(venda);
    	
    	response.sendRedirect("tabela.jsp");
    }
    
    protected void excluirVenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int idVendas = Integer.parseInt(request.getParameter("idVendas"));
    	
    	vendaDAO.excluirVenda(idVendas);
    	
    	response.sendRedirect("tabela.jsp");
    }
}