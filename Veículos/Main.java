
/*
 * Gabriel Fredes
 * Exercício sobre herança
 * Universidade Federal do Pampa - UNIPAMPA - Campus Bagé (Engenharia de Computação)
 */
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static int Menu(Scanner input) {
        System.out.println("1 - Informar um veículo");
        System.out.println("2 - Listar veículos");
        System.out.println("3 - Sair");
        System.out.print("Digite a opção desejada: ");
        int op = input.nextInt();
        return op;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<Vehicle> veiculos = new Vector<Vehicle>();
        int menu;

        do {
            menu = Menu(input);
            switch (menu) {
                case 1:
                    System.out.print("\n\nInforme o tipo de veículo: \n");
                    System.out.println("1 - Caminhão");
                    System.out.println("2 - Veículo Off-Road");
                    System.out.print("Digite a opção desejada: ");
                    int tipo = input.nextInt();

                    if (tipo == 1) {
                        System.out.print("Quantos passageiros o caminhão suporta? ");
                        int passageiros = input.nextInt();
                        System.out.print("Quantos galões de gasolina o caminhão suporta? ");
                        int galoes = input.nextInt();
                        System.out.print("Quantos km o caminhão faz por galão? ");
                        int milhas = input.nextInt();
                        System.out.print("Qual a capacidade de carga do caminhão (Em kg)? ");
                        int carga = input.nextInt();

                        Truck caminhao = new Truck(passageiros, galoes, milhas, carga, "Caminhão");
                        veiculos.add(caminhao);
                    } else if (tipo == 2) {
                        System.out.print("Quantos passageiros o veículo off-road suporta? ");
                        int passageiros = input.nextInt();
                        System.out.print("Quantos galões de gasolina o veículo off-road suporta? ");
                        int galoes = input.nextInt();
                        System.out.print("Quantos km o veículo off-road faz por galão? ");
                        int milhas = input.nextInt();
                        System.out.print("Qual a distância entre o solo e o veículo (Em cm)? ");
                        int distancia = input.nextInt();

                        OffRoad veiculoOffRoad = new OffRoad(passageiros, galoes, milhas, distancia,
                                "Veículo Off-Road");
                        veiculos.add(veiculoOffRoad);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 2:
                    for (Vehicle veiculo : veiculos) {
                        System.out.println(veiculo);
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção de menu inválida!");
                    break;
            }
        } while (menu != 3);
        input.close();
    }
}
