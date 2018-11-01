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
		if(!clientes.containsKey(CPF)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		clientes.remove(CPF);
	}
	
	public void editarDadosDoCliente(String CPF, String atributoMudar, String novoValor) {
		if(!clientes.containsKey(CPF)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		if(atributoMudar != "nome" && atributoMudar != "email" && atributoMudar != "localDeTrabalho") {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		if(atributoMudar == null || atributoMudar == "") {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if(novoValor == null || novoValor != "") {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		if(atributoMudar == "nome") {
			clientes.get(CPF).setNome(novoValor);
		}else if(atributoMudar == "email") {
			clientes.get(CPF).setEmail(novoValor);
		}else if(atributoMudar == "localDeTrabalho") {
			clientes.get(CPF).setLocalTrabalho(novoValor);
		}
	}
	
	public String exibeCliente(String CPF) {
		if(!clientes.containsKey(CPF)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
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
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || email == "") {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if(fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		
		Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, novoFornecedor);
	}
	
	public void removeFornecedor(String nome) {
		if(nome == "") {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
	}
	
	public void editaFornecedor(String nome, String atributoMudar, String novoValor) {
		if(atributoMudar == "nome") {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		if(atributoMudar == "" || atributoMudar == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if(atributoMudar != "email"  && atributoMudar != "telefone") {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe");
		}
		if(novoValor == "" || novoValor == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		
		if(atributoMudar == "email") {
			fornecedores.get(nome).setEmail(novoValor);
		}else if(atributoMudar == "telefone") {
			fornecedores.get(nome).setTelefone(novoValor);
		}
	}
	
	public String exibeFornecedor(String nome) {
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
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
	
	// metodos para produtos
	public void cadastraProdutoParaFornecedor(String nomeForncedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		if(!fornecedores.containsKey(nomeForncedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if(nomeProduto == null || nomeProduto == "") {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricaoProduto == null || descricaoProduto == "") {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if(nomeForncedor == null || nomeForncedor == "") {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(precoProduto < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		if(fornecedores.get(nomeForncedor).existeProduto(nomeProduto, descricaoProduto)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
		fornecedores.get(nomeForncedor).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
	}
	
	public String exibeProdutoDoFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		if(nomeProduto == null || nomeProduto == "") {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		if(nomeFornecedor == null || nomeFornecedor == "") {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(descricaoProduto == null || descricaoProduto == "") {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(!fornecedores.get(nomeFornecedor).existeProduto(nomeProduto, descricaoProduto)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		
		return fornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, descricaoProduto);
	}
	
	public String exibeTodosProdutosDoFornecedor(String nomeFornecedor) {
		if(nomeFornecedor == null || nomeFornecedor == "") {
			throw new IllegalArgumentException("Erro na exibicao dos produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao dos produto: fornecedor nao existe.");
		}
		return fornecedores.get(nomeFornecedor).exibeTodosProdutos();
	}
	
	public void editaProduto (String nomeFornecedor, String nome, String descricao, double preco) {
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if(preco< 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		if(descricao == null || descricao == "") {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(nomeFornecedor == null || nomeFornecedor == "") {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		fornecedores.get(nomeFornecedor).editaProduto(nome, descricao, preco);
	}
	
	public void removeProduto(String nomeFornecedor, String nome, String descricao) {
		if(!fornecedores.get(nomeFornecedor).existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		if(nomeFornecedor == null || nomeFornecedor == "") {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao == "") {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		
		fornecedores.get(nomeFornecedor).removeProduto(nome, descricao);
	}
	
	
}






















