/*
 * UNIPAMPA
 * Engenharia de Computação
 * EC11
 * Gabriel Fredes e Gabriel Dalmazo
 * SP2
*/

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void novoAluno(Scanner input, Escola escola) {
        System.out.print("\nDigite o nome d@ alun@: ");
        String nome = input.nextLine();
        try {
            System.out.print("Digite a matrícula d@ alun@: ");
            long matricula = input.nextLong();
            input.nextLine();

            Aluno al = new Aluno(nome, matricula);
            escola.adicionarAluno(al);
            System.out.print("Alun@ adicionado com sucesso!\n");
        } catch (InputMismatchException e) {
            System.out.println("Ocorreu um erro! A matrícula deve ser um número inteiro.");
            input.nextLine();
            return;
        }
    }

    public static void novoInstrutor(Scanner input, Escola escola) {
        System.out.print("\nDigite o nome d@ instrutor(a): ");
        String nome = input.nextLine();
        try {
            System.out.print("Digite o código d@ instrutor(a): ");
            long codigo = input.nextLong();
            input.nextLine();

            Instrutor inst = new Instrutor(nome, codigo);
            escola.adicionarInstrutor(inst);


            System.out.println("Instrutor(a) adicionad@ com sucesso!\n");
        } catch (InputMismatchException e) {
            System.out.println("Ocorreu um erro! O código deve ser um número inteiro.");
            input.nextLine();
        }
    }

    public static Curso novoCurso(Scanner input, Escola escola) {
        System.out.print("\nDigite o nome do curso: ");
        String nome = input.nextLine();
        try {
            System.out.print("Digite o código do curso: ");
            long codigo = input.nextLong();
            input.nextLine();
            System.out.print("Digite a carga horária do curso (quantas horas?): ");
            int cargaHoraria = input.nextInt();
            input.nextLine();

            Curso cur = new Curso(nome, codigo, cargaHoraria);
            escola.adicionaCurso(cur);

            System.out.println("Curso adicionado com sucesso!\n");
            return cur;
        } catch (InputMismatchException e) {
            System.out.println("Ocorreu um erro! O código e a carga horária devem ser números inteiros.");
            input.nextLine();
            return null;
        }

    }

    public static void novaTurma(Scanner input, Escola escola) {
        try {
            System.out.print("Digite o código da turma: ");
            long codTurma = input.nextLong();
            input.nextLine();

            

            // confere se já existe uma turma com o código digitado
            escola.confereTurma(codTurma);

            System.out.print("Digite a data de início da turma (xx/xx/xxxx): ");
            String dataIni = input.nextLine();
            System.out.print("Digite a data de término da turma (xx/xx/xxxx): ");
            String dataFim = input.nextLine();

            // vincula um curso
            System.out.print("\nInforme o curso desta turma");
            LinkedList<Curso> listaCurso = new LinkedList<Curso>();

            try {
                System.out.print("\nDigite o código do curso: ");
                long codCurso = input.nextLong();
                input.nextLine();

                LinkedList<Curso> cur;
                cur = escola.buscarCurso(codCurso);
                
                listaCurso.add(cur.get(0));

            } catch (InputMismatchException e) {
                System.out.println("Ocorreu um erro! O código deve ser um número inteiro.");
                input.nextLine();
                return;
            } catch (Excecao_CursoNaoEncontrado e) {
                System.out.println(e.getMessage());
                return;
            }
       
            // informa os instrutores da turma
            System.out.println("\nInforme os instrutores(as) desta turma");
            LinkedList<Instrutor> listaInstrutores = new LinkedList<Instrutor>();

            // loopa até o usuario digitar que é o ultimo instrutor
            do {
                try {
                    System.out.print("Digite o código do instrutor(a): ");
                    long codInstrutor = input.nextLong();
                    input.nextLine();

                    LinkedList<Instrutor> temp;
                    temp = escola.buscarInstrutor(codInstrutor);

                    if (listaInstrutores.contains(temp.get(0))) {
                        System.out.println("Este instrutor(a) já foi adicionado(a)!");
                    } else {
                        listaInstrutores.add(temp.get(0));
                    }
                    System.out.println("Instrutor(a) " + temp.get(0).getNome() + " adicionad@ com sucesso!\n");

                } catch (Excecao_InstrutorNaoEncontrado e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Ocorreu um erro! O código deve ser um número inteiro.");
                    input.nextLine();
                }
                System.out.print("\nDeseja informar outro instrutor? (s/n): ");
            } while (input.nextLine().equals("s"));

            // informa os alunos da turma
            System.out.println("\nInforme @s alun@s desta turma");
            LinkedList<Aluno> listaAlunos = new LinkedList<Aluno>();

            // loopa até o usuario digitar que é o ultimo aluno
            do {
                try {
                    System.out.print("Digite a matrícula d@ alun@: ");
                    long matAluno = input.nextLong();
                    input.nextLine();

                    LinkedList<Aluno> temp;
                    temp = escola.buscarAluno(matAluno);

                    // confere se já está na lista
                    if (listaAlunos.contains(temp.get(0))) {
                        System.out.println("Alun@ " + temp.get(0).getNome() + " já está na lista!");
                    } else {
                        listaAlunos.add(temp.get(0));
                        System.out.println("Alun@ " + temp.get(0).getNome() + " adicionad@ com sucesso!\n");
                    }

                } catch (Excecao_AlunoNaoEncontrado e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Ocorreu um erro! A matrícula deve ser um número inteiro.");
                    input.nextLine();
                }
                System.out.print("\nDeseja informar outr@ alun@? (s/n): ");
            } while (input.nextLine().equals("s"));

            Turma turma = new Turma(codTurma, dataIni, dataFim, listaCurso, listaAlunos, listaInstrutores);
            escola.adicionarTurma(turma);
            System.out.println("Turma adicionada com sucesso!\n");

        } catch (

        InputMismatchException e) {
            System.out.println("Ocorreu um erro! O código deve ser um número inteiro.");
            input.nextLine();
        } catch (Excecao_TurmaExistente e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // System.out.print("Digite o nome da escola: ");
        // String nomeEscola = input.nextLine();
        // System.out.print("Digite o telefone da escola: ");
        // String telefoneEscola = input.nextLine();
        // Escola escola = new Escola(nomeEscola, telefoneEscola);

        Escola escola = new Escola("Escola de Cursos de Curta Duração ECCD.", "123456789");

        int opcao = 0;

        do {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Escola " + escola.getNomeEscola() + " / Contato: " + escola.getTelefoneEscola());
            System.out.print("1 - Novo Alun@");
            System.out.print("\t\t| 4 - Buscar Instrutor(a)\n");
            System.out.print("2 - Buscar Alun@");
            System.out.print("\t| 5 - Nova Turma\n");
            System.out.print("3 - Novo Instrutor(a)");
            System.out.print("\t| 6 - Buscar Turma\n");
            System.out.print("7 - Criar Curso");
            System.out.print("\t\t| 8 - Buscar Curso\n");
            System.out.print("\n9 - Ordenar e Listar turmas\n");
            System.out.println("10 - Sair");
            System.out.print("--------------------------------------------------\n");

            try {
                System.out.print("Digite a opção desejada: ");
                opcao = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ops! Ocorreu um erro, você precisa inserir um número inteiro neste campo.");
                input.nextLine();
            }

            switch (opcao) {
                case 1:
                    novoAluno(input, escola);
                    break;
                case 2:
                    System.out.print("Digite a matrícula d@ alun@: ");
                    long matricula = input.nextLong();
                    input.nextLine();

                    try {
                        LinkedList<Aluno> alunos = escola.buscarAluno(matricula);
                        for (Aluno al : alunos) {
                            System.out.println("\nNome: " + al.getNome());
                            System.out.println("Matrícula: " + al.getMatricula());
                        }
                    } catch (Excecao_AlunoNaoEncontrado e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    novoInstrutor(input, escola);
                    break;
                case 4:
                    System.out.print("Digite o código do instrutor(a): ");
                    long codigo = input.nextLong();
                    input.nextLine();

                    try {
                        LinkedList<Instrutor> instrutores = escola.buscarInstrutor(codigo);
                        for (Instrutor inst : instrutores) {
                            System.out.println("\nNome: " + inst.getNome());
                            System.out.println("Código: " + inst.getCodigo());
                        }
                    } catch (Excecao_InstrutorNaoEncontrado e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    novaTurma(input, escola);
                    break;
                case 6:
                    System.out.print("Digite o código da turma: ");
                    long codTurma = input.nextLong();
                    input.nextLine();

                    try {
                        LinkedList<Turma> turmas = escola.buscarTurma(codTurma);
                        for (Turma turma : turmas) {
                            escola.umaTurma(turma);
                        }
                    } catch (Excecao_TurmaNaoEncontrada e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    novoCurso(input, escola);
                    break;
                case 8:
                    System.out.print("Digite o código do curso: ");
                    long codCurso = input.nextLong();
                    input.nextLine();

                    try {
                        LinkedList<Curso> cursos = escola.buscarCurso(codCurso);
                        for (Curso curso : cursos) {
                            escola.umCurso(curso);
                        }
                    } catch (Excecao_CursoNaoEncontrado e) {
                        System.out.println("Curso não encontrado!");
                    }
                    break;
                case 9:
                    escola.listarTurmas();
                    break;

                default:
                    if (opcao == 10) {
                        System.out.println("Saindo do programa!");
                        break;
                    } else
                        System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 10);
        input.close();
    }
}
