package chapter01;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/15
 */

public class TicketSeller {
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	public TicketOffice getTicketOffice() {
		return this.ticketOffice;
	}
}
