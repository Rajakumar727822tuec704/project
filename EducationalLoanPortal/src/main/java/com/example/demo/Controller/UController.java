package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.LoanApplicationModel;
import com.example.demo.Model.LoginModel;
import com.example.demo.Model.UserModel;
import com.example.demo.Service.UserService;

@CrossOrigin
@RestController
public class UController {

	@Autowired UserService s;
	
	public static boolean flag1 = false;
	public static boolean flag2 = false;
	
	@PostMapping("/user/login")
	public String userLogin(@RequestBody Map<String, String> mp)
	{
		String mail = mp.get("email");
		String pass = mp.get("password");
		return s.validateUser(mail, pass);
	}
	
	@PostMapping("/user/signup")
	public String userSignup(@RequestBody LoginModel lm)
	{
		if(flag2)
			return s.newUser(lm);
		else
			return "Please Login";
	}
	
	@GetMapping("/user/getProfile")
	public Optional<UserModel> getProf()
	{
		if(flag2)
			return s.getUserProf();
		else
			return null;
	}
	
	@GetMapping("user/viewLoan")
	public Optional<LoanApplicationModel> viewLoan()
	{
		if(flag2)
			return s.viewLoan();
		else
			return null;
	}
	
	@GetMapping("/admin/getAllLoans")
	public List<LoanApplicationModel> getAllLoans()
	{
		if(flag1)
			return s.getAllLoans();
		else
			return null;
	}
	
	@PostMapping("/admin/login")
	public String adminLogin(@RequestBody Map<String, String> mp)
	{
		String mail = mp.get("email");
		String pass = mp.get("password");
		return s.validateAdmin(mail, pass);
	}

}

