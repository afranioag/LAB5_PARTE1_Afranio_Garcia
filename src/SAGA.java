import java.util.HashMap;

public class SAGA {
	private HashMap<String, Cliente> clientes;
	private HashMap<String, Fornecedor> fornecedores;
	
	public SAGA() {
		clientes = new HashMap<>();
		fornecedores = new HashMap<>();
	}
	
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
	
	public String toStringListaDeCliente() {
		String listaDeClientes = "";
		
		
		
		return listaDeClientes;
	}
	
	public void cadastraFornecedor(String nome, String email, String telefone) {
		Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, novoFornecedor);
	}
	
}
