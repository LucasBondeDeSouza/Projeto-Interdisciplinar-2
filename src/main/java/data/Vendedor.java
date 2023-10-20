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

	@Override
	public String getNome() {
		return super.getNome();
	}

	@Override
	public void setNome(String nome) {
		super.setNome(nome);
	}

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		super.setEmail(email);
	}

	@Override
	public String getSenha() {
		return super.getSenha();
	}

	@Override
	public void setSenha(String senha) {
		super.setSenha(senha);
	}
    
    
}
