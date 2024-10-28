package ks52team01.common.files.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import groovy.util.logging.Slf4j;
import ks52team01.admin.exam.dto.QnaBank;
import ks52team01.common.files.dto.QnaImg;
import ks52team01.common.files.mapper.FileMapper;
import ks52team01.common.files.util.FilesUtils;
import ks52team01.common.mapper.CommonMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements FileService {

	private final FilesUtils filesUtils;
	private final FileMapper fileMapper;
	private final CommonMapper commonMapper;

	@Override
	public void addFiles(String key, MultipartFile[] file, QnaBank qnaBank) {

		String newQnaImgCode = commonMapper.getPrimaryKey("qna_img", "qna_img_code", "qic");

		List<QnaImg> fileList = filesUtils.uploadFiles(file);

		for (QnaImg element : fileList) {
			element.setQnaImgType(key);
			element.setUserCode(qnaBank.getUserCode());
			element.setQnaCode(qnaBank.getQnaCode());
			element.setQnaImgCode(newQnaImgCode);
		}

		if (!fileList.isEmpty())
			fileMapper.addFiles(fileList);

	}

	@Override
	public void addFile(String key, MultipartFile file, QnaBank qnaBank) {

		String newQnaImgCode = commonMapper.getPrimaryKey("qna_img", "qna_img_code", "qic");

		QnaImg fileInfo = filesUtils.uploadFile(file);
		fileInfo.setQnaImgType(key);
		fileInfo.setUserCode(qnaBank.getUserCode());
		fileInfo.setQnaCode(qnaBank.getQnaCode());
		fileInfo.setQnaImgCode(newQnaImgCode);

		if (fileInfo != null)
			fileMapper.addFile(fileInfo);
	}

}
