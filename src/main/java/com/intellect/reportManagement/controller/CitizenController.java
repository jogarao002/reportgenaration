package com.intellect.reportManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.intellect.reportManagement.entity.CitizenPlanInfo;
import com.intellect.reportManagement.search.SearchData;
import com.intellect.reportManagement.service.CitizenService;

@Controller
public class CitizenController {

	@Autowired
	private CitizenService citizenService;

	@GetMapping("/")
	public String indexPage(Model model) {

		init(model);
		return "index";
	}

	@PostMapping("/search")
	private String getRecords(SearchData searchData, Model model) {
		System.out.println(searchData);
		List<CitizenPlanInfo> list = citizenService.findAll(searchData);
		model.addAttribute("allList", list);
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("search", new SearchData());
		model.addAttribute("names", citizenService.findPlans());
		model.addAttribute("planStatus", citizenService.findPlanStatus());
	}

}
