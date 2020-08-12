package kr.gracelove.testpractice.study;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/13
 */

public class Study {

	private StudyStatus status;

	private int limit;

	private int numberOfMinEnrolment;

	public Study(int limit, int numberOfMinEnrolment) {
		if (numberOfMinEnrolment < 0) {
			throw new IllegalArgumentException("최소 참석인원은 0 보다 커야 합니다.");
		}
		this.status = StudyStatus.DRAFT;
		this.limit = limit;
		this.numberOfMinEnrolment = numberOfMinEnrolment;
	}

	public StudyStatus getStatus() {
		return status;
	}

	public int getLimit() {
		return limit;
	}

	public int getNumberOfMinEnrolment() {
		return numberOfMinEnrolment;
	}
}
