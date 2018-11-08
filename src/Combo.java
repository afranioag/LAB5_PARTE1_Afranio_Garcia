
public class Combo extends Produto{
	private double fator;
	
	public Combo(String nome, String descricao, double preco, double fator) {
		
		super(nome, descricao, (preco*(1 - fator)));
		this.fator = fator;
	}
	
	
	public void setFator(double fator) {	
		this.fator = fator;
	}
	
	@Override
	public void editaPreco(double fator) {
		double novo = super.getPreco() / (1 - this.fator);
		novo *= (1-fator);
		this.setFator(fator);
		super.setPreco(novo);
	}
	
	@Override
	public int compareTo (Produto c) {
		return this.getNome().compareTo(c.getNome());
	}
	
	/**
	 * Retorna uma representação do produto, com nome, descrição e preco.
	 * 
	 */
	@Override
	public String toString() {
		return this.nome+" - "+this.descricao+" - R$"+String.format("%.2f", this.preco);
	}
	
}
