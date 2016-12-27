package com.ftc.fia.business;

import com.ftc.fia.domain.TestMe;

import java.util.List;

/**
 * Created by Zelalem Belay on 12/23/2016.
 */
public interface ITestDataAccess
{
    public TestMe getTestById(int id);
    public List<TestMe> getTests();
    public void createTest(TestMe testMe);
    public void deleteTest(TestMe testMe);
    public void updateTest(TestMe testMe);
}
