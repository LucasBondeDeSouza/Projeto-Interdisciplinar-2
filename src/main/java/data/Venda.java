package data;

public class Venda extends Produto {
	
	private int idVenda;
    private String comprador;
    private String categoria;
    private Produto produto;
    private String dataVenda;
    private Vendedor vendedor;
    
    public Venda(){
    }

    public Venda(int idVenda, String comprador, String categoria, Produto produto, String dataVenda, Vendedor vendedor) {
        this.idVenda = idVenda;
        this.comprador = comprador;
        this.categoria = categoria;
        this.produto = produto;
        this.dataVenda = dataVenda;
        this.vendedor = vendedor;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Double calcularValor() {
        double valorTotal = 0.0;
            
        return valorTotal;
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
	public int getQuantidadeProduto() {
		return super.getQuantidadeProduto();
	}

	@Override
	public void setQuantidadeProduto(int quantidadeProduto) {
		super.setQuantidadeProduto(quantidadeProduto);
	}

	@Override
	public double getPrecoProduto() {
		return super.getPrecoProduto();
	}

	@Override
	public void setPrecoProduto(double precoProduto) {
		super.setPrecoProduto(precoProduto);
	}
    
    
}