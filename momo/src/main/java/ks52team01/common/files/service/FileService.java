package ks52team01.common.files.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ks52team01.admin.exam.dto.AdminQnaBank;
import ks52team01.common.files.dto.QnaImg;

public interface FileService {

	// 다중파일 등록
	void addFiles(String key, MultipartFile[] file, AdminQnaBank qnaBank);

	// 단일파일 등록
	void addFile(String key, MultipartFile file, AdminQnaBank qnaBank);

	// 이미지목록
	List<QnaImg> getQnaImgListByQnaCode(String qnaCode);

	// 이미지목록
	List<QnaImg> getQnaImgFileInputListByQnaCode(String qnaCode);

	void removeFiles(String key, String qnaCode);

	void deleteImg(String qnaCode, String qnaImgOriginalName);

	List<QnaImg> getQnaImgListByExamCode(String currentSubject);

}
