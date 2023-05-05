package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Subcust;

public interface SubcustRepo extends JpaRepository<Subcust,Integer> {
	Subcust findByusername(String username);
}
