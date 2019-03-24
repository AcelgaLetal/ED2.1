package ule.edi.limitedpriorityqueue;

public class LinkedQueue<T> implements QueueADT<T> {
	
	protected static class Node<D> {
		D element;
		Node<D> next;
		
		Node() {
		this.element = null;
		this.next = null;
		}
		Node(D element) {
		this.element = element;
		this.next = null;
		}
		
		}

	private int count;
	private Node<T> front, rear; 
	
	public LinkedQueue()
	 {
		// TODO Auto-generated method stub
		front = new Node<T>();
		rear = new Node <T>();
		count = 0;
	 } 
	
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		
		if (element != null)
		{
			Node<T> nuevo = new Node<T>(element);
			
			if(isEmpty())
			{
				front = nuevo;
				rear = nuevo;
				count++;
			}
			else if(count == 1)
			{
				rear = nuevo;
				front.next = rear;
				count++;
			}
			else
			{
				rear.next = nuevo;
				count++;
			}
			rear = nuevo;
		}
		else
		{
			throw new NullPointerException();
		}
		
	}

	@Override
	public T dequeue() throws EmptyCollectionException
	{
		// TODO Auto-generated method stub
		
		T aux = first();
		front = front.next;
		count --;
		
		return aux;	
	}

	@Override
	public T first()  throws EmptyCollectionException{
		// TODO Auto-generated method stub
		return front.element;	
	}

	@Override
	public boolean isEmpty() {
		 // TODO Auto-generated method stub
		if(count == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public T dequeueLast() 
	{
	  // TODO Auto-generated method stub

		T devolver = rear.element;
		
		if(front.next == null)
		{
			devolver = front.element;
			front = null;
			count--;
		}
		else if(front.next.next == null)
		{	
			devolver = front.next.element;
			front.next = null;
			count--;
		}
		else
		{
			Node<T> iter = front.next;
			Node<T> aux = front;
			iter.next = front.next.next;
			aux.next = front.next;
			
			while(iter.next.next != null)
			{
				iter.next = iter.next.next;
				aux.next = aux.next.next;
			}
			//devolver = iter.next.element;
			iter.next = null;
			rear = aux.next;
			count--;
		}
		return devolver;
		
	}

	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			Node<T> actual=front;
			while (actual!=null) {
				rx.append(actual.element.toString());
				rx.append(", ");
				actual=actual.next;
			}
			rx.delete(rx.length() - 2, rx.length());
			return rx.toString();
		}
		return ""; 


};

}
