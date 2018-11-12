/**
 * Representação de uma compra, será criada com um nome para o produto
 * coprado, um preço e a data que foi feita a compra.
 * @author afranio
 *
 */
public class Compra implements Comparable<Compra>{
	private String produto;
	private String data;
	private double preco;
	
	/**
	 * Constroi a compra.
	 * 
	 * @param produto o nome do produto
	 * @param data a data da compra
	 * @param preco o preço do produto
	 */
	public Compra(String produto, String data, double preco) {
		this.produto = produto;
		this.data = data;
		this.preco = preco;
	}
	
	
	@Override
	public int compareTo(Compra c) {
		return this.toString().compareTo(c.toString());
	}

	@Override
	public String toString() {
		return this.produto +" - "+ this.data;
	}

	public String getProduto() {
		return produto;
	}


	public double getPreco() {
		return preco;
	}


	public String getData() {
		return data;
	}

}
