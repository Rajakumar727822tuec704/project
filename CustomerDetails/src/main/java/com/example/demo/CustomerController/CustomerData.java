package com.example.demo.CustomerController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Customer.CustomerDetails;
import com.example.demo.CustomerService.CustomerSer;

@RestController
@RequestMapping("/abc")
public class CustomerData {
	@Autowired
	CustomerSer serobj;
	
	@PostMapping("")
	public String create(@RequestBody CustomerDetails pojobj )
	{
		return serobj.addCustomer(pojobj);
	}
	
	@GetMapping("")
	public List<CustomerDetails>read()
	{
		return serobj.getCustomer();
	}
	
	@GetMapping("/{id}")
	public Optional<CustomerDetails>readById(@PathVariable int id)
	{
		return serobj.getCustomerById(id);
	}
	
}