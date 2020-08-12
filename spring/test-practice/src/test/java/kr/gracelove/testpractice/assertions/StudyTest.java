package kr.gracelove.testpractice.assertions;

import kr.gracelove.testpractice.study.Study;
import kr.gracelove.testpractice.study.StudyStatus;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/13
 */

public class StudyTest {

	@Test
	void assert_test() {
		Study study = new Study(-10, 0);
		assertEquals(StudyStatus.DRAFT, study.getStatus(), "처음 스터디를 만들면 상태값은" + StudyStatus.DRAFT + "여야 한다.");
		assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "처음 스터디를 만들면 상태값은" + StudyStatus.DRAFT + "여야 한다.");
		assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
			@Override
			public String get() {
				return "처음 스터디를 만들면 상태값은" + StudyStatus.DRAFT + "여야 한다.";
			}
		});

		assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야합니다.");
	}

	@Test
	void assert_all() {
		Study study = new Study(-10, 0);
		assertAll(
				() -> assertNotNull(study),
				() -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
						() -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + "상태 여야 합니다."),
				() -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 합니다.")
		);
	}

	@Test
	void assert_throws() {
		IllegalArgumentException illegalArgumentException =
				assertThrows(IllegalArgumentException.class, () -> new Study(10, -1));
		String message = illegalArgumentException.getMessage();
		assertEquals("최소 참석인원은 0 보다 커야 합니다.", message);
	}

	@Test
	void assert_timeout() {
		assertTimeout(Duration.ofMillis(100), () -> {
			new Study(10, 10);
			Thread.sleep(300);
		});
	}
}
