package com.ftc.fia.service.impl;

import com.ftc.fia.business.ITestDataAccess;
import com.ftc.fia.domain.TestMe;
import com.ftc.fia.repository.ITestRepository;
import com.ftc.fia.service.ITestMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zelalem Belay on 12/23/2016.
 */

@Service
public class TestService implements ITestMeService
{
    @Autowired
    ITestDataAccess iTestDataAccess;


    @Override
    public TestMe getTestById(int id) {
        return null;
    }

    @Override
    public List<TestMe> getTests() {
        return iTestDataAccess.getTests();
    }

    @Override
    public void createTest(TestMe testMe) {
        iTestDataAccess.createTest(testMe);
    }

    @Override
    public void deleteTest(TestMe testMe) {

    }

    @Override
    public void updateTest(TestMe testMe) {

    }
}
