package supermercado;
 
public class Item {
	private Produto produto;
	private int quantidade;
	
	public Item (Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public void somaItem (int quantidade) {
		this.quantidade += quantidade;
	}
}
 