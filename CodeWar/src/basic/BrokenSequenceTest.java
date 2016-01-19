package basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class BrokenSequenceTest{

	   @Test
	   public void test1() {
	     assertEquals("", 4, new BrokenSequence().findMissingNumber("1 2 3 5"));
	     assertEquals("", 2, new BrokenSequence().findMissingNumber("1 3"));
	     assertEquals("", 0, new BrokenSequence().findMissingNumber("1 2 3"));
	   }
	   
	   @Test
	   public void test2() {
	     assertEquals("", 1, new BrokenSequence().findMissingNumber("_____________"));
	   }   
	   
	   @Test
	   public void test3() {
	     assertEquals("", 0, new BrokenSequence().findMissingNumber(""));
	   } 
	   
	}