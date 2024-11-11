package ks52team01.student.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.study.dto.DetailedSchedule;
import ks52team01.student.study.dto.LearningScheduleDto;
import ks52team01.student.study.dto.ProblemScrape;
import ks52team01.student.study.dto.ProblemSolving;
import ks52team01.student.study.dto.StudySchedule;
import ks52team01.student.study.dto.StudyTarget;
import ks52team01.student.study.dto.TargetGrade;
import ks52team01.student.study.dto.TargetUniversity;

@Mapper
public interface StudyMapper {

	public void addCastSubject(StudyTarget studytargetDAO);

	public void getCastSubjectList(StudyTarget studytargetDAO);

	public void modifyCastSubject(StudyTarget studytargetDAO);

	public void removeCastSubject(StudyTarget studytargetDAO);

	public void addTargetUniversity(TargetUniversity targetuniversityDAO);

	public void getTargetUniversityList(TargetUniversity targetuniversityDAO);

	public void modifyTargetUniversity(TargetUniversity targetuniversityDAO);

	public void removeTargetUniversity(TargetUniversity targetuniversityDAO);

	public void addTargetGrade(TargetGrade targetgradeDAO);

	public void getTargetGradeList(TargetGrade targetgradeDAO);

	public void modifyTargetGrade(TargetGrade targetgradeDAO);

	public void removeTargetGrade(TargetGrade targetgradeDAO);

	public void addLearningSchedule(StudySchedule studyscheduleDAO);

	public void getLearningScheduleList(StudySchedule studyscheduleDAO);

	public void modifyLearningSchedule(StudySchedule studyscheduleDAO);

	public void removeLearningSchedule(StudySchedule studyscheduleDAO);

	public void addDetailedSchedule(DetailedSchedule detailedSchedule);

	public void getDetailedScheduleList(DetailedSchedule detailedSchedule);

	public void modifyDetailedSchedule(DetailedSchedule detailedSchedule);

	public void removeDetailedSchedule(DetailedSchedule detailedSchedule);

	public void addQuestionScrape(ProblemScrape problemscrapeDAO);

	public void getQuestionScrapeList(ProblemScrape problemscrapeDAO);

	public void modifyQuestionScrape(ProblemScrape problemscrapeDAO);

	public void removeQuestionScrape(ProblemScrape problemscrapeDAO);

	public void addProblemSolving(ProblemSolving problemsolvingDAO);

	public void getProblemSolvingList(ProblemSolving problemsolvingDAO);

	public void modifyProblemSolving(ProblemSolving problemsolvingDAO);

	public void removeProblemSolving(ProblemSolving problemsolvingDAO);

	List<StudyTarget> getStudyTarget(String id);
	
	List<TargetUniversity> getTargetUniversity(String id);

	List<TargetGrade> getTargetGrade(String id);

	List<StudySchedule> getStudySchedule(String id);

	List<DetailedSchedule> getDetailedSchedule(String id);

	List<ProblemScrape> getProblemScrape();
	
	List<ProblemSolving> getProblemSolving();

	List<LearningScheduleDto> getLearningSchedules(String id);
}
