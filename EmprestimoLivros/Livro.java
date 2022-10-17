public class Livro {
    private String titulo;
    private String autor;

    public Livro (String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public String toString() {
        String toString = String.format("%s (Autor: %s)\n", titulo, autor);
        return toString;
    }
}
