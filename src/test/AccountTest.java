package test;

import org.junit.Test;

import junit.framework.*;
import synchro.Account;
import synchro.Address;

public class AccountTest extends TestCase {

	@Test(expected = IllegalArgumentException.class)
	public void testRepeatAccountAddress() {
		
		Account account = new Account();
		Address add1 = new Address();
		add1.setState("TX");
		account.setAddress(add1);
		Address  add2 = new Address();
		account.setAddress(add2);
	}
	
	@Test
	public void testValidState() {
		Account account = new Account();
		Address address = new Address();
		address.setState("TX");
		account.setAddress(address);
		assertEquals("TX", account.getAddress().getState()); //shouldn't throw an exception
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidState1() {
		Account account = new Account();
		Address address = new Address();
		address.setState("AZ");
		account.setAddress(address);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidState2() {
		Account account = new Account();
		Address address = new Address();
		address.setState("Cookie Monster");
		account.setAddress(address);		
	}
	
	@Test
	public void testValidNameLength() {
		Account account = new Account();
		String minAcceptable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456";
		account.setName(minAcceptable);
		//shouldn't throw an exception
		assertEquals(minAcceptable, account.getName());
		
		String maxAcceptable = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ12345678";
		Account account2 = new Account();
		account2.setName(maxAcceptable);
		//shouldn't throw an exception
		assertEquals(maxAcceptable, account.getName());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNameTooShort() {
		String belowAcceptable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345";
		Account account = new Account();
		account.setName(belowAcceptable);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNameTooLong() {
		String overAcceptable = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		Account account = new Account();
		account.setName(overAcceptable);
	}
	
	

}
