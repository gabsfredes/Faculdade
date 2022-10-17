/*
"O supermercado vende diferentes tipos de produtos. Cada produto tem um preço e uma
quantidade em estoque. Um pedido de um cliente é composto de itens, onde cada item
especifica o produto que o cliente deseja e a respectiva quantidade. Esse pedido pode ser
pago em dinheiro, cheque ou cartão."

Caso queira informar mais de um cliente, inserir vetor de clientes.
 */

import java.util.Scanner;
import supermercado.*;

public class Super {

	private Descricao descricao;

	public static int menu(Scanner input) {
		int op;
		do {
			System.out.println("\n--- Menu ---");
			System.out.println("1 - Informar Estoque");
			System.out.println("2 - ");
			System.out.println("3 - ");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opcao: ");
			op = input.nextInt();
		} while (op < 1 || op > 4);
		input.nextLine(); // limpa o buffer
		return op;
	}

	public static void informaEstoque(Scanner input) {
		System.out.print("\n***** Informando estoque do sistema *****\n");

		System.out.print("[ - ARROZ - ]\n");
		System.out.print("Informe a quantidade em estoque: ");
		int qtdArroz = input.nextInt();
		System.out.print("Informe o preço: ");
		double precoArroz = input.nextDouble();

		// System.out.print("[ - FEIJÃO - ]\n");
		// System.out.print("Informe a quantidade em estoque: ");
		// int qtdFeijao = input.nextInt();
		// System.out.print("Informe o preço: ");
		// double precoFeijao = input.nextDouble();

		// System.out.print("[ - FARINHA - ]\n");
		// System.out.print("Informe a quantidade em estoque: ");
		// int qtdFarinha = input.nextInt();
		// System.out.print("Informe o preço: ");
		// double precoFarinha = input.nextDouble();

		// System.out.print("[ - LEITE - ]\n");
		// System.out.print("Informe a quantidade em estoque: ");
		// int qtdLeite = input.nextInt();
		// System.out.print("Informe o preço: ");
		// double precoLeite = input.nextDouble();

		// criando objetos Produto
		Produto arroz = new Produto(Descricao.ARROZ, precoArroz, qtdArroz);
		// Produto feijao = new Produto(Descricao.FEIJAO, precoFeijao, qtdFeijao);
		// Produto farinha = new Produto(Descricao.FARINHA, precoFarinha, qtdFarinha);
		// Produto leite = new Produto(Descricao.LEITE, precoLeite, qtdLeite);

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int op;
		do {
			op = menu(input);
			switch (op) {
				case 1:
					informaEstoque(input);
					break;
				case 2:

					break;
				case 3:
					System.out.println("\nO programa está encerando .....\n\nEncerrado!\n");
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
		} while (op != 4);

	}

}
