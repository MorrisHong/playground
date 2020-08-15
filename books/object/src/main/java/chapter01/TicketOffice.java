package chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/15
 */

public class TicketOffice {
	private Long amount;
	private List<Ticket> tickets = new ArrayList<>();

	public TicketOffice(Long amount, Ticket... tickets) {
		this.amount = amount;
		this.tickets.addAll(List.of(tickets));
	}

	public Ticket getTicket() {
		return tickets.remove(0);
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}
}
