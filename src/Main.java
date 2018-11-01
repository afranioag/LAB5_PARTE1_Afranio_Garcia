
public class Main {
	public static void main(String[] args) {
		SAGA controle = new SAGA();
		
		controle.cadastraCliente("kfranio", "093", "SPLab", "kfranio.garcia@gmail.com");
		controle.cadastraCliente("afranio", "193", "Lab", "afranio.garcia@gmail.com");
		controle.cadastraCliente("zfranio", "293", "SP", "zfranio.garcia@gmail.com");
		controle.cadastraCliente("gfranio", "393", "PL", "gfranio.garcia@gmail.com");
		
		controle.cadastraFornecedor("ze", "ze@gmail.com", "839988");
		controle.cadastraFornecedor("meba", "meba@gmail.com", "8388748");
		controle.cadastraFornecedor("chico", "chico@gmail.com", "8398521");
		
		controle.cadastraProdutoParaFornecedor("ze", "batata", "batataDoce pequena", 3.50);
		controle.cadastraProdutoParaFornecedor("ze", "tomate", "tomate madura", 2.50);
		controle.cadastraProdutoParaFornecedor("ze", "cenoura", "cenoura fina", 2.50);
		
		
		System.out.println(controle.exibeCliente("093"));
		System.out.println(controle.exibeFornecedor("ze"));
		System.out.println(controle.exibeProdutoDoFornecedor("ze", "batata", "batataDoce pequena"));
		System.out.println(controle.exibeTodosProdutosDoFornecedor("ze"));
		System.out.println(controle.exibeTodosFornecedores());
		System.out.println(controle.exibeTodosClientes());
		
	}
}
