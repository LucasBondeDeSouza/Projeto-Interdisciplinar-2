package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.opencsv.CSVWriter;
import model.VendaDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import data.Venda;

@WebServlet("/exportCSV")
public class ExportCSVController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExportCSVController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
        System.out.println(action);
        
        if (action.equals("/exportCSV")) {
        	exportarCSV(request, response);
        } else {
        	response.sendRedirect("index.html");
        }
    }
	
	protected void exportarCSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=\"vendas.csv\"");
		
		try {
			PrintWriter writer = response.getWriter();
			CSVWriter csvWriter = new CSVWriter(writer);
			
			VendaDAO vendaDAO = new VendaDAO();
			ArrayList<Venda> vendas = vendaDAO.listarVendas();
			
			// Escreva o cabeçalho do CSV
			String[] header = {"ID" + "|" + "Comprador" + "|" + "Categoria" + "|" + "Produto" + "|" + "Data Venda" + "|" + "Valor" + "|" + "Quantidade" + "|" + "Vendedor"};
			csvWriter.writeNext(header);
			
			for (Venda venda : vendas) {
                String[] data = {
                    String.valueOf(venda.getIdVendas()) + "|" +
                    venda.getComprador() + "|" +
                    venda.getCategoria() + "|" +
                    venda.getNomeProduto() + "|" +
                    venda.getDataVenda() + "|" +
                    String.valueOf(venda.getValor()) + "|" +
                    String.valueOf(venda.getQuantidade()) + "|" +
                    venda.getNomeVendedor()
                };
                csvWriter.writeNext(data);
		    }
			
			csvWriter.close();
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
	}
}
