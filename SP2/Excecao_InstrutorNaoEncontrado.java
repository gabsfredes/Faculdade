/*
 * UNIPAMPA
 * Engenharia de Computação
 * EC11
 * Gabriel Fredes e Gabriel Dalmazo
 * ASP2
*/

public class Excecao_InstrutorNaoEncontrado extends Exception{
        public Excecao_InstrutorNaoEncontrado() {
            super("Instrutor(a) não encontrado! Tente novamente.");
        }
    
        public Excecao_InstrutorNaoEncontrado(String message) {
            super(message);
        }
    
}
