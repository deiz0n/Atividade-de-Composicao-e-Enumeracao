package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.OrderStatus;

public class Order {

	SimpleDateFormat sfd  = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sfd2  = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	
	Client client = new Client();
	OrderItem item = new OrderItem();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void romoveItem(OrderItem item) {
		items.remove(item);
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public double total() {
		double soma = 0.0;
		for (OrderItem x : items) {
			soma += x.subTotal();
		}
		return soma;
	}
	
	@Override
	public String toString() {
		StringBuilder x = new StringBuilder();
		x.append("Sumário do pedido:\n");
		x.append("Hora do pedido: " + sfd.format(moment) + "\n");
		x.append("Status do pedido: " + status + "\n");
		x.append("Cliente: " + client.getName() + " (" + sfd2.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		x.append("Items do pedido: \n");
		for (OrderItem y : items) {
			x.append(y.getProduct().getName() + ", Quantidade: " + y.getQuantity() + ", Subtotal: $" + String.format("%.2f", y.getPrice()) + "\n");
		};
		x.append("Preço total: $" + String.format("%.2f", total()));
		return x.toString();
	}
}
