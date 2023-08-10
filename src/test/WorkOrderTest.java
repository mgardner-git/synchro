package test;

import static org.junit.Assert.*;

import org.junit.Test;

import synchro.WorkOrder;

public class WorkOrderTest {

	@Test
	public void testSetTotal() {
		WorkOrder order = new WorkOrder();
		order.setTotal(2.0);
		assertEquals(2.0, order.getTotal().doubleValue(),.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetTotalTwice() {
		WorkOrder order = new WorkOrder();
		order.setTotal(2.0);
		order.setTotal(3.0);
	}

}
