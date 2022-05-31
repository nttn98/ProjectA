package entity;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private String customerID;
	private String customerName;
	private String customerUserName;
	private String customerPass;
	private String customerAddress;
	private long customerPhone;

	public Customer(String customerID, String customerName, String customerAddress, String customerUserName, String customerPass,
			long customerPhone) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerUserName = customerUserName;
		this.customerPass = customerPass;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getCustomerPass() {
		return customerPass;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerInfor() {
		String str = this.customerID;
		str += " " + this.customerName;
		str += " " + this.customerUserName;
		str += " " + this.customerPass;
		str += " " + this.customerAddress;
		str += " " + this.customerPhone;
		return str;
	}
}
