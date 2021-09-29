package com.cg.customer.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Loan")
@Validated
public class LoanController {
	@GetMapping("/byName/{name}")
	public String display(@PathVariable("name") String name) {
		System.out.println("cntrlr fetch name: " + name);
		String response = name;
		System.out.println("by name details: " + response);
		return response;
	}
}
