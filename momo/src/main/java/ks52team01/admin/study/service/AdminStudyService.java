package ks52team01.admin.study.service;

import java.util.List;

import ks52team01.admin.study.dto.AdminDetailedSchedule;
import ks52team01.admin.study.dto.AdminProblemScrape;
import ks52team01.admin.study.dto.AdminProblemSolving;
import ks52team01.admin.study.dto.AdminStudySchedule;
import ks52team01.admin.study.dto.AdminStudyTarget;
import ks52team01.admin.study.dto.AdminTargetGrade;
import ks52team01.admin.study.dto.AdminTargetUniversity;

public interface AdminStudyService {
	
	List<AdminStudyTarget> AdmingetStudyTarget(String id);
	
	List<AdminTargetUniversity> AdmingetTargetUniversity(String id);

	List<AdminTargetGrade> AdmingetTargetGrade(String id);

	List<AdminStudySchedule> AdmingetStudySchedule(String id);

	List<AdminDetailedSchedule> AdmingetDetailedSchedule(String id);

	List<AdminProblemScrape> AdmingetProblemScrape();
	
	List<AdminProblemSolving> AdmingetProblemSolving();
	
	
	void adminremoveCastSubject(AdminStudyTarget studytargetDAO);
	void adminremoveTargetUniversity(AdminTargetUniversity targetuniversityDAO);
	void adminremoveTargetGrade(AdminTargetGrade targetgradeDAO);
	void adminremoveLearningSchedule(AdminStudySchedule studyschedulDAO);
	void adminremoveDetailedSchedule(AdminDetailedSchedule detailedscheduleDAO);
}
