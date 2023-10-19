package data;

public class Vendedor extends Usuario {
	private int idVendedor;

	public Vendedor() {
		super();
	}

	public Vendedor(String nome, String email, String senha) {
		super(nome, email, senha);
	}
	
	public Vendedor(int id, String nome, String email, String senha) {
        super(nome, email, senha);
        this.idVendedor = id;
    }
	
	public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
}
