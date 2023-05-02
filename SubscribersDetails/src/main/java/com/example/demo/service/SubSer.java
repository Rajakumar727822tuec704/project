package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modD.Omodel;
import com.example.demo.model.LogIn;
import com.example.demo.RepoD.ORepo;
import com.example.demo.repository.LogRepo;


@Service
public class SubSer {
	
	@Autowired
	ORepo repository;
	
	@Autowired
	LogRepo repositoryL;
	
	public String addCustomer(Omodel customer)
	{
		repository.save(customer);
		return "Added successfully";
	}
	public List<Omodel> getCustomer()
	{
		return repository.findAll();
		
	}
	public Optional<Omodel> getCustomerById(int id)
	{
		return repository.findById(id);
	}
	public String updateCustomer(Omodel customer)
	{
		repository.save(customer);
		return "Updated successfully";
	}
	public String deleteById(int id)
	{
		repository.deleteById(id);
		return "Deleted successfully";
	}
	
	public List<Omodel> getProDetails(@RequestParam String field)
	{
		return repository.findAll(Sort.by(Direction.ASC,field));
	}

	public List<Omodel> getProwithPag(int offset, int pagesize)
	{
		Page<Omodel> page=repository.findAll(PageRequest.of(offset, pagesize));
		return page.getContent();
	}
	
	public String checkLogin(String uname,String pwd)
	{
		LogIn user=repositoryL.findByuname(uname);
		if(user==null)
		{
			return "Invalid Details";
		}
		else
		{
			if(user.getPwd().equals(pwd))
			{
				return "Login successful";
			}
			else
			{
				return "Login failed";
			}
		}
	}
	
	public LogIn addUser(LogIn mod)
	{
		return repositoryL.save(mod);
	}
	
	
	public List<LogIn> getUser()
	{
		return repositoryL.findAll();
	}

}