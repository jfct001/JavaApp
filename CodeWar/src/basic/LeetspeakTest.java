package basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeetspeakTest {

	  Leetspeak myEncoder = new Leetspeak();
	  
	  @Test
	  public void simpleTest(){
	    assertTrue("empty string", myEncoder.encode("").equals(""));
	    assertEquals("abcdef string", "4bc3f", myEncoder.encode("abcef"));
	    assertEquals("AelMOuu string", "431/^^\\0(_)(_)", myEncoder.encode("AelMOuu"));
	  }

}
