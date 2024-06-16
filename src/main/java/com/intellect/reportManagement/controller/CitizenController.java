package com.intellect.reportManagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.intellect.reportManagement.entity.CitizenPlanInfo;
import com.intellect.reportManagement.search.SearchData;
import com.intellect.reportManagement.service.CitizenService;

import net.bytebuddy.implementation.bind.annotation.Morph;

@Controller
public class CitizenController {

	@Autowired
	private CitizenService citizenService;

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchData());
		init(model);
		return "index";
	}
	
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=plans.xls");
		citizenService.exportExcel(response);
	}
	
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=plans.pdf");
		citizenService.exportPdf(response);
	}
	
	@PostMapping("/search")
	public String getRecords(@ModelAttribute("search") SearchData searchData, Model model) {
		List<CitizenPlanInfo> list = citizenService.findAll(searchData);
		model.addAttribute("allList", list);
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("names", citizenService.findPlans());
		model.addAttribute("planStatus", citizenService.findPlanStatus());
	}

}
