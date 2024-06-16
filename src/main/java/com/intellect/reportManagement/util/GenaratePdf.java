package com.intellect.reportManagement.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.intellect.reportManagement.entity.CitizenPlanInfo;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class GenaratePdf {
	public void genarate(HttpServletResponse response, List<CitizenPlanInfo> records, File file) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
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
	}
 }
