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
	public List<QnaImg> getQnaImgListByQnaCode(String qnaCode) {

		return fileMapper.getQnaImgListByQnaCode(qnaCode);
	}

	@Override
	public void addFiles(String key, MultipartFile[] file, QnaBank qnaBank) {

		if (file == null || file.length == 0) {

			return; // 파일이 없으면 메서드 종료
		}

		List<QnaImg> fileList = filesUtils.uploadFiles(file);
		int plusIdx = 0;
		for (QnaImg element : fileList) {
			int newIdx = Integer.parseInt(element.getQnaImgCode().substring(3)) + plusIdx;
			String newQnaCode = "qic" + newIdx;
			element.setQnaImgCode(newQnaCode);
			element.setQnaImgType(key);
			element.setUserCode(qnaBank.getUserCode());
			element.setQnaCode(qnaBank.getQnaCode());
			plusIdx += 1;
		}

		if (!fileList.isEmpty())
			fileMapper.addFiles(fileList);

	}

	@Override
	public void addFile(String key, MultipartFile file, QnaBank qnaBank) {

		if (file == null || file.isEmpty()) {

			return; // 파일이 없으면 메서드 종료
		}
		String newQnaImgCode = commonMapper.getPrimaryKey("qna_img", "qna_img_code", "qic");

		QnaImg fileInfo = filesUtils.uploadFile(file);
		fileInfo.setQnaImgType(key);
		fileInfo.setUserCode(qnaBank.getUserCode());
		fileInfo.setQnaCode(qnaBank.getQnaCode());
		fileInfo.setQnaImgCode(newQnaImgCode);
		if (fileInfo != null) {

			fileMapper.addFile(fileInfo);
		}
	}

}
