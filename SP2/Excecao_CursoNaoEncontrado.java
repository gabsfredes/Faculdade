public class Excecao_CursoNaoEncontrado extends Exception {
    public Excecao_CursoNaoEncontrado() {
        super("Curso não encontrado! Tente criar a turma novamente.");
    }

    public Excecao_CursoNaoEncontrado(String msg) {
        super(msg);
    }
}
