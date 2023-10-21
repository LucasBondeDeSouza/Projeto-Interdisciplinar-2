package data;

public class Venda extends Produto {
	
	private int idVenda;
    private String comprador;
    private String categoria;
    private String dataVenda;
    private String nomeVendedor;
    
    public Venda() {
    	
    }
    
	public Venda(int idVenda, String comprador, String categoria, String nomeProduto, Double valor, String dataVenda, int quantidade, String nomeVendedor) {
		super();
	}
	
	public Venda(int idProduto, String nomeProduto, int quantidade, double valor) {
		super(idProduto, nomeProduto, quantidade, valor);
	}
	
	public Venda(int idProduto, String nomeProduto, int quantidade, double valor, int idVenda, String comprador,
			String categoria, String dataVenda, String nomeVendedor) {
		super(idProduto, nomeProduto, quantidade, valor);
		this.idVenda = idVenda;
		this.comprador = comprador;
		this.categoria = categoria;
		this.dataVenda = dataVenda;
		this.nomeVendedor = nomeVendedor;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
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
	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	@Override
	public int getIdProduto() {
		return super.getIdProduto();
	}
	@Override
	public void setIdProduto(int idProduto) {
		super.setIdProduto(idProduto);
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
	public int getQuantidade() {
		return super.getQuantidade();
	}
	@Override
	public void setQuantidade(int quantidade) {
		super.setQuantidade(quantidade);
	}
	@Override
	public double getValor() {
		return super.getValor();
	}
	@Override
	public void setValor(double valor) {
		super.setValor(valor);
	}
}