package chapter01;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/15
 */

public class Theater {
	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {
		ticketSeller.sellTo(audience);
	}
}
