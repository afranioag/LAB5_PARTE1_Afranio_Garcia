
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SAGA {
	private HashMap<String, Cliente> clientes;
	private HashMap<String, Fornecedor> fornecedores;
	
	public SAGA() {
		clientes = new HashMap<>();
		fornecedores = new HashMap<>();
	}
	
	// metodos para clientes
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || email == "") {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if(localizacao == null || localizacao == "") {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.");
		}
		if(clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		
		Cliente novoCliente = new Cliente(cpf, nome, email, localizacao);
		clientes.put(cpf, novoCliente);
		return cpf;
	}
	
	public void removeCliente(String CPF) {
		if(!clientes.containsKey(CPF)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		clientes.remove(CPF);
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		if(atributo != "nome" && atributo != "email" && atributo != "localDeTrabalho") {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		if(atributo == null || atributo == "") {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if(novoValor == null || novoValor != "") {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		if(atributo == "nome") {
			clientes.get(cpf).setNome(novoValor);
		}else if(atributo == "email") {
			clientes.get(cpf).setEmail(novoValor);
		}else if(atributo == "localDeTrabalho") {
			clientes.get(cpf).setLocalTrabalho(novoValor);
		}
	}
	
	public String exibeCliente(String cpf) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return clientes.get(cpf).toString();
	}
	
	public String exibeClientes() {
		Set <String> cpfClientes = clientes.keySet();
		List <String> nomesClientes = new ArrayList<>();
		for(String chaves: cpfClientes) {
			nomesClientes.add(clientes.get(chaves).toString());
		}
		Collections.sort(nomesClientes);
		
		String nomesOrdenados = "";
		int contador = 0;
		for(String nomes: nomesClientes) {
			contador += 1;
			if(contador == nomesClientes.size()) {
				nomesOrdenados += nomes.toString();
			}else {
				nomesOrdenados += nomes.toString()+" | ";
			}
		}
		return nomesOrdenados;
	}
	
	
	// metodos para fornecedores
	public void adicionaFornecedor(String nome, String email, String telefone) {
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
	
	public String exibeFornecedores() {
		Set<String> nomesFornecedores = fornecedores.keySet();
		List <String> fornOrdenados = new ArrayList<>();
		for(String chaves: nomesFornecedores) {
				fornOrdenados.add(fornecedores.get(chaves).toString());
		}
		Collections.sort(fornOrdenados);
		int contador = 0;
		String nomesOrd = "";
		for(String nomes: fornOrdenados) {
			contador += 1;
			if (contador == fornOrdenados.size()) {
				nomesOrd += nomes;
			}else {
				nomesOrd += nomes+" | ";
			}
			
		}
		return nomesOrd;
	}
	
	// metodos para produtos
	public void adicionaProduto(String forncedor, String nome, String descricao, double preco) {
		if(!fornecedores.containsKey(forncedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao == "") {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if(forncedor == null || forncedor == "") {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		if(fornecedores.get(forncedor).existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
		fornecedores.get(forncedor).cadastraProduto(nome, descricao, preco);
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		if(fornecedor == null || fornecedor == "") {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao == "") {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(!fornecedores.get(fornecedor).existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		
		return fornecedores.get(fornecedor).exibeProduto(nome, descricao);
	}
	
	public String exibeProdutos(String nomeFornecedor) {
		if(nomeFornecedor == null || nomeFornecedor == "") {
			throw new IllegalArgumentException("Erro na exibicao dos produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao dos produto: fornecedor nao existe.");
		}
		return fornecedores.get(nomeFornecedor).exibeTodosProdutos();
	}
	
	public void editaProduto (String nome, String descricao, String fornecedor, double novoPreco) {
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if(novoPreco< 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		if(descricao == null || descricao == "") {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(fornecedor == null || fornecedor == "") {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		fornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
	}
	
	public void removeProduto(String nome, String descricao, String fornecedor) {
		if(!fornecedores.get(fornecedor).existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		if(fornecedor == null || fornecedor == "") {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao == "") {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(nome == null || nome == "") {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		
		fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
	
}






















