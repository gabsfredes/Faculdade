/*
 * UNIPAMPA
 * Engenharia de Computação
 * EC11
 * Gabriel Fredes e Gabriel Dalmazo
 * ASP2
*/

public class Excecao_TurmaNaoEncontrada extends Exception{
    public Excecao_TurmaNaoEncontrada() {
        super("Turma não encontrada! Tente novamente");
    }

    public Excecao_TurmaNaoEncontrada(String message) {
        super(message);
    }

}
