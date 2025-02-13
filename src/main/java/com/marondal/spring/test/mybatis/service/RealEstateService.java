package com.marondal.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.mybatis.domain.RealEstate;
import com.marondal.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	// 전달 받은 id와 일치하는 매물 정보 얻어 오기 
	public RealEstate getRealEstate(int id) {
		
		// real_estate 테이블에서 id가 일치하는 행 조회 
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		
		return realEstate;
	}
	
//	전달받은 월세보다 낮은 매물 정보 얻어오기 
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		
		// real_estate 테이블에서 전달받은 월세 보다 낮은 행 조회 
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
		
		return realEstateList;
	}

}
