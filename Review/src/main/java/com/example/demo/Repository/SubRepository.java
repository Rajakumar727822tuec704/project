package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.SubModel;

import jakarta.transaction.Transactional;

public interface SubRepository extends JpaRepository<SubModel, Integer> {
	@Query(value="select * from Sub_model ",nativeQuery=true)
	public List<SubModel> getAllData();

	@Query(value="select * from Sub_model where subnum=:id",nativeQuery=true)
	public List<SubModel> bysubnum (@Param("id")int id);

	@Query(value="select * from sub_model where subnum between :start and :end",nativeQuery=true)
	public List<SubModel> startEnd(@Param("start") int start,@Param("end")int end);

	@Modifying
	@Transactional
	@Query(value="delete from sub_model where subnum=?1 and subname=?2",nativeQuery = true)
	Integer deleteD(@Param("id") int pid,@Param ("name") String pname);

	@Modifying
	@Transactional
	@Query(value="update sub_model set subnum=:pid where subname=:pname",nativeQuery=true)
	public void updateByQuery(@Param ("pid")int pid,@Param ("pname")String pname);
	@Query(value="select c from SubModel c")
    List<SubModel> jpqlQ();
    
    @Query(value="select c from SubModel c where c.subnum=?1")
    public List<SubModel> jqBYCon(@Param ("id")int sid);
}
