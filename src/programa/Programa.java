package programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Client;
import entidades.Order;
import entidades.OrderItem;
import entidades.Product;
import entidades.enums.OrderStatus;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		String nome, email, status;
		Date dataNascimento, dataPedido = new Date();
		int quanti;
		
		System.out.println("Digite os dados do cliente: ");
		System.out.print("Nome: ");
		nome = sc.nextLine();
		System.out.print("Email: ");
		email = sc.next();
		System.out.print("Data de nascimento (dd/MM/yyyy): ");
		dataNascimento = data.parse(sc.next());
		
		Client client = new Client(nome, email, dataNascimento);
		
		System.out.println("Digite os dados do pedido: ");
		System.out.print("Status: ");
		status = sc.next();
		
		Order order = new Order(dataPedido, OrderStatus.valueOf(status), client);
		
		System.out.print("Quantos items irão para esse pedido: ");
		quanti = sc.nextInt();
		
		
		for (int x = 1; x <= quanti; x++) {
			System.out.println("Digite os dados do pedido " + x + "#: ");
			System.out.print("Nome do produto: ");
			String nomeProduto = sc.next();
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantiProduto = sc.nextInt();
			
			OrderItem item = new OrderItem(quantiProduto, precoProduto, new Product(nomeProduto, precoProduto));
			order.addItem(item);
		};
		
		
		System.out.println(order);
		
		sc.close();
	}

}
