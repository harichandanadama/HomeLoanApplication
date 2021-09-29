package com.cg.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.customer.entity.Emi;

@Repository
public interface EmiDao extends JpaRepository<Emi, Integer> {

}
