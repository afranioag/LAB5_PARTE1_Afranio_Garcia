/**
 * Representação de um cliente. Eles será construido a partir
 * do seu cpf que será sua identificação e deve seguir o modelo vigente do pais com 11 caracteres.
 * O nome, um local de trabalho e seu email.
 * @author afranio
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Cliente implements Comparable<Cliente>{
	private String CPF;
	private String localTrabalho;
	private String nome;
	private String email;
	private HashMap<String, Conta> contas;
	
	/**
	 * constroi o cliente.
	 * 
	 * @param cpf, o cpf do cliente
	 * @param nome, o nome do cliente
	 * @param localTrabalho, o local onde ele trabalha
	 * @param email, seu email
	 */
	public Cliente( String cpf, String nome, String email, String localTrabalho) {
		this.nome = nome;
		this.CPF = cpf;
		this.localTrabalho = localTrabalho;
		this.email = email;
		contas = new HashMap<>();
	}
	
	public void adicionaCompra(String fornecedor, String data,  String produto, double preco){
		if(!contas.containsKey(fornecedor)){
			contas.put(fornecedor, new Conta(fornecedor));
		}
		contas.get(fornecedor).adicionaCompra(produto, data, preco);
	}
	
	public String exibeConta() {	
		Set<String> fornecedores =  contas.keySet();
		List<String> nomesFornecedores = new ArrayList<>();
		
		for(String chaves: fornecedores) {
			nomesFornecedores.add(chaves);
		}
		Collections.sort(nomesFornecedores);
		
		String exibeConta = "Cliente: "+this.nome+" | ";
		int conte = 1;
		for(String chaves: nomesFornecedores) {
			if (conte == nomesFornecedores.size()) {
				exibeConta += contas.get(chaves).toString();
			}else {
				exibeConta += contas.get(chaves).toString()+" | ";
			}
		}
		return exibeConta;
	}
	
	public String exibeContas(String fornecedor) {
		return "Cliente: "+ this.nome +" | "+ contas.get(fornecedor).toString();
	}
	
	public String getDebito(String fornecedor) {
				return String.format("%.2f", contas.get(fornecedor).getDebito()).replace(",", ".");
	}
	
	public boolean debitoFornecedor(String fornecedor) {
		return contas.containsKey(fornecedor);
	}
	
	public boolean dataCerta(String data) {
		String[] testaData = data.split("/");
		if(Integer.parseInt(testaData[0]) <= 0 || Integer.parseInt(testaData[0]) > 31){
			return false;
		}
		if(Integer.parseInt(testaData[1]) <= 0 || Integer.parseInt(testaData[1]) > 12){
			return false;
		}
		if(Integer.parseInt(testaData[2]) <= 1990 || Integer.parseInt(testaData[2]) > 2050){
			return false;
		}
		return true;
		
	}
	
	public String getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return CPF;
	}
	
	// rever isso
	public boolean existeConta() {
		if(contas.size() > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
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
		Cliente other = (Cliente) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		return true;
	}

	/**
	 * Exibe a representação do cliente. 
	 * NOME - LOCALDETRABALHO - EMAIL
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localTrabalho + " - "+this.email;
	}

	@Override
	public int compareTo(Cliente c) {
		return toString().compareTo(c.toString());		
	}
	
}
