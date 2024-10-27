package ks52team01.common.files.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.common.files.dto.QnaImg;

@Mapper
public interface FileMapper {

	int addFile(QnaImg fileInfo);

	int addFiles(List<QnaImg> fileList);

}
