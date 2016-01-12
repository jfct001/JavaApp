package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>();
		tail = new LLNode<E>();
		this.head.next = tail;
		this.tail.prev = head;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) {
			throw new NullPointerException();
		}
		
		addNode(tail, element);
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> iterNode = head;
		for (int i = 0; i <= index; ++i) {
			if (i > this.size-1) {
				throw new IndexOutOfBoundsException();
			}
			iterNode = iterNode.next;
		}
		return iterNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		if (element == null) {
			throw new NullPointerException();
		}
		
		LLNode<E> iterNode = head;
		// set to be -1 in case of 0 empty List
		for (int i = -1; i <= index-1; ++i) {
			if (i > this.size-1) {
				throw new IndexOutOfBoundsException();
			}
			iterNode = iterNode.next;
		}
		addNode(iterNode, element);
	}


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> iterNode = head;
		for (int i = 0; i <= index; ++i) {
			if (i > size-1) {
				throw new IndexOutOfBoundsException();
			}
			iterNode = iterNode.next;
		}
		E curData = iterNode.data;
		removeNode(iterNode);
		return curData;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		if (element == null) {
			throw new NullPointerException();
		}
		
		LLNode<E> iterNode = head;
		for (int i = 0; i <= index; ++i) {
			if (i > this.size-1) {
				throw new IndexOutOfBoundsException();
			}
			iterNode = iterNode.next;
		}
		E curData = iterNode.data;
		iterNode.data = element;
		return curData;
	}   
	
	/** add Node before curNode **/
	private void addNode(LLNode<E> curNode, E element) {
		LLNode<E> cur = new LLNode<E>(element); 
		LLNode<E> last = curNode.prev;
		last.next = cur;
		curNode.prev = cur;
		cur.prev = last;
		cur.next = curNode;
		this.size += 1;
	}
	
	/** remove current Node **/
	private void removeNode(LLNode<E> curNode) {
		LLNode<E> prev = curNode.prev;
		LLNode<E> next = curNode.next;
		prev.next = next;
		next.prev = prev;
		this.size -= 1;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;
	
	public LLNode()
	{
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> nextNode) {
		this.data = e;
		LLNode<E> prevNode = nextNode.prev;
		this.prev = prevNode;
		prevNode.next = this;
		this.next = nextNode;
		nextNode.prev = this;
	}

}
