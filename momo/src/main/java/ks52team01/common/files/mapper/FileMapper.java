package ks52team01.common.files.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.common.files.dto.QnaImg;

@Mapper
public interface FileMapper {

	int addFile(QnaImg fileInfo);

	int addFiles(List<QnaImg> fileList);

	List<QnaImg> getQnaImgListByQnaCode(String qnaCode);

	List<QnaImg> getQnaImgFileInputListByQnaCode(String qnaCode);

	int removeFiles(String key, String qnaImgCode);

	List<QnaImg> getFileInfoByQnaCode(String key,String qnaCode);

	List<QnaImg> getFileInfoByQnaCodeAndQnaImgOriginalName(String qnaImgOriginalName, String qnaCode);

	List<QnaImg> getQnaImgListByExamCode(String currentSubject, String currentMjrCode);

	

}
