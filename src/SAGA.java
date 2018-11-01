import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SAGA {
	private HashMap<String, Cliente> clientes;
	private HashMap<String, Fornecedor> fornecedores;
	
	public SAGA() {
		clientes = new HashMap<>();
		fornecedores = new HashMap<>();
	}
	
	// metodos para clientes
	public String cadastraCliente(String nome, String CPF, String localTrabalho, String email) {
		
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || email == "") {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if(localTrabalho == null || localTrabalho == "") {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.");
		}
		if(clientes.containsKey(CPF)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		if (CPF.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		
		Cliente novoCliente = new Cliente(nome, CPF, localTrabalho, email);
		clientes.put(CPF, novoCliente);
		return CPF;
	}
	public void removerCliente(String CPF) {
		clientes.remove(CPF);
	}
	
	public void editarDadosSoCliente(String nome, String CPF, String localTrabalho, String email) {
		clientes.get(CPF).setNome(nome);
		clientes.get(CPF).setEmail(email);
		clientes.get(CPF).setLocalTrabalho(localTrabalho);
	}
	
	public String exibeCliente(String CPF) {
		return clientes.get(CPF).toString();
	}
	
	public String exibeTodosClientes() {
		Set <String> cpfClientes = clientes.keySet();
		List <String> nomesClientes = new ArrayList<>();
		for(String chaves: cpfClientes) {
			nomesClientes.add(clientes.get(chaves).toString());
		}
		Collections.sort(nomesClientes);
		
		String nomesOrdenados = "";
		for(String nomes: nomesClientes) {
			nomesOrdenados += nomesClientes.toString()+" | ";
		}
		return nomesOrdenados;
		
	}
	
	
	// metodos para fornecedores
	public void cadastraFornecedor(String nome, String email, String telefone) {
		Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, novoFornecedor);
	}
	
	public void removeFornecedor(String nome) {
		fornecedores.remove(nome);
	}
	
	public void editaFornecedor(String nome, String email, String telefone) {
		fornecedores.get(nome).setEmail(email);
		fornecedores.get(nome).setTelefone(telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}
	
	public String exibeTodosFornecedores() {
		Set<String> nomesFornecedores = fornecedores.keySet();
		List <String> fornOrdenados = new ArrayList<>();
		for(String chaves: nomesFornecedores) {
				fornOrdenados.add(fornecedores.get(chaves).toString());
		}
		Collections.sort(fornOrdenados);
		
		String nomesOrd = "";
		for(String nomes: fornOrdenados) {
			nomesOrd += nomes+" | ";
		}
		return nomesOrd;
	}

	public void cadastraProdutoParaFornecedor(String nomeForncedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		fornecedores.get(nomeForncedor).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
	}
	
	public String exibeProdutoDoFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		try {
			return fornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, descricaoProduto);
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public String exibeTodosProdutosDoFornecedor(String nomefornecedor) {
		return fornecedores.get(nomefornecedor).exibeTodosProdutos();
	}
	
	
}






















