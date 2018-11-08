
public abstract class Produto implements Comparable<Produto>{
	protected String nome;
	protected String descricao;
	protected double preco;
	
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public abstract void editaPreco(double preco); 
	
	
}
