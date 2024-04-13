package com.skilldistillery.videostorerest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpavideostore.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
