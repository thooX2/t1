package ks52team01.student.study.dto;

import lombok.Data;

@Data
public class StudyTarget {
	private String idx;
	private String usercode;
	private String smcck;
	private String smcsk;
	private String smccm;
	private String smcsm;
	private String smci1;
	private String smci2;
	private String smcl1;
	private String smcl2;
	private String smck;
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getSmcck() {
		return smcck;
	}
	public void setSmcck(String smcck) {
		this.smcck = smcck;
	}
	public String getSmcsk() {
		return smcsk;
	}
	public void setSmcsk(String smcsk) {
		this.smcsk=smcsk;
	
	}
	public String getSmccm() {
		return smccm;
	}
	public void setSmccm(String smccm) {
		this.smccm = smccm;
	}
	public String getSmcsm() {
		return smcsm;
	}
	public void setSmcsm(String smcsm) {
		this.smcsm = smcsm;
	}
	public String getSmci1() {
		return smci1;
	}
	public void setSmci1(String smci1) {
		this.smci1 = smci1;
	}
	public String getSmci2() {
		return smci2;
	}
	public void setSmci2(String smci2) {
		this.smci2 = smci2;
	}
	public String getSmcl1() {
		return smcl1;
	}
	public void setSmcl1(String smcl1) {
		this.smcl1 = smcl1;
	}
	public String getSmcl2() {
		return smcl2;
	}
	public void setSmcl2(String smcl2) {
		this.smcl2 = smcl2;
	}
	public String getSmck() {
		return smck;
	}
	public void setSmck(String smck) {
		this.smck = smck;
	}
	@Override
	public String toString() {
		return "StudyTargetDAO [idx=" + idx + ", usercode=" + usercode + ", smcck=" + smcck + ", smcsk=" + smcsk
				+ ", smccm=" + smccm + ", smcsm=" + smcsm + ", smci1=" + smci1 + ", smci2=" + smci2 + ", smcl1=" + smcl1
				+ ", smcl2=" + smcl2 + ", smck=" + smck + "]";
	}

}
