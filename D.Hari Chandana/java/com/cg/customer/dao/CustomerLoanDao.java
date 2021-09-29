package com.cg.customer.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.customer.entity.LoanApplication;

@Repository
public interface CustomerLoanDao extends JpaRepository<LoanApplication, Integer> {
	
	
	@Query("from LoanApplication where customerid=:id")
	List<LoanApplication> findByCustId( @Param("id") int id);
	
	@Query("from LoanApplication where customerid=:id and applicationid=:appid")
	Optional<LoanApplication> findByAppId( @Param("id") int id, @Param("appid") int appid);

}
