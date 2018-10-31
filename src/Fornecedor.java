
import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
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
	
	public String exibeProduto(String nome, String descricao) {
		int indice = 0;
		if (produtos.contains(nome) && produtos.contains(descricao)) {
			indice = produtos.indexOf(nome);
		}
		return produtos.get(indice).toString();
	}
	
	public String exibeTodosProdutos() {
		produtos.sort();
		String todosProdutos = "";
		for(Produto produto: produtos) {
			todosProdutos += produto.toString()+" | ";
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
	public String toString() {
		return this.nome +" - "+this.email+" - "+this.telefone;
	}

}