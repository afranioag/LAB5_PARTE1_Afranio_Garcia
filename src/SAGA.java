/**
 * Representação de um controlador do sistema SAGA
 * Ele é composto por mapas de clientes e fornecedores.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
 
public class SAGA {
	private HashMap<String, Cliente> clientes;
	private HashMap<String, Fornecedor> fornecedores;
	
	/**
	 * Inicializa o sistema criando um mapa de cliente e fornecedor.
	 */
	public SAGA() {
		clientes = new HashMap<>();
		fornecedores = new HashMap<>();
	}
	
	// metodos para clientes
	/**
	 * Adiciona um cliente ao sistema. Para sua criação é preciso passar CPF que será sua identificação e não poderá ser alterado depois,
	 * um nome, email e uma localização de trabalho.
	 * Caso algum desses atributos sejam passados irregulares será lançada uma exceção para cada tipo de erro.
	 * @param cpf o cpf do cliente, formado por onze caracteres numericos. 
	 * @param nome o nome cliente
	 * @param email o email do cliente
	 * @param localizacao o local de trabalho do cliente
	 * @return
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if(localizacao == null || localizacao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
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
	
	/**
	 * Remove um cliente a partir do cpf informado. Será lançada uma exceção para cpf invalido.
	 * @param cpf o cpf do cliente
	 */
	public void removeCliente(String cpf) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		clientes.remove(cpf);
	}
	
	/**
	 * Edição nos dados de um cliente, é preciso passar o cpf exato do cliente e o atributo que se quer modificar e um novoValor para
	 * o atributo.
	 * @param cpf o cpf do cliente
	 * @param atributo o atributo que se deseja modificar
	 * @param novoValor o novo valor para o atributo
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		if(atributo == null || atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if(novoValor == null || novoValor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		if(!atributo.equals("nome") && !atributo.equals("email") && !atributo.equals("localizacao")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		if(atributo.equals("nome")) {
			clientes.get(cpf).setNome(novoValor);
		}else if(atributo.equals("email")) {
			clientes.get(cpf).setEmail(novoValor);
		}else if(atributo.equals("localizacao")) {
			clientes.get(cpf).setLocalTrabalho(novoValor);
		}
	}
	
	/**
	 * Retorna uma String contendo os dados do cliente cujo cpf foi informado
	 * @param cpf o cpf do cliente
	 * @return retorna uma String
	 */
	public String exibeCliente(String cpf) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return clientes.get(cpf).toString();
	}
	
	/**
	 * Retorna todos os clientes cadastrados em ordem alfabetica
	 * @return retorna uma string
	 */
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
	
	/**
	 * Adiciona um fornecedor ao sistema. É preciso informar um nome, email e telefone. Em caso
	 * de algum atributo inavalido será lançada uma exceção para o tipo de atributo.
	 * @param nome o nome do forbecedor
	 * @param email o email do fornecedor
	 * @param telefone o telefone de contato do fornecedor
	 * @return retorna o nome do fornecedor em caso de sucesso
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if(fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		
		Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, novoFornecedor);
		return nome;
	}
	
	/**
	 * remove um fornecedor atraves do nome informado. Não pode ser um nome invalido. assim será lançada uma exceção
	 * @param nome o nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		if(nome.equals("")) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
	}
	
	/**
	 * Edita os dados do fornecedor. Informa o nome do fornecedor e o tipo de atributo que se quer modificar e o novo valor
	 * para esse atributo
	 * @param nome o nome do fornecedor
	 * @param atributo o atributo que se deseja modificar
	 * @param novoValor o novo valor para esse atributo
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if(atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		if(atributo.equals("") || atributo == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if(!atributo.equals("email")  && !atributo.equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
		if(novoValor.equals("") || novoValor == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		
		if(atributo.equals("email")) {
			fornecedores.get(nome).setEmail(novoValor);
		}else if(atributo.equals("telefone")) {
			fornecedores.get(nome).setTelefone(novoValor);
		}
	}
	
	/**
	 * Retorna uma string contendo a reprensetação do fornecedor. Nome email e telefone
	 * @param nome o nome do fornecedor que se quer retornar as informações
	 * @return retorna uma string
	 */
	public String exibeFornecedor(String nome) {
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return fornecedores.get(nome).toString();
	}
	
	/**
	 * Retorma uma string contendo todos os fornecedores do sistema em ordem alfabetica
	 * @return retorna uma string
	 */
	public String exibeFornecedores() {
		Set<String> nomesFornecedores = fornecedores.keySet();
		List <String> fornecedoresOrdenados = new ArrayList<>();
		for(String chaves: nomesFornecedores) {
				fornecedoresOrdenados.add(fornecedores.get(chaves).toString());
		}
		Collections.sort(fornecedoresOrdenados);
		int contador = 0;
		String nomesOrd = "";
		for(String nomes: fornecedoresOrdenados) {
			contador += 1;
			if (contador == fornecedoresOrdenados.size()) {
				nomesOrd += nomes;
			}else {
				nomesOrd += nomes+" | ";
			}
			
		}
		return nomesOrd;
	}
	
	// metodos para produtos
	
	/**
	 *  Cria um produto que será adicionado a uma lista de produtos de um determinado fornecedor.
	 *  É preciso passar o nome do fornecedor, um nome e descrilçao para o produto e um preço.
	 *  Em caso de algum erro nos parametros será lançada uma exceção para o dado erro.
	 * @param fornecedor o fornecedor que receberá o produto
	 * @param nome o nome do produto
	 * @param descricao a descrição do produto
	 * @param preco o pŕeço do produto
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if(fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		
		if(preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		if(fornecedores.get(fornecedor).existeProduto(nome, descricao) > -1) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
		fornecedores.get(fornecedor).cadastraProduto(nome, descricao, preco);
	}
	
	/**
	 * Retorna um produto expecifico. É preciso informar o nome e a descrição do produto como tambem
	 * o fornecedor que tem esse produto.
	 * @param nome o nome do produto
	 * @param descricao a descrição do produto
	 * @param fornecedor o fornecedor que tem o produto
	 * @return retorna uma string
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		if(descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(fornecedores.get(fornecedor).existeProduto(nome, descricao) == -1) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		
		return fornecedores.get(fornecedor).exibeProduto(nome, descricao);
	}
	
	/**
	 * Retorna uma string com todos os produtos do fornecedor em ordem alfabetica
	 * @param fornecedor o fornecedor que contem os produtos que se quer ver.
	 * @return retorna uma string
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		if(fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao dos produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao dos produto: fornecedor nao existe.");
		}
		return fornecedores.get(fornecedor).exibeProdutos();
	}
	
	/**
	 * Retorna uma string contendo todos os produtos de todos os fornecedores
	 * @return retorna uma string
	 */
	public String exibeProdutos () {
		Set<String> nomesFornecedores = fornecedores.keySet();
		List <String> fornecedoresOrdenados = new ArrayList<>();
		for(String chaves: nomesFornecedores) {
			fornecedoresOrdenados.add(chaves);
		}
		Collections.sort(fornecedoresOrdenados);
		int cont = 0;
		String aux = "";
		for(String nova: fornecedoresOrdenados) {
			if(this.exibeProdutosFornecedor(nova).length() < 4) {
				cont += 1;
				continue;
			}
			
			if (cont == fornecedoresOrdenados.size()-1) {
				aux += this.exibeProdutosFornecedor(nova);
			}
			else {
				aux += this.exibeProdutosFornecedor(nova)+" | ";
			}
			cont += 1;
		}
		return aux;
	}
	
	/**
	 * Modifica o preço de uma produto, precisa passar o nome e a descrição do produto como o novo valor
	 * @param nome o nome do produto e o fornecedor que tem o produto
	 * @param descricao a descrição do produto
	 * @param fornecedor o fornecedor que tem o produto
	 * @param novoPreco o novo preço
	 */
	public void editaProduto (String nome, String descricao, String fornecedor, double novoPreco) {
		
		if(novoPreco< 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		if(descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		
		fornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
	}
	
	/**
	 * remove um produto da lista do fornecedor. É preciso passar o nome e a descrição do produto
	 * como tambem o fornecedor que tem o produto
	 * @param nome o nome do produto
	 * @param descricao a descrição do produto
	 * @param fornecedor o fornecedor que tem o produto
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		
		if(fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		if(fornecedores.get(fornecedor).existeProduto(nome, descricao) == -1) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		
		fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
	
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		if(fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}
		
		if(!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}		
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}
		if(descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}
		
		if(produtos.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		}
		
		if(fornecedores.get(fornecedor).existeProduto(nome, descricao) > -1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
		
		if (fornecedores.get(fornecedor).existeProduto(produtos) == -1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		}
		
		if(fator < 0 || fator > 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		
		if(fornecedores.get(fornecedor).existeCombo(nome, produtos) == 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo n�o pode possuir combos na lista de produtos.");
		}
		
		fornecedores.get(fornecedor).cadastraCombo(nome, descricao, fator, produtos);
		
	}
	
}






























