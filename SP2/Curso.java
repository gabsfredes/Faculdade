/*
 * UNIPAMPA
 * Engenharia de Computação
 * EC11
 * Gabriel Fredes e Gabriel Dalmazo
 * ASP2
*/

public class Curso {
    private String nome;
    private long codCurso;
    private int cargaHoraria;

    public Curso(String nome, long codCurso, int cargaHoraria) {
        this.nome = nome;
        this.codCurso = codCurso;
        this.cargaHoraria = cargaHoraria;
    }

    public long getCodCurso() {
        return codCurso;
    }

    public String getNomeCurso() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String toString() {
        return "\nCurso: " + nome + " (" + codCurso + ") - " + cargaHoraria + " Horas";
    }
}
