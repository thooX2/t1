package ks52team01.admin.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks52team01.admin.study.dto.AdminDetailedSchedule;
import ks52team01.admin.study.dto.AdminStudySchedule;
import ks52team01.admin.study.dto.AdminStudyTarget;
import ks52team01.admin.study.dto.AdminTargetGrade;
import ks52team01.admin.study.dto.AdminTargetUniversity;
import ks52team01.admin.study.service.AdminStudyService;
import ks52team01.admin.study.service.AdminStudyServiceImpl;
import ks52team01.student.study.dto.TargetUniversity;
import ks52team01.student.user.dto.User;

@Controller
@RequestMapping("/admin/study")
public class AdminStudyController {

	@Autowired
	private final AdminStudyService adminstudyService;

	public AdminStudyController(AdminStudyServiceImpl adminserviceImpl) {
		this.adminstudyService = adminserviceImpl;
	}

	@GetMapping("/StudyCsat")
	public String getCastSubjectList(HttpSession session, Model model) {

		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		model.addAttribute("CastSubjectList", adminstudyService.AdmingetStudyTarget(id));

		return "view/admin/study/admin_study_get_csat";
	}

	// 타겟 대학교 설정

	@GetMapping("/getTargetUniversityList")
	public String getTargetUniversityList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();
		model.addAttribute("TargetUniversityList", adminstudyService.AdmingetTargetUniversity(id));
		return "view/admin/study/admin_study_get_univers";
	}

	// 목표 등급 설정

	@GetMapping("/getTargetGradeList")
	public String getTargetGradeList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();
		model.addAttribute("TargetGradeList", adminstudyService.AdmingetTargetGrade(id));
		return "view/admin/study/admin_study_get_grade";
	}

	// 학습목표 설정

	@GetMapping("/getLearningScheduleList")
	public String getLearningScheduleList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();
		model.addAttribute("LearningScheduleList", adminstudyService.AdmingetStudySchedule(id));
		return "view/admin/study/admin_study_get_learning";
	}

	// 상세 스케쥴
	@GetMapping("/getDetailedScheduleList")
	public String getDetailedScheduleList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");
		String id = user.getUserCode();
		String grade = user.getGradeCode();
		model.addAttribute("DetailedScheduleList", adminstudyService.AdmingetDetailedSchedule(id));
		return "view/admin/study/admin_study_get_detail";
	}

	// 삭제주소 로딩

	@GetMapping("/removeCastSubject")
	public String adminDeleteProducts(@RequestParam("list.idx") String listIdx, Model model) {
		System.out.println("과목을 삭제하기");
		model.addAttribute("listIdx", listIdx);
		return "view/admin/study/admin_study_delete_csat";
	}

	@GetMapping("/removeTargetUniversity")
	public String admindeleteUniversity(@RequestParam("list.targetUniverseCode") String listIdx, Model model) {
		System.out.print(listIdx);
		System.out.println("목표대학교 삭제하기");
		model.addAttribute("listIdx", listIdx);
		return "view/admin/study/admin_study_delete_univers";
	}

	@GetMapping("/removeTargetGrade")
	public String admindeleteGrade(@RequestParam("list.gradeCode") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("목표등급 삭제하기");
		return "view/admin/study/admin_study_delete_grade";
	}

	@GetMapping("/removeLearningSchedule")
	public String admindeletelearning(@RequestParam("list.learningSchedule") String listIdx,
			@RequestParam("list.userCode") String usercode, Model model) {
		model.addAttribute("listIdx", listIdx);
		model.addAttribute("usercode", usercode);
		System.out.println("상세스케쥴 삭제하기");
		return "view/admin/study/admin_study_delete_learning";
	}

	@GetMapping("/removeDetailedSchedule")
	public String admindeleteDetailed(@RequestParam("list.detailedSchedule") String listIdx, Model model) {
		model.addAttribute("listIdx", listIdx);
		System.out.println("상세스케쥴 삭제하기");
		return "view/admin/study/admin_study_delete_detail";
	}

	@GetMapping("/getProblemSolvingList")
	public String getProblemSolvingList(Model model) {
		model.addAttribute("ProblemSolvingList", adminstudyService.AdmingetProblemSolving());
		return "view/admin/study/problem_solving_list";
	}

	@PostMapping("/removeCastSubject")
	public String adminremoveCastSubject(@ModelAttribute AdminStudyTarget adminstudytarget, Model model) {
		System.out.print("오류확인1" + adminstudytarget);

		adminstudyService.adminremoveCastSubject(adminstudytarget);
		return "redirect:/admin/study/StudyCsat";
	}

	@PostMapping("/removeTargetUniversity")
	public String adminremoveTargetUniversity(@ModelAttribute AdminTargetUniversity admintargetuniversity,
			Model model) {
		adminstudyService.adminremoveTargetUniversity(admintargetuniversity);
		return "redirect:/admin/study/getTargetUniversityList";
	}

	@PostMapping("/removeTargetGrade")
	public String adminremoveTargetGrade(@ModelAttribute AdminTargetGrade admintargetgrade, Model model) {
		adminstudyService.adminremoveTargetGrade(admintargetgrade);
		return "redirect:/admin/study/getTargetGradeList";
	}

	@PostMapping("/removeLearningSchedule")
	public String adminremoveLearningSchedule(@ModelAttribute AdminStudySchedule adminstudyschedule) {
		adminstudyService.adminremoveLearningSchedule(adminstudyschedule);
		return "redirect:/admin/study/getLearningScheduleList";
	}

	@PostMapping("/removeDetailedSchedule")
	public String adminremovedetailSchedule(@ModelAttribute AdminDetailedSchedule admindetailedSchedule) {
		adminstudyService.adminremoveDetailedSchedule(admindetailedSchedule);
		return "redirect:/admin/study/getDetailedScheduleList";
	}
}


