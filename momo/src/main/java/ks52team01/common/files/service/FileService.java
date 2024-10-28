package ks52team01.common.files.service;

import org.springframework.web.multipart.MultipartFile;

import ks52team01.admin.exam.dto.QnaBank;

public interface FileService {

	// 다중파일 등록
	void addFiles(String key, MultipartFile[] file, QnaBank qnaBank);
	// 단일파일 등록
	void addFile(String key, MultipartFile file, QnaBank qnaBank);

}
