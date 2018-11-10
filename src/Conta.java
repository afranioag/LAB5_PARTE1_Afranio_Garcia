import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conta {
	private String fornecedor;
	private double debito;
	private List<Compra> compras;
	
	public Conta(String fornecedor) {
		this.fornecedor = fornecedor;
		compras = new ArrayList<Compra>();
	}

	public void adicionaCompra(String produto, String data, double preco) {
		compras.add(new Compra(produto, data, preco));
		this.setDebito(getDebito()+preco);
	}
	
	public void pagaConta(double valor) {
		this.setDebito(this.getDebito() - valor);
	}
	
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
			nomes.add(com.toString());
		}
		
		Collections.sort(nomes);
		
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
