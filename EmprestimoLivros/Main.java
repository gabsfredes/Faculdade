import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static int menu(Scanner input) {
        int op;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Novo Emprestimo");
            System.out.println("4 - Imprimir emprestimos atuais");
            System.out.println("5 - Sair do program\n");
            System.out.print("Escolhe uma opcao: ");
            op = input.nextInt();
        } while (op < 1 || op > 5);
        input.nextLine(); // limpa o buffer
        return op;
    }

    public static Emprestimo novoEmprestimo(Scanner input) {
        Emprestimo E;
        System.out.println("\n--- Informe a data do emprestimo ---");
        System.out.print("Dia: ");
        int dia = input.nextInt();
        System.out.print("Mes: ");
        int mes = input.nextInt();
        System.out.print("Ano: ");
        int ano = input.nextInt();

        input.nextLine(); // limpa o buffer

        System.out.println("--- Pessoa do Emprestimo ---");
        System.out.print("Digite o nome da Pessoa: ");
        String nome = input.nextLine();
        System.out.print("Digite o Email da Pessoa: ");
        String email = input.nextLine();

        E = new Emprestimo((new Pessoa(nome, email)), (new Data(dia, mes, ano)));

        int maisLivro = 1;

        do {
        System.out.println("--- Livro do emprestimo ---");
        System.out.print("Nome do livro: ");
        String titulo = input.nextLine();
        System.out.print("Autor do livro: ");
        String autor = input.nextLine();

        System.out.print("Adicionar outro livro? [1 - Sim] [0-- - Nao] : ");
        maisLivro = input.nextInt();

        input.nextLine(); // limpa o buffer

        E.addLivro(new Livro(titulo, autor));
        } while(maisLivro == 1);

        return E;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<Emprestimo> emprestimos = new Vector<Emprestimo>(); // cria um vetor a classe emprestimo

        int op;
        do {
            op = menu(input);
            switch (op) {
                case 1:
                    Emprestimo proVetor = novoEmprestimo(input);
                    emprestimos.add(proVetor);
                    break;
                case 4:
                    for (Emprestimo lerEmprestimos : emprestimos) {
                        System.out.print(lerEmprestimos);
                        lerEmprestimos.mostraLivros();
                    }
                    break;
                case 5:
                    System.out.println("O programa esta enceranddo...\n...\n...\nEncerrado!\n");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } while (op != 5);
    }
}