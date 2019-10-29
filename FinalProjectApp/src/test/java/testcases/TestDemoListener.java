package testcases;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

public class TestDemoListener {
	@Test
	public void passTest() {
		System.out.println("this is passed test case");
	}

	@Test
	public void failedTest() {
		assertFalse(true);
		System.out.println("this is failed test case");
	}

	@Test(enabled = false)
	public void skipedTest() {
		System.out.println("this is skiped test case");
	}
}
