package ule.edi.limitedpriorityqueue;

import org.junit.*;




public class LimitedPriorityQueueLinkedTests {

	
	private LimitedPriorityQueueLinkedImpl<String> pq3;
	private LimitedPriorityQueueLinkedImpl<String> pq5;
	private LimitedPriorityQueueLinkedImpl<String> pq6;
	private LimitedPriorityQueueLinkedImpl<String> pq7;
	
	
	public LimitedPriorityQueueLinkedTests() {
		

	}
	
	@Before
	public void testBefore() throws Exception{
	    pq3 = new LimitedPriorityQueueLinkedImpl<String>(3); // limitado a 3 elementos
	    pq5 = new LimitedPriorityQueueLinkedImpl<String>(5); // limitado a 5 elementos
	    pq6 = new LimitedPriorityQueueLinkedImpl<String>(1); // limitado a 5 elementos
	    pq7 = new LimitedPriorityQueueLinkedImpl<String>(2); // limitado a 5 elementos
	    Assert.assertEquals(3, pq3.getCapacity());
	    Assert.assertEquals(0, pq3.getSize());
	}
	
	@Test
	public void testSomething() throws Exception {
		//pq3 = new LimitedPriorityQueueLinkedImpl<String>(3); // limitado a 3 elementos
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
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_3"), "Prior2_3");
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testGetCapacity() throws Exception
	{
		Assert.assertEquals(3, pq3.getCapacity());
	}
	
	@Test
	public void testFirst() throws Exception
	{
		String elem = "1";
		pq3.enqueue(1, elem);
		Assert.assertEquals(elem, pq3.first());
	}
	
	@Test
	public void testEnqueue() throws Exception
	{
		String elem = "1";
		String elem2 = "2";
		String elem3 = "1";
		String elem4 = "2";
		String elem5 = "1";
		String elem6 = "2";
		
		pq5.enqueue(3, elem);
		pq5.enqueue(2, elem2);
		pq5.enqueue(4, elem3);
		pq5.enqueue(5, elem4);
		pq5.enqueue(1, elem5);
		pq5.enqueue(4, elem6);
		
		pq3.enqueue(2, elem);
		pq3.enqueue(4, elem2);
		pq3.enqueue(3, elem3);
		
		Assert.assertEquals(elem, pq5.dequeue());
		
		pq7.enqueue(3, elem);
		pq7.enqueue(2, elem2);
		pq7.enqueue(3, elem3);
		
		pq6.dequeue();
				
	}
	@Test
	public void testDequeue() throws Exception
	{
		String elem = "1";
		String elem2 = "2";
		String elem3 = "d";
		pq6.enqueue(3, elem);
		pq6.enqueue(2, elem2);
		
		
		//
		
	}
}
