import java.util.HashMap;

public class SAGA {
	private HashMap<String, Cliente> clientes;
	private HashMap<String, Fornecedor> fornecedores;
	
	public SAGA() {
		clientes = new HashMap<>();
		fornecedores = new HashMap<>();
	}
	
	// metodos para clientes
	public void cadastraCliente(String nome, String CPF, String localTrabalho, String email) {
		Cliente novoCliente = new Cliente(nome, CPF, localTrabalho, email);
		clientes.put(CPF, novoCliente);
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
	
//	public String toStringListaDeCliente() {
//		String listaDeClientes = "";	
//		return listaDeClientes;
//	}
	
	
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
	
//	public String exibeTodosFornecedores() {
//		String dadosFornecedores = "";
//		return dadosFornecedores;
//	}
	
	// metodos para produtos
	public void cadastraProdutoParaFornecedor(String nomeForncedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		fornecedores.get(nomeForncedor).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
	}
	
	public String exibeProdutoDoFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		return fornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, descricaoProduto);
	}
	
	public String exibeTodosProdutosDoFornecedor(String nomefornecedor) {
		return fornecedores.get(nomefornecedor).exibeTodosProdutos();
	}
	
	
}






















