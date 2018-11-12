/**
 * Extende a classe produto, e representa um produto do tipo combo
 * Será a junção de mais de um produto. Tendo um desconto a cada produto somado.
 * 
 * @author afranio
 *
 */

public class Combo extends Produto{
	private double fator;
	
	/**
	 * Constroi o combo
	 * @param nome o nome que o combo terá
	 * @param descricao a descrição
	 * @param preco o preço somado dos produto que faz parte do combo
	 * @param fator o fator de desconto para esse combo
	 */
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
