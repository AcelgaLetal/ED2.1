package ule.edi.limitedpriorityqueue;

import org.junit.*;




public class LimitedPriorityQueueLinkedTests {

	
	private LimitedPriorityQueueLinkedImpl<String> pq3;
	private LimitedPriorityQueueLinkedImpl<String> pq5;
	
	
	public LimitedPriorityQueueLinkedTests() {
		

	}
	
	@Before
	public void testBefore() throws Exception{
	    pq3 = new LimitedPriorityQueueLinkedImpl<String>(3); // limitado a 3 elementos
	    pq5 = new LimitedPriorityQueueLinkedImpl<String>(5); // limitado a 5 elementos
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
	
	@Test (expected = IllegalArgumentException.class)
	public void testEnqueue() throws Exception
	{
		
		String elem = "1";
		String elem2 = "2";
		String elem3 = "3";
		String elem4 = "4";
		String elem5 = "5";
		String elem6 = "6";
		String elem7 = "7";
		
		Assert.assertEquals(null, pq5.enqueue(1, elem));
		Assert.assertEquals(null, pq5.enqueue(3, elem2));
		Assert.assertEquals(null, pq5.enqueue(2, elem3));
		Assert.assertEquals(null, pq5.enqueue(6, elem4));
		Assert.assertEquals(null, pq5.enqueue(5, elem5));
		Assert.assertEquals(elem6, pq5.enqueue(7, elem6));
		
		pq3.enqueue(0, elem);
	}
	@Test (expected = EmptyCollectionException.class)
	public void testDequeue() throws Exception
	{
		String elem = "1";
		String elem2 = "2";
		String elem3 = "d";
		pq3.enqueue(3, elem);
		pq3.enqueue(2, elem2);
		
		Assert.assertEquals(elem2, pq3.dequeue());
		
		pq3.enqueue(2, elem);
		pq3.enqueue(3, elem);
		pq3.enqueue(4, elem);
		
		pq5.dequeue();
		
		
		//
		
	}
}
