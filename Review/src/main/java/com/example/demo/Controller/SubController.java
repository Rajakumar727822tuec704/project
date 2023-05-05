package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;        
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.SubModel;
import com.example.demo.Repository.SubRepository;
import com.example.demo.service.SubService;

@RestController

public class SubController 
{
	@Autowired
	public SubService cser;
		
	@PostMapping("/postm")
	public SubModel addDetails(@RequestBody SubModel cr)
	{
		return cser.saveInfo(cr);
	}
	@GetMapping("/getma")
	public List <SubModel> getDetails()
	{
		return cser.getInfo();
	}
	
	@PutMapping("/updatem")
	public SubModel updateDetails(@RequestBody SubModel bikenum)
	{
		return cser.updateInfo(bikenum);
	}
	
	@DeleteMapping("delete/{cid}")
	public String deleteDetails (@PathVariable ("cid") int bikenum)
	{
		cser.deleteInfo(bikenum);
		return "Bike number "+bikenum+" is deleted";
				
	}
	@DeleteMapping("/deleteReq")
	public String deleteByReq(@RequestParam ("cid") int bikenum)
	{
		cser.deleteInfo(bikenum);
		return "Bike number "+bikenum+" is deleted";
	}
	@GetMapping("/sortDesc/{oname}")
	public List<SubModel> sortOwner(@PathVariable("oname") String bikename)
	{
		return cser.sortDesc(bikename);
	}

	@GetMapping("/sortAsc/{oname}")
	public List<SubModel> sortOwnerasc(@PathVariable ("oname") String bikename)
	{
		return cser.sortAsc(bikename);
	}


	@GetMapping("/pagination/{pnu}/{psize}")
	public List <SubModel> paginationData(@PathVariable ("pnu") int pnu, @PathVariable("psize")int psize)
	{
		return cser.paginationData(pnu, psize);
	}
	@Autowired
	public SubRepository ir;
	@GetMapping("/saveir")
	public List<SubModel> getD()
	{
		return ir.getAllData();
	}

	@GetMapping("byName/{id}")
	public List<SubModel> getName(@PathVariable ("id") int pid )
	{
		return ir.bysubnum(pid);
	}

	@GetMapping("startend/{start}/{end}")
	public List<SubModel> getStart(@PathVariable ("start")int start,@PathVariable ("end")int end)
	{
		return ir.startEnd(start, end);
	}

	@DeleteMapping("/del/{id}/{name}")
	public String delD(@PathVariable ("id") int id,@PathVariable ("name")String name)
	{
		ir.deleteD(id, name);
		return "deleted";
	}

	@PutMapping("updatee/{pid}/{pname}")
	public void updateQue(@PathVariable("pid")int pid,@PathVariable("pname") String pname)
	{
		ir.updateByQuery(pid, pname);
	}
	@GetMapping("jp")
	public List<SubModel> jplQuery()
	{
		return ir.jpqlQ();
	}
	@GetMapping("/upp/{id}")
	public List<SubModel> jpqUp(@PathVariable ("id") int id)
	{
		return ir.jqBYCon(id);
	}
}
