package sistema_pedidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Pedido> listaDePedidos = new ArrayList<>();
	private static int proximoNumeroPedido = 1;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Sistema de Pedidos do Restaurante do Xandão");
		boolean executando = true;
		
		while (executando) {
			exibirMenu();
			System.out.print("Selecione o número da opção que deseja realizar: ");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			case 1:
				registrarPedido();
				break;
			case 2:
				removerPedido();
				break;
			case 3:
				listarPedidos();
				break;
			case 4:
				executando = false;
				System.out.println("Saindo... Até a próxima!");
				break;
			case 5:
				System.out.println("Opção inválida! Selecione uma das opções disponíveis.");
				break;
				
			}
		}
		scanner.close();

	}
	public static void exibirMenu() {
		System.out.println("\n===== MENU PRINCIPAL DO RESTAURANTE DO XANDÃO =====\n");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("4. Sair\n");
	}
	public static void registrarPedido() {
		System.out.println("\n--- Novo Pedido ---");
		System.out.println("Nome do responsável pelo pedido: ");
		String nomeCliente = scanner.nextLine();
		
		Pedido novoPedido = new Pedido(proximoNumeroPedido, nomeCliente);
		String nomeItem;
		do {
			System.out.print("Digite um item desejado (ou 'fim' para concluir o pedido): ");
			nomeItem = scanner.nextLine();
			
			if (!nomeItem.equalsIgnoreCase("fim")) {
				System.out.print("Digite o preço do item (em reais): ");
				double precoItem = scanner.nextDouble();
				scanner.nextLine();
				
				Item item = new Item(nomeItem, precoItem);
				novoPedido.adicionarItem(item);
				
			}
		}
		while (!nomeItem.equalsIgnoreCase("fim"));
		
		listaDePedidos.add(novoPedido);
		System.out.println("\n Pedido de número " + novoPedido.getNumero() + " registrado!");
		proximoNumeroPedido++;
	}
	
	public static void removerPedido() {
		System.out.print("\nDigite o número do pedido que deseja remover: ");
		int numero = scanner.nextInt();
		scanner.nextLine();
		
		Pedido pedidoParaRemover = null;
		for (Pedido p : listaDePedidos) {
			if (p.getNumero() == numero) {
				pedidoParaRemover = p;
				break;
			}	
		}
		if (pedidoParaRemover != null) {
			listaDePedidos.remove(pedidoParaRemover);
			System.out.println("Pedido removido.");
		}
		else {
			System.out.println("Erro: Pedido não encontrado.");	
		}
	}
	
	public static void listarPedidos() {
		System.out.println("\n--- Lista de Pedidos ---");
		if (listaDePedidos.isEmpty()) {
			System.out.println("Nenhum pedido registrado.");
		}
		else {
			for (Pedido p : listaDePedidos) {
				System.out.println("------------------------------");
                System.out.println("Pedido de número " + p.getNumero());
                System.out.println("Cliente: " + p.getNomeCliente());
                System.out.println("Itens:");
                for (Item item : p.getItens()) {
                    System.out.println("- " + item);
                }
                System.out.printf("Valor Total: R$ %.2f\n", p.getValorTotal());
			}
			System.out.println("------------------------------");
		}
	
	}
	
}

