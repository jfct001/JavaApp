/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			emptyList.remove(0); 
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		assertEquals("Add End: check emptyList add end: ", true, emptyList.add(0));
		assertEquals("Add End: check emptyList size after add end: ", (Integer)1, (Integer)emptyList.size());
		assertEquals("Add End: check list1 add end: ", true, emptyList.add(89));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("Size: check shortList size is correct", (Integer)2, (Integer)shortList.size());
		assertEquals("Size: check List1 size is correct", (Integer)3, (Integer)list1.size());
		assertEquals("Size: check empty size is correct", (Integer)0, (Integer)emptyList.size());
		assertEquals("Size: check longerList size is correct", (Integer)10, (Integer)longerList.size());
	}

	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		list1.add(1,2);
		assertEquals("Add at index: check list1 add at index is correct", (Integer)2, list1.get(1));
		assertEquals("Add at index: check list1 size increment by 1", (Integer)4, (Integer)list1.size());
		
		emptyList.add(0, 10);
		assertEquals("Add at index: check emptyList add at index is correct", (Integer)10, emptyList.get(0));
		assertEquals("Add at index: check emptyList size increment by 1", (Integer)1, (Integer)emptyList.size());
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		assertEquals("Set: check list1 set is correct", (Integer)42, (Integer)list1.set(2,24));
		assertEquals("Set: check list1 set is correct", (Integer)24, (Integer)list1.get(2));
//		assertEquals("Size: check empty size is correct", (Integer)1, (Integer)emptyList.set(0, 1));
		
		try {
			emptyList.set(0, 2); 
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			list1.set(3, 2);  // list1 size = 3;
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}

	
}
