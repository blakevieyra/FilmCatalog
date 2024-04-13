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

@Entity
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "return_date")
	private LocalDateTime returnDate;

	@Column(name = "rental_date")
	private LocalDateTime rentalDate;

	// Rental is many, one customer can have many rental
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	// Rental is many, one customer can have many rental
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;

	//use primary key of the column to join
	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private InventoryItem inventoryItem;

	@OneToMany(mappedBy = "rental")
	private List<Payment> payments;

	public Rental() {
	}

	public void addPayment(Payment payment) {
		// no payments yet, lets start now
		if (payments == null) {
			payments = new ArrayList<>();
		}

		// the payment had been fat-fingered, and associated w a diff rental
		if (!payments.contains(payment)) {
			// make customer happy, and "assign" the payment to THIS rental
			payments.add(payment);

			if (payment.getRental() != null) {
				// find the wrong rental, and remove this ct's payment from it
				payment.getRental().removePayment(payment);
			}
			// make the ct happy, and correctly assign their payment to THIS rental
			payment.setRental(this);
		}
	}

	public void removePayment(Payment payment) {
		if (payments != null && payments.contains(payment)) {
			payments.remove(payment);
			payment.setRental(null);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", returnDate=" + returnDate + ", rentalDate=" + rentalDate + ", customer="
				+ customer + ", staff=" + staff + ", payments=" + payments + "]";
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDateTime getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDateTime rentalDate) {
		this.rentalDate = rentalDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, id, inventoryItem, payments, rentalDate, returnDate, staff);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rental other = (Rental) obj;
		return Objects.equals(customer, other.customer) && id == other.id
				&& Objects.equals(inventoryItem, other.inventoryItem) && Objects.equals(payments, other.payments)
				&& Objects.equals(rentalDate, other.rentalDate) && Objects.equals(returnDate, other.returnDate)
				&& Objects.equals(staff, other.staff);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

}
