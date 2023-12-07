package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.salas.SalaController;

import java.util.Scanner;

public class HomeController {
	
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao;
		do {
			System.out.print("\n-------  Home -------");
			System.out.print(
				"""

					1. Vender sala
					2. Manter Sala
					3. Cadastrar sala
					4. Manter Itens
					5. Manter Pedidos
					Opção (Zero p/sair):\s""");
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
				case 1 -> System.out.println("Em desenvolvimento"); //VendasController.main(null);
				case 2 -> System.out.println("Em desenvolvimento"); //ProdutoController.main(null);
				case 3 -> SalaController.main(null);
				case 4 -> System.out.println("Em desenvolvimento"); //ItemController.main(null);
				case 5 -> System.out.println("Em desenvolvimento"); //PedidoController.main(null);
				default -> {
					if (opcao != 0) System.out.println("Opção inválida.");
				}
			}
		} while(opcao != 0) ;
		System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
		input.close(); //libera o recurso
	}

}//fim classe
