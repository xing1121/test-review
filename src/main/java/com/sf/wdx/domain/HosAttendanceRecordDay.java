package com.sf.wdx.domain;

import java.util.Date;

public class HosAttendanceRecordDay {

	private String calcTag;

	private String createBy;

	private Date createTm;

	private Date currentDate;

	private String empCode;

	private String isAddtend;

	private String signTimeId;

	private Date signInTime;

	private Date signOutTime;

	private String signIp;

	public HosAttendanceRecordDay() {
	}

	public HosAttendanceRecordDay(String calcTag, String createBy, Date createTm, Date currentDate, String empCode,
			String isAddtend, String signTimeId, Date signInTime, Date signOutTime, String signIp) {
		this.calcTag = calcTag;
		this.createBy = createBy;
		this.createTm = createTm;
		this.currentDate = currentDate;
		this.empCode = empCode;
		this.isAddtend = isAddtend;
		this.signTimeId = signTimeId;
		this.signInTime = signInTime;
		this.signOutTime = signOutTime;
		this.signIp = signIp;
	}

	public String getCalcTag() {
		return calcTag;
	}

	public void setCalcTag(String calcTag) {
		this.calcTag = calcTag;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTm() {
		return createTm;
	}

	public void setCreateTm(Date createTm) {
		this.createTm = createTm;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getIsAddtend() {
		return isAddtend;
	}

	public void setIsAddtend(String isAddtend) {
		this.isAddtend = isAddtend;
	}

	public String getSignTimeId() {
		return signTimeId;
	}

	public void setSignTimeId(String signTimeId) {
		this.signTimeId = signTimeId;
	}

	public Date getSignInTime() {
		return signInTime;
	}

	public void setSignInTime(Date signInTime) {
		this.signInTime = signInTime;
	}

	public Date getSignOutTime() {
		return signOutTime;
	}

	public void setSignOutTime(Date signOutTime) {
		this.signOutTime = signOutTime;
	}

	public String getSignIp() {
		return signIp;
	}

	public void setSignIp(String signIp) {
		this.signIp = signIp;
	}

	@Override
	public String toString() {
		return "HosAttendanceRecordDay [calcTag=" + calcTag + ", createBy=" + createBy + ", createTm=" + createTm
				+ ", currentDate=" + currentDate + ", empCode=" + empCode + ", isAddtend=" + isAddtend + ", signTimeId="
				+ signTimeId + ", signInTime=" + signInTime + ", signOutTime=" + signOutTime + ", signIp=" + signIp
				+ "]";
	}

}
