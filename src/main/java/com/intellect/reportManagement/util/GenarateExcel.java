package com.intellect.reportManagement.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.intellect.reportManagement.entity.CitizenPlanInfo;

@Component
public class GenarateExcel {
	public  void  genarate(HttpServletResponse response, List<CitizenPlanInfo> records) throws IOException {
		
		//If i am using XSSFWorkbook then the extension was xlsx
		//If i am using HSSFWorkbook then the extension was xls
		//Workbook workbook = new XSSFWorkbook();
		Workbook workbook = new HSSFWorkbook();
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
		
		FileOutputStream fileOutputStream = new FileOutputStream("plans.xls");
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();
	}
}
