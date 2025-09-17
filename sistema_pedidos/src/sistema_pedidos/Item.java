package sistema_pedidos;

public class Item {
	private String nome;
	private double preco;
	
	public Item(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}
	public String toString() {
		return String.format("%s - R$ %.2f", nome, preco);
	}

}
