package manager;

import java.util.ArrayList;

import dao.CustomerDAO;
import entity.Customer;
import entity.Product;

public class CustomerManager {
	private ArrayList<Customer> listCustomers;
	private CustomerDAO myCustomerDAO;

	public CustomerManager() {
		this.listCustomers = new ArrayList<>();
		myCustomerDAO = new CustomerDAO();
	}

	public CustomerManager(ArrayList<Customer> listCustomers) {
		this.listCustomers = listCustomers;
		myCustomerDAO = new CustomerDAO();
	}

	public Customer getCustomerByID(String id) {
		Customer resCustomer = null;
		for (int i = 0; i < this.listCustomers.size(); i++) {
			Customer currentCustomer = listCustomers.get(i);
			if (currentCustomer.getCustomerID().equalsIgnoreCase(id)) {
				return currentCustomer;
			}
		}
		return resCustomer;
	}

	public boolean addCustomer(Customer customer) {
		boolean result = false;
		if (this.getCustomerByID(customer.getCustomerID()) == null) {
			this.listCustomers.add(customer);
			result = true;
		}
		return result;
	}

	public boolean deleteCustomerByID(String id) {
		boolean result = false;

		Customer foundCustomer = this.getCustomerByID(id);
		if (foundCustomer != null) {
			this.listCustomers.remove(foundCustomer);
			result = true;
		}
		return result;
	}

	public ArrayList getListCustomers() {
		return this.listCustomers;
	}

	public ArrayList getCustomerByName(String name) {
		ArrayList resultCustomerList = new ArrayList<>();

		Customer tempCustomer;
		for (int i = 0; i < listCustomers.size(); i++) {
			tempCustomer = listCustomers.get(i);
			if (tempCustomer.getCustomerName().contains(name.toLowerCase())) {
				resultCustomerList.add(tempCustomer);
			}
		}
		return resultCustomerList;
	}

	public ArrayList getCustomerByPhone(long phone) {
		ArrayList resultCustomerList = new ArrayList<>();

		Customer tempCustomer;
		for (int i = 0; i < listCustomers.size(); i++) {
			tempCustomer = listCustomers.get(i);
			if (tempCustomer.getCustomerPhone() == phone) {
				resultCustomerList.add(tempCustomer);
			}
		}
		return resultCustomerList;
	}

	public ArrayList getCustomerByAddress(String address) {
		ArrayList resultCustomerList = new ArrayList<>();

		Customer tempCustomer;
		for (int i = 0; i < listCustomers.size(); i++) {
			tempCustomer = listCustomers.get(i);
			if (tempCustomer.getCustomerAddress().contains(address.toLowerCase())) {
				resultCustomerList.add(tempCustomer);
			}
		}
		return resultCustomerList;
	}

	public ArrayList getCustomerByUserName(String userName) {
		ArrayList resultCustomerList = new ArrayList<>();

		Customer tempCustomer;
		for (int i = 0; i < listCustomers.size(); i++) {
			tempCustomer = listCustomers.get(i);
			if (tempCustomer.getCustomerAddress().contains(userName.toLowerCase())) {
				resultCustomerList.add(tempCustomer);
			}
		}
		return resultCustomerList;
	}

	public int saveByteData() {
		this.myCustomerDAO.saveListCustomerAsByte(listCustomers);
		return this.listCustomers.size();
	}

	public int saveCharData() {
		this.myCustomerDAO.saveListCustomerAsChar(listCustomers);
		return this.listCustomers.size();
	}

	public int getByteData() {
		this.listCustomers = this.myCustomerDAO.readListCustomerAsByte();
		if (this.listCustomers == null) {
			this.listCustomers = new ArrayList<Customer>();
		}
		return this.listCustomers.size();
	}

}
