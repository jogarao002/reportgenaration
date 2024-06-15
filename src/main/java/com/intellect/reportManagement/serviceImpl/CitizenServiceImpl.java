package com.intellect.reportManagement.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public boolean exportEmail(HttpServletResponse response) throws Exception {
		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("report-sheet");
		Row headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("ID");
		headRow.createCell(1).setCellValue("Citizen Name");
		headRow.createCell(2).setCellValue("Citizen Gender");
		headRow.createCell(3).setCellValue("Citizen Plan Name");
		headRow.createCell(4).setCellValue("Citizen Plan Status");
		headRow.createCell(5).setCellValue("Citizen Plan Start Date");
		headRow.createCell(6).setCellValue("Citizen Plan End Date");
		headRow.createCell(7).setCellValue("Citizen Denial Reason");
		headRow.createCell(8).setCellValue("Citizen Terminate Reason");
		headRow.createCell(9).setCellValue("Citizen Termination Date");
		headRow.createCell(10).setCellValue("Citizen Benefited Amount");

		List<CitizenPlanInfo> records = citizenRepository.findAll();

		int count = 1;

		for (CitizenPlanInfo record : records) {
			Row dataRow = sheet.createRow(count);
			dataRow.createCell(0).setCellValue(record.getCitizenId());
			dataRow.createCell(1).setCellValue(record.getCitizenName());
			dataRow.createCell(2).setCellValue(record.getCitizenGender());
			dataRow.createCell(3).setCellValue(record.getCitizenPlanName());
			dataRow.createCell(4).setCellValue(record.getCitizenPlanStatus());
			dataRow.createCell(5).setCellValue(record.getCitizenPlanStartDate() + "");
			dataRow.createCell(6).setCellValue(record.getCitizenPlanEndDate() + "");
			dataRow.createCell(7).setCellValue(record.getCitizenDenailReason());
			dataRow.createCell(8).setCellValue(record.getCitizenTerminateReason());
			dataRow.createCell(9).setCellValue(record.getCitizenTerminationDate() + "");
			if (null != record.getCitizenBenfitedAmount()) {
				dataRow.createCell(10).setCellValue(record.getCitizenBenfitedAmount());
			} else {
				dataRow.createCell(10).setCellValue("N/A");
			}
			count++;
		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		PdfPTable table = new PdfPTable(11);
		
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Citizen Gender");
		table.addCell("Citizen Plan Name");
		table.addCell("Citizen Plan Status");
		table.addCell("Citizen Plan Start Date");
		table.addCell("Citizen Plan End Date");
		table.addCell("Citizen Denial Reason");
		table.addCell("Citizen Terminate Reason");
		table.addCell("Citizen Termination Date");
		table.addCell("Citizen Benefited Amount");
		
		List<CitizenPlanInfo> records = citizenRepository.findAll();


		for (CitizenPlanInfo record : records) {
			table.addCell(String.valueOf(record.getCitizenId()));
			table.addCell(record.getCitizenName());
			table.addCell(record.getCitizenGender());
			table.addCell(record.getCitizenPlanName());
			table.addCell(record.getCitizenPlanStatus());
			table.addCell(record.getCitizenPlanStartDate() + "");
			table.addCell(record.getCitizenPlanEndDate() + "");
			table.addCell(record.getCitizenDenailReason());
			table.addCell(record.getCitizenTerminateReason());
			table.addCell(record.getCitizenTerminationDate() + "");
			if (null != record.getCitizenBenfitedAmount()) {
				table.addCell(String.valueOf(record.getCitizenBenfitedAmount()));
			} else {
				table.addCell("N/A");
			}
		}
		
		document.add(table);
		document.close();
		return true;
	}

}
