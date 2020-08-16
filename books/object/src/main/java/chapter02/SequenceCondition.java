package chapter02;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/16
 */

public class SequenceCondition implements DiscountCondition {
	private int sequence;

	public SequenceCondition(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}
}
