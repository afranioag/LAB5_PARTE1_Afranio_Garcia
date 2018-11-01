import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"Facade", "easyaccept/use_case_1.txt"};
		EasyAccept.main(args);
	}
	private SAGA saga;
	
	public Facade () {
		this.saga = new SAGA();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		try{
			saga.cadastraCliente(cpf, nome, email, localizacao);
			return cpf;
		}catch (Exception e) {
			 return e.getMessage();
		}
	}
	
	public void removeCliente (String cpf) {
		try {
			saga.removeCliente(cpf);
		}catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public void  editaCliente(String cpf, String atributo, String novoValor) {
		try {
			saga.editaCliente(cpf, atributo, novoValor);
		}catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	public String exibeCliente (String CPF) {
		try {
			return saga.exibeCliente(CPF);
		}catch (Exception e) {
			 return e.getMessage();
		}
	}
	
	public String exibeTodosClientes() {
		return saga.exibeTodosClientes();
	}
	
	public void cadastraFornecedores(String nome, String email, String telefone) {
		try {
			saga.cadastraFornecedor(nome, email, telefone);
		}catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public void removeFornecedor(String nome) {
		try {
			saga.removeFornecedor(nome);
		}catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public void editaFornecedor(String nome, String atributoMudar, String novoValor) {
		try {
			saga.editaFornecedor(nome, atributoMudar, novoValor);
		}catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public String exibeFornecedor(String nome) {
		try {
			return saga.exibeFornecedor(nome);
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public String exibeTodosFornecedores() {
		return saga.exibeTodosFornecedores();
	}
	
	public void cadastraProdutoParaFornecedor(String nomeForncedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		try {
			saga.cadastraProdutoParaFornecedor(nomeForncedor, nomeProduto, descricaoProduto, precoProduto);
		}catch(Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public String exibeProdutoDoFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		try {
			return saga.exibeProdutoDoFornecedor(nomeFornecedor, nomeProduto, descricaoProduto);
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public String exibeTodosProdutosDoFornecedor(String nomeFornecedor) {
		try {
			return saga.exibeTodosProdutosDoFornecedor(nomeFornecedor);
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public void editaProduto (String nomeFornecedor, String nome, String descricao, double preco) {
		try {
			saga.editaProduto(nomeFornecedor, nome, descricao, preco);
		}catch(Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public void removeProduto(String nomeFornecedor, String nome, String descricao) {
		try {
			saga.removeProduto(nomeFornecedor, nome, descricao);
		}catch(Exception e) {
			 System.out.println(e.getMessage());
		}
	}
}

























