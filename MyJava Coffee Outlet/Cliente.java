public class Cliente {
    private String nome;
    private String CPF;
    private String endereco;

    public Cliente(String nome, String CPF, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public String toString () {
        return "Nome do cliente: " + nome + ". CPF: " + CPF + "\nEndereço: " + endereco;
    }
}
