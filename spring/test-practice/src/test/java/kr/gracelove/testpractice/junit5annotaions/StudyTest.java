package kr.gracelove.testpractice.junit5annotaions;

import kr.gracelove.testpractice.study.Study;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/13
 */

class StudyTest {

	@Test
	void create1() {
		Study study = new Study(-10, 0);
		assertNotNull(study);
		System.out.println("create1()");
	}

	@Test
	void create2() {
		System.out.println("create2()");
	}

	@Disabled
	@Test
	void create3() {
		System.out.println("create3()");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("@BeforeAll");
	}


	@AfterAll
	static void afterAll() {
		System.out.println("@AfterAll");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("@BeforeEach");
	}

	@AfterEach
	void afterEach() {
		System.out.println("@AfterEach");
	}
}