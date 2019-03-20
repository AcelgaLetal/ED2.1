package ule.edi.limitedpriorityqueue;

import org.junit.*;




public class LimitedPriorityQueueArrayTests {

	
	private LimitedPriorityQueueArrayImpl<String> pq3;
	private LimitedPriorityQueueArrayImpl<String> pq5;
	
	
	public LimitedPriorityQueueArrayTests() {
				
	}
	@Test
	public void testIsFull() throws Exception
	{
		LimitedPriorityQueueArrayImpl<String> pq6 = new LimitedPriorityQueueArrayImpl<String>(1, 2);
		Assert.assertEquals(1, pq6.getCapacity());
		String num = "3";
		pq6.enqueue(1, num);
		Assert.assertEquals(true, pq6.isFull());

	}
	
	@Before
	public void testBefore() throws Exception{
	    pq3 = new LimitedPriorityQueueArrayImpl<String>(3,2); // limitado a 3 elementos, las posibles prioridades son [1,2]	    
	    pq5 = new LimitedPriorityQueueArrayImpl<String>(5,3); // limitado a 5 elementos, las posibles prioridades son [1,2,3]

	}
	
	@Test
	public void testEnVacia() throws Exception {
		
	    Assert.assertEquals(pq3.isEmpty(), true);
	    Assert.assertEquals(pq3.isFull(), false);
	    Assert.assertEquals(pq3.getSize(), 0);
	    Assert.assertEquals(pq3.toString(), "[]");
	}
	
	@Test
	public void testInsertarHastaLLenar() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 1);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 2);	
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 3);	
	    Assert.assertEquals(pq3.isFull(), true);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testInsertarMenorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_3"), "Prior2_3");    // El elemento insertado tiene menor prioridad que los que estaban, por tanto es el que sale
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testInsertarMayorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_2"), "Prior2_2");
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1, Prior1_2)), ( Priority:2 (Prior2_1))]");
	  
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPriorityZero() throws Exception
	{
		pq3 = new LimitedPriorityQueueArrayImpl<String>(0, 3);
	}
	
	@Test 
	public void testEnqueueZero() throws Exception
	{
		pq3 = new LimitedPriorityQueueArrayImpl<String>(2, 3);
		pq5 = new LimitedPriorityQueueArrayImpl<String>(2, 3);
		
		String num = "3";
		
		pq3.enqueue(0, num);
	}
	
	@Test 
	public void testEnqueueSuperior() throws Exception
	{
		pq3 = new LimitedPriorityQueueArrayImpl<String>(2, 3);
		
		String num = "3";
		
		pq3.enqueue(10, num);
	}
	
	@Test 
	public void testEnqueueNull() throws Exception
	{
		pq3 = new LimitedPriorityQueueArrayImpl<String>(2, 3);
		
		String num = null;
		
		pq3.enqueue(1, num);
	}
	
	@Test 
	public void testEnqueueFull() throws Exception
	{
		pq3 = new LimitedPriorityQueueArrayImpl<String>(2, 3);
		
		String num1 = "1";
		String num2 = "2";
		String num3 = "3";
		pq3.enqueue(1, num1);
		pq3.enqueue(2, num2);
		pq3.enqueue(1, num3);
	}
	
	@Test 
	public void testEnqueueFirst() throws Exception
	{
		pq3 = new LimitedPriorityQueueArrayImpl<String>(6, 3);
		pq5 = new LimitedPriorityQueueArrayImpl<String>(3, 3);
				
		String num1 = "1";
		String num2 = "2";
		String num3 = "3";
		String num4 = "4";
		String num5 = "5";
		String num6 = "6";
		
		pq3.enqueue(1, num1);
		pq3.enqueue(2, num2);
		
		Assert.assertEquals(num1, pq3.first());
		
		pq3.enqueue(2, num4);
		pq3.enqueue(2, num5);
		pq5.first();
		
		Assert.assertEquals(pq3.enqueue(1, num3), num5.toString()); 	
	}
	
	@Test 
	public void testDequeue() throws Exception
	{
		pq3 = new LimitedPriorityQueueArrayImpl<String>(3, 3);
		pq5 = new LimitedPriorityQueueArrayImpl<String>(3, 3);
				
		String num1 = "1";
		String num2 = "2";
		String num3 = "3";
		
		pq3.enqueue(1, num1);
		pq3.enqueue(2, num2);
		pq3.enqueue(1, num3);
		
		Assert.assertEquals(num1, pq3.dequeue());
		
		pq5.dequeue();
		
	}
	
}
