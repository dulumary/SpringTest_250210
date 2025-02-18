package com.marondal.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.mvc.service.SellerService;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@ResponseBody
	@PostMapping("/create")
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
		
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		
		return "삽입 결과 : " + count;
		
	}
	
	@GetMapping("/input")
	public String inputSeller() {
		return "mvc/sellerInput";
	}

}
