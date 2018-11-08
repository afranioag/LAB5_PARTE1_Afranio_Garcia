
public class Combo extends Produto{
	private double fator;
	
	public Combo(String nome, String descricao, double preco, double fator) {
		
		super(nome, descricao, (preco*(1 - fator)));
		this.fator = fator;
	}
	
	
	public void setFator(double fator) {	
		this.fator = fator;
	}
	
	public void editaPreco(double fator) {
		double novo = super.getPreco() / this.fator;
		novo *= fator;
		this.setFator(fator);
		super.setPreco(novo);
	}
	
	@Override
	public int compareTo (Produto c) {
		return this.getNome().compareTo(c.getNome());
	}
	
}
