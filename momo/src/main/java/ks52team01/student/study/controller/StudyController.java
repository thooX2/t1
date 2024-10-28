package ks52team01.student.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks52team01.student.study.dto.DetailedSchedule;
import ks52team01.student.study.dto.ProblemScrape;
import ks52team01.student.study.dto.ProblemSolving;
import ks52team01.student.study.dto.StudySchedule;
import ks52team01.student.study.dto.StudyTarget;
import ks52team01.student.study.dto.TargetGrade;
import ks52team01.student.study.dto.TargetUniversity;
import ks52team01.student.study.service.StudyService;
import ks52team01.student.study.service.StudyServiceImpl;
import ks52team01.student.user.dto.User;


@Controller
@RequestMapping("/study")
public class StudyController {
	
	private final StudyService studyService;
	
	
	
	public StudyController(StudyServiceImpl studyServiceImpl) {
		this.studyService = studyServiceImpl;
	}
	
	@GetMapping("/getCastSubjectList")
	public String getCastSubjectList(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();

		model.addAttribute("CastSubjectList", studyService.getStudyTarget(id));
		
		return  "view/user/study/cast_subject_list";
	}

	
	@GetMapping("/addCastSubject") 
	public String addProducts(Model model) {
		System.out.println("과목을 추가하기 이동");
		return "view/user/study/cast_subject_insert";
	}
	
	@GetMapping("/modifyCastSubject") 
	public String modifyProducts(@RequestParam("list.idx") String listIdx, Model model) {
		System.out.println("과목을 수정하기");
		model.addAttribute("listIdx", listIdx);
		return "view/user/study/cast_subject_modify";	
	}
	
	@GetMapping("/removeCastSubject") 
	public String deleteProducts(@RequestParam("list.idx") String listIdx, Model model) {
		System.out.println("과목을 삭제하기");
		 model.addAttribute("listIdx", listIdx);
		return "view/user/study/cast_subject_delete";	
	}
	
	
	
	

	
	@PostMapping("/addCastSubject")
	public String addCastSubject(@ModelAttribute StudyTarget studytarget , Model model) {
		studyService.addCastSubject(studytarget);
		return "redirect:/study/getCastSubjectList";
	}
	@PostMapping("/modifyCastSubject")
		public String modifyCastSubject(@ModelAttribute StudyTarget studytarget , Model model) { 
		studyService.modifyCastSubject(studytarget);
		return "redirect:/study/getCastSubjectList";
		
	}
	@PostMapping("/removeCastSubject")
	public String removeCastSubject(@ModelAttribute StudyTarget studytarget , Model model) {
		studyService.removeCastSubject(studytarget);
		return "redirect:/study/getCastSubjectList";
	}
	
	
	// 타겟 대학교 설정
	
	@GetMapping("/getTargetUniversityList")
	public String getTargetUniversityList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();
		model.addAttribute("TargetUniversityList", studyService.getTargetUniversity(id));
		return "view/user/study/target_university_list";
	}
	
	@GetMapping("/addTargetUniversity") 
	public String addUniversity(Model model) {
		System.out.println("목표대학교 추가하기");
		return "view/user/study/target_university_insert";
	}
	
	@GetMapping("/modifyTargetUniversity") 
	public String modifyUniversity(@RequestParam("list.targetUniverseCode") String listIdx, Model model) {
		System.out.println("목표대학교 수정하기");
		model.addAttribute("listIdx", listIdx);
		return "view/user/study/target_university_modify";	
	}
	
	@GetMapping("/removeTargetUniversity") 
	public String deleteUniversity(@RequestParam("list.targetUniverseCode") String listIdx, Model model) {
		System.out.print(listIdx);
		System.out.println("목표대학교 삭제하기");
		model.addAttribute("listIdx", listIdx);
		return "view/user/study/target_university_delete";	
	}
	

	
	
	
	
	
	@PostMapping("/addTargetUniversity")
	public String addTargetUniversity(@ModelAttribute TargetUniversity targetuniversity , Model model) {
		studyService.addTargetUniversity(targetuniversity);
		return "redirect:/study/getTargetUniversityList";
	}
	
	@PostMapping("/modifyTargetUniversity")
	public String modifyTargetUniversity(@ModelAttribute TargetUniversity targetuniversity , Model model) {
		System.out.println("일단 대학교 수정을 진행");
		
		studyService.modifyTargetUniversity(targetuniversity);
		
		
		return "redirect:/study/getTargetUniversityList";
	}
	
	@PostMapping("/removeTargetUniversity")
	public String removeTargetUniversity(@ModelAttribute TargetUniversity targetuniversity , Model model) {
		studyService.removeTargetUniversity(targetuniversity);
		return "redirect:/study/getTargetUniversityList";
	}
	
	
	
	
	
	
	
	
	//목표 등급 설정
	
	@GetMapping("/addTargetGrade") 
	public String addGrade(Model model) {
		System.out.println("목표등급 추가하기");
		return "view/user/study/target_grade_insert";
	}
	
	@GetMapping("/modifyTargetGrade") 
	public String modifyGrade(@RequestParam("list.gradeCode") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("목표등급 수정하기");
		return "view/user/study/target_grade_modify";	
	}
	
	@GetMapping("/removeTargetGrade") 
	public String deleteGrade(@RequestParam("list.gradeCode") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("목표등급 삭제하기");
		return "view/user/study/target_grade_delete";	
	}
	
	
	
	
	
	
	@GetMapping("/getTargetGradeList")
	public String getTargetGradeList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();
		model.addAttribute("TargetGradeList", studyService.getTargetGrade(id));
		return "view/user/study/target_grade_list";
	}
	@PostMapping("/addTargetGrade")
	public String addTargetGrade(@ModelAttribute TargetGrade targetgrade , Model model) {
		studyService.addTargetGrade(targetgrade);
		return "redirect:/study/getTargetGradeList";
	}
	@PostMapping("/modifyTargetGrade")
	public String modifyTargetGrade(@ModelAttribute TargetGrade targetgrade , Model model) {
		studyService.modifyTargetGrade(targetgrade);
		return "redirect:/study/getTargetGradeList";
	}
	@PostMapping("/removeTargetGrade")
	public String removeTargetGrade(@ModelAttribute TargetGrade targetgrade , Model model) {
		studyService.removeTargetGrade(targetgrade);
		return "redirect:/study/getTargetGradeList";
	}
	
	
	
	
	
	
	
	
	//학습목표 설정
	
	
	@GetMapping("/addLearningSchedule") 
	public String addlearning(Model model) {
		System.out.println("상세스케쥴 추가하기");
		return "view/user/study/learning_schedule_insert";
	}
	
	@GetMapping("/modifyLearningSchedule") 
	public String modifylearning(@RequestParam("list.learningSchedule") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("상세스케쥴 수정하기");
		return "view/user/study/learning_schedule_modify";	
	}
	
	@GetMapping("/removeLearningSchedule") 
	public String deletelearning(@RequestParam("list.learningSchedule") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("상세스케쥴 삭제하기");
		return "view/user/study/learning_schedule_delete";	
	}
	
	
	
	
	
	
	
	
	@GetMapping("/getLearningScheduleList")
	public String getLearningScheduleList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();
		model.addAttribute("LearningScheduleList", studyService.getStudySchedule(id));
		return "view/user/study/learning_schedule_list";
	}
	@PostMapping("/addLearningSchedule")
	public String addLearningSchedule(@ModelAttribute StudySchedule studyschedule, Model model) {
		studyService.addLearningSchedule(studyschedule);
		return "redirect:/study/getLearningScheduleList";
	}
	@PostMapping("/modifyLearningSchedule")
	public String modifyLearningSchedule(@ModelAttribute StudySchedule studyschedule, Model model) {
		studyService.modifyLearningSchedule(studyschedule);
		return "redirect:/study/getLearningScheduleList";
	}
	@PostMapping("/removeLearningSchedule")
	public String removeLearningSchedule(@ModelAttribute StudySchedule studyschedule, Model model) {
		studyService.removeLearningSchedule(studyschedule);
		return "redirect:/study/getLearningScheduleList";
	}
	
	
	
	
	
	
	
	
	
	
	
	//상세 스케쥴
	
	
	
	@GetMapping("/addDetailedSchedule") 
	public String addDetailed(Model model) {
		System.out.println("상세스케쥴 추가하기");
		return "view/user/study/detailed_schedule_insert";
	}
	
	@GetMapping("/modifyDetailedSchedule") 
	public String modifyDetailed(@RequestParam("list.detailedSchedule") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("상세스케쥴 수정하기");
		return "view/user/study/detailed_schedule_modify";	
	}
	
	@GetMapping("/removeDetailedSchedule") 
	public String deleteDetailed(@RequestParam("list.detailedSchedule") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("상세스케쥴 삭제하기");
		return "view/user/study/detailed_schedule_delete";	
	}
	
	
	
	
	
	@GetMapping("/getDetailedScheduleList")
	public String getDetailedScheduleList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();
		model.addAttribute("DetailedScheduleList", studyService.getDetailedSchedule(id));
		return "view/user/study/detailed_schedule_list";
	}
	@PostMapping("/addDetailedSchedule")
	public String addDetailedSchedule(@ModelAttribute DetailedSchedule detailedschedule , Model model) {
		studyService.addDetailedSchedule(detailedschedule);
		return "redirect:/study/getDetailedScheduleList";
	}
	@PostMapping("/modifyDetailedSchedule")
	public String modifyDetailedSchedule(@ModelAttribute DetailedSchedule detailedschedule , Model model) {
		studyService.modifyDetailedSchedule(detailedschedule);
		return "redirect:/study/getDetailedScheduleList";
	}
	@PostMapping("/removeDetailedSchedule")
	public String removeDetailedSchedule(@ModelAttribute DetailedSchedule detailedschedule , Model model) {
		studyService.removeDetailedSchedule(detailedschedule);
		return "redirect:/study/getDetailedScheduleList";
	}
	
	
	
	
	
	
	// 이후 부터가 석진씨 담당
	
	
	
	//문제 스크랩
	
	
	@GetMapping("/addScrape") 
	public String addScrape(Model model) {
		System.out.println("스크랩 추가하기");
		return "view/user/study/question_scrape_insert";
	}
	
	@GetMapping("/modifyScrape") 
	public String modifyScrape(@RequestParam("list.questionScrape") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("스크랩 수정하기");
		return "view/user/study/question_scrape_modify";	
	}
	
	@GetMapping("/deleteScrape") 
	public String deleteScrape(@RequestParam("list.questionScrape") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("스크랩 삭제하기");
		return "view/user/study/question_scrape_delete";	
	}
	
	
	
	
	
	
	@GetMapping("/getQuestionScrapeList")
	public String getQuestionScrapeList(Model model) {
		model.addAttribute("QuestionScrapeList", studyService.getProblemScrape());
		return "view/user/study/question_scrape_list";
	}
	@PostMapping("/addQuestionScrape")
	public String addQuestionScrape(@ModelAttribute ProblemScrape problemscrape , Model model) {
		studyService.addQuestionScrape(problemscrape);
		return "view/user/study/question_scrape_insert";
	}
	@PostMapping("/modifyQuestionScrape")
	public String modifyQuestionScrape(@ModelAttribute ProblemScrape problemscrape , Model model) {
		studyService.modifyQuestionScrape(problemscrape);
		return "view/user/study/question_scrape_modify";
	}
	@PostMapping("/removeQuestionScrape")
	public String removeQuestionScrape(@ModelAttribute ProblemScrape problemscrape , Model model) {
		studyService.removeQuestionScrape(problemscrape);
		return "view/user/study/question_scrape_delete";
	}
	
	
	
	
	
	
	
	
	
	// 문제 해결 노트
	
	
	@GetMapping("/addProblem") 
	public String addProblem(Model model) {
		System.out.println("문제해결노트 추가하기 이동");
		return "view/user/study/problem_solving_insert";
	}
	
	@GetMapping("/modifyProblem") 
	public String modifyProblem(@RequestParam("list.solvingHistory") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("문제해결노트 수정하기");
		return "view/user/study/problem_solving_modify";	
	}
	
	@GetMapping("/deleteProblem") 
	public String deleteProblem(@RequestParam("list.solvingHistory") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("문제해결노트 삭제하기");
		return "view/user/study/problem_solving_delete";	
	}
	
	
	
	
	
	
	@GetMapping("/getProblemSolvingList")
	public String getProblemSolvingList(Model model) {
		model.addAttribute("ProblemSolvingList", studyService.getProblemSolving());
		return "view/user/study/problem_solving_list";
	}
	@PostMapping("/addProblemSolving")
	public String addProblemSolving(@ModelAttribute ProblemSolving problemscrape , Model model) {
		studyService.addProblemSolving(problemscrape);
		return "view/user/study/problem_solving_insert";
	}
	@PostMapping("/modifyProblemSolving")
	public String modifyProblemSolving(@ModelAttribute ProblemSolving problemscrape , Model model) {
		studyService.modifyProblemSolving(problemscrape);
		return "view/user/study/problem_solving_modify";
	}
	@PostMapping("/removeProblemSolving")
	public String removeProblemSolving(@ModelAttribute ProblemSolving problemscrape , Model model) {
		studyService.removeProblemSolving(problemscrape);
		return "view/user/study/problem_solving_delete";
	}
}
