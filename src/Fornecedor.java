/**
 * Representação de um fornecedor de alimentos.
 * Ele é formado por um nome que é sua identidade, não podendo ser alterada, 
 * por um email e um telefone, como tambem por uma lista de produtos que ele comercializa.
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fornecedor implements Comparable<Fornecedor>{
	private String nome;
	private String email;
	private String telefone;
	private List<Produto> produtos;
	private List<Combo> combo;
	
	/**
	 * Constroi o comerciante e inicializa a lista vazia para adicionar produtos
	 * @param nome o nome do comerciante
	 * @param email o email
	 * @param telefone o telefone
	 * 
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ArrayList<Produto>();
		this.combo = new 	ArrayList<Combo>();
	}
	
	/**
	 * Cadastra e adiciona produtos a lista do fornecedor.
	 * @param nome o nome do produto
	 * @param descricao a descrição do produto
	 * @param preco o preço de mercado do produto
	 */
	public void cadastraProduto(String nome, String descricao, double preco) {
		produtos.add(new Produto(nome, descricao, preco));
	}
	
	/**
	 * Edita o preco do produto, para é preciso informar um nome e uma descrição de um produto que já exista. 
	 * @param nome o nome do produto a ser editado
	 * @param descricao a descrição do produto
	 * @param preco e o novo preço que o produto terá
	 */
	public void editaProduto(String nome, String descricao, double preco) {
		int indice = -1;
		for(Produto prod: produtos) {
			if (prod.getNome().equals(nome) && prod.getDescricao().equals(descricao)) {
				indice = produtos.indexOf(prod);
			}
		}
		if(indice < 0) {
			throw new ArrayIndexOutOfBoundsException("Produto nao cadastrado");
		}
		produtos.get(indice).setNome(nome);
		produtos.get(indice).setDescricao(descricao);
		produtos.get(indice).setPreco(preco);
	}
	
	/**
	 * Verifica se existe um produto cadastrado com o nome e a descrição passada.
	 * Retorna treu pra sim e false caso não exista
	 * @param nome o nome do produto a ser procurado
	 * @param descricao a descrição do produto
	 * @return retorna um valor booleano
	 */
	public boolean existeProduto(String nome, String descricao) {
		int indice = -1;
		
		for(Produto prod: produtos) {
			if (prod.getNome().equals(nome) && prod.getDescricao().equals(descricao)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Exibe a representação do produto informado. 
	 * @param nome o nome do produto que se deseja ter informação
	 * @param descricao a descrição do produto
	 * @return retorna uma stringo contendo as informações do produto
	 */
	public String exibeProduto(String nome, String descricao) {
		int indice = -1;
		
		for(Produto prod: produtos) {
			if (prod.getNome().equals(nome) && prod.getDescricao().equals(descricao)) {
				indice = produtos.indexOf(prod);
			}
		}
		
		if (indice < 0 ) {
			throw new ArrayIndexOutOfBoundsException("Produto não cadastrado");
		}
		return produtos.get(indice).toString();
	}
	
	/** 
	 * Remove um produto da lista. 
	 * Usa o nome e descrição para encontrar o produto, acha o indice dele e o remove.
	 * @param nome o nome do produto a ser removido
	 * @param descricao a descrição do produto
	 */
	public void removeProduto(String nome, String descricao) {
		int indice = -1;
		
		for(Produto prod: produtos) {
			if (prod.getNome().equals(nome) && prod.getDescricao().equals(descricao)) {
				indice = produtos.indexOf(prod);
			}
		}
		if (indice < 0 ) {
			throw new ArrayIndexOutOfBoundsException("Produto não cadastrado");
		}
		produtos.remove(indice);
	}
	
	/**
	 * Retorna uma string contendo a lista de produtos do fornecedor, em ordem alfabetica.
	 * @return retorna uma string
	 */
	public String exibeProdutos() {
		int contador = 0;
		String todosProdutos = "";
		Collections.sort(produtos);
		for(Produto produto: produtos) {
			contador += 1;
			if (contador == produtos.size()) {
				todosProdutos += this.nome+" - "+produto.toString();
			}else {
				todosProdutos += this.nome+" - "+produto.toString()+" | ";
			}
		}
		return todosProdutos;
	}
	
	public void cadastraCombo(String nome, String descricao, double fator, String produtos) {
		String[] produtosCombo = produtos.split(",");
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Fornecedor f) {
		return toString().compareTo(f.toString());
	}
	
	/**
	 * Retorna uma string com a representação do fornecedor.
	 */
	@Override
	public String toString() {
		return this.nome +" - "+this.email+" - "+this.telefone;
	}

}
