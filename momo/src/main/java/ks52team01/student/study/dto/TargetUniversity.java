package ks52team01.student.study.dto;

import lombok.Data;

@Data
public class TargetUniversity {
 private String targetUniverseCode;
 private String usercode;
 private String targetUniversityName;
 private String targetUniversityLesson;
 private String targetUniversityRangking;
 
public String getTargetUniverseCode() {
	return targetUniverseCode;
}
public void setTargetUniverseCode(String targetUniverseCode) {
	this.targetUniverseCode = targetUniverseCode;
}
public String getUserCode() {
	return usercode;
}
public void setUserCode(String usercode) {
	this.usercode = usercode;
}
public String getTargetUniversityName() {
	return targetUniversityName;
}
public void setTargetUniversityName(String targetUniversityName) {
	this.targetUniversityName = targetUniversityName;
}
public String getTargetUniversityLesson() {
	return targetUniversityLesson;
}
public void setTargetUniversityLesson(String targetUniversityLesson) {
	this.targetUniversityLesson = targetUniversityLesson;
}
public String getTargetUniversityRangking() {
	return targetUniversityRangking;
}
public void setTargetUniversityRangking(String targetUniversityRangking) {
	this.targetUniversityRangking = targetUniversityRangking;
}
@Override
public String toString() {
	return "TargetUniversityDAO [targetUniverseCode=" + targetUniverseCode + ", user_code=" + usercode
			+ ", targetUniversityName=" + targetUniversityName + ", targetUniversityLesson=" + targetUniversityLesson
			+ ", targetUniversityRangking=" + targetUniversityRangking + "]";
}
 
 
}
