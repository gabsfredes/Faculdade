/*
 * UNIPAMPA
 * Engenharia de Computação
 * EC11
 * Gabriel Fredes e Gabriel Dalmazo
 * ASP2
*/

public class Instrutor extends Pessoa{
    private long codigo;

    public Instrutor(String nome, long codigo) {
        super(nome);
        this.codigo = codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return super.getNome();
    }
}
