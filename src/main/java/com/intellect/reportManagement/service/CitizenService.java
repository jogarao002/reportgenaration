package com.intellect.reportManagement.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.intellect.reportManagement.entity.CitizenPlanInfo;
import com.intellect.reportManagement.search.SearchData;

public interface CitizenService {
	public List<String> findPlans();

	public List<String> findPlanStatus();

	public List<CitizenPlanInfo> findAll(SearchData SearchData);

	public boolean exportExcel(HttpServletResponse response) throws Exception;

	public boolean exportPdf(HttpServletResponse response) throws Exception;
}
