package supermercado;

public class Produto {
	private Descricao descricao;
	private double preco;
	private int qtdEstoque;
	
	public Produto (Descricao descricao, double preco, int qtdEstoque) {
		this.descricao = descricao;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
	}
}
