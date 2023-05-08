package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.LoanApplicationModel;

@Repository
public interface LoanApplicationRepo extends JpaRepository<LoanApplicationModel, Integer>{

	@Query("select lam from LoanApplicationModel lam where lam.applicantEmail=:applicantEmail")
	Optional<LoanApplicationModel> findbymail(String applicantEmail);

}