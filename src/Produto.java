/**
 * Representação de um produto alimenticio para lanchonetes
 * Ele é criado a partir de um nome, uma descrição e o seu preço de mercado.
 * @author afranio
 *
 */
public class Produto implements Comparable<Produto> {
	private String nome;
	private String descricao;
	private double preco;
	
	/**
	 * Constroi o prouto
	 * @param nome o nome do produto
	 * @param descricao a descrição que representa o produto
	 * @param preco o preco de mercado
	 */
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	/**
	 * Exibe o produto a partir do seu ToString,
	 * Para isso ele precisa receber o nome do produto e sua descrição para saber 
	 * a qual produto se refere
	 * @param nome o nome do produto
	 * @param descricao a descrição do produto
	 * @return retorna uma string com a representação do produto. NOME - DESCRIÇÃO - PREÇO
	 */
	public String exibeProduto(String nome, String descricao) {
			return toString();
	}
	
	@Override
	public int compareTo(Produto p) {
		return toString().compareTo(p.toString());
	}
	
	/**
	 * Retorna uma representação do produto, com nome, descrição e preco.
	 * 
	 */
	@Override
	public String toString() {
		return this.nome+" - "+this.descricao+" - R$"+String.valueOf(this.preco).replace(".", ",")+"0";
	}
}












