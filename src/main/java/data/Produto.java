package data;

public class Produto {

	private String nomeProduto;
	private Double valor;
	private String categoria;
	
	public Produto() {
		super();
	}

	public Produto(String nomeProduto, Double valor, String categoria) {
		super();
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.categoria = categoria;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
