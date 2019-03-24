package ule.edi.limitedpriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;


public class LimitedPriorityQueueLinkedImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;

	    private QueueNode<T> first;
	    private int count;
	

	private static class QueueNode<E> {
	
		public QueueNode(int priority, E content) {
			this.priority = priority;
			this.content = content;
			this.next = null;
		}
		
		public int priority;
		
		public E content;
		
		public QueueNode<E> next;
	};
	

	
	public LimitedPriorityQueueLinkedImpl(int capacity) {
		
		this.capacity = capacity;
		
		count = 0;
	}
	
  

  
    @Override
    public int getCapacity() {

        return capacity;
    }

    @Override
    public int getSize() {
        return count ;
    }

    @Override
    public boolean isFull() {
    	// TODO Auto-generated method stub
    	if(this.count == this.capacity)
    	{
    		return true;
    	}
    	
    	return false;
    }

	@Override
	public T enqueue(int p, T element)
	{
		T elemAux = null;

		if(p <= 0)
		{
			throw new IllegalArgumentException("Priority cannot be zero");
		}
		else
		{
			if(isEmpty())
			{
				QueueNode<T> nuevo = new QueueNode<T>(p, element);
				first = nuevo;
				count++;
				return null;
			}
			else
			{		
				enqueueAux(p, element);
				if(isFull())
				{
					elemAux = dequeueLast(p, element);
				}	
				count++;			
				return elemAux;
			}
		}
	}
	
	public T enqueueAux(int p, T element)
	{
		QueueNode<T> nuevo = new QueueNode<T>(p, element);
		
		if(nuevo.priority < first.priority)
		{
			nuevo.next = first;
			first = nuevo;
			return null;
		}
		else if(first.next == null)
		{
			first.next = nuevo;
			return null;
		}
		else if(nuevo.priority < first.next.priority )
		{
			nuevo.next = first.next;
			nuevo.priority = p;
			nuevo.content = element;
			first.next = nuevo;
			return null;
		}
		else
		{
			nuevo.next = first.next.next;
			QueueNode<T> aux = first;
			aux.next = first.next;
			
			while(nuevo.next != null)
			{
				if(nuevo.priority < nuevo.next.priority)
				{
					aux.next.next = nuevo;
					return null;
				}
				nuevo.next = nuevo.next.next;
				aux.next = aux.next.next;
			}
			aux.next.next = nuevo;
			return null;
		}
	}
	
	public T dequeueLast(int p, T element)
	{
		
		QueueNode<T> aux = first;
		aux.next = first.next;
		QueueNode<T> iter = first.next;
		iter.next = first.next.next;
		T elemAux = null;
		
		if(aux.next == null)
		{
			elemAux = first.content;
			first = null;
			count--;
			return elemAux;
		}
		else if(iter.next == null)
		{
			elemAux = first.next.content;
			first.next = null;
			count--;
			return elemAux;
		}
		else
		{
			while(iter.next.next != null)
			{
				aux.next = aux.next.next;
				iter.next = iter.next.next;
			}
			elemAux = iter.next.content;
			aux.next.next = null;
			iter.next = null;
			count--;
			return elemAux;
		}
	}
	
	
	@Override
	public T first() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return first.content;
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		T elemAux = null;
		if(isEmpty())
		{
			throw new EmptyCollectionException("La cola esta vacia");
		}
		else
		{
			elemAux = first.content;
			first = first.next;
			count--;
			return elemAux;
		}
		
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
	public String toString()
	{
		if (! this.isEmpty())
		{
			StringBuffer rx = new StringBuffer();
			rx.append("[");
		      // TODO : MOSTRAR LOS ELEMENTOS DE LA COLA DE PRIORIDAD CON EL MISMO FORMATO QUE LA OTRA IMPLEMENTACIÓN
			int i = 0;
			int priAux = 0;
			QueueNode<T> aux = first;
			aux.next = first.next;
			priAux = aux.priority;
			
			rx.append("( Priority:" + aux.priority + " (");
			rx.append(aux.content);
			
			while(aux.next != null && aux.next.priority == priAux)
			{
				rx.append(aux.next.content);
				aux.next = aux.next.next;
				rx.append(",");
			}
			rx.append(")");
			rx.append(")");
			
			while(aux.next != null)
			{	
				rx.append(", ");
				rx.append("( Priority:" + aux.next.priority + " (");
				priAux = aux.next.priority;
				
				while(aux.next != null && aux.next.priority == priAux)
				{
					if(i != 0)
					{
						rx.append(", ");
					}
					rx.append(aux.next.content);
					aux.next = aux.next.next;
					i++;
				}	
				rx.append("))");
			}
			
			rx.append("]");
			return rx.toString();
		} 
		else
		{
			return "[]";
		}
	}
}
