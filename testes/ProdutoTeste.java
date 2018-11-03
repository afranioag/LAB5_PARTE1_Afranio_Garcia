import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class ProdutoTeste {
	public Produto prod = new Produto("Batata", "Batata palha", 6.5);

	@Test
	public void testExibeProduto() {
		assertEquals("Batata - Batata palha - R$6,50",prod.exibeProduto("Batata", "Batata palha"));
	}

}
