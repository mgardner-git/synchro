	package synchro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Account extends BusinessObject {

	public static final int MAX_NAME_LENGTH = 60; //TODO: The instructions did not state the maximum length so we'll just use this for now
	public static final int MIN_NAME_LENGTH = 32; //TODO: Perhaps this should be in a properties file or something
	public static final String[] ACCEPTABLE_STATES = {"TX", "CA", "NY","NC"}; 
	
	private String name;
	private String businessName;
	private Address address;  //TODO: requirements state we can "add address" can an account have more then 1 address?
	private List<Customer> customers;
	
	
	public Account() {
		customers = new ArrayList<Customer>();
	}

	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address inAddress) {
		if (this.address != null) {
			throw new IllegalArgumentException("Address for account " + getId() + " has already been set");
		}
		boolean containsValidState = false;
		//TODO: This still allows the possibility of getting the address object and changing it somehow, need to think about that.
		for (String checkState : ACCEPTABLE_STATES) {
			if (checkState.toLowerCase().equals(inAddress.getState().toLowerCase())) {
				containsValidState = true;
			}
		}
		if (!containsValidState) {
			throw new IllegalArgumentException("State " + inAddress.getState() + " is not an acceptable state for Accounts");
		}else {
			this.address = inAddress;
		}
	}

	
	public String getName() {
		return name;
	}
	public void setName(String inName) {
		if (inName.length() < MIN_NAME_LENGTH || inName.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Account name " + inName + " is outside the length parameters of  " + MIN_NAME_LENGTH + " - " + MAX_NAME_LENGTH);
		} else {
			this.name = inName;
		}
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	
	
	public Iterator<Customer> getCustomers() {
		return customers.iterator();
	}
	
	public void addCustomer(Customer incoming) {
		customers.add(incoming);
	}
	
}
