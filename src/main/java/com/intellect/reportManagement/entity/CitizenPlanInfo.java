package com.intellect.reportManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITIZEN_PLAN_INFO")
public class CitizenPlanInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer citizenId;

	private String citizenName;

	private String citizenGender;

	private String citizenPlanName;

	private String citizenPlanStatus;

	private String citizenPlanStartDate;

	private String citizenPlanEndDate;

	private String citizenDenailReason;

	private String citizenTerminateReason;

	private String citizenTerminationDate;

	private Double citizenBenfitedAmount;

	public Integer getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizenGender() {
		return citizenGender;
	}

	public void setCitizenGender(String citizenGender) {
		this.citizenGender = citizenGender;
	}

	public String getCitizenPlanName() {
		return citizenPlanName;
	}

	public void setCitizenPlanName(String citizenPlanName) {
		this.citizenPlanName = citizenPlanName;
	}

	public String getCitizenPlanStatus() {
		return citizenPlanStatus;
	}

	public void setCitizenPlanStatus(String citizenPlanStatus) {
		this.citizenPlanStatus = citizenPlanStatus;
	}

	public String getCitizenPlanStartDate() {
		return citizenPlanStartDate;
	}

	public void setCitizenPlanStartDate(String citizenPlanStartDate) {
		this.citizenPlanStartDate = citizenPlanStartDate;
	}

	public String getCitizenPlanEndDate() {
		return citizenPlanEndDate;
	}

	public void setCitizenPlanEndDate(String citizenPlanEndDate) {
		this.citizenPlanEndDate = citizenPlanEndDate;
	}

	public String getCitizenDenailReason() {
		return citizenDenailReason;
	}

	public void setCitizenDenailReason(String citizenDenailReason) {
		this.citizenDenailReason = citizenDenailReason;
	}

	public String getCitizenTerminateReason() {
		return citizenTerminateReason;
	}

	public void setCitizenTerminateReason(String citizenTerminateReason) {
		this.citizenTerminateReason = citizenTerminateReason;
	}

	public String getCitizenTerminationDate() {
		return citizenTerminationDate;
	}

	public void setCitizenTerminationDate(String citizenTerminationDate) {
		this.citizenTerminationDate = citizenTerminationDate;
	}

	public Double getCitizenBenfitedAmount() {
		return citizenBenfitedAmount;
	}

	public void setCitizenBenfitedAmount(Double citizenBenfitedAmount) {
		this.citizenBenfitedAmount = citizenBenfitedAmount;
	}
	
	@Override
	public String toString() {
		return "CitizenPlanInfo [citizenId=" + citizenId + ", citizenName=" + citizenName + ", citizenGender="
				+ citizenGender + ", citizenPlanName=" + citizenPlanName + ", citizenPlanStatus=" + citizenPlanStatus
				+ ", citizenPlanStartDate=" + citizenPlanStartDate + ", citizenPlanEndDate=" + citizenPlanEndDate
				+ ", citizenDenailReason=" + citizenDenailReason + ", citizenTerminateReason=" + citizenTerminateReason
				+ ", citizenTerminationDate=" + citizenTerminationDate + ", citizenBenfitedAmount="
				+ citizenBenfitedAmount + "]";
	}
}
