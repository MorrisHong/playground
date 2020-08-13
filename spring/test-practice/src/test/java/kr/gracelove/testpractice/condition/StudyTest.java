package kr.gracelove.testpractice.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author : Eunmo Hong
 * @since : 2020/08/13
 */

class StudyTest {

	@Test
	@DisplayName("assumeTrue")
	void assumeTrue_test() {
		String user = System.getenv("USER");
		assumeTrue("govlmo91".equals(user));
		System.out.println("실행");
	}

	@Test
	@DisplayName("@EnabledOnOs")
	@EnabledOnOs(OS.MAC)
	void only_mac() {
		System.out.println("@EnabledOnOs(OS.MAC)");
	}

	@Test
	@DisplayName("@EnabledOnOs")
	@EnabledIfEnvironmentVariable(named = "USER", matches = "govlmo91")
	void EnabledIfEnvironmentVariable_test() {
		System.out.println("@EnabledIfEnvironmentVariable");
	}
}
