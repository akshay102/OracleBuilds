package com.valueobject;

/**
 * 
 * Value Object for storing different fields received from the input String
 * @author Akshay Singh
 *
 */
public class BuildVo {
	
	private String customerId;
	private String contractId;
	private String geoZone;
	private String teamCode;
	private String projectCode;
	private int duration;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getGeoZone() {
		return geoZone;
	}
	public void setGeoZone(String geoZone) {
		this.geoZone = geoZone;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		
		char lastChar = duration.charAt(duration.length()-1);
		duration = duration.substring(0, duration.length()-1);
		this.duration = Integer.parseInt(duration);

		if(lastChar=='m')
			this.duration = this.duration*60;
		else if(lastChar=='h')
			this.duration = this.duration*60*60;
			
	}

}
