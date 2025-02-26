package com.marondal.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.ajax.domain.Favorite;
import com.marondal.spring.test.ajax.service.FavoriteService;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/input")
	public String inputFavorite() {
		return "ajax/favorite/input";
	}
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteService.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favorite/list";
	}
	
	// 사이트 이름과 url을 전달 받고 저장하는 API
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String>  createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		int count = favoriteService.addFavorite(name, url);
		
		// 성공 {"result":"success"}
		// 실패 {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}

}
