package chapter02;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/16
 */

public class AmountDiscountPolicy extends DiscountPolicy{
	private Money discountAmount;

	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
