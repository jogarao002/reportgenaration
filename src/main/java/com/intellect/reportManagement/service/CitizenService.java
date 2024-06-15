package com.intellect.reportManagement.service;

import java.util.List;

import com.intellect.reportManagement.entity.CitizenPlanInfo;
import com.intellect.reportManagement.search.SearchData;

public interface CitizenService {
	public List<String> findPlans();

	public List<String> findPlanStatus();

	public List<CitizenPlanInfo> findAll(SearchData SearchData);

	public boolean exportEmail();

	public boolean exportPdf();
}
