package com.skilldistillery.videostorerest.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.jpavideostore.entities.Address;

@SpringBootTest
class AddressRepositoryTest {

	@Autowired
	private AddressRepository addressRepo;

	@Test
	void test_Address_By_Id_and_Street_Name() {
		Optional<Address> addressOpt = addressRepo.findById(1);
		Address address = null;
		if (addressOpt.isPresent()) {
			address = addressOpt.get();
		}
		assertEquals("47 MySakila Drive", address.getStreet());
	}

}
