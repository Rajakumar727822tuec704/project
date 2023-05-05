package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Subcust;
import com.example.demo.Repository.SubcustRepo;

@Service
public class SubCustser {
	@Autowired
	public SubcustRepo rrepo;
	public Subcust saveDe(Subcust cc)
	{
		return rrepo.save(cc);
	}
	public List<Subcust> getinfoDe()
	{
		return rrepo.findAll();
	}
	
	public String checkLogin(String username,String password)
	{
		Subcust user= rrepo.findByusername(username);
		if(user==null)
		{
			return "No Registered user found";
		}
		else
		{
			if(user.getPassword().equals(password))
			{
				return "Registration Succesfull";
			}
			else
			{
				return "Registration Failed";
			}
		}
	}

}
