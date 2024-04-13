package com.skilldistillery.jpavideostore.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

	public Customer() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	private String email;

	@OneToMany(mappedBy = "customer")
	private List<Rental> rentals;

	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;

	public void addRental(Rental rental) {
		if (rentals == null) {
			rentals = new ArrayList<>();
		}
		if (!rentals.contains(rental)) {
			rentals.add(rental);

			if (rental.getCustomer() != null) {
				rental.getCustomer().removeRental(rental);
			}
			rental.setCustomer(this);
		}
	}

	public void removeRental(Rental rental) {
		if (rentals != null && rentals.contains(rental)) {
			rentals.remove(rental);
			rental.setCustomer(null);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// adding uni-directionaly relationship between customer and address. Every
	// customer has only one address
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + ", first_name="
				+ first_name + ", last_name=" + last_name + ", email=" + email + ", rentals=" + rentals.size() + ", store="
				+ store + ", address=" + address + "]";
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, createDate, email, first_name, id, lastUpdate, last_name, rentals, store);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(createDate, other.createDate)
				&& Objects.equals(email, other.email) && Objects.equals(first_name, other.first_name) && id == other.id
				&& Objects.equals(lastUpdate, other.lastUpdate) && Objects.equals(last_name, other.last_name)
				&& Objects.equals(rentals, other.rentals) && Objects.equals(store, other.store);
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
