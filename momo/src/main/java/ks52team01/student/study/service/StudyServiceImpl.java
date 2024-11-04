package ks52team01.student.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ks52team01.student.study.dto.DetailedSchedule;
import ks52team01.student.study.dto.LearningScheduleDto;
import ks52team01.student.study.dto.ProblemScrape;
import ks52team01.student.study.dto.ProblemSolving;
import ks52team01.student.study.dto.StudySchedule;
import ks52team01.student.study.dto.StudyTarget;
import ks52team01.student.study.dto.TargetGrade;
import ks52team01.student.study.dto.TargetUniversity;
import ks52team01.student.study.mapper.StudyMapper;

@Service
public class StudyServiceImpl implements StudyService {
	
	@Autowired
	private final StudyMapper studyMapper;
	
	public StudyServiceImpl(StudyMapper studyMapper) {
		this.studyMapper = studyMapper;
	}
	
	@Override
	public List<StudyTarget> getStudyTarget(String id){
		return studyMapper.getStudyTarget(id);
	}
	
	@Override
	public List<TargetUniversity> getTargetUniversity(String id){
		return studyMapper.getTargetUniversity(id);
	}
	
	@Override
	public List<TargetGrade>  getTargetGrade(String id){
		return studyMapper.getTargetGrade(id);
	}
	
	@Override
	public List<StudySchedule> getStudySchedule(String id){
		return studyMapper.getStudySchedule(id);
	}
	
	@Override
	public List<DetailedSchedule> getDetailedSchedule(String id){
		return studyMapper.getDetailedSchedule(id);
	}

	@Override
	public List<ProblemScrape> getProblemScrape(){
		return studyMapper.getProblemScrape();
	}
	
	@Override
	public List<ProblemSolving> getProblemSolving(){
		return studyMapper.getProblemSolving();
	}
	
	@Override
    public List<LearningScheduleDto> getLearningSchedules() {
        return studyMapper.getLearningSchedules();
    }
	

	
	@Override
	public void addCastSubject(StudyTarget studytargetDAO) {
		studyMapper.addCastSubject(studytargetDAO);
	}

	@Override
	public void getCastSubjectList(StudyTarget studytargetDAO) {
		studyMapper.getCastSubjectList(studytargetDAO);
	}

	@Override
	public void modifyCastSubject(StudyTarget studytargetDAO) {
		studyMapper.modifyCastSubject(studytargetDAO);
	}

	@Override
	public void removeCastSubject(StudyTarget studytargetDAO) {
		studyMapper.removeCastSubject(studytargetDAO);
	}

	@Override
	public void addTargetUniversity(TargetUniversity targetuniversityDAO) {
		studyMapper.addTargetUniversity(targetuniversityDAO);
	}

	@Override
	public void getTargetUniversityList(TargetUniversity targetuniversityDAO) {
		studyMapper.getTargetUniversityList(targetuniversityDAO);
	}

	@Override
	public void modifyTargetUniversity(TargetUniversity targetuniversityDAO) {
		studyMapper.modifyTargetUniversity(targetuniversityDAO);
	}

	@Override
	public void removeTargetUniversity(TargetUniversity targetuniversityDAO) {
		studyMapper.removeTargetUniversity(targetuniversityDAO);
	}

	@Override
	public void addTargetGrade(TargetGrade targetgradeDAO) {
		studyMapper.addTargetGrade(targetgradeDAO);
	}

	@Override
	public void getTargetGradeList(TargetGrade targetgradeDAO) {
		studyMapper.getTargetGradeList(targetgradeDAO);
	}

	@Override
	public void modifyTargetGrade(TargetGrade targetgradeDAO) {
		studyMapper.modifyTargetGrade(targetgradeDAO);
	}

	@Override
	public void removeTargetGrade(TargetGrade targetgradeDAO) {
		studyMapper.removeTargetGrade(targetgradeDAO);
	}

	@Override
	public void addLearningSchedule(StudySchedule studyscheduleDAO) {
		studyMapper.addLearningSchedule(studyscheduleDAO);
	}

	@Override
	public void getLearningScheduleList(StudySchedule studyscheduleDAO) {
		studyMapper.getLearningScheduleList(studyscheduleDAO);
	}

	@Override
	public void modifyLearningSchedule(StudySchedule studyscheduleDAO) {
		studyMapper.modifyLearningSchedule(studyscheduleDAO);
	}

	@Override
	public void removeLearningSchedule(StudySchedule studyscheduleDAO) {
		studyMapper.removeLearningSchedule(studyscheduleDAO);
	}

	@Override
	public void addDetailedSchedule(DetailedSchedule detailedscheduleDAO) {
		studyMapper.addDetailedSchedule(detailedscheduleDAO);
	}

	@Override
	public void getDetailedScheduleList(DetailedSchedule detailedscheduleDAO) {
		studyMapper.getDetailedScheduleList(detailedscheduleDAO);
	}

	@Override
	public void modifyDetailedSchedule(DetailedSchedule detailedscheduleDAO) {
		studyMapper.modifyDetailedSchedule(detailedscheduleDAO);
	}

	@Override
	public void removeDetailedSchedule(DetailedSchedule detailedscheduleDAO ) {
		studyMapper.removeDetailedSchedule(detailedscheduleDAO);
	}

	@Override
	public void addQuestionScrape(ProblemScrape problemscrapeDAO) {
		studyMapper.addQuestionScrape(problemscrapeDAO);
	}

	@Override
	public void getQuestionScrapeList(ProblemScrape problemscrapeDAO) {
		studyMapper.getQuestionScrapeList(problemscrapeDAO);
	}

	@Override
	public void modifyQuestionScrape(ProblemScrape problemscrapeDAO) {
		studyMapper.modifyQuestionScrape(problemscrapeDAO);
	}

	@Override
	public void removeQuestionScrape(ProblemScrape problemscrapeDAO) {
		studyMapper.removeQuestionScrape(problemscrapeDAO);
	}

	@Override
	public void addProblemSolving(ProblemSolving problemsolvingDAO) {
		studyMapper.addProblemSolving(problemsolvingDAO);
	}

	@Override
	public void getProblemSolvingList(ProblemSolving problemsolvingDAO) {
		studyMapper.getProblemSolvingList(problemsolvingDAO);
	}

	@Override
	public void modifyProblemSolving(ProblemSolving problemsolvingDAO) {
		studyMapper.modifyProblemSolving(problemsolvingDAO);
	}

	@Override
	public void removeProblemSolving(ProblemSolving problemsolvingDAO) {
		studyMapper.removeProblemSolving(problemsolvingDAO);
	}

}
