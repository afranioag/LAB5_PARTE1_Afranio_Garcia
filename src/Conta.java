/**
 * Representação de uma conta cliente. Ela será construída com
 * uma lista de compras que esse cliente tem com um determinado fornecedor. E acumulará
 * o debito desse cliente com esse fornecedor
 */
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conta {
	private String fornecedor;
	private double debito;
	private List<Compra> compras;
	
	/**
	 * Constroi a conta cliente
	 * @param fornecedor o fornecedor que o cliente fez as compras
	 */
	public Conta(String fornecedor) {
		this.fornecedor = fornecedor;
		compras = new ArrayList<Compra>();
	}
	
	/**
	 * Adiciona uma compra a lista. Caso o cliente ainda não tenha nenhuma compra será criada a lista de compras.
	 * 
	 * @param produto o nome do produto comprado
	 * @param data a data da compra
	 * @param preco o preço do produto
	 */
	public void adicionaCompra(String produto, String data, double preco) {
		compras.add(new Compra(produto, data, preco));
		this.setDebito(getDebito()+preco);
	}
	
	/**
	 * O cliente quita o debito total com o fornecedor
	 */
	public void pagaConta() {
		this.setDebito(this.getDebito() - this.getDebito());
	}
	
	/**
	 * Retorna a divida do cliente
	 * @return retorna um double com o debito
	 */
	public double getDebito() {
		return this.debito;		
	}

	private void setDebito(double debito) {
		this.debito = debito;
	}

	public String getFornecedor() {
		return fornecedor;
	}
	
	public String toString() {
		
		int conte = 1;
		List<String> nomes = new ArrayList<>();
		for(Compra com: compras) {
			nomes.add(com.toString().replaceAll("/", "-"));
		}
		
		String comp = getFornecedor() +" | ";
		
		for(String compras2: nomes) {
			if(conte == compras.size()) {
				comp += compras2;
			}else {
				comp += compras2 + " | ";
			}
			conte+=1;
		}
		return comp;
	}
	
	public String listarCompras(String criterio, String cliente, String fornecedor) {
		String listaCompras = "";
		Collections.sort(compras);
		if(criterio.equals("Cliente")) {
			for(Compra compra: compras) {
				listaCompras += cliente +", "+ fornecedor +", "+ compra.getProduto() +", "+ compra.getData() +" | ";
			}		
		}
		return listaCompras;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
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
		Conta other = (Conta) obj;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		return true;
	}
	
	
}
