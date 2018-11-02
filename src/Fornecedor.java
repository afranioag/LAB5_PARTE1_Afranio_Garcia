
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fornecedor implements Comparable<Fornecedor>{
	private String nome;
	private String email;
	private String telefone;
	private List <Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ArrayList();
	}
	
	public void cadastraProduto(String nome, String descricao, double preco) {
		produtos.add(new Produto(nome, descricao, preco));
	}
	
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
	
	public boolean existeProduto(String nome, String descricao) {
		int indice = -1;
		
		for(Produto prod: produtos) {
			if (prod.getNome().equals(nome) && prod.getDescricao().equals(descricao)) {
				return true;
			}
		}
		return false;
	}
	
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
	
	public String exibeTodosProdutos() {
		int contador = 0;
		String todosProdutos = "";
		Collections.sort(produtos);
		for(Produto produto: produtos) {
			contador += 1;
			if (contador == produtos.size()) {
				todosProdutos += produto.toString();
			}else {
				todosProdutos += produto.toString()+" | ";
			}
		}
		return todosProdutos;
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
	
	@Override
	public String toString() {
		return this.nome +" - "+this.email+" - "+this.telefone;
	}

}
