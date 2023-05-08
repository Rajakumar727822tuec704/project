package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.AdminModel;

@Repository
public interface AdminRepo extends JpaRepository<AdminModel, String>{

	AdminModel findByemail(String email);

}