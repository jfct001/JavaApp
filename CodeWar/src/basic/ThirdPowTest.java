package basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThirdPowTest {

	@Test
	public void test() {
		assertEquals(6, ThirdPow.intCubeSumDiv(1));
		assertEquals(28, ThirdPow.intCubeSumDiv(2));
		assertEquals(30, ThirdPow.intCubeSumDiv(3));
		assertEquals(84, ThirdPow.intCubeSumDiv(4));
		assertEquals(102, ThirdPow.intCubeSumDiv(5));
	}

}
