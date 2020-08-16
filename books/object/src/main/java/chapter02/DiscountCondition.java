package chapter02;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/16
 */

public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
