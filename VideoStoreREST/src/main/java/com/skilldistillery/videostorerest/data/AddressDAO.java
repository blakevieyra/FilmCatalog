package com.skilldistillery.videostorerest.data;

import java.util.List;

import com.skilldistillery.jpavideostore.entities.Address;

public interface AddressDAO {

	List<Address> findAll();

	Address findById(int id);
	
	Address create(Address address);
}
