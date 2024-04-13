package com.skilldistillery.jpavideostore.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Store {

	public Store() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "manager_id")
	private Staff manager;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	public int getId() {
		return id;
	}

	@OneToMany(mappedBy = "store")
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "store")
	private List<InventoryItem> inventoryItem;

	public void addCustomer(Customer customer) {
		if (customers == null) {
			customers = new ArrayList<>();
		}
		if (!customers.contains(customer)) {
			customers.add(customer);

			if (customer.getStore() != null) {
				customer.getStore().removeCustomer(customer);
			}
			customer.setStore(this);
		}
	}

	public void removeCustomer(Customer customer) {
		if (customers != null && customers.contains(customer)) {
			customers.remove(customer);
			customer.setStore(null);
		}
	}

	@OneToMany(mappedBy = "store")
	private List<Staff> staffMembers;

	public void addStaff(Staff staff) {
		if (staffMembers == null) {
			staffMembers = new ArrayList<>();
		}
		if (!staffMembers.contains(staff)) {
			staffMembers.add(staff);

			if (staff.getStore() != null) {
				staff.getStore().removeStaff(staff);
			}
			staff.setStore(this);
		}
	}

	public void removeStaff(Staff staff) {
		if (staffMembers != null && staffMembers.contains(staff)) {
			staffMembers.remove(staff);
			staff.setStore(null);
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	public Staff getStaff() {
		return manager;
	}

	public void setStaff(Staff manager) {
		this.manager = manager;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, customers, id, inventoryItem, manager, staffMembers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return Objects.equals(address, other.address) && Objects.equals(customers, other.customers) && id == other.id
				&& Objects.equals(inventoryItem, other.inventoryItem) && Objects.equals(manager, other.manager)
				&& Objects.equals(staffMembers, other.staffMembers);
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", staff=" + manager + ", address=" + address + ", customers=" + customers.size()
				+ ", staffMembers=" + staffMembers.size() + "]";
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Staff> getStaffMembers() {
		return staffMembers;
	}

	public void setStaffMembers(List<Staff> staffMembers) {
		this.staffMembers = staffMembers;
	}

	public List<InventoryItem> getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(List<InventoryItem> inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

}