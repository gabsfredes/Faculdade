package supermercado;
 
public class Pedido {
	private Cliente cliente;
	private tipoPagamento pagamento;
	
	public Pedido (Cliente cliente, tipoPagamento pagamento) {
		this.cliente = cliente;
		this.pagamento = pagamento;
	}
} 
 