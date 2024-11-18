package ks52team01.student.study.service;

import java.util.List;

import ks52team01.student.study.dto.DetailedSchedule;
import ks52team01.student.study.dto.LearningScheduleDto;
import ks52team01.student.study.dto.StudySchedule;
import ks52team01.student.study.dto.StudyTarget;
import ks52team01.student.study.dto.TargetGrade;
import ks52team01.student.study.dto.TargetUniversity;

public interface StudyService {

	
	void addCastSubject(StudyTarget studytargetDAO);
	
	void getCastSubjectList(StudyTarget studytargetDAO);
	
	void modifyCastSubject(StudyTarget studytargetDAO);
	
	void removeCastSubject(StudyTarget studytargetDAO);
	
	void addTargetUniversity(TargetUniversity targetuniversityDAO);
	
	void getTargetUniversityList(TargetUniversity targetuniversityDAO);
	
	void modifyTargetUniversity(TargetUniversity targetuniversityDAO);
	
	void removeTargetUniversity(TargetUniversity targetuniversityDAO);
	
	void addTargetGrade(TargetGrade targetgradeDAO);
	
	void getTargetGradeList(TargetGrade targetgradeDAO);
	
	void modifyTargetGrade(TargetGrade targetgradeDAO);
	
	void removeTargetGrade(TargetGrade targetgradeDAO);
	
	void addLearningSchedule(StudySchedule studyschedulDAO);
	
	void getLearningScheduleList(StudySchedule studyschedulDAO);
	
	void modifyLearningSchedule(StudySchedule studyschedulDAO);
	
	void removeLearningSchedule(StudySchedule studyschedulDAO);
	
	void addDetailedSchedule(DetailedSchedule detailedscheduleDAO);
	
	void getDetailedScheduleList(DetailedSchedule detailedscheduleDAO);
	
	void modifyDetailedSchedule(DetailedSchedule detailedscheduleDAO);
	
	void removeDetailedSchedule(DetailedSchedule detailedscheduleDAO);


	List<StudyTarget> getStudyTarget(String id);
	
	List<TargetUniversity> getTargetUniversity(String id);

	List<TargetGrade> getTargetGrade(String id);

	List<StudySchedule> getStudySchedule(String id);

	List<DetailedSchedule> getDetailedSchedule(String id);

	
	List<LearningScheduleDto> getLearningSchedules(String id);
}
