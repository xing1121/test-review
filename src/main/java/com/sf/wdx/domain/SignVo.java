package com.sf.wdx.domain;

public class SignVo {

	private String success;

	private String msg;

	private HosAttendanceRecordDay hosAttendanceRecordDay;

	public SignVo() {
	}

	public SignVo(String success, String msg, HosAttendanceRecordDay hosAttendanceRecordDay) {
		this.success = success;
		this.msg = msg;
		this.hosAttendanceRecordDay = hosAttendanceRecordDay;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HosAttendanceRecordDay getHosAttendanceRecordDay() {
		return hosAttendanceRecordDay;
	}

	public void setHosAttendanceRecordDay(HosAttendanceRecordDay hosAttendanceRecordDay) {
		this.hosAttendanceRecordDay = hosAttendanceRecordDay;
	}

	@Override
	public String toString() {
		return "ResVO [success=" + success + ", msg=" + msg + ", hosAttendanceRecordDay=" + hosAttendanceRecordDay
				+ "]";
	}

}
