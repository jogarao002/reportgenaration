package com.intellect.reportManagement.serviceImpl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.intellect.reportManagement.entity.CitizenPlanInfo;
import com.intellect.reportManagement.repository.CitizenRepository;
import com.intellect.reportManagement.search.SearchData;
import com.intellect.reportManagement.service.CitizenService;
import com.intellect.reportManagement.util.GenarateExcel;
import com.intellect.reportManagement.util.GenaratePdf;
import com.intellect.reportManagement.util.SendEmail;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepository citizenRepository;

	@Autowired
	private GenarateExcel genarateExcel;

	@Autowired
	private GenaratePdf genaratePdf;
	
	@Autowired
	private SendEmail sendEmail;

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

		if (null != searchData.getPlanName() && !"".equals(searchData.getPlanName())) {
			citizenPlanInfo.setCitizenPlanName(searchData.getPlanName());
		}
		if (null != searchData.getPlanStatus() && !"".equals(searchData.getPlanStatus())) {
			citizenPlanInfo.setCitizenPlanStatus(searchData.getPlanStatus());
		}
		if (null != searchData.getPlanStartDate() && !"".equals(searchData.getPlanStartDate())) {
			String startDate = searchData.getPlanStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localData = LocalDate.parse(startDate, formatter);
			citizenPlanInfo.setCitizenPlanStartDate(localData);
		}
		if (null != searchData.getPlanEndDate() && !"".equals(searchData.getPlanEndDate())) {
			String endDate = searchData.getPlanEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localData = LocalDate.parse(endDate, formatter);
			citizenPlanInfo.setCitizenPlanEndDate(localData);
		}
		List<CitizenPlanInfo> resultList = citizenRepository.findAll(Example.of(citizenPlanInfo));
		return resultList;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		File file = new File("plans.xls");
		List<CitizenPlanInfo> records = citizenRepository.findAll();
		genarateExcel.genarate(response, records);
		String toMailAddress = "omkartinku03@gmail.com";
		String subject = "This is from jogarao";
		String body = "<h1>Hiii</h1>";
		sendEmail.genarateEmail(toMailAddress, subject, body, file);
		file.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File file = new File("plans.pdf");
		List<CitizenPlanInfo> records = citizenRepository.findAll();
		genaratePdf.genarate(response, records, file);
		String toMailAddress = "omkartinku03@gmail.com";
		String subject = "This is from jogarao";
		String body = "<h1>Hiii</h1>";
		sendEmail.genarateEmail(toMailAddress, subject, body, file);
		file.delete();
		return true;
	}

}
