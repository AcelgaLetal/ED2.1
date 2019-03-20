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
	   // TODO Auto-generated method stub
		T elementoAux = null;
		
		if(isEmpty())
		{
			first = new QueueNode<T>(p, element);
			count++;
			return null;
		}
		else
		{
			if(isFull())
			{
				
				QueueNode<T> aux2 = first.next;
				
				if(first.next == null)
				{				
					elementoAux = first.content;
					first = null;
				}
				else if (aux2.next == null)
				{
					elementoAux = first.next.content;
					first.next = null;
				}
				else
				{
					QueueNode<T> aux = first;
					aux2 = first.next;
					
					while(aux2.next != null)
					{
						aux = aux.next;
						aux2 = aux2.next;
					}
					elementoAux = aux.next.content;
					aux.next = null;
					count--;
				}
								
			}

			QueueNode<T> nuevo = new QueueNode<T>(p, element);
			
			if(nuevo.priority < first.priority)
			{
				nuevo.next = first;
				first = nuevo;
				count++;
				return elementoAux;
			}
			else
			{	
				if(first.next == null)
				{
					first.next = nuevo;
					count++;
					return elementoAux;
				}
				else if(first.next.priority > nuevo.priority)
				{
					int auxPrior = nuevo.priority;
					nuevo = first;
					nuevo.priority = auxPrior;
					first.next = nuevo;
					count++;
					return elementoAux;
				}
				else
				{
					QueueNode<T> aux;
					int auxPrior = nuevo.priority;
					nuevo = first.next;
					nuevo.priority = auxPrior;
					aux = first;
					
					while(nuevo.next != null)
					{
						if(nuevo.priority < nuevo.next.priority)
						{
							aux.next = nuevo;
							count++;
							return elementoAux;
						}
						nuevo = nuevo.next;
						nuevo.priority = auxPrior;
						aux = aux.next;
						
					}
					
					aux.next = nuevo;
					count++;
					return elementoAux;
				}
			}
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
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
		      // TODO : MOSTRAR LOS ELEMENTOS DE LA COLA DE PRIORIDAD CON EL MISMO FORMATO QUE LA OTRA IMPLEMENTACIÓN
		
			rx.append("]");
			return rx.toString();
		} else {
			return "[]";
		}
	}


  
}
