public class Excecao_AlunoNaoEncontrado extends Exception{

    public Excecao_AlunoNaoEncontrado() {
        super("Alun@ não encontrad@! Tente novamente.");
    }

    public Excecao_AlunoNaoEncontrado(String message) {
        super(message);
    }

}
