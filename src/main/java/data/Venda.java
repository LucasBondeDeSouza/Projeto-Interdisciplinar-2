package data;

public class Venda {
	
	private int idVendas;
    private String comprador;
    private String categoria;
    private String nomeProduto;
    private Double valor;
    private String dataVenda;
    private int quantidade;
    private String nomeVendedor;
    
	public Venda(int idVendas, String comprador, String categoria, String nomeProduto, Double valor, String dataVenda,
			int quantidade, String nomeVendedor) {
		super();
		this.idVendas = idVendas;
		this.comprador = comprador;
		this.categoria = categoria;
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.dataVenda = dataVenda;
		this.quantidade = quantidade;
		this.nomeVendedor = nomeVendedor;
	}

	public Venda() {
		super();
	}

	public int getIdVendas() {
		return idVendas;
	}
	
	public void setIdVendas(int idVendas) {
		this.idVendas = idVendas;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
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

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
}