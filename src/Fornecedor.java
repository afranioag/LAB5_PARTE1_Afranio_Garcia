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
	 * Retorna o indice do produto se ele existe e um negativo caso não exista
	 * @param nome o nome do produto a ser procurado
	 * @param descricao a descrição do produto
	 * @return retorna um valor inteiro
	 */
	public int existeProduto(String nome, String descricao) {
		for(Produto prod: produtos) {
			if (prod.getNome().equals(nome) && prod.getDescricao().equals(descricao)) {
				return produtos.indexOf(prod);
			}
		}
		return -1;
	}
	
	public int existeProduto (String produtos) {
		String[] produtosProd = produtos.split(", ");
		int conte = 0;
		String[] prod1 =produtosProd[0].split(" - ");
		String[] prod2 =produtosProd[1].split(" - ");
		
		for(Produto prod: this.produtos) {
			if(prod.getNome().equals(prod1[0]) && prod.getDescricao().equals(prod1[1])){
				conte += 1;
			}
			if(prod.getNome().equals(prod2[0]) && prod.getDescricao().equals(prod2[1])) {
				conte += 1;
			}
		}
		if(conte == 2) {
			return 1;
		}
		return -1;
	}
	
	/**
	 * Exibe a representação do produto informado. 
	 * @param nome o nome do produto que se deseja ter informação
	 * @param descricao a descrição do produto
	 * @return retorna uma stringo contendo as informações do produto
	 */
	public String exibeProduto(String nome, String descricao) {
		int indice = this.existeProduto(nome, descricao);
		
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
	
	// metodos para o combo
	public void cadastraCombo(String nome, String descricao, double fator, String produtos) {
		String[] produtosCombo = produtos.split(", ");
		double preco = 0;
		
		String[] prod1 = produtosCombo[0].split(" - ");
		String[] prod2 = produtosCombo[1].split(" - ");
		
		if(this.existeProduto(prod1[0], prod1[1]) > -1){
			preco += this.produtos.get(this.existeProduto(prod1[0], prod1[1])).getPreco();
		}
		if(this.existeProduto(prod2[0], prod2[1]) > -1){
			preco += this.produtos.get(this.existeProduto(prod2[0], prod2[1])).getPreco();
		}
		
		//Combo novoCombo = new Combo(nome, descricao, (preco * (1 - fator)));
		Combo novoCombo = new Combo(nome, descricao, preco, fator);
		this.produtos.add(novoCombo);
		this.combo.add(novoCombo);
	}
	
	public int existeCombo(String fornecedor, String produtos) {
		String[] produtosCombo = produtos.split(", ");
		
		String[] prod1 = produtosCombo[0].split(" - ");
		String[] prod2 = produtosCombo[1].split(" - ");
		
		for(Combo comb: combo) {
			if(comb.getNome().equals(prod1[0]) && comb.getDescricao().equals(prod1[1])){
				return 1;
			}
			if(comb.getNome().equals(prod2[0]) && comb.getDescricao().equals(prod2[1])) {
				return 1;
			}
		}
		return -1;
	}

	public void editaCombo(String nome, String descricao, double novoFator) {
		combo.get(this.existeProduto(nome, descricao)).editaPreco(novoFator);
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
