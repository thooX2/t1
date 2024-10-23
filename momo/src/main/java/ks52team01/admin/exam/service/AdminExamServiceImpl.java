package ks52team01.admin.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks52team01.admin.exam.dto.SubMirCate;
import ks52team01.admin.exam.dto.SubMjrCate;
import ks52team01.admin.exam.mapper.AdminExamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminExamServiceImpl implements AdminExamService {

	private final AdminExamMapper adminExamMapper;

	@Override
	public List<SubMirCate> getAdminExamCategoryList() {

		return adminExamMapper.getAdminExamCategoryList();
	}

}
