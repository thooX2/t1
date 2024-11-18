package ks52team01.student.study.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks52team01.student.study.dto.DetailedSchedule;
import ks52team01.student.study.dto.LearningScheduleDto;
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

		model.addAttribute("CastSubjectList", studyService.getStudyTarget(id));

		return "view/user/study/cast_subject_list";
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
	public String addCastSubject(@ModelAttribute StudyTarget studytarget, Model model) {
		studyService.addCastSubject(studytarget);
		return "redirect:/study/getCastSubjectList";
	}

	@PostMapping("/modifyCastSubject")
	public String modifyCastSubject(@ModelAttribute StudyTarget studytarget, Model model) {
		studyService.modifyCastSubject(studytarget);
		return "redirect:/study/getCastSubjectList";

	}

	@PostMapping("/removeCastSubject")
	public String removeCastSubject(@ModelAttribute StudyTarget studytarget, Model model) {
		studyService.removeCastSubject(studytarget);
		return "redirect:/study/getCastSubjectList";
	}

	// 타겟 대학교 설정

	@GetMapping("/getTargetUniversityList")
	public String getTargetUniversityList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
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
	public String addTargetUniversity(@ModelAttribute TargetUniversity targetuniversity, Model model) {
		studyService.addTargetUniversity(targetuniversity);
		return "redirect:/study/getTargetUniversityList";
	}

	@PostMapping("/modifyTargetUniversity")
	public String modifyTargetUniversity(@ModelAttribute TargetUniversity targetuniversity, Model model) {
		System.out.println("일단 대학교 수정을 진행");

		studyService.modifyTargetUniversity(targetuniversity);

		return "redirect:/study/getTargetUniversityList";
	}

	@PostMapping("/removeTargetUniversity")
	public String removeTargetUniversity(@ModelAttribute TargetUniversity targetuniversity, Model model) {
		studyService.removeTargetUniversity(targetuniversity);
		return "redirect:/study/getTargetUniversityList";
	}

	// 목표 등급 설정

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
		model.addAttribute("TargetGradeList", studyService.getTargetGrade(id));
		return "view/user/study/target_grade_list";
	}

	@PostMapping("/addTargetGrade")
	public String addTargetGrade(@ModelAttribute TargetGrade targetgrade, Model model) {
		studyService.addTargetGrade(targetgrade);
		return "redirect:/study/getTargetGradeList";
	}

	@PostMapping("/modifyTargetGrade")
	public String modifyTargetGrade(@ModelAttribute TargetGrade targetgrade, Model model) {
		studyService.modifyTargetGrade(targetgrade);
		return "redirect:/study/getTargetGradeList";
	}

	@PostMapping("/removeTargetGrade")
	public String removeTargetGrade(@ModelAttribute TargetGrade targetgrade, Model model) {
		studyService.removeTargetGrade(targetgrade);
		return "redirect:/study/getTargetGradeList";
	}
	
	// 해당하는 값들을 불러오는 코드
	@GetMapping("/learning-schedules")
	@ResponseBody
	public List<LearningScheduleDto> getLearningSchedules(HttpSession session) {
		
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		
		List<LearningScheduleDto> schedule = studyService.getLearningSchedules(id);
		return schedule;
	}
	
	// 풀캘린더가 있는 페이지로 이동하기 위한 코드
	@GetMapping("/getLearningScheduleList")
	public String getLearningScheduleList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		model.addAttribute("LearningScheduleList", studyService.getStudySchedule(id));
		return "view/user/study/learning_schedule_list";
	}

	//학습계획을 추가하기 위한 코드
	@PostMapping("/addLearningSchedule")
	@ResponseBody
	public  String saveLearning(@RequestBody StudySchedule studyschedule) {

		studyService.addLearningSchedule(studyschedule);
		
		String ClearText = "학습계획을 추가하시는데 성공하였습니다.";
		return ClearText;
		
	}

	@PostMapping("/modifyLearningSchedule")
	@ResponseBody
	public String modifyLearning(@RequestBody StudySchedule studyschedule) {
		studyService.modifyLearningSchedule(studyschedule);
		String ClearText = "학습계획을 수정하시는데 성공하였습니다.";
		return ClearText;
	}

	@PostMapping("/removeLearningSchedule")
	@ResponseBody
	public String removeLearning(@RequestBody StudySchedule studyschedule) {
		studyService.removeLearningSchedule(studyschedule);
		String ClearText = "학습계획을 삭제하시는데 성공하였습니다.";
		return ClearText;
	}

	@PostMapping("/addDetailedSchedule")
	@ResponseBody
	public String saveDetail(@RequestBody DetailedSchedule detailedschedule) {
		
		studyService.addDetailedSchedule(detailedschedule);

		String ClearText = "상세계획을 추가하시는데 성공하였습니다.";
		return ClearText;
	}

	@PostMapping("/modifyDetailedSchedule")
	@ResponseBody
	public String modifyDetail(@RequestBody DetailedSchedule detailedschedule) {
		System.out.println("case2 : 2차진행");
		studyService.modifyDetailedSchedule(detailedschedule);
		String ClearText = "상세계획을 수정하시는데 성공하였습니다.";
		return ClearText;
	}

	@PostMapping("/removeDetailedSchedule")
	@ResponseBody
	public String removeDetail(@RequestBody DetailedSchedule detailedschedule) {
		studyService.removeDetailedSchedule(detailedschedule);
		String ClearText = "상세계획을 삭제하시는데 성공하였습니다.";
		return ClearText;
	}
}
