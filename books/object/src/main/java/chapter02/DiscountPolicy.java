package chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/16
 */

public abstract class DiscountPolicy {
	private final List<DiscountCondition> conditions;

	public DiscountPolicy(DiscountCondition... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	public Money calculateDiscountAmount(Screening screening) {
		for (DiscountCondition each : conditions) {
			if (each.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}
		return Money.ZERO;
	}

	abstract protected Money getDiscountAmount(Screening screening);
}
