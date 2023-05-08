package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Controller.UController;
import com.example.demo.Model.AdminModel;
import com.example.demo.Model.LoanApplicationModel;
import com.example.demo.Model.LoginModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.AdminRepo;
import com.example.demo.Repository.LoanApplicationRepo;
import com.example.demo.Repository.LoginRepo;
import com.example.demo.Repository.UserRepo;

@Service
public class UserService {

	@Autowired UserRepo ur;
	@Autowired LoginRepo lr;
	@Autowired LoanApplicationRepo lar;
	@Autowired AdminRepo ar;
	
	public static String email;
	public static String applicantEmail;
	
	public Optional<UserModel> getUserProf() {
		return ur.findbyemail(email);
	}

	public Optional<LoanApplicationModel> viewLoan() {
		return lar.findbymail(applicantEmail);
	}

	public String validateUser(String email, String pass) {
		UserService.email = email;
		applicantEmail = email;
		UController.flag2 = true;
		LoginModel userData = lr.findByemail(email);
		if(userData == null)
		{
			return "User Not Found!";
		}
		else
		{
			if(userData.getPassword().equals(pass))
			{
				return "Login Successful";
			}
			else
			{
				return "Wrong Password";
			}
		}
	}

	public String newUser(LoginModel lm) {
		lr.save(lm);
		return "Account Created Successfully";
	}

	public List<LoanApplicationModel> getAllLoans() {
		return lar.findAll();
	}

	public String validateAdmin(String email, String pass) {
		
		UController.flag1 = true;
		AdminModel adminData = ar.findByemail(email);
		if(adminData == null)
		{
			return "Admin Not Found!";
		}
		else
		{
			if(adminData.getPassword().equals(pass))
			{
				return "Login Successful! Welcome";
			}
			else
			{
				return "Wrong Password";
			}
		}
	}
	

	
}
