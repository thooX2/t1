package ks52team01.student.study.dto;

import lombok.Data;

@Data
public class DetailedSchedule {
	private String detailedSchedule;
	private String userCode;
	private String learningSchedule;
	private String detailedScheduleMemo;
	private String detailedScheduleDate;
	private String detailedScheduleStartTime;
	private String detailedScheduleEndTime;
	private String detailedScheduleStudyTime;
	private String detailedScheduleResult;
	public String getDetailedSchedule() {
		return detailedSchedule;
	}
	public void setDetailedSchedule(String detailedSchedule) {
		this.detailedSchedule = detailedSchedule;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getLearningSchedule() {
		return learningSchedule;
	}
	public void setLearningSchedule(String learningSchedule) {
		this.learningSchedule = learningSchedule;
	}
	public String getDetailedScheduleMemo() {
		return detailedScheduleMemo;
	}
	public void setDetailedScheduleMemo(String detailedScheduleMemo) {
		this.detailedScheduleMemo = detailedScheduleMemo;
	}
	public String getDetailedScheduleDate() {
		return detailedScheduleDate;
	}
	public void setDetailedScheduleDate(String detailedScheduleDate) {
		this.detailedScheduleDate = detailedScheduleDate;
	}
	public String getDetailedScheduleStartTime() {
		return detailedScheduleStartTime;
	}
	public void setDetailedScheduleStartTime(String detailedScheduleStartTime) {
		this.detailedScheduleStartTime = detailedScheduleStartTime;
	}
	public String getDetailedScheduleEndTime() {
		return detailedScheduleEndTime;
	}
	public void setDetailedScheduleEndTime(String detailedScheduleEndTime) {
		this.detailedScheduleEndTime = detailedScheduleEndTime;
	}
	public String getDetailedScheduleStudyTime() {
		return detailedScheduleStudyTime;
	}
	public void setDetailedScheduleStudyTime(String detailedScheduleStudyTime) {
		this.detailedScheduleStudyTime = detailedScheduleStudyTime;
	}
	public String getDetailedScheduleResult() {
		return detailedScheduleResult;
	}
	public void setDetailedScheduleResult(String detailedScheduleResult) {
		this.detailedScheduleResult = detailedScheduleResult;
	}
	@Override
	public String toString() {
		return "DetailedScheduleDAO [detailedSchedule=" + detailedSchedule + ", userCode=" + userCode
				+ ", learningSchedule=" + learningSchedule + ", detailedScheduleMemo=" + detailedScheduleMemo
				+ ", detailedScheduleDate=" + detailedScheduleDate + ", detailedScheduleStartTime="
				+ detailedScheduleStartTime + ", detailedScheduleEndTime=" + detailedScheduleEndTime
				+ ", detailedScheduleStudyTime=" + detailedScheduleStudyTime + ", detailedScheduleResult="
				+ detailedScheduleResult + "]";
	}
}
