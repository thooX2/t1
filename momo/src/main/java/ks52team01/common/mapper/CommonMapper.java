package ks52team01.common.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {

	// 자동증가코드 생성
	String getPrimaryKey(String tableName, String columnName, String codePattern);
}
