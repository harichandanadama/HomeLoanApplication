package com.cg.customer.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customer.dao.EmiDao;
import com.cg.customer.entity.Emi;

@Service
@Transactional
public class EmiServiceImpl implements EmiService {
	
	@Autowired
	private EmiDao edao;

	@Override
	public Emi calculate(Emi emi) {
		Date d=emi.getLoandate();
		double a=emi.getLoanAmount();
		int n=emi.getTenure();
		float r=emi.getInterestRate();
		double interest = (double) ((a * (r * 0.01))/n);
		double emiAmount1 = ((a/n) + interest);
		double totalEmiAmount = interest * n;
		double totalAmount = emiAmount1 * n;
		LocalDate l=LocalDate.now();
		int day=d.getDate();
		System.out.println(d);
		String date="";
		if(day>=1 && day<=19) {
			LocalDate d2=l.plusMonths(1);
			//
			Month m=d2.getMonth();
			int y=d2.getYear();
			String d3="05"+"/"+m+"/"+y;
			emi.setDueDate(d3);
		}
		else {
			LocalDate d2=l.plusMonths(2);
			Month m=d2.getMonth();
			int y=d2.getYear();
			String d3="05"+"/"+m+"/"+y;
			emi.setDueDate(d3);
		}
		emi.setInterestAmount(interest);
		emi.setEmiAmount(emiAmount1);
		emi.setTotalEmiAmount(totalAmount);
		return emi;
		
	}

}
