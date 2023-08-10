package synchro;

public class WorkOrder extends BusinessObject{

	private Customer customer;
	private String workType; //TODO: Perhaps this should be an enum. If we have a small set of possible work types
	private String description;
	private Double total;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double inTotal) {
		if (this.total != null) {
			throw new IllegalArgumentException("For work order " + getId() + " the total has already been set to " + total);
		} else {
			this.total = inTotal;
		}
	}
	
}
