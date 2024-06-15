package com.intellect.reportManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intellect.reportManagement.entity.CitizenPlanInfo;

@Repository
public interface CitizenRepository extends JpaRepository<CitizenPlanInfo, Integer> {
	
	@Query("select distinct(citizenPlanName) from CitizenPlanInfo")
	public List<String> getPlans();
	
	@Query("select distinct(citizenPlanStatus) from CitizenPlanInfo")
	public List<String> getPlanStatus();
	
}
