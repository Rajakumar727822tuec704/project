package com.example.demo.RepoD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modD.Omodel;

@Repository
public interface ORepo  extends JpaRepository<Omodel,Integer>
{

}