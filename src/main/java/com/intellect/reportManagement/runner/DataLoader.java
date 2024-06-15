package com.intellect.reportManagement.runner;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.intellect.reportManagement.entity.CitizenPlanInfo;
import com.intellect.reportManagement.repository.CitizenRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	 private CitizenRepository citizenRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		citizenRepository.deleteAll();

		CitizenPlanInfo c1 = new CitizenPlanInfo();
		c1.setCitizenName("Ramu");
		c1.setCitizenGender("Male");
		c1.setCitizenPlanName("Cash");
		c1.setCitizenPlanStatus("Approved");
		c1.setCitizenPlanStartDate(LocalDate.now());
		c1.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c1.setCitizenBenfitedAmount(5000.00);

		CitizenPlanInfo c2 = new CitizenPlanInfo();
		c2.setCitizenName("Praveen");
		c2.setCitizenGender("Male");
		c2.setCitizenPlanName("Food");
		c2.setCitizenPlanStatus("Terminated");
		c2.setCitizenPlanStartDate(LocalDate.now());
		c2.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c2.setCitizenTerminateReason("Person Having High Value Properties");
		c2.setCitizenTerminationDate(LocalDate.now());

		CitizenPlanInfo c3 = new CitizenPlanInfo();
		c3.setCitizenName("Prasanna");
		c3.setCitizenGender("Male");
		c3.setCitizenPlanName("Medical");
		c3.setCitizenPlanStatus("Denied");
		c3.setCitizenPlanStartDate(LocalDate.now());
		c3.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c3.setCitizenDenailReason("Person Having A Government Job");

		CitizenPlanInfo c4 = new CitizenPlanInfo();
		c4.setCitizenName("Dileep");
		c4.setCitizenGender("Male");
		c4.setCitizenPlanName("Employment");
		c4.setCitizenPlanStatus("Approved");
		c4.setCitizenPlanStartDate(LocalDate.now());
		c4.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c4.setCitizenBenfitedAmount(4000.00);

		CitizenPlanInfo c5 = new CitizenPlanInfo();
		c5.setCitizenName("Sai");
		c5.setCitizenGender("Male");
		c5.setCitizenPlanName("Cash");
		c5.setCitizenPlanStatus("Terminated");
		c5.setCitizenPlanStartDate(LocalDate.now());
		c5.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c5.setCitizenTerminateReason("Person Having High Value Properties");
		c5.setCitizenTerminationDate(LocalDate.now());

		CitizenPlanInfo c6 = new CitizenPlanInfo();
		c6.setCitizenName("Ramesh");
		c6.setCitizenGender("Male");
		c6.setCitizenPlanName("Food");
		c6.setCitizenPlanStatus("Approved");
		c6.setCitizenPlanStartDate(LocalDate.now());
		c6.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c6.setCitizenBenfitedAmount(5000.00);

		CitizenPlanInfo c7 = new CitizenPlanInfo();
		c7.setCitizenName("Jogarao");
		c7.setCitizenGender("Male");
		c7.setCitizenPlanName("Medical");
		c7.setCitizenPlanStatus("Denied");
		c7.setCitizenPlanStartDate(LocalDate.now());
		c7.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c7.setCitizenDenailReason("Person Having A Government Job");

		CitizenPlanInfo c8 = new CitizenPlanInfo();
		c8.setCitizenName("Durgaprasad");
		c8.setCitizenGender("Male");
		c8.setCitizenPlanName("Employment");
		c8.setCitizenPlanStatus("Approved");
		c8.setCitizenPlanStartDate(LocalDate.now());
		c8.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c8.setCitizenBenfitedAmount(4000.00);

		CitizenPlanInfo c9 = new CitizenPlanInfo();
		c9.setCitizenName("Venkatesh");
		c9.setCitizenGender("Male");
		c9.setCitizenPlanName("Cash");
		c9.setCitizenPlanStatus("Denied");
		c9.setCitizenPlanStartDate(LocalDate.now());
		c9.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c9.setCitizenTerminationDate(LocalDate.now());
		c9.setCitizenBenfitedAmount(4000.00);

		CitizenPlanInfo c10 = new CitizenPlanInfo();
		c10.setCitizenName("Sailaja");
		c10.setCitizenGender("Fe-Male");
		c10.setCitizenPlanName("Food");
		c10.setCitizenPlanStatus("Terminated");
		c10.setCitizenPlanStartDate(LocalDate.now());
		c10.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c10.setCitizenTerminateReason("Person Having High Value Properties");
		c10.setCitizenTerminationDate(LocalDate.now());

		CitizenPlanInfo c11 = new CitizenPlanInfo();
		c11.setCitizenName("Lakshmi");
		c11.setCitizenGender("Fe-Male");
		c11.setCitizenPlanName("Medical");
		c11.setCitizenPlanStatus("Denied");
		c11.setCitizenPlanStartDate(LocalDate.now());
		c11.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c11.setCitizenDenailReason("Person Having A Government Job");

		CitizenPlanInfo c12 = new CitizenPlanInfo();
		c12.setCitizenName("Naveen");
		c12.setCitizenGender("Male");
		c12.setCitizenPlanName("Employment");
		c12.setCitizenPlanStatus("Approved");
		c12.setCitizenPlanStartDate(LocalDate.now());
		c12.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c12.setCitizenBenfitedAmount(4000.00);

		CitizenPlanInfo c13 = new CitizenPlanInfo();
		c13.setCitizenName("Seetharam");
		c13.setCitizenGender("Fe-Male");
		c13.setCitizenPlanName("Food");
		c13.setCitizenPlanStatus("Terminated");
		c13.setCitizenPlanStartDate(LocalDate.now());
		c13.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c13.setCitizenTerminateReason("Person Having High Value Properties");
		c13.setCitizenTerminationDate(LocalDate.now());

		CitizenPlanInfo c14 = new CitizenPlanInfo();
		c14.setCitizenName("Bhavana");
		c14.setCitizenGender("Fe-Male");
		c14.setCitizenPlanName("Medical");
		c14.setCitizenPlanStatus("Denied");
		c14.setCitizenPlanStartDate(LocalDate.now());
		c14.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c14.setCitizenDenailReason("Person Having A Government Job");

		CitizenPlanInfo c15 = new CitizenPlanInfo();
		c15.setCitizenName("Santosh");
		c15.setCitizenGender("Male");
		c15.setCitizenPlanName("Employment");
		c15.setCitizenPlanStatus("Approved");
		c15.setCitizenPlanStartDate(LocalDate.now());
		c15.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c15.setCitizenBenfitedAmount(4000.00);

		CitizenPlanInfo c16 = new CitizenPlanInfo();
		c16.setCitizenName("Geetha");
		c16.setCitizenGender("Fe-Male");
		c16.setCitizenPlanName("Food");
		c16.setCitizenPlanStatus("Terminated");
		c16.setCitizenPlanStartDate(LocalDate.now());
		c16.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c16.setCitizenTerminateReason("Person Having High Value Properties");
		c16.setCitizenTerminationDate(LocalDate.now());

		CitizenPlanInfo c17 = new CitizenPlanInfo();
		c17.setCitizenName("Chandhana");
		c17.setCitizenGender("Fe-Male");
		c17.setCitizenPlanName("Medical");
		c17.setCitizenPlanStatus("Denied");
		c17.setCitizenPlanStartDate(LocalDate.now());
		c17.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c17.setCitizenDenailReason("Person Having A Government Job");

		CitizenPlanInfo c18 = new CitizenPlanInfo();
		c18.setCitizenName("Gangadhar");
		c18.setCitizenGender("Male");
		c18.setCitizenPlanName("Employment");
		c18.setCitizenPlanStatus("Approved");
		c18.setCitizenPlanStartDate(LocalDate.now());
		c18.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c18.setCitizenBenfitedAmount(4000.00);

		CitizenPlanInfo c19 = new CitizenPlanInfo();
		c19.setCitizenName("Bhargavi");
		c19.setCitizenGender("Fe-Male");
		c19.setCitizenPlanName("Cash");
		c19.setCitizenPlanStatus("Terminated");
		c19.setCitizenPlanStartDate(LocalDate.now());
		c19.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c19.setCitizenTerminateReason("Person Having High Value Properties");
		c19.setCitizenTerminationDate(LocalDate.now());

		CitizenPlanInfo c20 = new CitizenPlanInfo();
		c20.setCitizenName("Jyothi");
		c20.setCitizenGender("Fe-Male");
		c20.setCitizenPlanName("Medical");
		c20.setCitizenPlanStatus("Denied");
		c20.setCitizenPlanStartDate(LocalDate.now());
		c20.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c20.setCitizenDenailReason("Person Having A Government Job");

		CitizenPlanInfo c21 = new CitizenPlanInfo();
		c21.setCitizenName("Yamuna");
		c21.setCitizenGender("Fe-Male");
		c21.setCitizenPlanName("Employment");
		c21.setCitizenPlanStatus("Approved");
		c21.setCitizenPlanStartDate(LocalDate.now());
		c21.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c21.setCitizenBenfitedAmount(4000.00);

		CitizenPlanInfo c22 = new CitizenPlanInfo();
		c22.setCitizenName("Hareesh");
		c22.setCitizenGender("Male");
		c22.setCitizenPlanName("Food");
		c22.setCitizenPlanStatus("Terminated");
		c22.setCitizenPlanStartDate(LocalDate.now());
		c22.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c22.setCitizenTerminateReason("Person Having High Value Properties");
		c22.setCitizenTerminationDate(LocalDate.now());

		CitizenPlanInfo c23 = new CitizenPlanInfo();
		c23.setCitizenName("Jyoshna");
		c23.setCitizenGender("Fe-Male");
		c23.setCitizenPlanName("Medical");
		c23.setCitizenPlanStatus("Denied");
		c23.setCitizenPlanStartDate(LocalDate.now());
		c23.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c23.setCitizenDenailReason("Person Having A Government Job");

		CitizenPlanInfo c24 = new CitizenPlanInfo();
		c24.setCitizenName("Uday");
		c24.setCitizenGender("Male");
		c24.setCitizenPlanName("Cash");
		c24.setCitizenPlanStatus("Approved");
		c24.setCitizenPlanStartDate(LocalDate.now());
		c24.setCitizenPlanEndDate(LocalDate.now().plusDays(6));
		c24.setCitizenBenfitedAmount(4000.00);

		List<CitizenPlanInfo> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16,
				c17, c18, c19, c20, c21, c22, c23, c24);
		citizenRepository.saveAll(list);
	}

}
