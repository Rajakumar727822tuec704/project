package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.SubModel;
import com.example.demo.Repository.SubRepository;
@Service

public class SubService
{
	@Autowired
    public SubRepository crepo;
	
	public SubModel saveInfo(SubModel c)
	{
		return crepo.save(c);
	}
	public List<SubModel> getInfo()
	{
		return crepo.findAll();
	}
	public SubModel updateInfo(SubModel iu)
	{
		return crepo.saveAndFlush(iu);
		
	}
	public void deleteInfo(int id )
	{
		crepo.deleteById(id);
	}
	public List <SubModel> sortDesc (String oname)
	{
		return crepo.findAll(Sort.by(oname).descending());
	}

	public List<SubModel> sortAsc (String oname)
	{
		return crepo.findAll(Sort.by(oname).ascending());
	}
	public List<SubModel> paginationData (int pageNu,int pageSize)
	{
		Page<SubModel> p=crepo.findAll (PageRequest.of(pageNu, pageSize));
		return p.getContent();
	}
}	
	