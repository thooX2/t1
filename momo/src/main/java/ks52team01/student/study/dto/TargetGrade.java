package ks52team01.student.study.dto;

import lombok.Data;

@Data
public class TargetGrade {
	private String gradeCode;
	private String UserCode;
	private String smjcc;
	private String smicc;
	private String lastGrade;
	private String recentGrade;
	private String tar_grade_set;
	private String result_grade_set;
	private String count_grade_set;
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getUserCode() {
		return UserCode;
	}
	public void setUserCode(String userCode) {
		UserCode = userCode;
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
	public String getLastGrade() {
		return lastGrade;
	}
	public void setLastGrade(String lastGrade) {
		this.lastGrade = lastGrade;
	}
	public String getRecentGrade() {
		return recentGrade;
	}
	public void setRecentGrade(String recentGrade) {
		this.recentGrade = recentGrade;
	}
	public String getTar_grade_set() {
		return tar_grade_set;
	}
	public void setTar_grade_set(String tar_grade_set) {
		this.tar_grade_set = tar_grade_set;
	}
	public String getResult_grade_set() {
		return result_grade_set;
	}
	public void setResult_grade_set(String result_grade_set) {
		this.result_grade_set = result_grade_set;
	}
	public String getCount_grade_set() {
		return count_grade_set;
	}
	public void setCount_grade_set(String count_grade_set) {
		this.count_grade_set = count_grade_set;
	}
	@Override
	public String toString() {
		return "TargetGradeDAO [gradeCode=" + gradeCode + ", UserCode=" + UserCode + ", smjcc=" + smjcc + ", smicc="
				+ smicc + ", lastGrade=" + lastGrade + ", recentGrade=" + recentGrade + ", tar_grade_set="
				+ tar_grade_set + ", result_grade_set=" + result_grade_set + ", count_grade_set=" + count_grade_set
				+ "]";
	}
	
	
}
