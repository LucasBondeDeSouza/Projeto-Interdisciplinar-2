package data;

public class Venda extends Produto {
	
	private int idVendas;
    private String comprador;
    private String dataVenda;
    private int quantidade;
    private String nomeVendedor;
    
	public Venda() {
		super();
	}
	
	public Venda(String nomeProduto, Double valor, String categoria) {
		super(nomeProduto, valor, categoria);
	}
	
	public Venda(int idVendas, String comprador, String dataVenda, int quantidade, String nomeVendedor) {
		super();
		this.idVendas = idVendas;
		this.comprador = comprador;
		this.dataVenda = dataVenda;
		this.quantidade = quantidade;
		this.nomeVendedor = nomeVendedor;
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
	
	@Override
	public String getNomeProduto() {
		return super.getNomeProduto();
	}
	
	@Override
	public void setNomeProduto(String nomeProduto) {
		super.setNomeProduto(nomeProduto);
	}
	
	@Override
	public Double getValor() {
		return super.getValor();
	}
	
	@Override
	public void setValor(Double valor) {
		super.setValor(valor);
	}
	
	@Override
	public String getCategoria() {
		return super.getCategoria();
	}
	
	@Override
	public void setCategoria(String categoria) {
		super.setCategoria(categoria);
	}
}