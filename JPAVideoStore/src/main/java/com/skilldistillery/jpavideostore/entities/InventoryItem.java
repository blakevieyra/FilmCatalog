package com.skilldistillery.jpavideostore.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="inventory_item")
public class InventoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "media_condition")
	private MediaCondition mediaCondition;
	
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="film_id")
	private Film film;

	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;
	
	@OneToMany(mappedBy="inventoryItem")
	@JsonIgnore
	private List<Rental> rentals;
	
	public void addRental(Rental rental) {
		// no payments yet, lets start now
			if (rentals==null) {rentals = new ArrayList<>(); }
		
			// the payment had been fat-fingered, and associated w a diff rental
			if ( ! rentals.contains(rental)   ) {
			// make customer happy, and "assign" the payment to THIS rental
				rentals.add(rental);
				
				if (rental.getInventoryItem() != null) {
				// find the wrong rental, and remove this ct's payment from it
					rental.getInventoryItem().removeRental(rental);
				}
				// make the ct happy, and correctly assign their payment to THIS rental
				rental.setInventoryItem(null);
			}
		}
	public void removeRental(Rental rental) {
		if (rentals != null && rentals.contains(rental)) {
			rentals.remove(rental);
			rental.setInventoryItem(null);
		}
	}
	
	public InventoryItem() {
		super();
	}


	public InventoryItem(int id, MediaCondition mediaCondition, LocalDateTime lastUpdate) {
		super();
		this.id = id;
		this.mediaCondition = mediaCondition;
		this.lastUpdate = lastUpdate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public MediaCondition getMediaCondition() {
		return mediaCondition;
	}


	public void setMediaCondition(MediaCondition mediaCondition) {
		this.mediaCondition = mediaCondition;
	}


	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	

	public Film getFilm() {
		return film;
	}


	public void setFilm(Film film) {
		this.film = film;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}

//
//	public List<Rental> getRentals() {
//		return rentals;
//	}
//
//
//	public void setRentals(List<Rental> rentals) {
//		this.rentals = rentals;
//	}


	@Override
	public int hashCode() {
		return Objects.hash(film, id, lastUpdate, mediaCondition, rentals, store);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryItem other = (InventoryItem) obj;
		return Objects.equals(film, other.film) && id == other.id && Objects.equals(lastUpdate, other.lastUpdate)
				&& mediaCondition == other.mediaCondition && Objects.equals(rentals, other.rentals)
				&& Objects.equals(store, other.store);
	}


	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", mediaCondition=" + mediaCondition + ", lastUpdate=" + lastUpdate + "]";
	}
	public List<Rental> getRentals() {
		return rentals;
	}
	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}
	
	
	
}