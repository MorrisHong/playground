package chapter02;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/16
 */

public class NoneDiscountPolicy extends DiscountPolicy{
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}