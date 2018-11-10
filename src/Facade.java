/**
 * Representação de uma fachada onde será rodado o sistema saga,
 * ele apenas instancia e inicia o sistema.
 * Chamando todos os seus metodos de forma simples
 */

import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"Facade", "easyaccept/use_case_1.txt","easyaccept/use_case_2.txt","easyaccept/use_case_3.txt", "easyaccept/use_case_4.txt", "easyaccept/use_case_5.txt"};
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
	public String exibeCliente (String cpf) {
			return saga.exibeCliente(cpf);
	}
	
	public String exibeClientes() {
		return saga.exibeClientes();
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
			return saga.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return saga.exibeFornecedor(nome);
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
			saga.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void removeFornecedor(String nome) {
		saga.removeFornecedor(nome);
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
	
	public String exibeProdutosFornecedor(String nomeFornecedor) {
			return saga.exibeProdutosFornecedor(nomeFornecedor);
	}
	
	public String exibeProdutos() {
		return saga.exibeProdutos();
	}
	
	public void editaProduto (String nome, String descricao, String fornecedor, double novoPreco) {
			saga.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	public void removeProduto(String nome, String descricao, String fornecedor) {
			saga.removeProduto(nome, descricao, fornecedor);
	}
	
	public void adicionaCombo (String fornecedor, String nome, String descricao, double fator, String produtos) {
		saga.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		saga.editaCombo(nome, descricao, fornecedor, novoFator);
	}
	
	
	public void adicionaCompra(String cpf, String nome, String data, String nome_prod, String desc_prod){
		saga.adicionaCompra(cpf, nome, data, nome_prod, desc_prod);
	}

	public String getDebito(String cpf, String fornecedor) {
		return saga.getDebito(cpf, fornecedor);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		return saga.exibeContas(cpf, fornecedor);
	}
	
	public String exibeConta (String cpf) {
		return saga.exibeConta(cpf);
	}
}
















