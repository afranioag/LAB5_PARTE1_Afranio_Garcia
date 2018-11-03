import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SagaTeste {

	SAGA saga = new SAGA();
	
	@Test
	void testAdicionaCliente() {
		// cpf já existe
		saga.adicionaCliente("98765432199", "Alfonse Capone", "@gmail.com", "UFCG");
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("98765432199", "Alfonse Capone", "@gmail.com", "UFCG");
		});
		
		// cpf grande
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("12345678911000000", "Afranio", "@gmail.com", "UFCG");
		});
		// cpf curto
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("123", "Afranio", "@gmail.com", "UFCG");
		});
		// nome vazio
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("12345678911", "", "@gmail.com", "UFCG");
		});
		
		// nome null
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("12345678911", null, "@gmail.com", "UFCG");
		});
		
		// email vazio
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("12345678911", "Afranio", "", "UFCG");
		});
		
		// email null
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("12345678911", "Afranio", null, "UFCG");
		});
		
		// local vazio
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("12345678911", "Afranio", "@gmail.com", "");
		});
		
		// local null
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("12345678911", "Afranio", "@gmail.com", null);
		});
		
		// todos os dados ok
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaCliente("12345678911", "Afranio", "@gmail.com", "UFCG");
		});
	}

	@Test
	void testRemoveCliente() {
		saga.adicionaCliente("12345678911", "Afranio", "@gmail.com", "UFCG");
		// cpf não existe
		assertThrows(IllegalArgumentException.class, ()->{
			saga.removeCliente("");
		});
		
		// cpf correto
		assertThrows(IllegalArgumentException.class, ()->{
			saga.removeCliente("12345678911");
		});
	}

	@Test
	void testEditaCliente() {
		saga.adicionaCliente("98765432199", "Alfonse Capone", "@gmail.com", "UFCG");
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.editaCliente("98765432199", "atributo", "lamp@gmail.com");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.editaCliente("98765432199", "email", "");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.editaCliente("98765432199", "email", null);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.editaCliente("98765432199", "", "lamp@gmail.com");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.editaCliente("98765432199", null, "lamp@gmail.com");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.editaCliente("xxxxxxxxxxx", "nome", "Lampiao");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.editaCliente("98765432199", "localizacao", "casa");
		});
	}

	@Test
	void testAdicionaFornecedor() {
		saga.adicionaFornecedor("existeNome", "email", "telefone");
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaFornecedor("existeNome", "email", "telefone");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaFornecedor(null, "email", "telefone");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaFornecedor("", "email", "telefone");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaFornecedor("nome", null, "telefone");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaFornecedor("nome", "", "telefone");
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			saga.adicionaFornecedor("nome", "email", "telefone");
		});
	}

//	@Test
//	void testRemoveFornecedor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEditaFornecedor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testExibeFornecedor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testExibeFornecedores() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAdicionaProduto() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testExibeProduto() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testExibeProdutosFornecedor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testExibeProdutos() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEditaProduto() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRemoveProduto() {
//		fail("Not yet implemented");
//	}

}
