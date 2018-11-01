
public class Main {
	public static void main(String[] args) {
		SAGA controle = new SAGA();
		
		controle.cadastraCliente("afranio", "093", "SPLab", "afranio.garcia@gmail.com");
		controle.cadastraFornecedor("ze", "ze@gmail.com", "839988");
		controle.cadastraProdutoParaFornecedor("ze", "batata", "batataDoce pequena", 3.50);
		controle.cadastraProdutoParaFornecedor("ze", "tomate", "tomate madura", 2.50);
		controle.cadastraProdutoParaFornecedor("ze", "cenoura", "cenoura fina", 2.50);
		
		
		System.out.println(controle.exibeCliente("093"));
		System.out.println(controle.exibeFornecedor("ze"));
		System.out.println(controle.exibeProdutoDoFornecedor("ze", "batata", "batataDoce pequena"));
		System.out.println(controle.exibeTodosProdutosDoFornecedor("ze"));
		
	}
}
