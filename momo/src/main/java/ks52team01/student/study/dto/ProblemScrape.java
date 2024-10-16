package ks52team01.student.study.dto;

import lombok.Data;

@Data
public class ProblemScrape {
	private String questionScrape;
	private String userCode;
	private String examCode;
	private String examQnaCode;
	private String questionScrapeMemo;
	private String questionScrapeLevel;
	private String questionScrapeCreateTime;
	private String questionScrapeModifyTime;
	private String questionScrapeResult;
	public String getQuestionScrape() {
		return questionScrape;
	}
	public void setQuestionScrape(String questionScrape) {
		this.questionScrape = questionScrape;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	public String getExamQnaCode() {
		return examQnaCode;
	}
	public void setExamQnaCode(String examQnaCode) {
		this.examQnaCode = examQnaCode;
	}
	public String getQuestionScrapeMemo() {
		return questionScrapeMemo;
	}
	public void setQuestionScrapeMemo(String questionScrapeMemo) {
		this.questionScrapeMemo = questionScrapeMemo;
	}
	public String getQuestionScrapeLevel() {
		return questionScrapeLevel;
	}
	public void setQuestionScrapeLevel(String questionScrapeLevel) {
		this.questionScrapeLevel = questionScrapeLevel;
	}
	public String getQuestionScrapeCreateTime() {
		return questionScrapeCreateTime;
	}
	public void setQuestionScrapeCreateTime(String questionScrapeCreateTime) {
		this.questionScrapeCreateTime = questionScrapeCreateTime;
	}
	public String getQuestionScrapeModifyTime() {
		return questionScrapeModifyTime;
	}
	public void setQuestionScrapeModifyTime(String questionScrapeModifyTime) {
		this.questionScrapeModifyTime = questionScrapeModifyTime;
	}
	public String getQuestionScrapeResult() {
		return questionScrapeResult;
	}
	public void setQuestionScrapeResult(String questionScrapeResult) {
		this.questionScrapeResult = questionScrapeResult;
	}
	@Override
	public String toString() {
		return "ProblemScrapeDAO [questionScrape=" + questionScrape + ", userCode=" + userCode + ", examCode="
				+ examCode + ", examQnaCode=" + examQnaCode + ", questionScrapeMemo=" + questionScrapeMemo
				+ ", questionScrapeLevel=" + questionScrapeLevel + ", questionScrapeCreateTime="
				+ questionScrapeCreateTime + ", questionScrapeModifyTime=" + questionScrapeModifyTime
				+ ", questionScrapeResult=" + questionScrapeResult + "]";
	}
}
