package ks52team01.student.study.dto;

import lombok.Data;

@Data
public class StudySchedule {
	private String learningSchedule;
	private String userCode;
	private String smjcc;
	private String smicc;
	private String learningScheduleMemo;
	private String learningScheduleDay;
	private String learningScheduleStart;
	private String learningScheduleEnd;
	private String learningScheduleCompleate;
	public String getLearningSchedule() {
		return learningSchedule;
	}
	public void setLearningSchedule(String learningSchedule) {
		this.learningSchedule = learningSchedule;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getSmjcc() {
		return smjcc;
	}
	public void setSmjcc(String smjcc) {
		this.smjcc = smjcc;
	}
	public String getSmicc() {
		return smicc;
	}
	public void setSmicc(String smicc) {
		this.smicc = smicc;
	}
	public String getLearningScheduleMemo() {
		return learningScheduleMemo;
	}
	public void setLearningScheduleMemo(String learningScheduleMemo) {
		this.learningScheduleMemo = learningScheduleMemo;
	}
	public String getLearningScheduleDay() {
		return learningScheduleDay;
	}
	public void setLearningScheduleDay(String learningScheduleDay) {
		this.learningScheduleDay = learningScheduleDay;
	}
	public String getLearningScheduleStart() {
		return learningScheduleStart;
	}
	public void setLearningScheduleStart(String learningScheduleStart) {
		this.learningScheduleStart = learningScheduleStart;
	}
	public String getLearningScheduleEnd() {
		return learningScheduleEnd;
	}
	public void setLearningScheduleEnd(String learningScheduleEnd) {
		this.learningScheduleEnd = learningScheduleEnd;
	}
	public String getLearningScheduleCompleate() {
		return learningScheduleCompleate;
	}
	public void setLearningScheduleCompleate(String learningScheduleCompleate) {
		this.learningScheduleCompleate = learningScheduleCompleate;
	}
	@Override
	public String toString() {
		return "StudyScheduleDAO [learningSchedule=" + learningSchedule + ", userCode=" + userCode + ", smjcc=" + smjcc
				+ ", smicc=" + smicc + ", learningScheduleMemo=" + learningScheduleMemo + ", learningScheduleDay="
				+ learningScheduleDay + ", learningScheduleStart=" + learningScheduleStart + ", learningScheduleEnd="
				+ learningScheduleEnd + ", learningScheduleCompleate=" + learningScheduleCompleate + "]";
	}
	
	
}
