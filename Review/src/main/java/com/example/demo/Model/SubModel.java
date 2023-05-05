package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class SubModel 
{
	@Id                                         
   private int subnum;
   private String subname;
   private int subplan;
public int getSubnum() {
	return subnum;
}
public void setSubnum(int subnum) {
	this.subnum = subnum;
}
public String getSubname() {
	return subname;
}
public void setSubname(String subname) {
	this.subname = subname;
}
public int getSubplan() {
	return subplan;
}
public void setSubplan(int subplan) {
	this.subplan = subplan;
}
}