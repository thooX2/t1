package ks52team01.admin.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ks52team01.admin.study.dto.AdminDetailedSchedule;
import ks52team01.admin.study.dto.AdminProblemScrape;
import ks52team01.admin.study.dto.AdminProblemSolving;
import ks52team01.admin.study.dto.AdminStudySchedule;
import ks52team01.admin.study.dto.AdminStudyTarget;
import ks52team01.admin.study.dto.AdminTargetGrade;
import ks52team01.admin.study.dto.AdminTargetUniversity;
import ks52team01.admin.study.mapper.AdminStudyMapper;

@Service
public class AdminStudyServiceImpl implements AdminStudyService {

	@Autowired
	private final AdminStudyMapper adminStudyMapper;

	public AdminStudyServiceImpl(AdminStudyMapper adminStudyMapper) {
		this.adminStudyMapper = adminStudyMapper;
	}

	@Override
	public List<AdminStudyTarget> AdmingetStudyTarget(String id) {
		return adminStudyMapper.AdmingetStudyTarget(id);
	}

	@Override
	public List<AdminTargetUniversity> AdmingetTargetUniversity(String id) {
		return adminStudyMapper.AdmingetTargetUniversity(id);
	}

	@Override
	public List<AdminTargetGrade> AdmingetTargetGrade(String id) {
		return adminStudyMapper.AdmingetTargetGrade(id);
	}

	@Override
	public List<AdminStudySchedule> AdmingetStudySchedule(String id) {
		return adminStudyMapper.AdmingetStudySchedule(id);
	}

	@Override
	public List<AdminDetailedSchedule> AdmingetDetailedSchedule(String id) {
		return adminStudyMapper.AdmingetDetailedSchedule(id);
	}

	@Override
	public List<AdminProblemScrape> AdmingetProblemScrape() {
		return adminStudyMapper.AdmingetProblemScrape();
	}

	@Override
	public List<AdminProblemSolving> AdmingetProblemSolving() {
		return adminStudyMapper.AdmingetProblemSolving();
	}

	// 삭제

	@Override
	public void adminremoveCastSubject(AdminStudyTarget adminstudytargetDAO) {
		adminStudyMapper.adminremoveCastSubject(adminstudytargetDAO);
	}

	@Override
	public void adminremoveTargetUniversity(AdminTargetUniversity admintargetuniversityDAO) {
		adminStudyMapper.adminremoveTargetUniversity(admintargetuniversityDAO);
	}

	@Override
	public void adminremoveTargetGrade(AdminTargetGrade admintargetgradeDAO) {
		adminStudyMapper.adminremoveTargetGrade(admintargetgradeDAO);
	}

	@Override
	public void adminremoveLearningSchedule(AdminStudySchedule adminstudyscheduleDAO) {
		adminStudyMapper.adminremoveLearningSchedule(adminstudyscheduleDAO);
	}

	@Override
	public void adminremoveDetailedSchedule(AdminDetailedSchedule admindetailedscheduleDAO) {
		adminStudyMapper.adminremoveDetailedSchedule(admindetailedscheduleDAO);
	}

}
