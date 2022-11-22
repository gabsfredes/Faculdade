public class Excecao_InstrutorNaoEncontrado extends Exception{
        public Excecao_InstrutorNaoEncontrado() {
            super("Instrutor(a) não encontrado! Tente novamente.");
        }
    
        public Excecao_InstrutorNaoEncontrado(String message) {
            super(message);
        }
    
}
