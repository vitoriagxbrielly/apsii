package ex3;

public class main {

	public static void main(String[] args) {
		
		Livro livro = new Livro(
				"Dom Casmurro",
				34.99,
				"Machado de Assis"
				
		);
		
		CD cd = new CD(
				"Believe JB",
				95.00,
				13
		);
		
		System.out.println(" LIVRO ");
		System.out.println("Nome: " + livro.getNome());
		System.out.println("Preço: R$ " + livro.getPreco());
		System.out.println("Autor: " + livro.getAutor());
		
		System.out.println("\n CD ");
		cd.exibeInformacoes();
	}

}
