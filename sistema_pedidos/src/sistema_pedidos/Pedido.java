package sistema_pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int numero;
	private String nomeCliente;
	private List<Item> itens;
	
	public Pedido(int numero, String nomeCliente) {
		this.numero = numero;
		this.nomeCliente = nomeCliente;
		this.itens = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public void adicionarItem(Item item) {
		this.itens.add(item);
	}
	
	public double getValorTotal() {
		double total = 0.0;
		for (Item item : itens) {
			total += item.getPreco();
		}
		return total;
	}
}
