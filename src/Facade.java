import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"Facade", "easyaccept/use_case_1.txt","easyaccept/use_case_2.txt","easyaccept/use_case_3.txt"};
		EasyAccept.main(args);
	}
	private SAGA saga;
	
	public Facade () {
		this.saga = new SAGA();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return	saga.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public void removeCliente (String cpf) {
			saga.removeCliente(cpf);
	}
	
	public void  editaCliente(String cpf, String atributo, String novoValor) {
		
			saga.editaCliente(cpf, atributo, novoValor);
	}
	public String exibeCliente (String CPF) {
	
			return saga.exibeCliente(CPF);
	}
	
	public String exibeClientes() {
		return saga.exibeClientes();
	}
	
	public void adicionaFornecedores(String nome, String email, String telefone) {
			saga.adicionaFornecedor(nome, email, telefone);
	}
	
	public void removeFornecedor(String nome) {
			saga.removeFornecedor(nome);
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		
			saga.editaFornecedor(nome, atributo, novoValor);
	}
	
	public String exibeFornecedor(String nome) {
		
			return saga.exibeFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return saga.exibeFornecedores();
	}
	
	public void adicionaProduto(String forncedor, String nome, String descricao, double preco) {
			saga.adicionaProduto(forncedor, nome, descricao, preco);
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
			return saga.exibeProduto(nome, descricao, fornecedor);
	}
	
	public String exibeTodosProdutosDoFornecedor(String nomeFornecedor) {
			return saga.exibeTodosProdutosDoFornecedor(nomeFornecedor);
	}
	
	public void editaProduto (String nome, String descricao, String fornecedor, double novoPreco) {
			saga.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	public void removeProduto(String nome, String descricao, String fornecedor) {
			saga.removeProduto(nome, descricao, fornecedor);
	}
}

























