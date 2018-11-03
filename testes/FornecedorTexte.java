import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FornecedorTexte {
	
	Fornecedor forn = new Fornecedor("Jose", "@gmail.com", "8399");
	 
	@Test
	void testCadastraProduto() {
		forn.cadastraProduto("Batata", "Batata palha", 6.5);
		assertEquals("Batata - Batata palha - R$6,50", forn.exibeProduto("Batata", "Batata palha"));
	}

	@Test
	void testEditaProduto() {
		forn.cadastraProduto("Batata", "Batata palha", 6.5);
		forn.editaProduto("Batata", "Batata palha", 4.5);
		assertEquals("Batata - Batata palha - R$4,50", forn.exibeProduto("Batata", "Batata palha"));
	}

	@Test
	void testExisteProduto() {
		forn.cadastraProduto("Batata", "Batata palha", 6.5);
		assertEquals(true, forn.existeProduto("Batata", "Batata palha"));
		assertEquals(false, forn.existeProduto("cenoura", "Batata palha"));
	}


	@Test
	void testRemoveProduto() {
		forn.cadastraProduto("Batata", "Batata palha", 6.5);
		assertEquals(true, forn.existeProduto("Batata", "Batata palha"));
		forn.removeProduto("Batata", "Batata palha");
		assertEquals(false, forn.existeProduto("Batata", "Batata palha"));
	}

	@Test
	void testExibeProdutos() {
		forn.cadastraProduto("Batata", "Batata palha", 6.5);
		forn.cadastraProduto("Ameixa", "Ameixa seca", 4.5);
		forn.cadastraProduto("Carne", "Carne vermelha", 10.5);
		assertEquals("Jose - Ameixa - Ameixa seca - R$4,50 | Jose - Batata - Batata palha - R$6,50 | Jose - Carne - Carne vermelha - R$10,50", forn.exibeProdutos());
	}

}
