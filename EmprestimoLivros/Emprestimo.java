import java.util.Vector;

public class Emprestimo {
    private Pessoa pessoa;
    private Data data;
    private Vector<Livro> livrosL = new Vector<Livro>();

    public Emprestimo(Pessoa pessoa, Data data) {
        this.pessoa = pessoa;
        this.data = data;
    }

    public void addLivro(Livro livro) {
        livrosL.add(livro);
    }

    public void mostraLivros() {
        for (Livro leitura : livrosL) {
            System.out.print(leitura);
        }
    }

    public String toString() {
        String toString = String.format("\n--- %02d/%02d/%d --- \nPessoa: %s (%s)\nLivro(s): \n", data.dia, data.mes,
                data.ano, pessoa.nome, pessoa.email);
        return toString;
    }
}
