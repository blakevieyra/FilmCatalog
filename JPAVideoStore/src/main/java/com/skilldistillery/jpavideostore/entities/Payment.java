package com.skilldistillery.jpavideostore.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {


	public Payment() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double amount;

	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
	@ManyToOne
	@JoinColumn(name = "rental_id")
	private Rental rental;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
//	
//	public void addRental(Rental rentals) {
//	// no payments yet, lets start now
//		if (payments==null) { payments = new ArrayList<>(); }
//	
//		// the payment had been fat-fingered, and associated w a diff rental
//		if ( ! payments.contains(payment)   ) {
//		// make customer happy, and "assign" the payment to THIS rental
//			payments.add(payment);
//			
//			if (payment.getRental() != null) {
//			// find the wrong rental, and remove this ct's payment from it
//				payment.getRental().removePayment(payment);
//			}
//			// make the ct happy, and correctly assign their payment to THIS rental
//			payment.setRental(this);
//		}
//	}
//	public void removeRental(Rental rental) {
//		if (rentals != null && rentals.contains(rental)) {
//			rentals.remove(rental);
//			rental.setPayment(null);
//		}
//	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, paymentDate, rental);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && id == other.id
				&& Objects.equals(paymentDate, other.paymentDate) && Objects.equals(rental, other.rental);
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", paymentDate=" + paymentDate + ", rental=" + rental.getCustomer().getFirst_name() + "]";
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
}