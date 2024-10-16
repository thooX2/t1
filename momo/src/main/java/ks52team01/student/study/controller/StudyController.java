package ks52team01.student.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ks52team01.student.study.dto.DetailedSchedule;
import ks52team01.student.study.dto.ProblemScrape;
import ks52team01.student.study.dto.ProblemSolving;
import ks52team01.student.study.dto.StudySchedule;
import ks52team01.student.study.dto.StudyTarget;
import ks52team01.student.study.dto.TargetGrade;
import ks52team01.student.study.dto.TargetUniversity;
import ks52team01.student.study.service.StudyService;
import ks52team01.student.study.service.StudyServiceImpl;

@Controller
public class StudyController {
	
	private final StudyService studyService;
	
	public StudyController(StudyServiceImpl studyServiceImpl) {
		this.studyService = studyServiceImpl;
	}
	
	@GetMapping("/addCast") 
	public String addProducts(Model model) {
		System.out.println("과목을 추가하기 이동");
		return "view/user/study/cast_subject_insert";
	}
	
	@GetMapping("/modifyCast") 
	public String modifyProducts(Model model) {
		System.out.println("과목을 수정하기");
		return "view/user/study/cast_subject_modify";	
	}
	
	@GetMapping("/deleteCast") 
	public String deleteProducts(Model model) {
		System.out.println("과목을 삭제하기");
		return "view/user/study/cast_subject_delete";	
	}
	
	
	
	@GetMapping("/getCastSubjectList")
	public String getCastSubjectList(Model model) {
		model.addAttribute("CastSubjectList", studyService.findAll());
		return  "view/user/study/cast_subject_list";
	}

	
	@GetMapping("/addCastSubject")
	public String addCastSubject(@ModelAttribute StudyTarget studytargetdao , Model model) {
		studyService.addCastSubject(studytargetdao);
		return  "view/user/study/cast_subject_insert";
	}
	@GetMapping("/modifyCastSubject")
		public String modifyCastSubject(@ModelAttribute StudyTarget studytargetdao , Model model) { 
		studyService.modifyCastSubject(studytargetdao);
		return  "view/user/study/cast_subject_modify";
		
	}
	@GetMapping("/removeCastSubject")
	public String removeCastSubject(@ModelAttribute StudyTarget studytargetdao , Model model) {
		studyService.removeCastSubject(studytargetdao);
		return  "view/user/study/cast_subject_delete";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 타겟 대학교 설정
	
	@GetMapping("/addUniversity") 
	public String addUniversity(Model model) {
		System.out.println("목표대학교 추가하기");
		return "view/user/study/target_university_insert";
	}
	
	@GetMapping("/modifyUniversity") 
	public String modifyUniversity(Model model) {
		System.out.println("목표대학교 수정하기");
		return "view/user/study/target_university_modify";	
	}
	
	@GetMapping("/deleteUniversity") 
	public String deleteUniversity(Model model) {
		System.out.println("목표대학교 삭제하기");
		return "view/user/study/target_university_delete";	
	}
	

	
	
	@GetMapping("/getTargetUniversityList")
	public String getTargetUniversityList(Model model) {
		model.addAttribute("TargetUniversityList", studyService.findAll2());
		return "view/user/study/target_university_list";
	}
	
	@GetMapping("/addTargetUniversity")
	public String addTargetUniversity(@ModelAttribute TargetUniversity targetuniversityDAO , Model model) {
		studyService.addTargetUniversity(targetuniversityDAO);
		return "view/user/study/target_university_insert";
	}
	
	@GetMapping("/modifyTargetUniversity")
	public String modifyTargetUniversity(@ModelAttribute TargetUniversity targetuniversityDAO , Model model) {
		studyService.modifyTargetUniversity(targetuniversityDAO);
		return "view/user/study/target_university_modify";
	}
	
	@GetMapping("/removeTargetUniversity")
	public String removeTargetUniversity(@ModelAttribute TargetUniversity targetuniversityDAO , Model model) {
		studyService.removeTargetUniversity(targetuniversityDAO);
		return "view/user/study/target_university_remove";
	}
	
	
	
	
	
	
	
	
	//목표 등급 설정
	
	@GetMapping("/addGrade") 
	public String addGrade(Model model) {
		System.out.println("목표등급 추가하기");
		return "view/user/study/target_grade_insert";
	}
	
	@GetMapping("/modifyGrade") 
	public String modifyGrade(Model model) {
		System.out.println("목표등급 수정하기");
		return "view/user/study/target_grade_modify";	
	}
	
	@GetMapping("/deleteGrade") 
	public String deleteGrade(Model model) {
		System.out.println("목표등급 삭제하기");
		return "view/user/study/target_grade_delete";	
	}
	
	
	
	
	
	
	@GetMapping("/getTargetGradeList")
	public String getTargetGradeList(Model model) {
		model.addAttribute("TargetGradeList", studyService.findAll3());
		return "view/user/study/target_grade_list";
	}
	@GetMapping("/addTargetGrade")
	public String addTargetGrade(@ModelAttribute TargetGrade targetgradeDAO , Model model) {
		studyService.addTargetGrade(targetgradeDAO);
		return "view/user/study/target_grade_insert";
	}
	@GetMapping("/modifyTargetGrade")
	public String modifyTargetGrade(@ModelAttribute TargetGrade targetgradeDAO , Model model) {
		studyService.modifyTargetGrade(targetgradeDAO);
		return "view/user/study/target_grade_modify";
	}
	@GetMapping("/removeTargetGrade")
	public String removeTargetGrade(@ModelAttribute TargetGrade targetgradeDAO , Model model) {
		studyService.removeTargetGrade(targetgradeDAO);
		return "view/user/study/target_grade_delete";
	}
	
	
	
	
	
	
	
	
	//학습목표 설정
	
	
	@GetMapping("/addlearning") 
	public String addlearning(Model model) {
		System.out.println("상세스케쥴 추가하기");
		return "view/user/study/learning_schedule_insert";
	}
	
	@GetMapping("/modifylearning") 
	public String modifylearning(Model model) {
		System.out.println("상세스케쥴 수정하기");
		return "view/user/study/learning_schedule_modify";	
	}
	
	@GetMapping("/deletelearning") 
	public String deletelearning(Model model) {
		System.out.println("상세스케쥴 삭제하기");
		return "view/user/study/learning_schedule_delete";	
	}
	
	
	
	
	
	
	
	
	@GetMapping("/getLearningScheduleList")
	public String getLearningScheduleList(@ModelAttribute TargetGrade targetgradeDAO , Model model) {
		model.addAttribute("LearningScheduleList", studyService.findAll4());
		return "view/user/study/learning_schedule_list";
	}
	@GetMapping("/addLearningSchedule")
	public String addLearningSchedule(@ModelAttribute StudySchedule studyscheduleDAO, Model model) {
		studyService.addLearningSchedule(studyscheduleDAO);
		return "view/user/study/learning_schedule_insert";
	}
	@GetMapping("/modifyLearningSchedule")
	public String modifyLearningSchedule(@ModelAttribute StudySchedule studyscheduleDAO, Model model) {
		studyService.modifyLearningSchedule(studyscheduleDAO);
		return "view/user/study/target_university_modify";
	}
	@GetMapping("/removeLearningSchedule")
	public String removeLearningSchedule(@ModelAttribute StudySchedule studyscheduleDAO, Model model) {
		studyService.removeLearningSchedule(studyscheduleDAO);
		return "view/user/study/target_university_delete";
	}
	
	
	
	
	
	
	
	
	
	
	
	//상세 스케쥴
	
	
	
	@GetMapping("/addDetailed") 
	public String addDetailed(Model model) {
		System.out.println("상세스케쥴 추가하기");
		return "view/user/study/detailed_schedule_insert";
	}
	
	@GetMapping("/modifyDetailed") 
	public String modifyDetailed(Model model) {
		System.out.println("상세스케쥴 수정하기");
		return "view/user/study/detailed_schedule_modify";	
	}
	
	@GetMapping("/deleteDetailed") 
	public String deleteDetailed(Model model) {
		System.out.println("상세스케쥴 삭제하기");
		return "view/user/study/detailed_schedule_delete";	
	}
	
	
	
	
	
	@GetMapping("/getDetailedScheduleList")
	public String getDetailedScheduleList(@ModelAttribute DetailedSchedule detailedscheduleDAO , Model model) {
		model.addAttribute("DetailedScheduleList", studyService.findAll5());
		return "view/user/study/detailed_schedule_list";
	}
	@GetMapping("/addDetailedSchedule")
	public String addDetailedSchedule(@ModelAttribute DetailedSchedule detailedscheduleDAO , Model model) {
		studyService.addDetailedSchedule(detailedscheduleDAO);
		return "view/user/study/detailed_schedule_insert";
	}
	@GetMapping("/modifyDetailedSchedule")
	public String modifyDetailedSchedule(@ModelAttribute DetailedSchedule detailedscheduleDAO , Model model) {
		studyService.modifyDetailedSchedule(detailedscheduleDAO);
		return "view/user/study/detailed_schedule_modify";
	}
	@GetMapping("/removeDetailedSchedule")
	public String removeDetailedSchedule(@ModelAttribute DetailedSchedule detailedscheduleDAO , Model model) {
		studyService.removeDetailedSchedule(detailedscheduleDAO);
		return "view/user/study/detailed_schedule_delete";
	}
	
	
	
	
	
	
	
	
	
	
	//문제 스크랩
	
	
	@GetMapping("/addScrape") 
	public String addScrape(Model model) {
		System.out.println("스크랩 추가하기");
		return "view/user/study/question_scrape_insert";
	}
	
	@GetMapping("/modifyScrape") 
	public String modifyScrape(Model model) {
		System.out.println("스크랩 수정하기");
		return "view/user/study/question_scrape_modify";	
	}
	
	@GetMapping("/deleteScrape") 
	public String deleteScrape(Model model) {
		System.out.println("스크랩 삭제하기");
		return "view/user/study/question_scrape_delete";	
	}
	
	
	
	
	
	
	@GetMapping("/getQuestionScrapeList")
	public String getQuestionScrapeList(Model model) {
		model.addAttribute("QuestionScrapeList", studyService.findAll6());
		return "view/user/study/question_scrape_list";
	}
	@GetMapping("/addQuestionScrape")
	public String addQuestionScrape(@ModelAttribute ProblemScrape problemscrapeDAO , Model model) {
		studyService.addQuestionScrape(problemscrapeDAO);
		return "view/user/study/question_scrape_insert";
	}
	@GetMapping("/modifyQuestionScrape")
	public String modifyQuestionScrape(@ModelAttribute ProblemScrape problemscrapeDAO , Model model) {
		studyService.modifyQuestionScrape(problemscrapeDAO);
		return "view/user/study/question_scrape_modify";
	}
	@GetMapping("/removeQuestionScrape")
	public String removeQuestionScrape(@ModelAttribute ProblemScrape problemscrapeDAO , Model model) {
		studyService.removeQuestionScrape(problemscrapeDAO);
		return "view/user/study/question_scrape_delete";
	}
	
	
	
	
	
	
	
	
	
	// 문제 해결 노트
	
	
	@GetMapping("/addProblem") 
	public String addProblem(Model model) {
		System.out.println("문제해결노트 추가하기 이동");
		return "view/user/study/problem_solving_insert";
	}
	
	@GetMapping("/modifyProblem") 
	public String modifyProblem(Model model) {
		System.out.println("문제해결노트 수정하기");
		return "view/user/study/problem_solving_modify";	
	}
	
	@GetMapping("/deleteProblem") 
	public String deleteProblem(Model model) {
		System.out.println("문제해결노트 삭제하기");
		return "view/user/study/problem_solving_delete";	
	}
	
	
	
	
	
	
	@GetMapping("/getProblemSolvingList")
	public String getProblemSolvingList(Model model) {
		model.addAttribute("ProblemSolvingList", studyService.findAll7());
		return "view/user/study/problem_solving_list";
	}
	@GetMapping("/addProblemSolving")
	public String addProblemSolving(@ModelAttribute ProblemSolving problemscrapeDAO , Model model) {
		studyService.addProblemSolving(problemscrapeDAO);
		return "view/user/study/problem_solving_insert";
	}
	@GetMapping("/modifyProblemSolving")
	public String modifyProblemSolving(@ModelAttribute ProblemSolving problemscrapeDAO , Model model) {
		studyService.modifyProblemSolving(problemscrapeDAO);
		return "view/user/study/problem_solving_modify";
	}
	@GetMapping("/removeProblemSolving")
	public String removeProblemSolving(@ModelAttribute ProblemSolving problemscrapeDAO , Model model) {
		studyService.removeProblemSolving(problemscrapeDAO);
		return "view/user/study/problem_solving_delete";
	}
}
