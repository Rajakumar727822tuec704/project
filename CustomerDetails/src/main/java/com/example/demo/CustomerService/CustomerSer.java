package com.example.demo.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Customer.CustomerDetails;
import com.example.demo.CustomerRepository.CustomerREpo;
@Service
public class CustomerSer {
	@Autowired
	CustomerREpo repobj;
	
	public String addCustomer(CustomerDetails pojobj)
	{
		repobj.save(pojobj);
	return"Added";
	}
	
	public List<CustomerDetails>getCustomer()
	{
		return repobj.findAll();
	}
	
	public Optional<CustomerDetails>getCustomerById(int id)
	{
		return repobj.findById(id);
	}

}
