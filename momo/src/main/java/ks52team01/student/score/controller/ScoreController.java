package ks52team01.student.score.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.score.dto.Subject;
import ks52team01.student.score.service.ScoreExamAllService;
import ks52team01.student.user.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/score")
@Slf4j
public class ScoreController {

	private final ScoreExamAllService scoreExamAllService;

	@GetMapping("/scoreMain")
	public String getScoreMain(Model model, HttpSession session, HttpServletResponse response) throws IOException {
		// 세션에 저장된 회원 정보
		User user = (User) session.getAttribute("loggedInUser");
		
		// 최초로 응시한 모의고사 목록 조회
		String userCode = user.getUserCode();
		List<TookExamInfo> firstTookExamList = scoreExamAllService.getFirstTookExamList(userCode);
		
		Map<String, Subject> subjectScoreMap = null;
		if(firstTookExamList != null) {
			// 현재 모의고사 점수 조회
			TookExamInfo curTookExam = firstTookExamList.get(0);
			String areaCityCode = curTookExam.getAreaCityCode();
			String examCode = curTookExam.getExamCode();
			String tookExamInfoCode = curTookExam.getTookExamInfoCode();
			subjectScoreMap = scoreExamAllService.getTookExamScore(userCode, areaCityCode, examCode, tookExamInfoCode);
		}
		
		Date userBirthDate = user.getUserBirthDate();
		String formattedUserBirthDate = new SimpleDateFormat("yy.MM.dd").format(userBirthDate);
		
		model.addAttribute("user", user);
		model.addAttribute("tookExamList", firstTookExamList);
		model.addAttribute("subjectScoreMap", subjectScoreMap);
		model.addAttribute("formattedUserBirthDate", formattedUserBirthDate);
		return "view/user/score/exam_all_score_summary";
	}
	
	@PostMapping("/searchTookExamScore")
	@ResponseBody
	public Map<String, Subject> getScoreMain(@RequestBody TookExamInfo tookExamInfo, HttpSession session) {
		// 세션에 저장된 회원 정보
		User user = (User) session.getAttribute("loggedInUser");
		String userCode = user.getUserCode();

		// 현재 모의고사 점수 조회
		String areaCityCode = tookExamInfo.getAreaCityCode();
		String examCode = tookExamInfo.getExamCode();
		String tookExamInfoCode = tookExamInfo.getTookExamInfoCode();
		return scoreExamAllService.getTookExamScore(userCode, areaCityCode, examCode, tookExamInfoCode);
	}
}
