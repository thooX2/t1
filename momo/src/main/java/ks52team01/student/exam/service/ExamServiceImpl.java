package ks52team01.student.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks52team01.student.exam.dto.ExamAnalyseDto;
import ks52team01.student.exam.mapper.ExamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ExamServiceImpl implements ExamService {

    private final ExamMapper examMapper;
    

   @Override
    public List<ExamAnalyseDto> getUserExamData(String userCode, String majorCode) {
        return examMapper.selectUserExamData(userCode, majorCode);
    }
}
