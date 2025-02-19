package com.marondal.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marondal.spring.test.mvc.domain.Realtor;
import com.marondal.spring.test.mvc.repository.RealtorRepository;

@Controller
public class RealtorService {
	
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor realtor) {
		int count = realtorRepository.insertRealtorByObject(realtor);
		
		return count;
	}

}
