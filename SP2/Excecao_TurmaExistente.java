public class Excecao_TurmaExistente extends Exception {
    public Excecao_TurmaExistente() {
        super("Já existe uma turma com esse código.");
    }
    public Excecao_TurmaExistente(String msg) {
        super(msg);
    }
}