package ule.edi.limitedpriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class LimitedPriorityQueueArrayImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;
	    private int npriorities;
	    private int count;

	    private ArrayList<LinkedQueue<T>> colas;
	
	

	public LimitedPriorityQueueArrayImpl(int capacity, int npriorities){
		
      //TODO  asignar los valores de los atributos
	  // Crear el arrayList, y añadir una cola por cada una de las prioridades (1..npriorities)
	  // Si capacidad <=0 disparar la excepción: IllegalArgumentException
	
		
		if (capacity > 0)
		{
			this.capacity = capacity;
			this.npriorities = npriorities;
			
			colas = new ArrayList<>(npriorities);
			
			for (int i = 0; i < npriorities; i++)
			{
				colas.add(new LinkedQueue<T>());
			}
		}
		else
		{
			throw new IllegalArgumentException("Capacity cannot be zero");
		}
		
	}
	
	
    @Override
    public int getCapacity() {
		return capacity;
    	
    }

    @Override
    public int getSize() {
    	return count;
    }

    @Override
    public boolean isFull() {
    	// TODO Auto-generated method stub
    	if (count == capacity)
    	{
    		return true;
    	}
    	return false;
    }

	@Override
	public T enqueue(int p, T element) {
		// TODO Auto-generated method stub
		int selection = 0;
		T elemAux = null;
		
		if(p <= 0)
		{
			throw new IllegalArgumentException("La prioridad no puede ser menor o igual que cero");
		}
		if (p > npriorities)
		{
			throw new IllegalArgumentException("La prioridad introducida est� por encima de las existentes");
		}
		
		colas.get(p - 1).enqueue(element);
				
		if(isFull())
		{
			for(int i = npriorities - 1; i >= 0; i--)
			{
				if(colas.get(i).isEmpty() == false)
				{
					selection = i;
					break;
				}
			}
			elemAux = colas.get(selection).dequeueLast();
			count--;
		}
		count++;
		
		return elemAux;
				 
	}
	


	@Override
	public T first() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		T elemAux = null;
		int election = 0;
		
		if(isEmpty() == false)
		{
			for(int i = 0; i < npriorities; i++)
			{
				if(colas.get(i).isEmpty() == false)
				{
					election = i;
					break;
				}
			}
			elemAux = colas.get(election).first();
			
			return elemAux;
		}
		else
		{
			throw new EmptyCollectionException("Cola vacia");
		}
		
	}



	@Override
	public T dequeue() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		int election = 0;
		T element = null;
		if(isEmpty())
		{
			throw new EmptyCollectionException("Cola vacia");
		}
		else
		{
			for(int i =  0; i < npriorities; i++)
			{
				if(colas.get(i).isEmpty() == false)
				{
					election = i;
					break;
				}
			}
			
			element = colas.get(election).dequeue();
			
			return element;
		}
	}

	@Override
	public boolean isEmpty() {
		if (count == 0)
		{
			return true;
		}
		return false;
	}

	
	@Override
	public String toString()
	{
	    boolean separator=false;

	    if (!this.isEmpty())
	    {
			StringBuffer rx = new StringBuffer();
			rx.append("[");

			for (int n = 0; n < this.npriorities; ++n)
			{
				if (!colas.get(n).isEmpty())
				{
					rx.append("( Priority:"+(n+1)+" ("); 
					rx.append(colas.get(n).toString());
					rx.append(")), ");

					separator=true;
				}       
			}

			if (separator) 
			{
				rx.delete(rx.length() - 2,rx.length());
				rx.append("]");

				return rx.toString();
			}
			else
			{
				return "[]";
			}
		}
	    return "[]";
	}
};
  

