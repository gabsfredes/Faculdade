public class Excecao_InstrutorNaoEncontrado extends Exception{
        public Excecao_InstrutorNaoEncontrado() {
            super("Instrutor não encontrado");
        }
    
        public Excecao_InstrutorNaoEncontrado(String message) {
            super(message);
        }
    
}
