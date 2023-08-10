package synchro;

import java.util.Iterator;
import java.util.List;

public class Customer extends BusinessObject {
	private Account account;
	private String name;
	private Address address;
	private List<WorkOrder> workOrders;

	public Customer(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Iterator<WorkOrder> getWorkOrders() {
		return workOrders.iterator();
	}
	
	
	
}
