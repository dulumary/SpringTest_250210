package com.marondal.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.marondal.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
	// real_estate 테이블에서 id가 일치하는 행 조회 
	public RealEstate selectRealEstate(@Param("id") int id);
	
	// real_estate 테이블에서 전달받은 월세 보다 낮은 행 조회
	public List<RealEstate> selectRealEstateListByRentPrice(@Param("rentPrice") int rentPrice);

}
