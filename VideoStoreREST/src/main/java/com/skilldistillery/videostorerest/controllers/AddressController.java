package com.skilldistillery.videostorerest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jpavideostore.entities.Address;
import com.skilldistillery.videostorerest.data.AddressDAO;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class AddressController {


	@Autowired
	private AddressDAO addressDAO;

	@GetMapping(path = "addresses")
	public List<Address> index() {
		return addressDAO.findAll();
	}

	@GetMapping(path = "addresses/{id}")
	public Address show(@PathVariable("id") Integer id, HttpServletResponse req) {
		Address address = addressDAO.findById(id);
		if (address == null) {
			req.setStatus(404);
		}
		return address;
	}

	@PostMapping(path = "addresses")
	public Address createAddress(@RequestBody Address address, HttpServletResponse req) {
		address = addressDAO.create(address);
		try {
			if (address != null) {
				req.setStatus(201);
			}
		} catch (Exception e) {
			req.setStatus(400);
			address = null;
			e.printStackTrace();
		}
		return address;
	}
}