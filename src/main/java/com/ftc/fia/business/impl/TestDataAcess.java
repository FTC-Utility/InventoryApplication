package com.ftc.fia.business.impl;

import com.ftc.fia.business.ITestDataAccess;
import com.ftc.fia.domain.TestMe;
import com.ftc.fia.repository.ITestRepository;
import com.ftc.fia.service.ITestMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Zelalem Belay on 12/23/2016.
 */

@Service
@Transactional
public class TestDataAcess implements ITestDataAccess
{
    @Autowired
    ITestRepository iTestRepository;

    @Override
    public TestMe getTestById(int id) {
        return null;
    }

    @Override
    public List<TestMe> getTests() {
        return iTestRepository.findAll();
    }

    @Override
    public void createTest(TestMe testMe) {
        iTestRepository.save(testMe);
    }

    @Override
    public void deleteTest(TestMe testMe) {

    }

    @Override
    public void updateTest(TestMe testMe) {

    }
}
