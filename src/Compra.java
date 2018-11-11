
public class Compra implements Comparable<Conta>{
	private String produto;
	private String data;
	private double preco;
	
	public Compra(String produto, String data, double preco) {
		this.produto = produto;
		this.data = data;
		this.preco = preco;
	}
	
	
	@Override
	public int compareTo(Conta c) {
		return this.toString().compareTo(c.toString());
	}

	@Override
	public String toString() {
		return this.produto +" - "+ this.data.replaceAll("/", "-");
	}


	public double getPreco() {
		return preco;
	}


	public String getData() {
		return data;
	}

}
