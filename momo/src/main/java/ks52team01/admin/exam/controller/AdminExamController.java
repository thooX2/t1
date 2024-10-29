package ks52team01.admin.exam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ks52team01.admin.exam.dto.ExamQnaChap;
import ks52team01.admin.exam.dto.ExamQnaType;
import ks52team01.admin.exam.dto.QnaBank;
import ks52team01.admin.exam.dto.SubMirCate;
import ks52team01.admin.exam.service.AdminExamService;
import ks52team01.common.files.dto.QnaImg;
import ks52team01.common.files.service.FileService;
import ks52team01.common.mapper.CommonMapper;
import ks52team01.student.user.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/admin/exam/")
public class AdminExamController {

	private final AdminExamService adminExamService;
	private final FileService fileService;
	private final CommonMapper commonMapper;

	@PostMapping("/deleteImg")
	public String deleteImg(@RequestParam(name = "qnaCode") String qnaCode,
			@RequestParam(name = "qnaImgOriginalName") String qnaImgOriginalName) {

		log.error(qnaCode);
		log.error(qnaImgOriginalName);
		fileService.deleteImg(qnaCode, qnaImgOriginalName);

		return "redirect:/admin/exam/questionList";
	}

	@PostMapping("/modifyQuestion")
	public String modifyQuestion(@RequestPart(name = "fileInput", required = false) MultipartFile[] fileInput,
			@RequestParam(name = "item1_file", required = false) MultipartFile item1File,
			@RequestParam(name = "item2_file", required = false) MultipartFile item2File,
			@RequestParam(name = "item3_file", required = false) MultipartFile item3File,
			@RequestParam(name = "item4_file", required = false) MultipartFile item4File,
			@RequestParam(name = "item5_file", required = false) MultipartFile item5File,
			@RequestParam(name = "question_file", required = false) MultipartFile questionFile, QnaBank qnaBank) {

		if (fileInput != null && !fileInput[0].isEmpty()) {
			fileService.removeFiles("fileInput", qnaBank.getQnaCode());
			fileService.addFiles("fileInput", fileInput, qnaBank);
		}

		if (item1File != null && !item1File.isEmpty()) {
			fileService.removeFiles("item1_file", qnaBank.getQnaCode());
			fileService.addFile("item1_file", item1File, qnaBank);
		}

		if (item2File != null && !item2File.isEmpty()) {

			fileService.removeFiles("item2_file", qnaBank.getQnaCode());
			fileService.addFile("item2_file", item2File, qnaBank);
		}

		if (item3File != null && !item3File.isEmpty()) {

			fileService.removeFiles("item3_file", qnaBank.getQnaCode());
			fileService.addFile("item3_file", item3File, qnaBank);
		}

		if (item4File != null && !item4File.isEmpty()) {

			fileService.removeFiles("item4_file", qnaBank.getQnaCode());
			fileService.addFile("item4_file", item4File, qnaBank);
		}

		if (item5File != null && !item5File.isEmpty()) {

			fileService.removeFiles("item5_file", qnaBank.getQnaCode());
			fileService.addFile("item5_file", item5File, qnaBank);
		}

		if (questionFile != null && !questionFile.isEmpty()) {

			fileService.removeFiles("question_file", qnaBank.getQnaCode());
			fileService.addFile("question_file", questionFile, qnaBank);
		}

		adminExamService.modifyQuestionProc(qnaBank);

		return "redirect:/admin/exam/questionList";
	}

	@GetMapping("/modifyQuestion")
	public String modifyQuestion(@RequestParam(name = "qnaCode") String qnaCode, Model model) {

		List<SubMirCate> categoryList = new ArrayList<SubMirCate>();
		categoryList = adminExamService.getAdminExamCategoryList();

		List<User> userList = new ArrayList<User>();
		userList = adminExamService.getUserListByGrade("ugc1");

		List<ExamQnaType> qnaTypeList = new ArrayList<ExamQnaType>();
		qnaTypeList = adminExamService.getQnaTypeList();

		List<ExamQnaChap> qnaChapList = new ArrayList<ExamQnaChap>();
		qnaChapList = adminExamService.getQnaChapList();

		List<QnaImg> qnaImgList = new ArrayList<QnaImg>();
		qnaImgList = fileService.getQnaImgListByQnaCode(qnaCode);

		List<QnaImg> qnaImgFileInputList = new ArrayList<QnaImg>();
		qnaImgFileInputList = fileService.getQnaImgFileInputListByQnaCode(qnaCode);

		QnaBank qnaBankInfo = adminExamService.getQuestionInfo(qnaCode);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("userList", userList);
		model.addAttribute("qnaTypeList", qnaTypeList);
		model.addAttribute("qnaChapList", qnaChapList);
		model.addAttribute("qnaBankInfo", qnaBankInfo);
		model.addAttribute("qnaImgList", qnaImgList);
		model.addAttribute("qnaImgFileInputList", qnaImgFileInputList);

		return "view/admin/exam/admin_exam_modify_question";

	}

	@GetMapping("/searchQuestionList")
	@ResponseBody
	public List<QnaBank> searchQuestionList(QnaBank qnaBank) {
		log.error("list:{}", qnaBank);
		List<QnaBank> searchList = new ArrayList<QnaBank>();
		searchList = adminExamService.searchQuestionList(qnaBank);
		return searchList;
	}

	@PostMapping("/addQuestion")
	public String adminExamAddQuestion(@RequestPart(name = "fileInput", required = false) MultipartFile[] fileInput,
			@RequestParam(name = "item1_file", required = false) MultipartFile item1File,
			@RequestParam(name = "item2_file", required = false) MultipartFile item2File,
			@RequestParam(name = "item3_file", required = false) MultipartFile item3File,
			@RequestParam(name = "item4_file", required = false) MultipartFile item4File,
			@RequestParam(name = "item5_file", required = false) MultipartFile item5File,
			@RequestParam(name = "question_file", required = false) MultipartFile questionFile, QnaBank qnaBank) {

		String newQnaCode = commonMapper.getPrimaryKey("qna_bank", "qna_code", "qc");
		qnaBank.setQnaCode(newQnaCode);
		adminExamService.addExamQuestion(qnaBank);

		fileService.addFiles("fileInput", fileInput, qnaBank);
		fileService.addFile("item1_file", item1File, qnaBank);
		fileService.addFile("item2_file", item2File, qnaBank);
		fileService.addFile("item3_file", item3File, qnaBank);
		fileService.addFile("item4_file", item4File, qnaBank);
		fileService.addFile("item5_file", item5File, qnaBank);
		fileService.addFile("question_file", questionFile, qnaBank);

		return "redirect:/admin/exam/questionList";
	}

	@GetMapping("/category")
	public String adminExamCategory(Model model) {

		List<SubMirCate> categoryList = new ArrayList<SubMirCate>();
		categoryList = adminExamService.getAdminExamCategoryList();

		List<ExamQnaType> qnaTypeList = new ArrayList<ExamQnaType>();
		qnaTypeList = adminExamService.getQnaTypeList();

		List<ExamQnaChap> qnaChapList = new ArrayList<ExamQnaChap>();
		qnaChapList = adminExamService.getQnaChapList();

		model.addAttribute("qnaTypeList", qnaTypeList);
		model.addAttribute("qnaChapList", qnaChapList);
		model.addAttribute("categoryList", categoryList);
		return "view/admin/exam/admin_exam_category";
	}

	@GetMapping("/management")
	public String admintest6() {
		return "view/admin/exam/admin_exam_management";
	}

	@GetMapping("/addQuestion")
	public String adminExamAddQuestion(Model model) {
		List<SubMirCate> categoryList = new ArrayList<SubMirCate>();
		categoryList = adminExamService.getAdminExamCategoryList();

		List<User> userList = new ArrayList<User>();
		userList = adminExamService.getUserListByGrade("ugc1");

		List<ExamQnaType> qnaTypeList = new ArrayList<ExamQnaType>();
		qnaTypeList = adminExamService.getQnaTypeList();

		List<ExamQnaChap> qnaChapList = new ArrayList<ExamQnaChap>();
		qnaChapList = adminExamService.getQnaChapList();

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("userList", userList);
		model.addAttribute("qnaTypeList", qnaTypeList);
		model.addAttribute("qnaChapList", qnaChapList);

		return "view/admin/exam/admin_exam_add_question";
	}

	@GetMapping("/questionPopup")
	public String admintest4() {
		return "view/admin/exam/admin_exam_question_popup";
	}

	@GetMapping("/managementList")
	public String admintest3() {
		return "view/admin/exam/admin_exam_management_list";
	}

	@GetMapping("/questionList")
	public String admintest(Model model) {
		List<SubMirCate> categoryList = new ArrayList<SubMirCate>();
		categoryList = adminExamService.getAdminExamCategoryList();

		List<User> userList = new ArrayList<User>();
		userList = adminExamService.getUserListByGrade("ugc1");

		List<QnaBank> questionList = new ArrayList<QnaBank>();
		questionList = adminExamService.getQuestionListAll();

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("userList", userList);
		model.addAttribute("questionList", questionList);

		return "view/admin/exam/admin_exam_question_list";
	}

}
