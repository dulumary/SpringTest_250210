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
	
	// real_estate 테이블에서 전달 받은 면적 보다 넓고, 가격보다 낮은 매매 매물 행 조회
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	public int insertRealEstateByObject(RealEstate realEstate);
	
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);

}
