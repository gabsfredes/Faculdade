public class Excecao_TurmaExistente extends Exception {
    public Excecao_TurmaExistente() {
        super("Turma já cadastrada");
    }
    public Excecao_TurmaExistente(String msg) {
        super(msg);
    }
}