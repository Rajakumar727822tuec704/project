package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LogIn;

@Repository
public interface LogRepo extends JpaRepository<LogIn,String> 
{
    LogIn findByuname(String uname);
}