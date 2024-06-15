package com.intellect.reportManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.intellect.reportManagement.entity.CitizenPlanInfo;
import com.intellect.reportManagement.repository.CitizenRepository;
import com.intellect.reportManagement.search.SearchData;
import com.intellect.reportManagement.service.CitizenService;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepository citizenRepository;
	
	@Override
	public List<String> findPlans() {
		return citizenRepository.getPlans();
	}

	@Override
	public List<String> findPlanStatus() {
		return citizenRepository.getPlanStatus();
	}

	@Override
	public List<CitizenPlanInfo> findAll(SearchData searchData) {
		
		CitizenPlanInfo citizenPlanInfo = new CitizenPlanInfo();
		
		if(null != searchData.getPlanName() && !"".equals(searchData.getPlanName())) {
			citizenPlanInfo.setCitizenPlanName(searchData.getPlanName());
		}
		if(null != searchData.getPlanStatus() && !"".equals(searchData.getPlanStatus())) {
			citizenPlanInfo.setCitizenPlanStatus(searchData.getPlanStatus());
		}
		if(null != searchData.getPlanStartDate() && !"".equals(searchData.getPlanStartDate())) {
			citizenPlanInfo.setCitizenPlanStartDate(searchData.getPlanStartDate());
		}
		if(null != searchData.getPlanEndDate() && !"".equals(searchData.getPlanEndDate())) {
			citizenPlanInfo.setCitizenPlanEndDate(searchData.getPlanEndDate());
		}
		Example<CitizenPlanInfo> all = Example.of(citizenPlanInfo);
		List<CitizenPlanInfo> resultList = citizenRepository.findAll(all);
		return resultList;
	}

	@Override
	public boolean exportEmail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
