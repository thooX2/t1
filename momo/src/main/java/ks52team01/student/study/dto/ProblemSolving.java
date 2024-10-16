package ks52team01.student.study.dto;

import lombok.Data;

@Data
public class ProblemSolving {
	private String solvingHistory;
	private String questionScrapeCode;
	private String UserCode;
	private String smjcc;
	private String smicc;
	private String solvingDate;
	private String qnaCode;
	private String solvingType;
	private String solvingcategory;
	private String solvingHistoryNote;
	private String solvingHistoryCount;
	public String getSolvingHistory() {
		return solvingHistory;
	}
	public void setSolvingHistory(String solvingHistory) {
		this.solvingHistory = solvingHistory;
	}
	public String getQuestionScrapeCode() {
		return questionScrapeCode;
	}
	public void setQuestionScrapeCode(String questionScrapeCode) {
		this.questionScrapeCode = questionScrapeCode;
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
	public String getSolvingDate() {
		return solvingDate;
	}
	public void setSolvingDate(String solvingDate) {
		this.solvingDate = solvingDate;
	}
	public String getQnaCode() {
		return qnaCode;
	}
	public void setQnaCode(String qnaCode) {
		this.qnaCode = qnaCode;
	}
	public String getSolvingType() {
		return solvingType;
	}
	public void setSolvingType(String solvingType) {
		this.solvingType = solvingType;
	}
	public String getSolvingcategory() {
		return solvingcategory;
	}
	public void setSolvingcategory(String solvingcategory) {
		this.solvingcategory = solvingcategory;
	}
	public String getSolvingHistoryNote() {
		return solvingHistoryNote;
	}
	public void setSolvingHistoryNote(String solvingHistoryNote) {
		this.solvingHistoryNote = solvingHistoryNote;
	}
	public String getSolvingHistoryCount() {
		return solvingHistoryCount;
	}
	public void setSolvingHistoryCount(String solvingHistoryCount) {
		this.solvingHistoryCount = solvingHistoryCount;
	}
	@Override
	public String toString() {
		return "ProblemSolvingDAO [solvingHistory=" + solvingHistory + ", questionScrapeCode=" + questionScrapeCode
				+ ", UserCode=" + UserCode + ", smjcc=" + smjcc + ", smicc=" + smicc + ", solvingDate=" + solvingDate
				+ ", qnaCode=" + qnaCode + ", solvingType=" + solvingType + ", solvingcategory=" + solvingcategory
				+ ", solvingHistoryNote=" + solvingHistoryNote + ", solvingHistoryCount=" + solvingHistoryCount + "]";
	}
	
	
	
}
